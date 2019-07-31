import com.spire.pdf.PdfDocument;
import com.spire.pdf.security.PdfSignature;
import com.spire.pdf.widget.*;
import javax.swing.*;
import java.util.ArrayList;

public class isModifiedSignedPDF {
    public static void main(String[] args) {
        String inputFile = "data/isModifiedSignedPDF.pdf";

        ArrayList<PdfSignature> signatures = new ArrayList<PdfSignature>();

        //Open a pdf document and get its all signatures
        PdfDocument pdf = new PdfDocument(inputFile);
        com.spire.pdf.fields.PdfForm tempVar = pdf.getForm();
        PdfFormWidget form = (PdfFormWidget) ((tempVar instanceof PdfFormWidget) ? tempVar : null);
        for (int i = 0; i < form.getFieldsWidget().getCount(); i++) {
            PdfSignatureFieldWidget field = (PdfSignatureFieldWidget) ((form.getFieldsWidget().get(i) instanceof PdfSignatureFieldWidget) ? form.getFieldsWidget().get(i) : null);
            if (field != null && field.getSignature() != null) {
                PdfSignature signature = field.getSignature();
                signatures.add(signature);
            }

            //Get the first signature
            PdfSignature signatureOne = signatures.get(0);

            //Detect if the pdf document was modified
            boolean modified = signatureOne.verifySignature();
            if (modified) {
                JOptionPane.showMessageDialog(null, "The document was modified");
            } else {
                JOptionPane.showMessageDialog(null, "The document was not modified");
            }
        }
        pdf.close();
    }
}
