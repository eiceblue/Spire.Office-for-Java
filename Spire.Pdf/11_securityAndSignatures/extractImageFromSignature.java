import com.spire.pdf.PdfDocument;
import com.spire.pdf.widget.PdfFormWidget;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.RenderedImage;
import java.io.*;

public class extractImageFromSignature {
    public static void main(String[] args) throws IOException {
        // Specify the input file path
        String input = "data/extractImageFromSignature.pdf";

        // Create a new PdfDocument object
        PdfDocument doc = new PdfDocument();

        // Load an existing PDF document from the input file path
        doc.loadFromFile(input);

        // Get the form widget of the document
        PdfFormWidget form = (PdfFormWidget) doc.getForm();

        // Extract the signature images from the form widget
        Image[] images = form.extractSignatureAsImages();

        // Save each extracted image as a PNG file
        for (int i = 0; i < images.length; i++) {
            ImageIO.write((RenderedImage) images[i], "png", new File("output/" + i + ".png"));
        }

        System.out.println("Images have been successfully extracted.");

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }
}
