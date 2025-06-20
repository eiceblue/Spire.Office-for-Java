import com.spire.doc.*;

public class macros {
    public static void main(String[] args) {

        // Create a document
        Document doc = new Document();

        // Load Word document which contains macro
        doc.loadFromFile("data/macros.docm", FileFormat.Docm);

        // Save the file
        String output = "output/macros.docm";
        doc.saveToFile(output,FileFormat.Docm);

        // Dispose the document
        doc.dispose();
    }
}
