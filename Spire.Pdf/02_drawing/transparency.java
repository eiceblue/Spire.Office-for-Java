import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.geom.*;
import java.awt.*;

public class transparency {
    public static void main(String[] args) {
        PdfDocument doc = new PdfDocument();
        // Create one section
        PdfSection section = doc.getSections().add();
        // Load image
        PdfImage image = PdfImage.fromFile("data/chartImage.png");
        double imageWidth = image.getPhysicalDimension().getWidth() / 2;
        double imageHeight = image.getPhysicalDimension().getHeight() / 2;
        PdfBlendMode[] modes= PdfBlendMode.values();

        for (PdfBlendMode loMode:modes)
        {
            PdfPageBase page = section.getPages().add();
            float pageWidth = (float) page.getCanvas().getClientSize().getWidth();
            float y = 10;

            //Draw Title
            y = y + 5;
            PdfBrush brush = new PdfSolidBrush(new PdfRGBColor(new Color(255,69,0)));
            PdfTrueTypeFont font = new PdfTrueTypeFont(new java.awt.Font("Arial", Font.BOLD,12));
            PdfStringFormat format = new PdfStringFormat(PdfTextAlignment.Center);
            String text = String.format("Transparency Blend Mode: %1$s", loMode);
            page.getCanvas().drawString(text, font, brush, pageWidth / 2, y, format);
            Dimension2D size = font.measureString(text, format);
            y = y + (float) size.getHeight() + 6;

            page.getCanvas().drawImage(image, 0, y, imageWidth, imageHeight);
            page.getCanvas().save();
            float d = (float) (page.getCanvas().getClientSize().getWidth() - imageWidth) / 5;
            float x = d;
            y = y + d / 2;
            for (int i = 0; i < 5; i++)
            {
                float alpha = 1.0f / 6 * (5 - i);
                page.getCanvas().setTransparency(alpha, alpha, loMode);
                page.getCanvas().drawImage(image, x, y, imageWidth, imageHeight);
                x = x + d;
                y = y + d / 2;
            }
            page.getCanvas().restore();
        }
        // Save pdf file.
        doc.saveToFile("output/transparency.pdf");
        // Close pdf file
        doc.close();
    }
}
