import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.*;

public class fillStrokeText {
    public static void main(String[] args) {
        // Define the input file path
        String input = "data/stamp.pdf";

        // Define the output file path
        String output = "output/fillStrokeText.pdf";

        // Load the PDF document from the input file
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(input);

        // Get the first page of the document
        PdfPageBase page = doc.getPages().get(0);

        // Create a pen with gray color for stroke
        PdfPen pen = new PdfPen(new PdfRGBColor(Color.GRAY));

        // Save the current graphics state
        PdfGraphicsState state = page.getCanvas().save();

        // Rotate the canvas by -20 degrees
        page.getCanvas().rotateTransform(-20);

        // Create a string format with character spacing of 5
        PdfStringFormat format = new PdfStringFormat();
        format.setCharacterSpacing(5f);

        // Draw the filled and stroked text "E-ICEBLUE" on the rotated canvas
        page.getCanvas().drawString("E-ICEBLUE", new PdfFont(PdfFontFamily.Helvetica, 45f), pen, 0, 500f, format);

        // Restore the graphics state to its previous state
        page.getCanvas().restore(state);

        // Save the modified PDF document to the specified output file
        doc.saveToFile(output, FileFormat.PDF);

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }
}
