import com.spire.doc.*;

public class replaceWithText {
    public static void main(String[] args) {
        //Create word document.
        Document document = new Document();

        // Load the document from disk.
        document.loadFromFile("data/Sample.docx");

        // Replace text
        document.replace("word", "ReplacedText", false, true);

        // Save doc file.
        document.saveToFile("output/replaceWithText.docx", FileFormat.Docx);

        //Dispose the document
        document.dispose();
    }
}
