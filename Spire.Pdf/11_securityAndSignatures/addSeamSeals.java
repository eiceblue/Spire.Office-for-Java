import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.*;

public class addSeamSeals {
    public static void main(String[] args) throws IOException {
        // Specify the input and output file paths
        String input = "data/addSeamSeals.pdf";
        String output = "output/addSeamSealsOutput.pdf";

        // Create a new PdfDocument object
        PdfDocument doc = new PdfDocument();

        // Load an existing PDF document from the input file path
        doc.loadFromFile(input);

        // Create a PdfUnitConvertor for unit conversion operations
        PdfUnitConvertor convert = new PdfUnitConvertor();

        // Declare variables for page, image array, and coordinates
        PdfPageBase pageBase = null;
        BufferedImage[] images = GetImage(doc.getPages().getCount());
        float x = 0;
        float y = 0;

        // Iterate through each page of the document
        for (int i = 0; i < doc.getPages().getCount(); i++) {
            // Retrieve the corresponding image for the current page
            BufferedImage image = images[i];

            // Get the PdfPageBase object for the current page
            pageBase = doc.getPages().get(i);

            // Calculate the X and Y coordinates for placing the image on the page
            x = (float) pageBase.getSize().getWidth() - convert.convertUnits(image.getWidth(), PdfGraphicsUnit.Pixel, PdfGraphicsUnit.Point);
            y = (float) pageBase.getSize().getHeight() / 2;

            // Draw the image onto the page's canvas using PdfImage.fromImage() and the calculated coordinates
            pageBase.getCanvas().drawImage(PdfImage.fromImage(image), new Point2D.Float(x, y));
        }

        // Save the modified PDF document to the output file path
        doc.saveToFile(output);

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }

	static BufferedImage[] GetImage(int num) throws IOException {
        // Specify the file path of the original image
        String originalImg = "data/SealImage.jpg";

        // Read the original image using ImageIO and store it in a BufferedImage object
        BufferedImage image = ImageIO.read(new File(originalImg));

        // Determine the number of rows and columns for chunk division
        int rows = 1;
        int cols = num;

        // Calculate the total number of image chunks
        int chunks = rows * cols;

        // Calculate the width and height of each image chunk based on the original image dimensions and chunk division
        int chunkWidth = image.getWidth() / cols;
        int chunkHeight = image.getHeight() / rows;

        // Create an array to store the generated image chunks
        BufferedImage[] imgs = new BufferedImage[chunks];

        // Initialize a counter for indexing the image chunks in the array
        int count = 0;

        // Loop through the rows and columns to generate each image chunk
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                // Create a new BufferedImage object for the current chunk with the appropriate width, height, and image type
                imgs[count] = new BufferedImage(chunkWidth, chunkHeight, image.getType());

                // Obtain the Graphics2D object from the current chunk image for drawing operations
                Graphics2D gr = imgs[count++].createGraphics();

                // Draw a portion of the original image onto the current chunk, adjusting the coordinates and size
                gr.drawImage(
                        image,
                        0,
                        0,
                        chunkWidth,
                        chunkHeight,
                        chunkWidth * y,
                        chunkHeight * x,
                        chunkWidth * y + chunkWidth,
                        chunkHeight * x + chunkHeight,
                        Color.WHITE,
                        null
                );
                // Dispose of the Graphics2D object to release system resources
                gr.dispose();
            }
        }
        // Return the array of generated image chunks
        return imgs;
    }
}


