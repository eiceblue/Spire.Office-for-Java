import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.*;


public class overlay {
    public static void main(String[] args) {
        // Loading a pdf document
        PdfDocument doc1 = new PdfDocument();
        doc1.loadFromFile("data/overlay1.pdf");
        // Loading a pdf document
        PdfDocument doc2 = new PdfDocument();
        doc2.loadFromFile("data/overlay2.pdf");
  	   // Create page template
        PdfTemplate template = doc1.getPages().get(0).createTemplate();

        for (PdfPageBase page : (Iterable<PdfPageBase>) doc2.getPages())
        {
            page.getCanvas().setTransparency(0.25f, 0.25f, PdfBlendMode.Overlay);
            page.getCanvas().drawTemplate(template, new Point());
        }

        doc2.saveToFile("output/overlay.pdf");
        // Close pdf file
        doc1.close();
        doc2.close();
    }
}
