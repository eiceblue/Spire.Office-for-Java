import com.spire.pdf.*;
import com.spire.pdf.security.*;
import com.spire.pdf.widget.*;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class isModifiedSignedPDF {
    public static void main(String[] args) throws IOException {
       // Specify the input file path
        String input = "data/isModifiedSignedPDF.pdf";

        // Create an ArrayList to store PdfSignature objects
        ArrayList<PdfSignature> signatures = new ArrayList<>();

        // Create a new PdfDocument object from the input file path
        PdfDocument pdf = new PdfDocument(input);

        // Get the form widget of the document
        PdfFormWidget form = (PdfFormWidget) pdf.getForm();

        // Iterate through each field in the form widget
        for (int i = 0; i < form.getFieldsWidget().getCount(); i++) {
            // Check if the field is a signature field and retrieve its signature
            PdfSignatureFieldWidget field = (PdfSignatureFieldWidget) form.getFieldsWidget().get(i);
            if (field != null && field.getSignature() != null) {
                PdfSignature signature = field.getSignature();
                signatures.add(signature);
            }
        }

        // Get the first signature from the list
        PdfSignature signatureOne = signatures.get(0);

        // Verify if the PDF document was modified
        boolean modified = signatureOne.verifyDocModified();

        // Show a message box with the result
        if (modified) {
            JOptionPane.showMessageDialog(null, "The document was modified");
        } else {
            JOptionPane.showMessageDialog(null, "The document was not modified");
        }

        // Close the PDF document to release resources
        pdf.close();

        // Dispose of the PDF document to free up system resources
        pdf.dispose();
    }
}
