import com.spire.doc.*;
import com.spire.doc.interfaces.IDocument;

public class replaceWithDocument {
    public static void main(String[] args) {
        //Create word document.
        Document doc = new Document();

        // Load the file from disk.
        doc.loadFromFile("data/Text2.docx");

        //Create word document.
        IDocument replaceDoc = new Document();

        // Load the second file from disk.
        replaceDoc.loadFromFile("data/Text1.docx");

        // Replace specified text with the other document.
        doc.replace("Document1", replaceDoc, false, true);

        String result = "output/replaceWithDocument.docx";

        // Save to file.
        doc.saveToFile(result, FileFormat.Docx);

        //Dispose the document
        doc.dispose();
    }
}
