import com.spire.pdf.*;

public class encryptionNewMethod {
    public static void main(String[] args) {
        // Input file path
        String input = "data/encryption.pdf";

        // Output file path
        String output = "output/encryption_output.pdf";

        // Create a new PDF document object
        PdfDocument doc = new PdfDocument();

        // Load the PDF document from the input file path
        doc.loadFromFile(input);

        // Create a password-based security policy with open and permission passwords
        PdfSecurityPolicy securityPolicy = new PdfPasswordSecurityPolicy("openPwd", "permissionPwd");

        // Set the encryption algorithm to AES 256-bit
        securityPolicy.setEncryptionAlgorithm(PdfEncryptionAlgorithm.AES_256);

        // Set document privilege to forbid all actions
        securityPolicy.setDocumentPrivilege(PdfDocumentPrivilege.getForbidAll());

        // Allow degraded printing
        securityPolicy.getDocumentPrivilege().setAllowDegradedPrinting(true);

        // Allow modification of annotations
        securityPolicy.getDocumentPrivilege().setAllowModifyAnnotations(true);

        // Allow document assembly
        securityPolicy.getDocumentPrivilege().setAllowAssembly(true);

        // Allow modification of document contents
        securityPolicy.getDocumentPrivilege().setAllowModifyContents(true);

        // Allow filling form fields
        securityPolicy.getDocumentPrivilege().setAllowFillFormFields(true);

        // Allow printing
        securityPolicy.getDocumentPrivilege().setAllowPrint(true);

        // Allow printing
        doc.encrypt(securityPolicy);

        // Save the encrypted document to the output file path
        doc.saveToFile(output, FileFormat.PDF);

        // Dispose of the document resources
        doc.dispose();
    }
}
