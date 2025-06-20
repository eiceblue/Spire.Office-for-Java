import com.spire.doc.*;

public class wordtoWordXML {
    public static void main(String[] args) {
        // Specify the input file path for the Word document
        String inputFile = "data/Template_Docx_1.docx";

        // Specify the output file path for the Word to WordML conversion result
        String result1 = "output/Result-WordToWordML.xml";

        // Specify the output file path for the Word to WordXML conversion result
        String result2 = "output/Result-WordToWordXML.xml";

        // Create a new Document object
        Document document = new Document();

        // Load the Word document from the specified input file
        document.loadFromFile(inputFile);

        // Save the loaded document to the specified output file in WordML format
        document.saveToFile(result1, FileFormat.Word_ML);

        // Save the loaded document to the specified output file in WordXML format
        document.saveToFile(result2, FileFormat.Word_Xml);

        // Clean up resources and release memory used by the Document object
        document.dispose();
    }
}
