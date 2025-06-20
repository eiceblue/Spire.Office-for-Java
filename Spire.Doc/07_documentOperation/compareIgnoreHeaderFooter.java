import com.spire.doc.Document;
import com.spire.doc.documents.comparison.CompareOptions;

public class compareIgnoreHeaderFooter {

    public static void main(String[] args) {
        // Load the first document
        Document doc1 = new Document();
        doc1.loadFromFile("Data/compareDoc1.docx");
        // Load the second document
        Document doc2 = new Document();
        doc2.loadFromFile("Data/compareDoc2.docx");
        // Set Compare options
        CompareOptions options = new CompareOptions();
        options.setIgnoreHeadersAndFooters(true);
        // Compare document
        doc1.compare(doc2,"e-iceblue",options);
        // Save document
        doc1.saveToFile("compareIgnoreHeaderFooter_output.docx");
        // Close and dispose document
        doc1.dispose();
        doc1.close();
    }
}
