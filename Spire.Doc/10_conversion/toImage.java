import com.spire.doc.Document;
import com.spire.doc.documents.ImageType;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class toImage {
    public static void main(String[] args) throws IOException {
        // Specify the input file path for the Word document to be converted
        String input = "data/convertedTemplate.docx";

        // Specify the output file path for the generated image file
        String output = "output/toImage.png";

        // Create a new Document object
        Document document = new Document();

        // Load the Word document from the specified input file path
        document.loadFromFile(input);

        // Save the first page of the document as a BufferedImage object, using Bitmap image type
        BufferedImage image = document.saveToImages(0, ImageType.Bitmap);

        // Create a new File object with the specified output file path
        File file = new File(output);

        // Write the BufferedImage object to the output file in PNG format
        ImageIO.write(image, "PNG", file);

        // Dispose of the resources used by the Document object
        document.dispose();
    }
}
