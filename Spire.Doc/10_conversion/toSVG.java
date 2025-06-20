import com.spire.doc.*;

public class toSVG {
    public static void main(String[] args) {
        // Define the input file path
        String inputFile = "data/convertedTemplate.docx";

        // Define the output file path
        String outputFile = "output/toSVG.svg";

        // Create a new Document object
        Document document = new Document();

        // Load the document from the input file
        document.loadFromFile(inputFile);

        // Save the document to the output file in SVG format
        document.saveToFile(outputFile, FileFormat.SVG);

        // Dispose of the document object to free up resources
        document.dispose();
    }
}
