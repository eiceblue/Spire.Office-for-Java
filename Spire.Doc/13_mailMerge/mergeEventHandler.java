import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;
import com.spire.doc.interfaces.IMergeField;
import com.spire.doc.reporting.*;
import java.util.*;

public class mergeEventHandler {
    // Index of the last processed row
    private static int lastIndex;

    public static void main(String[] args) throws Exception {
        // Path to the input Word document
        String input = "data/mergeEventHandler.docx";
        // Path to the output Word document
        String output = "output/mergeEventHandler.docx";

        // Create a new Document object
        Document document = new Document();

        // Load the input Word document
        document.loadFromFile(input);

        // Initialize the lastIndex variable
        lastIndex = 0;

        // Create a list of CustomerRecord objects
        List<CustomerRecord> customerRecords = new ArrayList<CustomerRecord>();

        // Create and add CustomerRecord objects
        CustomerRecord c1 = new CustomerRecord();
        c1.setContactName("Lucy");
        c1.setFax("786-324-10");
        c1.setDate(new Date());
        customerRecords.add(c1);

        CustomerRecord c2 = new CustomerRecord();
        c2.setContactName("Lily");
        c2.setFax("779-138-13");
        c2.setDate(new Date());
        customerRecords.add(c2);

        CustomerRecord c3 = new CustomerRecord();
        c3.setContactName("James");
        c3.setFax("363-287-02");
        c3.setDate(new Date());
        customerRecords.add(c3);

        // Set up the MergeField event handler for custom processing
        document.getMailMerge().MergeField = new MergeFieldEventHandler() {
            @Override
            public void invoke(Object sender, MergeFieldEventArgs args) {
                mailMerge_MergeField(sender, args);
            }
        };

        // Execute the grouped mail merge with the Customer DataTable
        document.getMailMerge().executeGroup(new MailMergeDataTable("Customer", customerRecords));

        // Save the resulting document to the output path
        document.saveToFile(output, FileFormat.Docx_2013);

        // Dispose of the document
        document.dispose();
    }

    // Custom MergeField event handler
    private static void mailMerge_MergeField(Object sender, MergeFieldEventArgs args) {
        // Check if the row index is greater than the lastIndex
        if (args.getRowIndex() > lastIndex) {
            // Update the lastIndex
            lastIndex = args.getRowIndex();
            // Add a page break for the merge field
            addPageBreakForMergeField(args.getCurrentMergeField());
        }
    }

    // Method to add a page break for a merge field
    private static void addPageBreakForMergeField(IMergeField mergeField) {
        boolean foundGroupStart = false;
        Paragraph paramgraph = (Paragraph) mergeField.getPreviousSibling().getOwner();

        while (!foundGroupStart) {
            paramgraph = (Paragraph) paramgraph.getPreviousSibling();
            for (int i = 0; i < paramgraph.getItems().getCount(); i++) {
                ParagraphBase paraBase = paramgraph.getItems().get(i);

                if (paraBase instanceof MergeField) {
                    MergeField merageField = (MergeField) paraBase;
                    // Check if the merge field is a GroupStart field
                    if ((merageField != null) && ("GroupStart".equals(merageField.getPrefix()))) {
                        foundGroupStart = true;
                        break;
                    }
                }
            }
        }

        // Append a page break to the paragraph
        paramgraph.appendBreak(BreakType.Page_Break);
    }

    static class CustomerRecord {
        public String ContactName;
        public String Fax;
        public Date Date;

        public String getContactName() {
            return ContactName;
        }

        public void setContactName(String contactName) {
            this.ContactName = contactName;
        }

        public String getFax() {
            return Fax;
        }

        public void setFax(String fax) {
            this.Fax = fax;
        }

        public Date getDate() {
            return Date;
        }

        public void setDate(Date date) {
            this.Date = date;
        }
    }
}
