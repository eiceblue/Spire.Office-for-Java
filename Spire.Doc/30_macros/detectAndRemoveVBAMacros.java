import com.spire.doc.*;

public class detectAndRemoveVBAMacros {
    public static void main(String[] args) {

        // Create a Word document
        Document document = new Document();

        // Load the file from disk
        document.loadFromFile("data/detectAndRemoveVBAMacros.docm");

        // If the document contains Macros, remove them from the document
        if (document.isContainMacro()) {
            document.clearMacros();
        }

        //Save to file
        String output = "output/detectAndRemoveVBAMacros.docm";
        document.saveToFile(output, FileFormat.Docm);

        // Dispose the document
        document.dispose();
    }
}
