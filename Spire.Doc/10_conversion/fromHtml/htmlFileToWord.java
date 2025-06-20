import com.spire.doc.*;
import com.spire.doc.documents.XHTMLValidationType;

public class htmlFileToWord {
    public static void main(String[] args) {
        // Define the path of the input HTML file
        String inputFile = "data/InputHtmlFile.html";

        // Define the path of the output Word document file
        String outputFile = "output/htmlFileToWord.docx";

        // Create a new instance of Document
        Document document = new Document();

        // Load the HTML file into the document object, specifying the file format as HTML and XHTMLValidationType as None
        document.loadFromFile(inputFile, FileFormat.Html, XHTMLValidationType.None);

        // Save the document to the specified output file, specifying the file format as Docx
        document.saveToFile(outputFile, FileFormat.Docx);

        // Dispose the document object to release any resources associated with it
        document.dispose();
    }
}
