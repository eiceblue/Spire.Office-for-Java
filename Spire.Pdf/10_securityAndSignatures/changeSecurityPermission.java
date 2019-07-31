import com.spire.pdf.PdfDocument;
import com.spire.pdf.security.PdfEncryptionKeySize;
import com.spire.pdf.security.PdfPermissionsFlags;

import java.util.EnumSet;

public class changeSecurityPermission {
    public static void main(String[] args) {
        String inputFile = "data/changeSecurityPermission.pdf";
        String outputPath = "output/changeSecurityPermission_result.pdf";

        //Create and load a pdf document
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile(inputFile);

        //Set an owner password, enable the permissions of fill form fields, set encryption level
        pdf.getSecurity().encrypt("", "test", EnumSet.of(PdfPermissionsFlags.Fill_Fields), PdfEncryptionKeySize.Key_256_Bit);

        //Save and launch
        pdf.saveToFile(outputPath);

    }
}
