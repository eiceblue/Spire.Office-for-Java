import com.spire.pdf.*;
import com.spire.pdf.annotations.*;
import com.spire.pdf.annotations.appearance.PdfAppearance;
import com.spire.pdf.graphics.*;
import java.awt.geom.Rectangle2D;

public class addImageStamp {
    public static void main(String[] args) {
        
		// Load a PDF document from disk
        PdfDocument document = new PdfDocument();
        document.loadFromFile("data/addLayer.pdf");

        // Get the first page of the document
        PdfPageBase page = document.getPages().get(0);

        // Define the position and dimensions of the rectangle for the rubber stamp annotation
        Rectangle2D rect = new Rectangle2D.Float(20, 20, 60, 60);

        // Create a rubber stamp annotation with the specified rectangle
        PdfRubberStampAnnotation stamp = new PdfRubberStampAnnotation(rect);

        // Load the image for the stamp
        PdfImage image = PdfImage.fromFile("data/image stamp.jpg");

        // Create a PDF template with dimensions 210x210 to hold the image
        PdfTemplate template = new PdfTemplate(210, 210);

        // Draw the image onto the template
        template.getGraphics().drawImage(image, 10, 10);

        // Create a PDF appearance for the rubber stamp annotation
        PdfAppearance appearance = new PdfAppearance(stamp);

        // Set the normal appearance of the annotation as the created PDF template
        appearance.setNormal(template);

        // Set the appearance of the rubber stamp annotation to the created PDF appearance
        stamp.setAppearance(appearance);

        // Add the rubber stamp annotation to the page's annotations widget
        page.getAnnotationsWidget().add(stamp);

        // Save the modified document to the specified output file
        String output = "output/addImageStamp-result.pdf";
        document.saveToFile(output, FileFormat.PDF);

        // Close the PDF document to release resources
        document.close();

        // Dispose of the PDF document to free up system resources
        document.dispose();
    }
}
