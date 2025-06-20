import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.*;

public class font {
    public static void main(String[] args) {
        //Create a pdf document.
        PdfDocument doc = new PdfDocument();

        // Create one page
        PdfPageBase page = doc.getPages().add();

        //Get half the page width
        float l = (float) page.getCanvas().getClientSize().getWidth() / 2;

        //Define gradient interval
        Point2D center = new Point2D.Float(l, l);

        // Define graident radius
        float r = (float)Math.sqrt(2 * l * l);

        // Define a gradient brush
        PdfRadialGradientBrush brush = new PdfRadialGradientBrush(center, 0f, center, r, new PdfRGBColor(Color.blue), new PdfRGBColor(Color.red));

        // Iterate through font families and draw text with different fonts
        PdfFontFamily[] fontFamilies = PdfFontFamily.values();

        // Define the start vertical position of the text
        float y = 10;

        // Iterate through font families
        for (int i = 0; i < fontFamilies.length; i++)
        {
            // Get the name of font
            String text = String.format("Font Family: %1$s", fontFamilies[i]);

            // Draw from the left side of the page
            float x1 = 0;

            // Define the vertical position of the text
            y = y + i * 16;

            // Define font1
            PdfFont font1 = new PdfFont(PdfFontFamily.Courier, 14f);

            // Define font2
            PdfFont font2 = new PdfFont(fontFamilies[i], 14f);

            // Measure the width of text
            float x2 = x1 + 10 + (float) font1.measureString(text).getWidth();

            // Draw text with font1
            page.getCanvas().drawString(text, font1, brush, x1, y);

            // Draw text with font2 after the text drawn with font1
            page.getCanvas().drawString(text, font2, brush, x2, y);
        }

        // Define font
        java.awt.Font font = new java.awt.Font("Arial", java.awt.Font.BOLD,14);

        // Define TrueType font -- embedded font.
        PdfTrueTypeFont trueTypeFont = new PdfTrueTypeFont(font);

        // Draw text with true type font
        page.getCanvas().drawString("Font Family: Arial - Embedded", trueTypeFont, brush, 0, (y = y + 16f));

        // Define the Arabic text (Right to left)
        String arabicText = "\u0627\u0644\u0630\u0647\u0627\u0628\u0021\u0020"
                + "\u0628\u062F\u0648\u0631\u0647\u0020\u062D\u0648\u0644\u0647\u0627\u0021\u0020"
                + "\u0627\u0644\u0630\u0647\u0627\u0628\u0021\u0020"
                + "\u0627\u0644\u0630\u0647\u0627\u0628\u0021\u0020"
                + "\u0627\u0644\u0630\u0647\u0627\u0628\u0021";

        // Define true type font and set unicode to true
        trueTypeFont = new PdfTrueTypeFont(font, true);

        // Define rctg
        Rectangle2D rctg = new Rectangle2D.Float();

        // Set the location and size of the framing rectangle of this Shape
        rctg.setFrame(new Point2D.Float(0, (y = y + 16f)), page.getCanvas().getClientSize());

        // Set text alignment
        PdfStringFormat format = new PdfStringFormat(PdfTextAlignment.Right);

        // Set text from right to left
        format.setRightToLeft(true);

        // Draw text
        page.getCanvas().drawString(arabicText, trueTypeFont, brush, rctg, format);

        // Define font "Batang"
        font = new java.awt.Font("Batang", java.awt.Font.ITALIC, 14);

        // Define TrueType font - not embedded
        trueTypeFont = new PdfTrueTypeFont(font);

        // Draw text
        page.getCanvas().drawString("Font Family: Batang - Not Embedded", trueTypeFont, brush, 0, (y = y + 16f));

        // Font file
        String fontFileName = "data/PT_Serif-Caption-Web-Regular.ttf";

        // Define TrueType Font by ttf file
        trueTypeFont = new PdfTrueTypeFont(fontFileName, 20f);

        // Draw text
        page.getCanvas().drawString("PT_Serif-Caption-Web-Regular Font", trueTypeFont, brush, 0, (y = y + 16f));

        // Draw text
        page.getCanvas().drawString("PT_Serif-Caption-Web-Regular Font, from https://company.paratype.com", new PdfFont(PdfFontFamily.Helvetica, 8f), brush, 10, (y = y + 20f));

        // Define CJK font(The font used to draw text in Chinese, Japanese, Korean)
        // Monotype_Hei_Medium is Chinese font
        PdfCjkStandardFont cjkFont = new PdfCjkStandardFont(PdfCjkFontFamily.Monotype_Hei_Medium, 14f);

        // Draw text with cjkfont
        page.getCanvas().drawString("How to say 'Font' in Chinese? \u5B57\u4F53", cjkFont, brush, 0, (y = y + 16f));

        // Hanyang_Systems_Gothic_Medium is Japanese font
        cjkFont = new PdfCjkStandardFont(PdfCjkFontFamily.Hanyang_Systems_Gothic_Medium, 14f);

        // Draw the text
        page.getCanvas().drawString("How to say 'Font' in Japanese? \u30D5\u30A9\u30F3\u30C8", cjkFont, brush, 0, (y = y + 16f));

        // Hanyang_Systems_Shin_Myeong_Jo_Medium is Korean font
        cjkFont = new PdfCjkStandardFont(PdfCjkFontFamily.Hanyang_Systems_Shin_Myeong_Jo_Medium, 14f);

        // Draw the text
        page.getCanvas().drawString("How to say 'Font' in Korean? \uAE00\uAF34", cjkFont, brush, 0, (y = y + 16f));

        // Save pdf file.
        doc.saveToFile("output/font.pdf");

        // Close the PDF document
        doc.close();

        // Dispose of the PDF document (frees up system resources)
        doc.dispose();
    }
}
