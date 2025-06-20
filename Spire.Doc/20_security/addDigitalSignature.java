import com.spire.doc.*;

public class addDigitalSignature {
    public static void main(String[] args) {
        String input = "data/AddDigitalSignature.docx";
        String output = "output/AddDigitalSignature_output.docx";
        String certificatePath = "data/gary.pfx";
        String securePwd = "e-iceblue";

        // Create a new document object
        Document doc = new Document();

        // Load the document from the specified input file
        doc.loadFromFile(input);

        // Save the document to the specified output file in DOCX format with encryption using the specified certificate path and password
        doc.saveToFile(output, FileFormat.Docx, certificatePath, securePwd);

        // Dispose the document resources
        doc.dispose();
    }
}
