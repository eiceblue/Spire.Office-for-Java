import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.util.EnumSet;

public class drawTextWithGradient {
    public static void main(String[] args) {
        // Create a pdf document
        PdfDocument doc = new PdfDocument();

        // Add a new page
        PdfPageBase page = doc.getPages().add();

        // Create a rectangle
        Rectangle rect = new Rectangle(new Point(0, 0), new Dimension(300, 100));

        // Create a brush with gradient
        PdfLinearGradientBrush brush = new PdfLinearGradientBrush(rect, new PdfRGBColor(Color.red), new PdfRGBColor(Color.blue), PdfLinearGradientMode.Horizontal);

        // Create a true type font with size 20f, underline style
        PdfFont font = new PdfFont(PdfFontFamily.Times_Roman, 20, EnumSet.of(PdfFontStyle.Italic));

        // Draw text
        page.getCanvas().drawString("Welcome to E-iceblue!", font, brush, new Point(0, 100));

        // Define the output path 
        String result="output/drawWithGradient.pdf";

        //Save to file
        doc.saveToFile(result);

        // Close the document
        doc.close();

        // Dispose of the document (frees up system resources)
        doc.dispose();
    }
}
