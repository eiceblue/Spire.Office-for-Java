import com.spire.doc.*;
import com.spire.doc.documents.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class htmlToImage {
    public static void main(String[] args) throws Exception{
        // Create a new Document object
        Document document = new Document();

        // Load an HTML file into the document, specifying the file format as Html and XHTML validation type as None
        document.loadFromFile("data/Template_HtmlFile1.html", FileFormat.Html, XHTMLValidationType.None);

        // Save the first page of the document as an image in Bitmap format
        BufferedImage image = document.saveToImages(0, ImageType.Bitmap);

        // Specify the output file path and name for the generated image
        String result = "output/result-HtmlToImage.png";

        // Create a new File object with the specified result file path
        File file = new File(result);

        // Write the image to the specified file in PNG format
        ImageIO.write(image, "PNG", file);

        // Dispose of the document resources
        document.dispose();
    }
}
