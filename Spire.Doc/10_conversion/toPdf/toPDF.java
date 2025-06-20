import com.spire.doc.*;

public class toPDF {
    public static void main(String[] args) {
        // Specify the input file path for the Word document to be processed
        String inputFile = "data/convertedTemplate.docx";

        // Specify the output file path for the resulting PDF document
        String outputFile = "output/toPDF.pdf";

        // Create a new instance of the Document class
        Document document = new Document();

        // Load the Word document from the specified input file
        document.loadFromFile(inputFile);

        // Save the document to the specified output file in PDF format with default settings for other parameters
        document.saveToFile(outputFile, FileFormat.PDF);

        // Dispose of system resources associated with the document
        document.dispose();
    }
}
