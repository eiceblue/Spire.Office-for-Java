import com.spire.doc.*;
import com.spire.doc.documents.*;

public class setBeforOrAfterSpacingLines {
    public static void main(String[] args) {
        // Create a new Document object
        Document doc = new Document();

        // Load a Word document from a specific file path
        doc.loadFromFile("data/Sample.docx");

        // Access the first section of the document
        Section section = doc.getSections().get(0);

        // Access the first paragraph in the section
        Paragraph paragraph = section.getParagraphs().get(0);

        // Set the spacing before the paragraph
        paragraph.getFormat().setBeforeSpacingLines(5f);

        // Set the spacing after the paragraph 
        paragraph.getFormat().setAfterSpacingLines(15f);

        // Save the modified document to a new file
        doc.saveToFile("output/setBeforOrAfterSpacingLines.docx");
		
		// Dispose the Document resources
		doc.dispose();
    }
}
