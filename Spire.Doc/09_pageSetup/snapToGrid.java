import com.spire.doc.*;
import com.spire.doc.documents.*;

public class snapToGrid {
    public static void main(String[] args) {
        // Define the input file path
        String inputFile = "data/SnapToGrid.docx";

        // Create a new Document object using the input file
        Document document = new Document(inputFile);

        // Get the first section of the document
        Section section = document.getSections().get(0);

        // Iterate through each paragraph in the section
        for (Paragraph paragraph : (Iterable<? extends Paragraph>)section.getParagraphs()) {
            // Set the "SnapToGrid" property of the paragraph's format to true
            paragraph.getFormat().setSnapToGrid(true);
        }

        // Save the modified document to an output file
        document.saveToFile("output/SnapToGrid_out.docx", FileFormat.Docx);

        // Dispose of the document object to release resources
        document.dispose();
    }
}
