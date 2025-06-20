import com.spire.doc.Document;
import com.spire.doc.FileFormat;

public class markDownToWordOrPDF {
    public static void main(String[] args) {
        // Create a new instance of the Document class
        Document document = new Document();

        // Load the content of the Markdown file into the Document object
        document.loadFromFile("data/MarkDownFile.md", FileFormat.Markdown);

        // Save the document as a DOCX file
        document.saveToFile("output/result.docx", FileFormat.Docx_2013);

        // Save the document as a PDF file
        document.saveToFile("output/result.pdf", FileFormat.PDF);
        document.dispose();
    }
}
