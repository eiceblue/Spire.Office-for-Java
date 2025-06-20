import com.spire.pdf.*;

public class changeSecurityPermission {
    public static void main(String[] args) {
        // Specify the input and output file paths
        String input = "data/changeSecurityPermission.pdf";
        String output = "output/changeSecurityPermission_output.pdf";

        // Create a new PdfDocument object
        PdfDocument pdf = new PdfDocument();

        // Load an existing PDF document from the input file path
        pdf.loadFromFile(input);

        // Create a PdfSecurityPolicy with the specified user password and owner password
        PdfSecurityPolicy securityPolicy = new PdfPasswordSecurityPolicy("userpassword", "ownerpassword");

        // Create a PdfDocumentPrivilege with desired permissions (e.g., allow filling form fields)
        PdfDocumentPrivilege privilege = new PdfDocumentPrivilege();
        privilege.setAllowFillFormFields(true);

        // Encrypt the PDF document using the specified security policy
        pdf.encrypt(securityPolicy);

        // Save the encrypted PDF document to the output file path
        pdf.saveToFile(output, FileFormat.PDF);

        // Close the PDF document to release resources
        pdf.close();

        // Dispose of the PDF document to free up system resources
        pdf.dispose();
    }
}
