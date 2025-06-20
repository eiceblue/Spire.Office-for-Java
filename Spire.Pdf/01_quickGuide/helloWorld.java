import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.*;

public class helloWorld {
    public static void main(String[] args) {
        // Create a pdf document
        PdfDocument doc = new PdfDocument();
		
        // Create one page
        PdfPageBase page = doc.getPages().add();
		
        // Define the color as black
        PdfRGBColor color = new PdfRGBColor(Color.black);
		
        // Draw the text on the page
        page.getCanvas().drawString("Hello, World!",
                new PdfFont(PdfFontFamily.Helvetica, 30f),
                new PdfSolidBrush(color), 10, 10);
				
        // Specify the output file path
        String result = "output/helloWorld.pdf";
		
        // Save the document to the specified file path in PDF format
        doc.saveToFile(result, FileFormat.PDF);
		
		// Close the document
        doc.close();
        
        // Dispose of the document (frees up system resources)
        doc.dispose();
    }
}
