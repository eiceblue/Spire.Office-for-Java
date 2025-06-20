import com.spire.pdf.*;
import com.spire.pdf.graphics.*;

import java.awt.*;

public class drawRotatedText {
    public static void main(String[] args) {
        // Create a pdf document
        PdfDocument doc = new PdfDocument();

        // Add a new page
        PdfPageBase page = doc.getPages().add();

        // Define the font for the text
        PdfFont font = new PdfFont(PdfFontFamily.Helvetica, 10f);

        // Define the brush color
        PdfSolidBrush brush = new PdfSolidBrush(new PdfRGBColor(Color.BLUE));

        // Define the text to be drawn
        String text = "This is a text";

        // Draw the text at position (20, 30)
        page.getCanvas().drawString(text, font, brush, 20, 30);

        // Draw the text at position (20, 200)
        page.getCanvas().drawString(text, font, brush, 20, 200);

        // Save the current graphics state
        PdfGraphicsState state = page.getCanvas().save();

        // Define the starting point for the transformed text
        Point point1 = new Point(20, 0);

        // Apply translation and rotation transformations to the canvas
        page.getCanvas().translateTransform(20, 30);

        // Rotate 90 degrees clockwise
        page.getCanvas().rotateTransform(90);

        // Draw the transformed text
        page.getCanvas().drawString(text, font, brush, point1);

        // Restore the graphics state to undo the transformations
        page.getCanvas().restore(state);

        // Save the state after restoring, in order to draw a new text
        PdfGraphicsState state2 = page.getCanvas().save();

        // Define the starting point for the second transformed text
        Point point2 = new Point(20, 0);

        // Apply translation and rotation transformations to the canvas again
        page.getCanvas().translateTransform(20, 200);

        // Rotate 90 degrees counterclockwise
        page.getCanvas().rotateTransform(-90);

        // Draw the second transformed text
        page.getCanvas().drawString(text, font, brush, point2);

        // Restore the graphics state again to undo the transformations for the second text
        page.getCanvas().restore(state2);

        // Save the document to the specified file path
        doc.saveToFile("output/drawRotatedText.pdf");

        // Close the document
        doc.close();

        // Dispose of the document (frees up system resources)
        doc.dispose();
    }
}
