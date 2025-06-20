import com.spire.doc.*;

public class executeWithRegion {

    public static void main(String[] args) throws Exception {
        // Path to the XML data file
        String data = "data/dataSample.xml";

        // Path to the input Word document
        String input = "data/ExecuteMailMergeSample.doc";

        // Path to the output Word document
        String output = "output/executeWithRegion.doc";

        // Create a new Document object
        Document doc = new Document();

        // Load the input Word document
        doc.loadFromFile(input);

        // Execute mail merge with region using the specified data
        doc.getMailMerge().executeWidthRegion(data);

        // Save the resulting document to the output path
        doc.saveToFile(output, FileFormat.Doc);

        // Dispose of the document
        doc.dispose();
    }
}
