import com.spire.pdf.PdfDocument;
import com.spire.pdf.security.PdfEncryptionKeySize;
import com.spire.pdf.security.PdfPermissionsFlags;

import java.util.EnumSet;

public class encryption {
    public static void main(String[] args) {
        String inputFile = "data/encryption.pdf";
        String outputFile = "output/encryption_result.pdf";

        //Load a pdf document.
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(inputFile);

        //Encrypt
        PdfEncryptionKeySize keySize = PdfEncryptionKeySize.Key_128_Bit;
        String openPassword = "e-iceblue";
        String permissionPassword = "test";
        EnumSet<PdfPermissionsFlags> flags = EnumSet.of(PdfPermissionsFlags.Print, PdfPermissionsFlags.Fill_Fields);
        doc.getSecurity().encrypt(openPassword, permissionPassword, flags, keySize);

        //Save pdf file.
        doc.saveToFile(outputFile);
        doc.close();
    }
}
