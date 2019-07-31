import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.*;

public class helloWorld {
    public static void main(String[] args) {
        // Create a pdf document
        PdfDocument doc = new PdfDocument();
        // Compress level
        doc.setCompressionLevel(PdfCompressionLevel.None);
        // Add a pdf page
        PdfPageBase page = doc.getPages().add();
        // Create PdfRGBColor
        PdfRGBColor color = new PdfRGBColor(Color.black);
        //Draw the text
        page.getCanvas().drawString("Hello World!",
                new PdfFont(PdfFontFamily.Helvetica, 30),
                new PdfSolidBrush(color), 35, 35);
        // Save to File
        doc.saveToFile("output/helloWorld.pdf");
    }
}
