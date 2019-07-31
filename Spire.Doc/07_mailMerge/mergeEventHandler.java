import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.MergeField;
import com.spire.doc.fields.ParagraphBase;
import com.spire.doc.interfaces.IMergeField;
import com.spire.doc.reporting.*;
import java.util.*;

public class mergeEventHandler {
    private static int lastIndex;

    public static void main(String[] args) throws Exception {
        String input = "data/mergeEventHandler.docx";
        String output = "output/mergeEventHandler.docx";
        Document document = new Document();
        document.loadFromFile(input);
        lastIndex = 0;

        List<CustomerRecord> customerRecords = new ArrayList<CustomerRecord>();
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

        //execute mailmerge
        document.getMailMerge().MergeField = new MergeFieldEventHandler() {

            @Override
            public void invoke(Object sender, MergeFieldEventArgs args) {
                mailMerge_MergeField(sender, args);
            }
        };
        document.getMailMerge().executeGroup(new MailMergeDataTable("Customer", customerRecords));

        //save doc file.
        document.saveToFile(output, FileFormat.Docx_2013);
    }

    private static void mailMerge_MergeField(Object sender, MergeFieldEventArgs args) {
        //next row
        if (args.getRowIndex() > lastIndex) {
            lastIndex = args.getRowIndex();
            addPageBreakForMergeField(args.getCurrentMergeField());
        }
    }

    private static void addPageBreakForMergeField(IMergeField mergeField) {
        //find needed position to add page break
        boolean foundGroupStart = false;
        Paragraph paramgraph = (Paragraph) mergeField.getPreviousSibling().getOwner();

        while (!foundGroupStart) {
            paramgraph = (Paragraph) paramgraph.getPreviousSibling();
            for (int i = 0; i < paramgraph.getItems().getCount(); i++) {

                ParagraphBase paraBase = paramgraph.getItems().get(i);

                if (paraBase instanceof MergeField) {
                    MergeField merageField = (MergeField) paraBase;
                    if ((merageField != null) && ("GroupStart".equals(merageField.getPrefix()))) {
                        foundGroupStart = true;
                        break;
                    }
                }
            }
        }

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
