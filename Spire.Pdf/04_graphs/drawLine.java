import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.*;

public class drawLine {
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
        float x = 95;
        float y = 95;
        float width = 400;
        float height = 500;

        // Create pens with specified colors and thickness
        PdfPen pen = new PdfPen(new PdfRGBColor(0, 0, 0), 0.1f);
        PdfPen pen1 = new PdfPen(new PdfRGBColor(255, 0, 0), 0.1f);

        // Draw the rectangle using the first pen
        page.getCanvas().drawRectangle(pen, x, y, width, height);

        // Draw two crossed lines using the second pen
        page.getCanvas().drawLine(pen1, x, y, x + width, y + height);
        page.getCanvas().drawLine(pen1, x + width, y, x, y + height);

        // Restore the previous graphics state
        page.getCanvas().restore(state);

        // Specify the output path
        String result = "output/drawLine_out.pdf";

        // Save the modified document to a file
        pdf.saveToFile(result);

        // Close the PDF document
        pdf.close();

        // Dispose of the PDF document (frees up system resources)
        pdf.dispose();
    }

}
