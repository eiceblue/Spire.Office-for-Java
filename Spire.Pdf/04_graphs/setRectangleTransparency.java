import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.*;

public class setRectangleTransparency {
    public static void main(String[] args) {
            // Create a new PdfDocument object
        PdfDocument pdf = new PdfDocument();

        // Load an existing PDF document from file
        pdf.loadFromFile("data/drawingTemplate.pdf");

        // Get the first page of the PDF document
        PdfPageBase page = pdf.getPages().get(0);

        // Save the current graphics state
        PdfGraphicsState state = page.getCanvas().save();

        // Set the initial position and dimensions of the rectangle
        int x = 200;
        int y = 300;
        int width = 200;
        int height = 100;

        // Create a PdfPen object with black color and thickness of 1
        PdfPen pen = new PdfPen(new PdfRGBColor(Color.black), 1f);

        // Create a PdfBrush object with red color
        PdfBrush brush = new PdfSolidBrush(new PdfRGBColor(Color.red));

        // Set the blending mode to normal and set the transparency of the canvas
        PdfBlendMode mode = PdfBlendMode.Normal;
        page.getCanvas().setTransparency(0.5f, 0.5f, mode);

        // Draw a rectangle on the canvas using the specified pen and brush
        page.getCanvas().drawRectangle(pen, brush, new Rectangle(x, y, width, height));

        // Update the position of the rectangle for the next step
        x = x + width / 2;
        y = y - height / 2;

        // Set a different transparency for the canvas
        page.getCanvas().setTransparency(0.2f, 0.2f, mode);

        // Draw a second rectangle on the canvas with the updated position
        page.getCanvas().drawRectangle(pen, brush, new Rectangle(x, y, width, height));

        // Restore the graphics state to its previous state
        page.getCanvas().restore(state);

        // Save the modified PDF document to a file
        String result = "output/setRectangleTransparency_out.pdf";
        pdf.saveToFile(result);

        // Close the PDF document
        pdf.close();

        // Dispose of the PDF document (frees up system resources)
        pdf.dispose();
    }
}
