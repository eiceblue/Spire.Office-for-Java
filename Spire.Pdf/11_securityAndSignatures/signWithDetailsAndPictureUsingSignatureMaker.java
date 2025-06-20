import com.spire.pdf.PdfDocument;
import com.spire.pdf.graphics.PdfImage;
import com.spire.pdf.interactive.digitalsignatures.*;

public class signWithDetailsAndPictureUsingSignatureMaker {
    public static void main(String[] args) {
		// Specify the input and output file paths
        String inputFile = "data/digitalSignature.pdf";
        String imageFile = "data/E-iceblueLogo.png";
        String pfxPath = "data/gary.pfx";
        String outputFile = "output/signWithSignatureMaker.pdf";

        // Create a new PdfDocument object
        PdfDocument doc = new PdfDocument();

        // Load an existing PDF document from the input file path
        doc.loadFromFile(inputFile);

        // Load the certificate from the PFX file and its password
        PdfCertificate x509 = new PdfCertificate(pfxPath, "e-iceblue");

        // Create a PdfOrdinarySignatureMaker object with the document and certificate
        PdfOrdinarySignatureMaker signatureMaker = new PdfOrdinarySignatureMaker(doc, x509);

        // Get the signature object from the signature maker
        PdfSignature signature = signatureMaker.getSignature();

        // Set the signer's name, contact info, location, and reason for signing
        signature.setName("E-iceblue");
        signature.setContactInfo("028-81705109");
        signature.setLocation("ChengDu");
        signature.setReason("The certificate of this document");

        // Create a PdfSignatureAppearance object for configuring the signature appearance
        PdfSignatureAppearance appearance = new PdfSignatureAppearance(signature);

        // Set the labels for the signer's name, contact info, location, reason, and date
        appearance.setNameLabel("Signer:");
        appearance.setContactInfoLabel("Phone:");
        appearance.setLocationLabel("Location:");
        appearance.setReasonLabel("Reason:");
        appearance.setDateLabel("Date:");

        // Set the graphic mode for the signature appearance
        appearance.setGraphicMode(GraphicMode.SignImageAndSignDetail);

        // Set the signature image using the specified image file
        appearance.setSignatureImage(PdfImage.fromFile(imageFile));

        // Iterate through the pages of the document and apply the signature with the configured appearance
        for (int i = 0; i < doc.getPages().getCount(); i++) {
            signatureMaker.makeSignature("signName" + (i + 1), doc.getPages().get(i),
                    (float) doc.getPages().get(i).getActualSize().getWidth() - 340,
                    (float) doc.getPages().get(0).getActualSize().getHeight() - 150, 220, 100, appearance);
        }

        // Save the modified PDF document to the output file path
        doc.saveToFile(outputFile);

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }
}
