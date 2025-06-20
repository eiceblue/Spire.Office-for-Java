import com.spire.pdf.*;
import com.spire.pdf.texts.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

public class extraction{
    public static void main(String[] args) throws Exception {
        // Load the PDF document
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile("data/extraction.pdf");

        // Create a StringBuilder to store extracted text
        StringBuilder buffer = new StringBuilder();

        // Create an ArrayList to store extracted images
        ArrayList<BufferedImage> images = new ArrayList<BufferedImage>();

        PdfTextExtractOptions extractOptions = new PdfTextExtractOptions();
      
        // Iterate over each page in the document
        for (PdfPageBase page : (Iterable<PdfPageBase>) doc.getPages()) {

            // Define the extractor based on page
            PdfTextExtractor textExtractor = new PdfTextExtractor(page);
            
            // Extract text from the current page and append it to the buffer
            buffer.append(textExtractor.extract(extractOptions));
            
            // Extract images from the current page and add them to the images list
            for (BufferedImage image : page.extractImages()) {
                images.add(image);
            }
        }

        // Save the extracted text to a file
        String fileName = "output/text.txt";
        FileWriter writer = new FileWriter(fileName);
        writer.write(buffer.toString());
        writer.flush();
        writer.close();

        // Save the extracted images to separate files
        int index = 0;
        for (BufferedImage image : images) {
            File output = new File("output/images/" + String.format("Image_%d.png", index++));
            ImageIO.write(image, "PNG", output);
        }

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }
}
