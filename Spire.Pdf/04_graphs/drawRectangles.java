import com.spire.pdf.*;
import com.spire.pdf.colorspace.PdfSeparationColor;
import com.spire.pdf.colorspace.PdfSeparationColorSpace;
import com.spire.pdf.graphics.*;
import java.awt.*;

public class drawRectangles {
    public static void main(String[] args) {
         // Load an existing PDF document
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile("data/drawingTemplate.pdf");

        // Get the first page of the document
        PdfPageBase page = pdf.getPages().get(0);

        // Save the current graphics state
        PdfGraphicsState state = page.getCanvas().save();

        // Set the location and size for the first rectangle
        int x = 130;
        int y = 100;
        int width = 300;
        int height = 400;

        // Create a pen with black color and thickness
        PdfPen pen = new PdfPen(new PdfRGBColor(Color.black), 0.1f);

        // Draw the first rectangle using the pen
        page.getCanvas().drawRectangle(pen, new Rectangle(x, y, width, height));

        // Update the location and size for the second rectangle
        y = y + height - 50;
        width = 100;
        height = 50;

        // Initialize an instance of PdfSeparationColorSpace with pink color
        PdfSeparationColorSpace cs = new PdfSeparationColorSpace("MyColor", new PdfRGBColor(Color.pink));

        // Create a pen with red color and thickness
        PdfPen pen1 = new PdfPen(new PdfRGBColor(Color.red), 0.1f);

        // Create a solid brush with a spot color based on the separation color space
        PdfBrush brush = new PdfSolidBrush(new PdfSeparationColor(cs, 0.1f));

        // Draw the second rectangle using the red pen and spot color brush
        page.getCanvas().drawRectangle(pen1, brush, new Rectangle(x, y, width, height));

        // Restore the previous graphics state
        page.getCanvas().restore(state);

        String result = "output/drawRectangles_out.pdf";

        // Save the modified document to a file
        pdf.saveToFile(result);

        // Close the PDF document
        pdf.close();

        // Dispose of the PDF document (frees up system resources)
        pdf.dispose();
    }
}
