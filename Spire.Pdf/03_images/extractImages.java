import com.spire.pdf.*;
import com.spire.pdf.utilities.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class extractImages {
    public static void main(String[] args) throws IOException {
        // Path to the input PDF file
        String inputFile = "data/ExtractImges.pdf";

        String outputPath = "output/";
        // Create a PDF document
        PdfDocument doc = new PdfDocument();

        // Load a file from disk
        doc.loadFromFile(inputFile);

        // Get the first page of the document
        PdfPageBase page = doc.getPages().get(0);

        // Create an instance of PdfImageHelper to work with images
        PdfImageHelper imageHelper = new PdfImageHelper();

        // Get information about the images on the page
        PdfImageInfo[] imageInfos = imageHelper.getImagesInfo(page);

        // Extract images from the page
        int index = 0;
        BufferedImage image;
        for (PdfImageInfo info : imageInfos) {
            // Get the image from the PdfImageInfo
            image = info.getImage();

            // Save the image as a PNG file with a unique name
            File file = new File(outputPath + "/" + String.format(("ToImage-img-%d.png"), index));

            // Save the image file in PNG format
            ImageIO.write(image, "PNG", file);
            index++;
        }

        // Dispose the PDF document to release resources
        doc.close();
    }
}
