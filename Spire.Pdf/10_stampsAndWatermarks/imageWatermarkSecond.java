import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class imageWatermarkSecond {
    public static void main(String[] args) throws IOException {
        // Define the input file paths
        String input1 = "data/headerAndFooter.pdf";
        String input2 = "data/E-logo.png";

        // Define the output file path
        String output = "output/imageWatermarkSecond.pdf";

        // Load the PDF document from the first input file
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(input1);

        // Read the image file and get its dimensions
        BufferedImage image = ImageIO.read(new File(input2));
        int width = image.getWidth();
        int height = image.getHeight();

        // Scale the image by a factor of 1.8
        float scale = 1.8f;

        // Calculate the scaled width and height based on the original dimensions and the scaling factor
        int scaledWidth = (int) (width * scale);
        int scaledHeight = (int) (height * scale);

        // Create a new BufferedImage with the scaled dimensions and ARGB type
        BufferedImage scaledImage = new BufferedImage(scaledWidth, scaledHeight, BufferedImage.TYPE_INT_ARGB);

        // Create a Graphics2D object from the scaled image
        Graphics2D g = scaledImage.createGraphics();

        // Draw the image starting at point (0, 0) with the scaled width and height
        g.drawImage(image, 0, 0, scaledWidth, scaledHeight, null);

        // Dispose the Graphics2D object to release system resources
        g.dispose();

        // Convert the scaled image to a PDF image
        PdfImage pdfImage = PdfImage.fromImage(scaledImage);

        // Get the first page of the document
        PdfPageBase page = doc.getPages().get(0);

        // Save the current graphics state
        page.getCanvas().save();

        // Set transparency for the watermark
        page.getCanvas().setTransparency( 0.5f, 0.5f, PdfBlendMode.Multiply);

        // Draw the image watermark on the page
        page.getCanvas().drawImage(pdfImage, new Point2D.Float(160, 260));

        // Restore the graphics state to its previous state
        page.getCanvas().restore();

        // Save the modified PDF document to the specified output file
        doc.saveToFile(output, FileFormat.PDF);

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }
}
