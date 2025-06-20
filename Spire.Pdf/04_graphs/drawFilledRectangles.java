import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.*;

public class drawFilledRectangles {
    public static void main(String[] args) {
        // Create a PDF document
        PdfDocument pdf = new PdfDocument();

        //Load the file from disk
        pdf.loadFromFile("data/drawingTemplate.pdf");

        // Get the first page of the document
        PdfPageBase page = pdf.getPages().get(0);

        // Save the current graphics state
        PdfGraphicsState state = page.getCanvas().save();

        // Set the location and size of the rectangle
        int x = 200;
        int y = 300;
        int width = 200;
        int height = 120;

        // Create a pen with black color and thickness of 1
        PdfPen pen = new PdfPen(new PdfRGBColor(0, 0, 0), 1f);

        // Create a brush with red color
        PdfBrush brush = new PdfSolidBrush(new PdfRGBColor(255, 0, 0));

        // Draw a filled rectangle on the page
        page.getCanvas().drawRectangle(pen, brush, new Rectangle(new Point(x, y), new Dimension(width, height)));

        // Restore the previous graphics state
        page.getCanvas().restore(state);

        String result = "output/drawFilledRectangles_out.pdf";

        // Save the modified document to a file
        pdf.saveToFile(result);

        // Close the PDF document
        pdf.close();

        // Dispose of the PDF document (frees up system resources)
        pdf.dispose();
    }
}
