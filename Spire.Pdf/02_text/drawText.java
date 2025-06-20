import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.Dimension2D;

public class drawText {
    public static void main(String[] args) {
       // Create a pdf document
        PdfDocument doc = new PdfDocument();

        // Create one page
        PdfPageBase page = doc.getPages().add();

        // Draw the normal text
        DrawText(page);

        // Draw the text with different alignment options
        AlignText(page);

        // Draw the text with alignment options inside rectangles
        AlignTextInRectangle(page);

        // Transform the text
        TransformText(page);

        // Draw the text with rotation
        RotateText(page);

        // Save the document
        doc.saveToFile("output/drawText.pdf", FileFormat.PDF);

        // Close the document
        doc.close();

        // Dispose of the document (frees up system resources)
        doc.dispose();
    }

    // Draw the text with different alignment options
    private static void AlignText(PdfPageBase page)
    {
        // Define the font
        PdfFont font = new PdfFont(PdfFontFamily.Helvetica, 20f);

        // Define the brush and set the color for brush
        PdfSolidBrush brush = new PdfSolidBrush(new PdfRGBColor(Color.blue));

        // Left alignment
        PdfStringFormat leftAlignment = new PdfStringFormat(PdfTextAlignment.Left, PdfVerticalAlignment.Middle);

        // Draw the text at (0,20)
        page.getCanvas().drawString("Left!", font, brush, 0, 20, leftAlignment);

        // Draw the text at (0,50)
        page.getCanvas().drawString("Left!", font, brush, 0, 50, leftAlignment);

        // Right alignment
        PdfStringFormat rightAlignment = new PdfStringFormat(PdfTextAlignment.Right, PdfVerticalAlignment.Middle);

        // Draw the text on the right of page
        page.getCanvas().drawString("Right!", font, brush, page.getCanvas().getClientSize().getWidth(), 20, rightAlignment);

        // Draw the text on the right of page
        page.getCanvas().drawString("Right!", font, brush, page.getCanvas().getClientSize().getWidth(), 50, rightAlignment);

        // Center alignment
        PdfStringFormat centerAlignment = new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle);

        // Draw the text on the center of page
        page.getCanvas().drawString("Go! Turn Around! Go! Go! Go!", font, brush, page.getCanvas().getClientSize().getWidth() / 2, 40, centerAlignment);
    }

    // Draw the text with alignment options inside rectangles
    private static void AlignTextInRectangle(PdfPageBase page)
    {
        // Define the font
        PdfFont font = new PdfFont(PdfFontFamily.Helvetica, 10f);

        // Define the brush and set the color for brush
        PdfSolidBrush brush = new PdfSolidBrush(new PdfRGBColor(Color.blue));

        // Define the rectangle rctg1
        Rectangle rctg1 = new Rectangle(0, 70, (int) page.getCanvas().getClientSize().getWidth() / 2, 100);

        // Define the rectangle rctg2
        Rectangle rctg2 = new Rectangle((int) page.getCanvas().getClientSize().getWidth() / 2, 70, (int) page.getCanvas().getClientSize().getWidth() / 2, 100);

        // Set left alignment for text
        PdfStringFormat leftAlignment = new PdfStringFormat(PdfTextAlignment.Left, PdfVerticalAlignment.Top);

        // Draw the rctg1
        page.getCanvas().drawRectangle(new PdfSolidBrush(new PdfRGBColor(Color.lightGray)), rctg1);

        // Draw the rctg2
        page.getCanvas().drawRectangle(new PdfSolidBrush(new PdfRGBColor(Color.lightGray)), rctg2);

        // Draw the text inside rctg1
        page.getCanvas().drawString("Left! Left!", font, brush, rctg1, leftAlignment);

        // Draw the text inside rctg2
        page.getCanvas().drawString("Left! Left!", font, brush, rctg2, leftAlignment);

        // Set right alignment for text
        PdfStringFormat rightAlignment = new PdfStringFormat(PdfTextAlignment.Right, PdfVerticalAlignment.Middle);

        // Draw the text inside rctg1
        page.getCanvas().drawString("Right! Right!", font, brush, rctg1, rightAlignment);

        // Draw the text inside rctg2
        page.getCanvas().drawString("Right! Right!", font, brush, rctg2, rightAlignment);

        // Set center alignment for text
        PdfStringFormat centerAlignment = new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Bottom);

        // Draw the text inside rctg1
        page.getCanvas().drawString("Go! Turn Around! Go! Go! Go!", font, brush, rctg1, centerAlignment);

        // Draw the text inside rctg2
        page.getCanvas().drawString("Go! Turn Around! Go! Go! Go!", font, brush, rctg2, centerAlignment);
    }

    // Draw the text with rotation
    private static void RotateText(PdfPageBase page)
    {
        // Save graphics state
        PdfGraphicsState state = page.getCanvas().save();

        // Define the font
        PdfFont font = new PdfFont(PdfFontFamily.Helvetica, 10f);

        // Define the brush and set color
        PdfSolidBrush brush = new PdfSolidBrush(new PdfRGBColor(Color.blue));

        // // Set left alignment for text
        PdfStringFormat centerAlignment = new PdfStringFormat(PdfTextAlignment.Left, PdfVerticalAlignment.Middle);

        // Set the offset value
        float x = (float) page.getCanvas().getClientSize().getWidth() / 2;
        float y = 380;

        // Apply translation and rotation transformations to the canvas
        page.getCanvas().translateTransform(x, y);

        // Draw text every 30 degrees of rotation
        for (int i = 0; i < 12; i++)
        {
            // Set the angle
            page.getCanvas().rotateTransform(30);

            // Draw text with rotation
            page.getCanvas().drawString("Go! Turn Around! Go! Go! Go!", font, brush, 20, 0, centerAlignment);
        }

        //Restore graphics
        page.getCanvas().restore(state);
    }

    // Transform the text
    private static void TransformText(PdfPageBase page)
    {
        // Save graphics state
        PdfGraphicsState state = page.getCanvas().save();

        // Define the font
        PdfFont font = new PdfFont(PdfFontFamily.Helvetica, 18f);

        // Define the brush1 and set color
        PdfSolidBrush brush1 = new PdfSolidBrush(new PdfRGBColor(Color.green));

        // Define the brush2 and set color
        PdfSolidBrush brush2 = new PdfSolidBrush(new PdfRGBColor(Color.green));

        // Set the translate transform
        page.getCanvas().translateTransform(20, 200);

        // Set the scale transform
        page.getCanvas().scaleTransform(1f, 0.6f);

        // Set the skew transform
        page.getCanvas().skewTransform(-10, 0);

        // Draw text with above transform
        page.getCanvas().drawString("Go! Turn Around! Go! Go! Go!", font, brush1, 0, 0);

        // Set the skew transform
        page.getCanvas().skewTransform(10, 0);

        // Draw text with skew transform
        page.getCanvas().drawString("Go! Turn Around! Go! Go! Go!", font, brush2, 0, 0);

        // Set the scale transform
        page.getCanvas().scaleTransform(1f, -1f);

        // Draw text with scale transform
        page.getCanvas().drawString("Go! Turn Around! Go! Go! Go!", font, brush2, 0, -2 * 18);

        //Restore graphics
        page.getCanvas().restore(state);
    }

    // Draw the normal text
    private static void DrawText(PdfPageBase page)
    {
        // Save graphics state
        PdfGraphicsState state = page.getCanvas().save();

        // Define the text
        String text = "Go! Turn Around! Go! Go! Go!";

        // Define the pen and set color
        PdfPen pen = PdfPens.getDeepSkyBlue();

        // Define the brush and set color
        PdfSolidBrush brush = new PdfSolidBrush(new PdfRGBColor(Color.white));

        // Define the format
        PdfStringFormat format = new PdfStringFormat();

        // Define the font
        PdfFont font = new PdfFont(PdfFontFamily.Helvetica, 18f, PdfFontStyle.Italic);

        // Measure the size of text
        Dimension2D size = font.measureString(text, format);

        // Define the rectangle rctg
        Rectangle rctg = new Rectangle((int)page.getCanvas().getClientSize().getWidth() / 2 + 10, 180,
                (int)size.getWidth() / 3 * 2, (int)size.getHeight() * 2);

        // Draw String
        page.getCanvas().drawString(text, font, pen, brush, rctg, format);

        //Restore graphics
        page.getCanvas().restore(state);
    }


}
