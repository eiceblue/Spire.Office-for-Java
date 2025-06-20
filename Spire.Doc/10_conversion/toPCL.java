import com.spire.doc.*;

public class toPCL {
    public static void main(String[] args) {
        // Define the input file path for the Word document to be converted
        String input = "data/convertedTemplate.docx";

        // Define the output file path for the converted PCL file
        String output = "output/toPCL.PCL";

        // Create a new instance of the Document class
        Document document = new Document();

        // Load the Word document from the specified input file
        document.loadFromFile(input);

        // Save the document as a PCL file to the specified output path
        document.saveToFile(output, FileFormat.PCL);

        // Release any system resources used by the document
        document.dispose();
    }
}
