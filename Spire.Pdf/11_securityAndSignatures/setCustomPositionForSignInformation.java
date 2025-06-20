import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import com.spire.pdf.security.*;
import java.awt.*;
import java.awt.geom.*;

public class setCustomPositionForSignInformation {
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
        rect.setFrame(new Point2D.Float(90, 550), new Dimension(300, 100));
        signature.setBounds(rect);

        // Load the sign image from file
        PdfImage pdfImage = PdfImage.fromFile("data/E-iceblueLogo.png");

        // Set the image source for the signature appearance
        signature.setSignImageSource(pdfImage);

        // Set the graphic mode for the signature appearance
        signature.setGraphicMode(GraphicMode.Sign_Image_And_Sign_Detail);

        // Set the label and value for the signer's name
        signature.setNameLabel("Signer:");
        signature.setName("Gary");

        // Set the label and value for contact information
        signature.setContactInfoLabel("ContactInfo:");

        // Set the label and value for the distinguished name (DN)
        signature.setDistinguishedNameLabel("DN: ");

        // Set the label and value for the location information
        signature.setLocationInfoLabel("Location:");
        signature.setLocationInfo("Chengdu");

        // Set the label and value for the reason of signing
        signature.setReasonLabel("Reason: ");
        signature.setReason("Le document est certified");

        // Set the label for the date
        signature.setDateLabel("Date:");

        // Set the document permissions for the certified PDF
        signature.setDocumentPermissions(PdfCertificationFlags.Allow_Form_Fill);

        // Enable certification for the signature
        signature.setCertificated(true);

        // Set the font for the sign details text
        signature.setSignDetailsFont(new PdfFont(PdfFontFamily.Times_Roman, 10f));

        // Set the font for the sign name text
        signature.setSignNameFont(new PdfFont(PdfFontFamily.Courier, 15));

        // Enable custom positioning for the signature elements
        signature.setCustomSignPosition(true);

        // Set the custom position for the sign image element
        signature.setCustomSignImagePosition(0, 0, 0.33f, 1f);

        // Set the custom position for the sign name element
        signature.setCustomSignNamePosition(0.2f, 0, 0.2f, 1f);

        // Set the custom position for the sign details element
        signature.setCustomSignDetailPosition(0.33f, 0, 0.66f, 1f);

        // Save the modified PDF document to the output file path
        doc.saveToFile(output, FileFormat.PDF);

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();

    }
}
