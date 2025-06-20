import com.spire.doc.*;

public class print {
    public static void main(String[] args) {

        // Create a document
        Document document = new Document();

        // Load the document
        document.loadFromFile("data/print.docx");

        // Print the document
        document.getPrintDocument().print();

        //Dispose the document
        document.dispose();
    }
}
