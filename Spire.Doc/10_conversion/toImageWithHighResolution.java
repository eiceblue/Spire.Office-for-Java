import com.spire.doc.*;
import com.spire.doc.documents.*;

import javax.imageio.*;
import java.awt.image.*;
import java.io.*;

public class toImageWithHighResolution {
    public static void main(String[] args) throws IOException {
        // Specify the input file path for the Word document to be converted
        String input = "data/imageResolutionTemplate.docx";

        // Specify the output file path for the generated high-resolution image file
        String output = "output/toImageWithHighResolution.png";

        // Create a new Document object
        Document document = new Document();

        // Load the Word document from the specified input file path
        document.loadFromFile(input);

        // Save the first page of the document as an array of BufferedImages with high resolution (300x300 pixels)
        BufferedImage[] image = document.saveToImages(0, 1, ImageType.Bitmap, 300, 300);

        // Create a new File object with the specified output file path
        File file = new File(output);

        // Write the first BufferedImage from the array to the output file in PNG format
        ImageIO.write(image[0], "PNG", file);

        // Dispose of the resources used by the Document object
        document.dispose();
    }
}
