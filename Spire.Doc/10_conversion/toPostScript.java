import com.spire.doc.*;

public class toPostScript {
    public static void main(String[] args) {
        // Define the input file path
        String input = "data/convertedTemplate.docx";

        // Define the output file path
        String output = "output/Result-toPostScript.ps";

        // Create a new Document object
        Document document = new Document();

        // Load the document from the input file
        document.loadFromFile(input);

        // Save the document to the output file in PostScript format
        document.saveToFile(output, FileFormat.Post_Script);

        // Dispose of the document object to free up resources
        document.dispose();
    }
}
