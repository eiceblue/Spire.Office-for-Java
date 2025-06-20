import com.spire.pdf.PdfDocument;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class convertAllPagesToPNG {
    public static void main(String[] args) throws  Exception{
        // Path to the input PDF file
        String inputFile = "data/toImage.pdf";

        // Path to the output directory where images will be saved
        String outputPath = "output/";

        //Create a pdf document object
        PdfDocument doc = new PdfDocument();

        // Load pdf file
        doc.loadFromFile(inputFile);

        // Creates a BufferedImage object to store image
        BufferedImage image;

        // Save each page of the PDF as an image
        for (int i = 0; i < doc.getPages().getCount(); i++) {

            // Convert the current page to an image
            image = doc.saveAsImage(i);

            // Create a file object with a unique name for the image file
            File file = new File(outputPath + "/" + String.format(("ToImage-img-%d.png"), i));

            // Save the image file in PNG format
            ImageIO.write(image, "PNG", file);
        }

        // Close the PDF document
        doc.close();

        // Dispose of the PDF document (frees up system resources)
        doc.dispose();
    }
}
