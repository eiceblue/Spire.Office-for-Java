import com.spire.doc.*;

public class toRtf {
    public static void main(String[] args) {
        // Define the input file path
        String inputFile = "data/convertedTemplate.docx";

        // Define the output file path
        String outputFile = "output/toRtf.rtf";

        // Create a new Document object
        Document document = new Document();

        // Load the document from the input file
        document.loadFromFile(inputFile);

        // Save the document to the output file in RTF format
        document.saveToFile(outputFile, FileFormat.Rtf);

        // Dispose of the document object to free up resources
        document.dispose();
    }
}
