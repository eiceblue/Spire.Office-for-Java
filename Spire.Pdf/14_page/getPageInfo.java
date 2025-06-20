import com.spire.pdf.*;
import java.io.*;

public class getPageInfo {
    public static void main(String[] args) throws IOException {
        // Specify the input and output file paths
        String inputFile = "data/getPageInfo.pdf";
        String outputFile = "output/getPageInfo_out.txt";

        // Create a new PdfDocument object
        PdfDocument doc = new PdfDocument();

        // Load the PDF document from the input file
        doc.loadFromFile(inputFile);

        // Retrieve the first page of the document
        PdfPageBase page = doc.getPages().get(0);

        // Retrieve the width, height, X coordinate, and Y coordinate of the MediaBox
        double MediaBoxWidth = page.getMediaBox().getWidth();
        double MediaBoxHeight = page.getMediaBox().getHeight();
        double MediaBoxX = page.getMediaBox().getX();
        double MediaBoxY = page.getMediaBox().getY();

        // Retrieve the width, height, X coordinate, and Y coordinate of the BleedBox
        double BleedBoxWidth = page.getBleedBox().getWidth();
        double BleedBoxHeight = page.getBleedBox().getHeight();
        double BleedBoxX = page.getBleedBox().getX();
        double BleedBoxY = page.getBleedBox().getY();

        // Retrieve the width, height, X coordinate, and Y coordinate of the CropBox
        double CropBoxWidth = page.getCropBox().getWidth();
        double CropBoxHeight = page.getCropBox().getHeight();
        double CropBoxX = page.getCropBox().getX();
        double CropBoxY = page.getCropBox().getY();

        // Retrieve the width, height, X coordinate, and Y coordinate of the ArtBox
        double ArtBoxWidth = page.getArtBox().getWidth();
        double ArtBoxHeight = page.getArtBox().getHeight();
        double ArtBoxX = page.getArtBox().getX();
        double ArtBoxY = page.getArtBox().getY();

       // Retrieve the width, height, X coordinate, and Y coordinate of the TrimBox
        double TrimBoxWidth = page.getTrimBox().getWidth();
        double TrimBoxHeight = page.getTrimBox().getHeight();
        double TrimBoxX = page.getTrimBox().getX();
        double TrimBoxY = page.getTrimBox().getY();

        // Retrieve the actual size of the page
        double actualSizeW = page.getActualSize().getWidth();
        double actualSizeH = page.getActualSize().getHeight();

        // Retrieve the rotation angle of the page
        PdfPageRotateAngle rotationAngle = page.getRotation();
        String rotation = rotationAngle.toString();

        // Create a StringBuilder to store the page information
        StringBuilder content = new StringBuilder();

        // Append the page information to the StringBuilder
        content.append("MediaBox width: " + MediaBoxWidth + "pt, height: " + MediaBoxHeight + "pt, RectangleF X: " + MediaBoxX + "pt, RectangleF Y: " + MediaBoxY + "pt.");
        content.append("\r\n");
        content.append("BleedBox width: " + BleedBoxWidth + "pt, height: " + BleedBoxHeight + "pt, RectangleF X: " + BleedBoxX + "pt, RectangleF Y: " + BleedBoxY + "pt.");
        content.append("\r\n");
        content.append("CropBox width: " + CropBoxWidth + "pt, height: " + CropBoxHeight + "pt, RectangleF X: " + CropBoxX + "pt, RectangleF Y: " + CropBoxY + "pt.");
        content.append("\r\n");
        content.append("ArtBox width: " + ArtBoxWidth + "pt, height: " + ArtBoxHeight + "pt, RectangleF X: " + ArtBoxX + "pt, RectangleF Y: " + ArtBoxY + "pt.");
        content.append("\r\n");
        content.append("TrimBox width: " + TrimBoxWidth + "pt, height: " + TrimBoxHeight + "pt, RectangleF X: " + TrimBoxX + "pt, RectangleF Y: " + TrimBoxY + "pt.");
        content.append("\r\n");
        content.append("The actual size of the current page width: " + actualSizeW);
        content.append("\r\n");
        content.append("The actual size of the current page height: " + actualSizeH);
        content.append("\r\n");
        content.append("The rotation angle of the current page: " + rotation);
        content.append("\r\n");

        // Create a FileWriter to write the page information to the output file
        FileWriter writer = new FileWriter(outputFile);
        writer.write(content.toString());
        writer.flush();
        writer.close();

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }
}
