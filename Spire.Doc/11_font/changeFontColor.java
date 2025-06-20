import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.TextRange;

import java.awt.*;

public class changeFontColor {
    public static void main(String[] args) {
        // Specify the input file path for the Word document to be processed
        String inputFile = "data/Sample.docx";

        // Specify the output file path for the resulting Word document with changed font color
        String outputFile = "output/ChangeFontColor.docx";

        // Create a new instance of the Document class
        Document doc = new Document();

        // Load the Word document from the specified input file
        doc.loadFromFile(inputFile);

        // Get the first section of the document
        Section section = doc.getSections().get(0);

        // Get the first paragraph of the section
        Paragraph p1 = section.getParagraphs().get(0);

        // Loop through each child object in the first paragraph
        for (int i = 0; i < p1.getChildObjects().getCount(); i++) {
            // Check if the child object is a TextRange
            if (p1.getChildObjects().get(i) instanceof TextRange) {
                // Cast the child object to TextRange
                TextRange tr = (TextRange)p1.getChildObjects().get(i);
                // Set the text color of the TextRange to red
                tr.getCharacterFormat().setTextColor(Color.red);
            }
        }

        // Get the second paragraph of the section
        Paragraph p2 = section.getParagraphs().get(1);

        // Loop through each child object in the second paragraph
        for (int j = 0; j < p2.getChildObjects().getCount(); j++) {
            // Check if the child object is a TextRange
            if (p2.getChildObjects().get(j) instanceof TextRange) {
                // Cast the child object to TextRange
                TextRange tr = (TextRange)p2.getChildObjects().get(j);
                // Set the text color of the TextRange to gray
                tr.getCharacterFormat().setTextColor(Color.GRAY);
            }
        }

        // Save the document to the specified output file in DOCX format
        doc.saveToFile(outputFile, FileFormat.Docx);

        // Dispose of system resources associated with the document
        doc.dispose();
    }
}
