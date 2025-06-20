import com.spire.pdf.PdfDocument;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.image.BufferedImage;

public class toImage {
    public static void main(String[] args) throws IOException {
        String inputFile = "data/JavaPDFSample_1.pdf";
        String outputPath = "output/";

        // Create a new PdfDocument
        PdfDocument doc = new PdfDocument();

        // Load the PDF document from the input file
        doc.loadFromFile(inputFile);

        BufferedImage image;

        // Iterate through each page in the document
        for (int i = 0; i < doc.getPages().getCount(); i++) {
            // Save the current page as an image
            image = doc.saveAsImage(i);

            // Create a new File object for the image file
            File file = new File(outputPath + "/" + String.format(("ToImage-img-%d.png"), i));

            // Write the image to the file as a PNG
            ImageIO.write(image, "PNG", file);
        }

        // Close the document
        doc.close();

        // Dispose of the resources used by the document
        doc.dispose();

    }
}
