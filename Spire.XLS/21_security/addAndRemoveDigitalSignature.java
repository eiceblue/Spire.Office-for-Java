import com.spire.xls.*;
import com.spire.xls.digital.CertificateAndPrivateKey;
import java.util.Date;

public class addAndRemoveDigitalSignature {

    public static void main(String[] args) throws Exception {
        /**
         * Add digital signature
         */
        // Specify the output file path and name for adding digital signature
        String addSignatureOut = "output/addSignatureOut.xlsx";

        // Specify the output file path and name for removing digital signature
        String removeSignatureOut = "output/removeSignatureOut.xlsx";

        // Specify the input Excel file path and name
        String input = "data/AddDigitalSignature.xlsx";

        // Specify the path of the digital certificate file
        String certificatePath = "data/gary.pfx";

        // Specify the password for the digital certificate
        String password = "e-iceblue";

        // Specify the comment for the digital signature
        String comment = "Spire.XLS";

        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load the input Excel file into the Workbook
        workbook.loadFromFile(input);

        // Create a CertificateAndPrivateKey object using the certificate file and password
        CertificateAndPrivateKey cap = new CertificateAndPrivateKey(certificatePath, password);

        // Add a digital signature to the Workbook using the certificate, comment, and current date
        workbook.addDigitalSignature(cap, comment, new Date());

        // Save the signed Workbook to the specified file in Excel 2013 format
        workbook.saveToFile(addSignatureOut, ExcelVersion.Version2013);

        // Release resources associated with the Workbook
        workbook.dispose();

        /**
         * Remove digital signature
         */
        // Create a new Workbook object
        Workbook workbook2 = new Workbook();

        // Load an Excel file from the specified path "addSignatureOut"
        workbook2.loadFromFile(addSignatureOut);

        // Remove all digital signatures from the workbook
        workbook2.removeAllDigitalSignatures();

        // Save the modified workbook to a new file with Excel 2013 format, using the specified output path "removeSignatureOut"
        workbook2.saveToFile(removeSignatureOut, ExcelVersion.Version2013);

        // Release resources associated with the workbook
        workbook2.dispose();
    }
}
