import com.spire.doc.*;
import com.spire.doc.documents.Paragraph;

public class removeEditableRange {
    public static void main(String[] args) {
        String inputFile = "data/removeEditableRange.docx";
        String outputFile = "output/removeEditableRange_output.docx";

        // Create a new document object
        Document document = new Document();

        // Load the document from the specified input file
        document.loadFromFile(inputFile);

        // Iterate through each section in the document
        for (int j = 0; j < document.getSections().getCount(); j++) {
            Section section = document.getSections().get(j);

            // Iterate through each paragraph in the section
            for (int k = 0; k < section.getParagraphs().getCount(); k++) {
                Paragraph paragraph = section.getParagraphs().get(k);

                // Iterate through each child object in the paragraph
                for (int i = 0; i < paragraph.getChildObjects().getCount(); ) {
                    DocumentObject obj = paragraph.getChildObjects().get(i);

                    // Remove PermissionStart and PermissionEnd objects from the paragraph
                    if (obj instanceof PermissionStart || obj instanceof PermissionEnd) {
                        paragraph.getChildObjects().remove(obj);
                    } else {
                        i++;
                    }
                }
            }
        }

        // Save the modified document to the specified output file in DOCX format
        document.saveToFile(outputFile, FileFormat.Docx);

        // Dispose the document resources
        document.dispose();
    }
}
