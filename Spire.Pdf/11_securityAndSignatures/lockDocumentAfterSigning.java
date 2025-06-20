import com.spire.pdf.*;
import com.spire.pdf.graphics.PdfImage;
import com.spire.pdf.security.*;
import java.awt.*;
import java.awt.geom.*;

public class lockDocumentAfterSigning {
    public static void main(String[] args) {
        // Specify the input, output, and PFX file paths
        String input = "data/digitalSignature.pdf";
        String output = "output/digitalSignature_output.pdf";
        String pfxPath = "data/gary.pfx";

        // Create a new PdfDocument object
        PdfDocument doc = new PdfDocument();

        // Load an existing PDF document from the input file path
        doc.loadFromFile(input);

        // Create a PdfCertificate using the PFX file and its password
        PdfCertificate cert = new PdfCertificate(pfxPath, "e-iceblue");

        // Create a PdfSignature object for the first page of the document, using the certificate and a unique signature name
        PdfSignature signature = new PdfSignature(doc, doc.getPages().get(0), cert, "signature0");

        // Set the rectangle boundaries for the signature appearance on the page
        Rectangle2D rect = new Rectangle2D.Float();
        rect.setFrame(new Point2D.Float(90, 550), new Dimension(270, 90));
        signature.setBounds(rect);

        // Set the graphic mode for the signature appearance
        signature.setGraphicMode(GraphicMode.Sign_Image_And_Sign_Detail);

        // Set the label and value for the signer's name
        signature.setNameLabel("Signer:");
        signature.setName("Gary");

        // Set the label and value for contact information
        signature.setContactInfoLabel("ContactInfo:");
        signature.setContactInfo("136558284211");

        // Set the label and value for the date
        signature.setDateLabel("Date:");
        signature.setDate(new java.util.Date());

        // Set the label and value for the location information
        signature.setLocationInfoLabel("Location:");
        signature.setLocationInfo("Chengdu");

        // Set the label and value for the reason of signing
        signature.setReasonLabel("Reason: ");
        signature.setReason("The certificate of this document");

        // Set the label and value for the distinguished name (DN)
        signature.setDistinguishedNameLabel("DN: ");
        signature.setDistinguishedName(signature.getCertificate().get_IssuerName().getName());

        // Set the image source for the signature appearance
        signature.setSignImageSource(PdfImage.fromFile("F:\\Spire\\Spire.Office_8.1.2\\samples\\Spire.Pdf\\data\\E-iceblueLogo.png"));

        // Set the document permissions for the certified PDF
        signature.setDocumentPermissions(PdfCertificationFlags.Forbid_Changes);

        // Enable locking for the signature
        signature.setLock(true);

        // Save the modified PDF document to the output file path
        doc.saveToFile(output, FileFormat.PDF);

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }

}
