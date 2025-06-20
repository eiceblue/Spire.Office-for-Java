import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.Field;

public class resetPageNumber {
    public static void main(String[] args) {
        // Create a new Document object, document1
        Document document1 = new Document();
        // Load the content of "ResetPageNumber1.docx" file into document1
        document1.loadFromFile("data/ResetPageNumber1.docx");

        // Create a new Document object, document2
        Document document2 = new Document();
        // Load the content of "ResetPageNumber2.docx" file into document2
        document2.loadFromFile("data/ResetPageNumber2.docx");

        // Create a new Document object, document3
        Document document3 = new Document();
        // Load the content of "ResetPageNumber3.docx" file into document3
        document3.loadFromFile("data/ResetPageNumber3.docx");

        // Copy sections from document2 into document1
        for (int i = 0; i < document2.getSections().getCount(); i++) {
            document1.getSections().add(document2.getSections().get(i).deepClone());
        }

        // Copy sections from document3 into document1
        for (int i = 0; i < document3.getSections().getCount(); i++) {
            document1.getSections().add(document3.getSections().get(i).deepClone());
        }

        // Update page numbering in the footers of each section in document1
        for (int i = 0; i < document1.getSections().getCount(); i++) {
            Section sec = document1.getSections().get(i);

            // Iterate through the child objects of the footer in each section
            for (int j = 0; j < sec.getHeadersFooters().getFooter().getChildObjects().getCount(); j++) {
                DocumentObject obj = sec.getHeadersFooters().getFooter().getChildObjects().get(j);

                // Check if the child object is a Structure_Document_Tag
                if (obj.getDocumentObjectType().equals(DocumentObjectType.Structure_Document_Tag)) {
                    DocumentObject para = obj.getChildObjects().get(0);

                    // Iterate through the child objects of the paragraph in Structure_Document_Tag
                    for (int k = 0; k < para.getChildObjects().getCount(); k++) {
                        DocumentObject item = para.getChildObjects().get(k);

                        // Check if the child object is a Field
                        if (item.getDocumentObjectType().equals(DocumentObjectType.Field)) {

                            // Check if the Field type is Field_Num_Pages
                            if (((Field)item).getType().equals(FieldType.Field_Num_Pages)) {
                                // Change the Field type to Field_Section_Pages
                                ((Field)item).setType(FieldType.Field_Section_Pages);
                            }
                        }
                    }
                }
            }
        }

        // Set page numbering options for the second section in document1
        document1.getSections().get(1).getPageSetup().setRestartPageNumbering(true);
        document1.getSections().get(1).getPageSetup().setPageStartingNumber(1);

        // Set page numbering options for the third section in document1
        document1.getSections().get(2).getPageSetup().setRestartPageNumbering(true);
        document1.getSections().get(2).getPageSetup().setPageStartingNumber(1);

        // Specify the output file path and name
        String result = "output/result-resetPageNumber.docx";

        // Save document1 to the specified file in Docx_2013 format
        document1.saveToFile(result, FileFormat.Docx_2013);

        // Release resources occupied by document objects
        document1.dispose();
        document2.dispose();
        document3.dispose();
    }
}
