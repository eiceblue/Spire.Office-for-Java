import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.Point2D;

public class drawImage {
    public static void main(String[] args) {
        PdfDocument doc = new PdfDocument();

        // Create one page
        PdfPageBase page = doc.getPages().add();
        
        // This method is used to transform and draw text on a PDF page.
        transformText(page);
        
        // This method is used to draw an image on a PDF page.
        drawImageMethod(page);
        
        // This method is used to transform and draw image on a PDF page.
        transformImage(page);

        // Save pdf file.
        doc.saveToFile("output/drawImage.pdf");
        
        // Close the PDF document
        doc.close();

        // Dispose of the PDF document (frees up system resources)
        doc.dispose();
    }

     // This method is used to transform and draw text on a PDF page.
    private static void transformText(PdfPageBase page) {

        // Save the current graphics state for later restoration.
        PdfGraphicsState state = page.getCanvas().save();

        // Define the font, brushes, and string format for the text.
        PdfFont font = new PdfFont(PdfFontFamily.Helvetica, 18);
        PdfSolidBrush brush1 = new PdfSolidBrush(new PdfRGBColor(Color.blue));
        PdfSolidBrush brush2 = new PdfSolidBrush(new PdfRGBColor(Color.gray));
        PdfStringFormat format = new PdfStringFormat(PdfTextAlignment.Center);

        // Translate the canvas to the center of the page horizontally and set the y-coordinate to 20.
        page.getCanvas().translateTransform(page.getCanvas().getClientSize().getWidth() / 2, 20);

        // Draw the first instance of the text using the first brush.
        page.getCanvas().drawString("Sales Report Chart", font, brush1, 0, 0, format);

        // Scale the canvas vertically by -0.8 and adjust the y-coordinate to position the second instance of the text.
        page.getCanvas().scaleTransform(1f, -0.8f);
        page.getCanvas().drawString("Sales Report Chart", font, brush2, 0, -2 * 18 * 1.2f, format);

        // Restore the saved graphics state.
        page.getCanvas().restore(state);
    }

     // This method is used to draw an image on a PDF page.
    private static void drawImageMethod(PdfPageBase page) {

        // Load the image from a file.
        PdfImage image = PdfImage.fromFile("data/chartImage.png");

        // Calculate the desired width and height of the image.
        float width = image.getWidth() * 0.75f;
        float height = image.getHeight() * 0.75f;

        // Calculate the x-coordinate for centering the image horizontally on the page.
        double x = (page.getCanvas().getClientSize().getWidth() - width) / 2;

        // Draw the image on the page's canvas at the specified position with the calculated width and height.
        page.getCanvas().drawImage(image, (int)x, 60, width, height);
    }

   // This method is used to transform and draw image on a PDF page.
    private static void transformImage(PdfPageBase page) {
        // Load the image from file
        PdfImage image = PdfImage.fromFile("data/chartImage.png");

        // Define skew and scale values
        int skewX = 20;
        int skewY = 20;
        float scaleX = 0.2f;
        float scaleY = 0.6f;

        // Calculate the transformed width and height of the image
        int width = (int)((image.getWidth() + image.getHeight() * Math.tan(Math.PI * skewX / 180)) * scaleX);
        int height = (int)((image.getHeight() + image.getWidth() * Math.tan(Math.PI * skewY / 180)) * scaleY);

        // Create a template with the transformed dimensions
        PdfTemplate template = new PdfTemplate(width, height);

        // Apply scaling and skew transformations to the graphics context of the template
        template.getGraphics().scaleTransform(scaleX, scaleY);
        template.getGraphics().skewTransform(skewX, skewY);

        // Draw the image onto the template
        template.getGraphics().drawImage(image, 0, 0);

        // Save the current graphics state
        PdfGraphicsState state = page.getCanvas().save();

        // Translate and set transparency for a sequence of templates on the page
        page.getCanvas().translateTransform(page.getCanvas().getClientSize().getWidth() - 50, 260);
        double offset = (page.getCanvas().getClientSize().getWidth() - 100) / 12;
        // Apply a series of transformations and draw templates on the page
        for (int i = 0; i < 12; i++) {
            // Translate the canvas horizontally by a negative offset
            page.getCanvas().translateTransform(-offset, 0);

            // Set the transparency based on the current iteration
            page.getCanvas().setTransparency(i / 12.0f);

            // Create a new point object for drawing the template
            Point2D.Float point = new Point2D.Float();
            point.x = 0;
            point.y = 0;

            // Draw the template onto the canvas at the specified point
            page.getCanvas().drawTemplate(template, point);
        }

        // Restore the graphics state
        page.getCanvas().restore(state);
    }
}
