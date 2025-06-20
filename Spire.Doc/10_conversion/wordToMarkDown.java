import com.spire.doc.Document;
import com.spire.doc.FileFormat;

public class wordToMarkDown {
    public static void main(String[] args) {
        // Instantiate a new Document object
        Document document = new Document();

        // Load the .docx file located at "data/convertedTemplate.docx" into the Document object
        document.loadFromFile("data/convertedTemplate.docx", FileFormat.Docx);

        // Save the content of the Document object as a Markdown file at "output/result.md"
        document.saveToFile("output/result.md", FileFormat.Markdown);

        document.dispose();
    }
}
