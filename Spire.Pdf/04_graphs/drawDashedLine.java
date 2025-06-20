import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.*;

public class drawDashedLine {
    public static void main(String[] args) {
       // Create a new PDF document
        PdfDocument pdf = new PdfDocument();

        // Add a new page to the document
        PdfPageBase page = pdf.getPages().add();

        // Save the current graphics state
        PdfGraphicsState state = page.getCanvas().save();

        float x = 150;
        float y = 200;
        float width = 300;

        // Create a pen with red color and thickness of 3
        PdfPen pen = new PdfPen(new PdfRGBColor(255, 0, 0), 3f);

        // Set the dash style of the pen to "Dash"
        pen.setDashStyle(PdfDashStyle.Dash);

        // Set the dash pattern of the pen
        pen.setDashPattern(new float[]{1, 4, 1});

        // Draw a dashed line on the page using the pen
        page.getCanvas().drawLine(pen, x, y, x + width, y);

        // Restore the previous graphics state
        page.getCanvas().restore(state);

        String result = "output/drawDashedLine_out.pdf";

        // Save the PDF document to a file
        pdf.saveToFile(result);

        // Close the PDF document
        pdf.close();

        // Dispose of the PDF document (frees up system resources)
        pdf.dispose();
    }
}
