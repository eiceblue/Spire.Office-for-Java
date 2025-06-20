import com.spire.doc.*;

public class xmlToWord {
    public static void main(String[] args) {
        // Specify the input file path for the XML document
        String inputFile = "data/Template_XmlFile.xml";

        // Specify the output file path for the Word document conversion result
        String outputFile = "output/Result-XMLToWord.docx";

        // Create a new Document object
        Document document = new Document();

        // Load the XML document from the specified input file
        document.loadFromFile(inputFile);

        // Save the loaded document to the specified output file in DOCX format
        document.saveToFile(outputFile, FileFormat.Docx);

        // Clean up resources and release memory used by the Document object
        document.dispose();
    }
}
