import com.spire.pdf.*;
import com.spire.pdf.security.*;
import com.spire.pdf.widget.*;
import java.util.ArrayList;

public class verifySignature {
    public static void main(String[] args)  {
        // Specify the input PDF file path
        String input = "data/ExtractImageFromSignature.pdf";

        // Create an ArrayList to store the extracted signatures
        ArrayList<PdfSignature> signatures = new ArrayList<>();

        // Load the PDF document
        PdfDocument pdf = new PdfDocument(input);

        // Get the form widget from the PDF document
        com.spire.pdf.fields.PdfForm tempVar = pdf.getForm();
        PdfFormWidget form = (PdfFormWidget) ((tempVar instanceof PdfFormWidget) ? tempVar : null);

        // Iterate through each field in the form
        for (int i = 0; i < form.getFieldsWidget().getCount(); i++) {
            // Check if the field is a signature field
            PdfSignatureFieldWidget field = (PdfSignatureFieldWidget) ((form.getFieldsWidget().get(i) instanceof PdfSignatureFieldWidget) ? form.getFieldsWidget().get(i) : null);

            if (field != null && field.getSignature() != null) {
                // Get the signature object associated with the field
                PdfSignature signature = field.getSignature();

                // Add the signature to the list of extracted signatures
                signatures.add(signature);
            }
        }

        // Get the first signature from the list
        PdfSignature signatureOne = signatures.get(0);

        // Verify the first signature
        boolean value = signatureOne.verifySignature();

        // Close the PDF document to release resources
        pdf.close();

        // Dispose of the PDF document to free up system resources
        pdf.dispose();
    }
}
