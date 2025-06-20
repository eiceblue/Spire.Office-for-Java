import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.Dimension2D;
import java.util.EnumSet;

public class addBorderForText {
    public static void main(String[] args) {
        // Create a pdf document
        PdfDocument doc = new PdfDocument();

        // Add a new page
        PdfPageBase page = doc.getPages().add();

        // Specify the input text
        String text = "Hello, World!";

        // Specify the font, font size and font style
        PdfFont font = new PdfFont(PdfFontFamily.Times_Roman, 14, EnumSet.of(PdfFontStyle.Bold));

        // Measure the size of the text
        Dimension2D size = font.measureString(text);

        // Define the location of the text
        int x = 60;
        int y = 60;

        // Draw the text on page
        page.getCanvas().drawString(text, font, new PdfSolidBrush(new PdfRGBColor(Color.black)), x, y);

        // Draw border for text
        PdfSolidBrush brush = new PdfSolidBrush(new PdfRGBColor(Color.black));

        // Draw the rectangle on page
        page.getCanvas().drawRectangle(new PdfPen(brush, 0.5f),new Rectangle(x, y, (int)size.getWidth(), (int)size.getHeight()));

        // Specify the output file path
        String result = "output/addBorderForText.pdf";

        // save to file
        doc.saveToFile(result,FileFormat.PDF);

        // Close the document
        doc.close();

        // Dispose of the document (frees up system resources)
        doc.dispose();
    }
}
