import com.spire.doc.*;
import com.spire.doc.documents.*;

public class removePageBreaks {
    public static void main(String[] args) {
        // Create a new instance of the Document class
        Document document = new Document();

        // Load an existing Word document from the specified file path
        document.loadFromFile("data/Template_Docx_4.docx");

        // Iterate through the paragraphs in the first section of the document
        for (int j = 0; j < document.getSections().get(0).getParagraphs().getCount(); j++) {
            // Get the current paragraph
            Paragraph p = document.getSections().get(0).getParagraphs().get(j);

            // Iterate through the child objects (elements) in the paragraph
            for (int i = 0; i < p.getChildObjects().getCount(); i++) {
                // Get the current child object
                DocumentObject obj = p.getChildObjects().get(i);

                // Check if the child object is a Break
                if (obj.getDocumentObjectType().equals(DocumentObjectType.Break)) {
                    // Cast the child object to a Break
                    Break b = (Break)obj;

                    // Remove the Break from the collection of child objects in the paragraph
                    p.getChildObjects().remove(b);
                }
            }
        }

        // Specify the file path for the resulting Word document
        String result = "output/result-removePageBreaks.docx";

        // Save the modified document to the specified file path in the Docx format compatible with Word 2013 or later
        document.saveToFile(result, FileFormat.Docx_2013);

        // Release any resources used by the Document instance
        document.dispose();
    }
}
