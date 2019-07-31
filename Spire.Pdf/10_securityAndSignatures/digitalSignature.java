import com.spire.pdf.PdfDocument;
import com.spire.pdf.security.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.*;

public class digitalSignature {
    public static void main(String[] args) {
        String inputFile = "data/digitalSignature.pdf";
        String outputFile = "output/digitalSignature_result.pdf";
        String pfxPath = "data/gary.pfx";

        //Load a pdf document
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(inputFile);

        //Load the certificate
        PdfCertificate cert = new PdfCertificate(pfxPath, "e-iceblue");

        PdfSignature signature = new PdfSignature(doc, doc.getPages().get(0), cert, "signature0");
        Rectangle2D rect = new Rectangle2D.Float();
        rect.setFrame(new Point2D.Float(90, 550), new Dimension(270, 90));
        signature.setBounds(rect);

        //Set the display mode of graphics, if not set any, the default one will be applied
        signature.setGraphicMode(GraphicMode.Sign_Image_And_Sign_Detail);
        signature.setNameLabel("Signer:");

        signature.setName("Gary");

        signature.setContactInfoLabel("ContactInfo:");
        signature.setContactInfo("136558284211");

        signature.setDateLabel("Date:");
        signature.setDate(new java.util.Date());

        signature.setLocationInfoLabel("Location:");
        signature.setLocationInfo("Chengdu");

        signature.setReasonLabel("Reason: ");
        signature.setReason("The certificate of this document");

        signature.setDistinguishedNameLabel("DN: ");
        signature.setDistinguishedName(signature.getCertificate().get_IssuerName().getName());
        signature.setSignImageSource(PdfImage.fromFile("data/E-iceblueLogo.png"));

        signature.setDocumentPermissions(PdfCertificationFlags.Forbid_Changes);
        signature.setCertificated(true);

        //Save pdf file.
        doc.saveToFile(outputFile);
        doc.close();

    }
}
