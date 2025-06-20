import com.spire.doc.*;
import com.spire.doc.fields.*;

public class deleteTableFromTextBox {
    public static void main(String[] args) {
        // Load the document
        Document doc = new Document();

        // Load the document from a file
        doc.loadFromFile("data/TextBoxTable.docx");

        // Get the first textbox
        TextBox textbox = doc.getTextBoxes().get(0);

        // Remove the first table from the textbox
        textbox.getBody().getTables().removeAt(0);

        // Save the document
        doc.saveToFile("output/deleteTableFromTextBox.docx", FileFormat.Docx_2013);

        // Dispose the document
        doc.dispose();
    }
}
