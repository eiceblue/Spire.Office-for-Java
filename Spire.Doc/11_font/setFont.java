import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.TextRange;
import com.spire.doc.formatting.CharacterFormat;

public class setFont {
    public static void main(String[] args) {
        // Set the input file path
        String inputFile = "data/Template_Docx_1.docx";

        // Set the output file path
        String outputFile = "output/setFont.docx";

        // Create a new Document object
        Document doc = new Document();

        // Load the document from the input file
        doc.loadFromFile(inputFile);

        // Get the first section of the document
        Section s = doc.getSections().get(0);

        // Get the third paragraph of the section
        Paragraph p = s.getParagraphs().get(2);

        // Create a new CharacterFormat object
        CharacterFormat format = new CharacterFormat(doc);

        // Set the font name to Arial and font size to 16
        format.setFontName("Arial");
        format.setFontSize(16);

        // Iterate through the child objects of the paragraph
        for (int j = 0; j < p.getChildObjects().getCount(); j++) {
            // Check if the child object is a TextRange
            if (p.getChildObjects().get(j) instanceof TextRange) {
                // Convert the child object to a TextRange
                TextRange tr = (TextRange)p.getChildObjects().get(j);

                // Apply the character format to the TextRange
                tr.applyCharacterFormat(format);
            }
        }

        // Save the modified document to the output file in Docx format
        doc.saveToFile(outputFile, FileFormat.Docx);

        // Release the resources associated with the document
        doc.dispose();
    }
}
