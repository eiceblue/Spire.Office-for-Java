import com.spire.doc.*;

public class adjustHeaderFooterHeight {
    public static void main(String[] args) {
        String input = "data/headerSample.docx";
        String output = "output/adjustHeaderFooterHeight.docx";

        // Create a new Document object
        Document doc = new Document();

        // Load the document from the input file
        doc.loadFromFile(input);

        // Get the first section of the document
        Section section = doc.getSections().get(0);

        // Set the header distance of the section to 100 points
        section.getPageSetup().setHeaderDistance(100);

        // Set the footer distance of the section to 100 points
        section.getPageSetup().setFooterDistance(100);

        // Save the modified document to the output file in Docx format
        doc.saveToFile(output, FileFormat.Docx);

        // Dispose of the document object to release resources
        doc.dispose();
    }
}
