import com.spire.doc.*;
import com.spire.doc.documents.*;

public class setImageBackground {
    public static void main(String[] args) {
        // Create a new Document object
        Document document = new Document();

        // Load an existing document from the specified file path
        document.loadFromFile("data/Template.docx");

        // Set the background type to "Picture"
        document.getBackground().setType(BackgroundType.Picture);

        // Set the picture for the background using the specified image file path
        document.getBackground().setPicture("data/Background.png");

        // Specify the output file path
        String result = "output/result-ImageBackground.docx";

        // Save the modified document to the output file path in Docx format
        document.saveToFile(result, FileFormat.Docx);

        // Dispose the document object to release resources
        document.dispose();
    }
}
