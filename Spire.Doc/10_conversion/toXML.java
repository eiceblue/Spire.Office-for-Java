import com.spire.doc.*;

public class toXML {
    public static void main(String[] args) {
        // Define the input file path and name for the Word document
        String inputFile = "data/toXML.doc";

        // Define the output file path and name for the XML document
        String outputFile = "output/toXML.xml";

        // Create a new instance of the Document class
        Document document = new Document();

        // Load the Word document from the specified input file
        document.loadFromFile(inputFile);

        // Save the document to an XML file using the specified output file path and name,
        // and specifying the file format as XML
        document.saveToFile(outputFile, FileFormat.Xml);

        // Dispose of the document object to free up resources
        document.dispose();
    }
}
