import com.spire.doc.*;

public class toHtml {
    public static void main(String[] args) {
        // Specify the input file path for the Word document to be converted
        String inputFile = "data/toHtmlTemplate.docx";

        // Specify the output file path for the HTML converted document
        String outputFile = "output/toHtml.html";

        // Create a new instance of the Document class
        Document document = new Document();

        // Load the Word document from the specified input file path
        document.loadFromFile(inputFile);

        // Save the document to the specified output file path in HTML format
        document.saveToFile(outputFile, FileFormat.Html);

        // Clean up system resources associated with the Document object
        document.dispose();
    }
}
