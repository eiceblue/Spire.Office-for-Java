import com.spire.pdf.PdfDocument;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class toTransparentBgImage {
    public static void main(String[] args) throws IOException {
        // Specify the path of the input PDF file
        String input = "data/pdfTemplate_N.pdf";

        // Specify the path of the output image with transparent background
        String output = "output/toImageWithBgTransparent.png";

        // Create a new instance of PdfDocument
        PdfDocument document = new PdfDocument();

        // Load the PDF file into the document
        document.loadFromFile(input);

        // Set the conversion options to save the PDF as an image with a transparent background
        document.getConvertOptions().setPdfToImageOptions(0);

        // Save the first page of the PDF document as an image with a transparent background
        BufferedImage image = document.saveAsImage(0);

        // Write the image to the specified output file in PNG format
        ImageIO.write(image, "PNG", new File(output));

        // Close the original document
        document.close();

        // Dispose of the resources used by the document
        document.dispose();
    }
}
