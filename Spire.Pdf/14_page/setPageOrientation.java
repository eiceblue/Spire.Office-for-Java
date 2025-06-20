import com.spire.pdf.*;
import com.spire.pdf.graphics.PdfImage;
import java.awt.geom.Point2D;

public class setPageOrientation {
    public static void main(String[] args) {
        // Create a new PdfDocument instance
        PdfDocument doc = new PdfDocument();

        // Create a new section in the document
        PdfSection section = doc.getSections().add();

        // Load the image from file
        PdfImage image = PdfImage.fromFile("data/scenery.jpg");

        // Check if the image width is greater than the page width and set the orientation accordingly
        if (image.getPhysicalDimension().getWidth() > section.getPageSettings().getSize().getWidth()) {
            section.getPageSettings().setOrientation(PdfPageOrientation.Landscape);
        } else {
            section.getPageSettings().setOrientation(PdfPageOrientation.Portrait);
        }

        // Add a new page to the section
        PdfPageBase page = section.getPages().add();

        // Draw the image on the page canvas at position (0, 0)
        page.getCanvas().drawImage(image, new Point2D.Float(0, 0));

        // Save the document to a file named "output/setPageOrientation_out.pdf"
        String output = "output/setPageOrientation_out.pdf";
        doc.saveToFile(output);

        // Close the document and release associated resources
        doc.close();
        doc.dispose();
    }
}
