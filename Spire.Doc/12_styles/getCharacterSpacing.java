import com.spire.doc.*;
import com.spire.doc.documents.Paragraph;
import com.spire.doc.fields.TextRange;

public class getCharacterSpacing {
    public static void main(String[] args) {
        // Set the input file path
        String inputFile = "data/Insert.docx";

        // Create a new Document object
        Document document = new Document();

        // Load the document from the input file
        document.loadFromFile(inputFile);

        // Get the first section of the document
        Section section = document.getSections().get(0);

        // Get the first paragraph of the section
        Paragraph p = section.getParagraphs().get(0);

        // Iterate through the child objects of the paragraph
        for (int j = 0; j < p.getChildObjects().getCount(); j++) {
            // Check if the child object is a TextRange
            if (p.getChildObjects().get(j) instanceof TextRange) {
                // Cast the child object to a TextRange
                TextRange tr = (TextRange)p.getChildObjects().get(j);

                // Get the font name and character spacing of the TextRange
                String fontName = tr.getCharacterFormat().getFontName();
                float fontSpacing = tr.getCharacterFormat().getCharacterSpacing();
            }
        }

        // Dispose of the document to release resources
        document.dispose();
    }
}
