import com.spire.doc.*;

public class txtToWord {
    public static void main(String[] args) {
        // Define the path to the input text file
        String input = "data/Template_TxtFile.txt";

        // Define the path for the output Word document
        String output = "output/Result-TxtToWord.docx";

        // Create a new Document object
        Document document = new Document();

        // Load the content of the input text file into the document
        document.loadFromFile(input);

        // Save the document as a Word document with the specified output path and format
        document.saveToFile(output, FileFormat.Docx);

        // Dispose of the document resources to free up memory
        document.dispose();
    }
}
