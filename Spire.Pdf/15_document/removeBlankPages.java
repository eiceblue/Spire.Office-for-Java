import com.spire.pdf.*;
import java.awt.*;
import java.awt.image.*;
import static com.spire.pdf.graphics.PdfImageType.Bitmap;

public class removeBlankPages {
    public static void main(String[] args) {
        // Create a PdfDocument object to load the original document
        PdfDocument document = new PdfDocument();

        // Load the PDF document from the file "data/removeBlankPages.pdf"
        document.loadFromFile("data/removeBlankPages.pdf");

        // Iterate through each page of the document in reverse order
        for (int i = document.getPages().getCount() - 1; i >= 0; i--) {
            // Check if the current page is blank based on its content
            if (document.getPages().get(i).isBlank()) {
                // Remove the blank page from the document
                document.getPages().removeAt(i);
            } else {
                // Save the page as an image
                BufferedImage image = document.saveAsImage(i, Bitmap);

                // Check if the image is blank
                if (isImageBlank(image)) {
                    // Remove the page from the document
                    document.getPages().removeAt(i);
                }
            }
        }

        // Specify the output file path for the modified PDF document
        String output = "output/removeBlankPages.pdf";

        // Save the modified document to a new PDF file
        document.saveToFile(output);

        // Close and dispose of system resources associated with the original document
        document.close();
        document.dispose();
    }

    public static boolean isImageBlank(BufferedImage image) {
        // Traverse image width and height to obtain pixels
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                int pixel = image.getRGB(i, j);
                Color c = new Color(pixel);
                // Check if any color component is below the threshold value of 240
                if (c.getRed() < 240 || c.getGreen() < 240 || c.getBlue() < 240) {
                    return false;
                }
            }
        }
        return true;
    }
}
