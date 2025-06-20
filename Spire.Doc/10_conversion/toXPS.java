import com.spire.doc.*;

public class toXPS {
    public static void main(String[] args) {
        // Define the path to the input file
        String inputFile = "data/convertedTemplate.docx";

        // Define the path to the output file
        String outputFile = "output/toXPS.xps";

        // Create a new Document object
        Document document = new Document();

        // Load the document from the specified input file
        document.loadFromFile(inputFile);

        // Save the document to the specified output file in XPS format
        document.saveToFile(outputFile, FileFormat.XPS);

        // Dispose of the resources used by the document
        document.dispose();
    }
}
