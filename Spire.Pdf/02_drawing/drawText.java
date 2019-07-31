import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.geom.*;
import java.util.EnumSet;
import java.awt.*;

public class drawText {
    public static void main(String[] args) {
        PdfDocument doc = new PdfDocument();
        PdfPageBase page = doc.getPages().add();
        drawText(page);
        alignText(page);
        alignTextInRectangle(page);
        transformText(page);
        rotateText(page);

        // Save doc file.
        doc.saveToFile("output/drawText.pdf");
        // Close pdf file
        doc.close();
    }
    static void alignText(PdfPageBase page) {
        // Draw the text - alignment
        PdfFont font = new PdfFont(PdfFontFamily.Helvetica, 20);
        PdfSolidBrush brush = new PdfSolidBrush(new PdfRGBColor(Color.blue));

        PdfStringFormat leftAlignment = new PdfStringFormat(PdfTextAlignment.Left, PdfVerticalAlignment.Middle);
        page.getCanvas().drawString("Left!", font, brush, 0, 20, leftAlignment);
        page.getCanvas().drawString("Left!", font, brush, 0, 50, leftAlignment);

        PdfStringFormat rightAlignment = new PdfStringFormat(PdfTextAlignment.Right, PdfVerticalAlignment.Middle);
        page.getCanvas().drawString("Right!", font, brush, page.getCanvas().getClientSize().getWidth(), 30, rightAlignment);
        page.getCanvas().drawString("Right!", font, brush, page.getCanvas().getClientSize().getWidth(), 60, rightAlignment);

        PdfStringFormat centerAlignment = new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle);
        page.getCanvas().drawString("Go! Turn Around! Go! Go! Go!", font,
                brush, page.getCanvas().getClientSize().getWidth() / 2, 40,
                centerAlignment);

    }

    static void alignTextInRectangle(PdfPageBase page) {
        // Draw the text - align in rectangle
        PdfFont font = new PdfFont(PdfFontFamily.Helvetica, 10);
        PdfRGBColor blue = new PdfRGBColor();
        blue.setB((byte) 255);
        PdfSolidBrush brush = new PdfSolidBrush(blue);
        Rectangle2D.Float rctg1 = new Rectangle2D.Float();
        rctg1.setRect(0,70,page.getCanvas().getClientSize().getWidth() / 2,100);

        Rectangle2D.Float rctg2 = new Rectangle2D.Float();
        rctg2.setRect(page.getCanvas().getClientSize().getWidth() / 2,70,page.getCanvas().getClientSize().getWidth() / 2,100);

        PdfRGBColor lightBlue = new PdfRGBColor();
        lightBlue.setR((byte) 0xad);
        lightBlue.setG((byte) 0xd8);
        lightBlue.setB((byte) 0xe6);
        page.getCanvas().drawRectangle(new PdfSolidBrush(lightBlue), rctg1);

        PdfRGBColor lightSkyBlue = new PdfRGBColor();
        lightSkyBlue.setR((byte) 0x87);
        lightSkyBlue.setG((byte) 0xce);
        lightSkyBlue.setB((byte) 0xfa);
        page.getCanvas().drawRectangle(new PdfSolidBrush(lightSkyBlue), rctg2);

        PdfStringFormat leftAlignment = new PdfStringFormat(
                PdfTextAlignment.Left, PdfVerticalAlignment.Top);
        page.getCanvas().drawString("Left! Left!", font, brush, rctg1,
                leftAlignment);
        page.getCanvas().drawString("Left! Left!", font, brush, rctg2,
                leftAlignment);

        PdfStringFormat rightAlignment = new PdfStringFormat(
                PdfTextAlignment.Right, PdfVerticalAlignment.Middle);
        page.getCanvas().drawString("Right! Right!", font, brush, rctg1,
                rightAlignment);
        page.getCanvas().drawString("Right! Right!", font, brush, rctg2,
                rightAlignment);

        PdfStringFormat centerAlignment = new PdfStringFormat(
                PdfTextAlignment.Center, PdfVerticalAlignment.Bottom);
        page.getCanvas().drawString("Go! Turn Around! Go! Go! Go!", font,
                brush, rctg1, centerAlignment);
        page.getCanvas().drawString("Go! Turn Around! Go! Go! Go!", font,
                brush, rctg2, centerAlignment);
    }

    static void rotateText(PdfPageBase page) {
        // Save graphics state
        PdfGraphicsState state = page.getCanvas().save();
        // Draw the text - transform
        PdfFont font = new PdfFont(PdfFontFamily.Helvetica, 10);

        PdfRGBColor blue = new PdfRGBColor();
        blue.setB((byte) 255);
        PdfSolidBrush brush = new PdfSolidBrush(blue);

        PdfStringFormat centerAlignment = new PdfStringFormat(
                PdfTextAlignment.Left, PdfVerticalAlignment.Middle);
        double x = page.getCanvas().getClientSize().getWidth() / 2;
        float y = 380;

        page.getCanvas().translateTransform(x, y);
        for (int i = 0; i < 12; i++) {
            page.getCanvas().rotateTransform(30);
            page.getCanvas().drawString("Go! Turn Around! Go! Go! Go!", font,
                    brush, 20, 0, centerAlignment);
        }
        // Restore graphics
        page.getCanvas().restore(state);
    }

    static void transformText(PdfPageBase page) {
        // Save graphics state
        PdfGraphicsState state = page.getCanvas().save();

        // Draw the text - transform
        PdfFont font = new PdfFont(PdfFontFamily.Helvetica, 18);

        PdfSolidBrush brush1 = new PdfSolidBrush(new PdfRGBColor(Color.blue));

        PdfSolidBrush brush2 = new PdfSolidBrush(new PdfRGBColor(Color.blue));

        page.getCanvas().translateTransform(20, 200);
        page.getCanvas().scaleTransform(1f, 0.6f);
        page.getCanvas().skewTransform(-10, 0);
        page.getCanvas().drawString("Go! Turn Around! Go! Go! Go!", font,
                brush1, 0, 0);

        page.getCanvas().skewTransform(10, 0);
        page.getCanvas().drawString("Go! Turn Around! Go! Go! Go!", font,
                brush2, 0, 0);

        page.getCanvas().scaleTransform(1f, -1f);
        page.getCanvas().drawString("Go! Turn Around! Go! Go! Go!", font,
                brush2, 0, -2 * 18);

        // Restore graphics
        page.getCanvas().restore(state);
    }

    static void drawText(PdfPageBase page) {
        // Save graphics state
        PdfGraphicsState state = page.getCanvas().save();

        // Draw text
        String text = "Go! Turn Around! Go! Go! Go!";
        PdfPen pen = PdfPens.getDeepSkyBlue();

        PdfSolidBrush brush = new PdfSolidBrush(new PdfRGBColor(Color.white));
        PdfStringFormat format = new PdfStringFormat();
        PdfFont font = new PdfFont(PdfFontFamily.Helvetica, 18, EnumSet.of(PdfFontStyle.Italic));
        Dimension2D size = font.measureString(text, format);
        Rectangle2D.Float rctg = new Rectangle2D.Float();
        rctg.setRect(page.getCanvas().getClientSize().getWidth() / 2 + 10,180,size.getWidth() / 3 * 2,size.getHeight() * 2);

        page.getCanvas().drawString(text, font, pen, brush, rctg, format);

        // Restore graphics
        page.getCanvas().restore(state);
    }
}
