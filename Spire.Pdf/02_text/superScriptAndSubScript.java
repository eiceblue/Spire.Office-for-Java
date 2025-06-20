import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.*;

public class superScriptAndSubScript {
    public static void main(String[] args) {
        // Create a new PDF document
        PdfDocument doc = new PdfDocument();

        // Add a new page to the document
        PdfPageBase page = doc.getPages().add();

        // Define the font and brush for drawing text
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial", Font.ITALIC, 20));
        PdfSolidBrush brush = new PdfSolidBrush(new PdfRGBColor(Color.black));

        // Set the text to be drawn
        String text = "Spire.PDF for Java";

        // Draw Superscript
        DrawSuperscript(page, text, font, brush);

        // Draw Subscript
        DrawSubscript(page, text, font, brush);

        // Specify the output file path
        String result = "output/superScriptAndSubScript.pdf";

        // Save the document to the specified file
        doc.saveToFile(result);

        // Close the PDF document
        doc.close();

        // Dispose of the PDF document (frees up system resources)
        doc.dispose();
    }

    private static void DrawSuperscript(PdfPageBase page,String text,PdfTrueTypeFont font,PdfSolidBrush brush)
    {
        float x = 120f;
        float y = 100f;

        // Draw the base text
        page.getCanvas().drawString(text, font, brush, new Point2D.Float(x, y));

        // Measure the string to determine its size
        Dimension2D size = font.measureString(text);

        // Set the x coordinate for the superscript text
        x += size.getWidth();

        // Instantiate a PdfStringFormat object
        PdfStringFormat format = new PdfStringFormat();

        // Set the format as superscript
        format.setSubSuperScript(PdfSubSuperScript.Super_Script);

        // Specify the superscript text to be drawn
        text = "Superscript";

        // Draw the superscript text with the specified format
        page.getCanvas().drawString(text, font, brush, new Point2D.Float(x, y), format);
    }


    private static void DrawSubscript(PdfPageBase page, String text, PdfTrueTypeFont font,PdfSolidBrush brush)
    {
        float x = 120f;
        float y = 150f;

        // Draw the base text
        page.getCanvas().drawString(text, font, brush, new Point2D.Float(x, y));

        // Measure the string to determine its size
        Dimension2D size = font.measureString(text);

        // Set the x coordinate for the subscript text
        x += size.getWidth();

        // Instantiate a PdfStringFormat object
        PdfStringFormat format = new PdfStringFormat();

        // Set the format as subscript
        format.setSubSuperScript(PdfSubSuperScript.Sub_Script);

        // Specify the subscript text to be drawn
        text = "Subscript";

        // Draw the subscript text with the specified format
        page.getCanvas().drawString(text, font, brush, new Point2D.Float(x, y), format);
    }
}
