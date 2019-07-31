import com.spire.pdf.PdfDocument;
import com.spire.pdf.security.*;

public class decryption {
    public static void main(String[] args) throws java.lang.Exception {
        String inputFile = "data/decryption.pdf";
        String outputFile = "output/decryption_result.pdf";

        //Load a pdf document.
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(inputFile, "test");

        //Decrypt the document
        doc.getSecurity().encrypt("", "", PdfPermissionsFlags.getDefaultPermissions(), PdfEncryptionKeySize.Key_256_Bit, "test");
        doc.saveToFile(outputFile);
        doc.close();

    }
}
