import com.spire.doc.*;

public class wordToTxt {
    public static void main(String[] args) {
        // Define the path to the input Word document
        String input = "data/convertedTemplate.docx";

        // Define the path for the output text file
        String output = "output/Result-WordToText.txt";

        // Create a new Document object
        Document document = new Document();

        // Load the content of the input Word document into the document object
        document.loadFromFile(input);

        // Save the document as a text file with the specified output path and format
        document.saveToFile(output, FileFormat.Txt);

        // Dispose of the document resources to free up memory
        document.dispose();
    }
}
