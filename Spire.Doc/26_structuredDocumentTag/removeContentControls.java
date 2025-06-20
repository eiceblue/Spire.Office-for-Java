import com.spire.doc.*;
import com.spire.doc.documents.*;

public class removeContentControls {
    public static void main(String[] args) {
        // Create a new instance of Document
        Document doc = new Document();

        // Load the document from a file
        doc.loadFromFile("data/removeContentControls.docx");

        // Iterate over each section in the document
        for (int s = 0; s < doc.getSections().getCount(); s++) {
            Section section = doc.getSections().get(s);

            // Iterate over each child object in the section's body
            for (int i = 0; i < section.getBody().getChildObjects().getCount(); i++) {

                // Check if the child object is a Paragraph
                if (section.getBody().getChildObjects().get(i) instanceof Paragraph) {
                    Paragraph para = (Paragraph) section.getBody().getChildObjects().get(i);

                    // Iterate over each child object in the paragraph
                    for (int j = 0; j < para.getChildObjects().getCount(); j++) {

                        // Check if the child object is a StructureDocumentTagInline
                        if (para.getChildObjects().get(j) instanceof StructureDocumentTagInline) {
                            StructureDocumentTagInline sdt = (StructureDocumentTagInline) para.getChildObjects().get(j);

                            // Remove the StructureDocumentTagInline from the paragraph
                            para.getChildObjects().remove(sdt);

                            // Decrement the index to account for the removed object
                            j--;
                        }
                    }
                }

                // Check if the child object is a StructureDocumentTag
                if (section.getBody().getChildObjects().get(i) instanceof StructureDocumentTag) {
                    StructureDocumentTag sdt = (StructureDocumentTag) section.getBody().getChildObjects().get(i);

                    // Remove the StructureDocumentTag from the section's body
                    section.getBody().getChildObjects().remove(sdt);

                    // Decrement the index to account for the removed object
                    i--;
                }
            }
        }

        // Save the modified document to a file
        String output = "output/removeContentControls.docx";
        doc.saveToFile(output, FileFormat.Docx_2013);

        // Dispose the document object
        doc.dispose();
    }
}
