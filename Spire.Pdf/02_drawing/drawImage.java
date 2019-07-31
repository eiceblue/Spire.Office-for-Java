import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.Point2D;

public class drawImage {
    public static void main(String[] args) {
        PdfDocument doc = new PdfDocument();
        // Create one page
        PdfPageBase page = doc.getPages().add();
        transformText(page);
        drawImageMethod(page);
        transformImage(page);
        // Save pdf file.
        doc.saveToFile("output/drawImage.pdf");
        // Close pdf file
        doc.close();
    }

    private static void transformText(PdfPageBase page) {
        // Save graphics state
        PdfGraphicsState state = page.getCanvas().save();
        // Draw the text - transform
        PdfFont font = new PdfFont(PdfFontFamily.Helvetica, 18);
        PdfSolidBrush brush1 = new PdfSolidBrush(new PdfRGBColor(Color.blue));
        PdfSolidBrush brush2 = new PdfSolidBrush(new PdfRGBColor(Color.gray));
        PdfStringFormat format = new PdfStringFormat(PdfTextAlignment.Center);
        page.getCanvas().translateTransform(page.getCanvas().getClientSize().getWidth() / 2, 20);
        page.getCanvas().drawString("Sales Report Chart", font, brush1, 0, 0, format);
        page.getCanvas().scaleTransform(1f, -0.8f);
        page.getCanvas().drawString("Sales Report Chart", font, brush2, 0, -2 * 18 * 1.2f, format);
        // Restore graphics
        page.getCanvas().restore(state);
    }

    private static void drawImageMethod(PdfPageBase page) {
        // Draw image
        PdfImage image = PdfImage.fromFile("data/chartImage.png");
        float width = image.getWidth() * 0.75f;
        float height = image.getHeight() * 0.75f;
        double x = (page.getCanvas().getClientSize().getWidth() - width) / 2;
        page.getCanvas().drawImage(image, (int)x, 60, width, height);
    }

    private static void transformImage(PdfPageBase page) {
        // Transform image
        PdfImage image = PdfImage.fromFile("data/chartImage.png");
        int skewX = 20;
        int skewY = 20;
        float scaleX = 0.2f;
        float scaleY = 0.6f;
        int width = (int) ((image.getWidth() + image.getHeight() * Math.tan(Math.PI * skewX / 180)) * scaleX);
        int height = (int) ((image.getHeight() + image.getWidth() * Math.tan(Math.PI * skewY / 180)) * scaleY);
        PdfTemplate template = new PdfTemplate(width, height);
        template.getGraphics().scaleTransform(scaleX, scaleY);
        template.getGraphics().skewTransform(skewX, skewY);
        template.getGraphics().drawImage(image, 0, 0);
        // Save graphics state
        PdfGraphicsState state = page.getCanvas().save();
        page.getCanvas().translateTransform(page.getCanvas().getClientSize().getWidth() - 50, 260);
        double offset = (page.getCanvas().getClientSize().getWidth() - 100) / 12;
        for (int i = 0; i < 12; i++) {
            page.getCanvas().translateTransform(-offset, 0);
            page.getCanvas().setTransparency(i / 12.0f);
            Point2D.Float point = new Point2D.Float();
            point.x=0;
            point.y=0;
            page.getCanvas().drawTemplate(template, point);
        }
        // Restore graphics
        page.getCanvas().restore(state);
    }
}
