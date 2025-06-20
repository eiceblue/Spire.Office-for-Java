import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import com.spire.pdf.interactive.digitalsignatures.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class addImageSignature {
    public static void main(String[] args) {
        // Create a new PdfDocument object
        PdfDocument doc = new PdfDocument();

        // Load an existing PDF document from the file path "data/AddImageSignature.pdf"
        doc.loadFromFile("data/AddImageSignature.pdf");

        // Create a PdfCertificate object with the certificate file path and password
        PdfCertificate cert = new PdfCertificate("data/gary.pfx", "e-iceblue");

        // Create a PdfOrdinarySignatureMaker with the loaded document and certificate
        PdfOrdinarySignatureMaker signatureMaker = new PdfOrdinarySignatureMaker(doc, cert);

        // Create an instance of the custom signature appearance class
        IPdfSignatureAppearance signatureAppearance = new PdfCustomSignatureAppearance();

        // Make the signature using the specified name and custom signature appearance
        signatureMaker.makeSignature("Signature", signatureAppearance);

        // Save the resulting PDF document to the file path "output/result.pdf" as PDF format
        doc.saveToFile("output/result.pdf", FileFormat.PDF);

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }
	
    public static class PdfCustomSignatureAppearance implements IPdfSignatureAppearance {

         // Generates the signature appearance on the provided PdfCanvas.
        @Override
        public void generate(PdfCanvas pdfCanvas) {
            // Load the image file
            File file = new File("data/AddImageSignature.png");
            BufferedImage image = null;

            try {
                // Read the image file into a BufferedImage object
                image = ImageIO.read(file);

                // Draw the image on the PdfCanvas at coordinates (0, 0)
                pdfCanvas.drawImage(PdfImage.fromImage(image), 0, 0);
            } catch (IOException e) {
                // If an error occurs while reading the image file, throw a RuntimeException
                throw new RuntimeException(e);
            }
        }
    }
}
