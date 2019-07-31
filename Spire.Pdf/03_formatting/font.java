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

        //Draw the text
        float l = (float) page.getCanvas().getClientSize().getWidth() / 2;
        Point2D center = new Point2D.Float(l, l);
        float r = (float)Math.sqrt(2 * l * l);
        PdfRadialGradientBrush brush = new PdfRadialGradientBrush(center, 0f, center, r, new PdfRGBColor(Color.blue), new PdfRGBColor(Color.red));

        PdfFontFamily[] fontFamilies = (PdfFontFamily[])PdfFontFamily.values();

        float y = 10;
        for (int i = 0; i < fontFamilies.length; i++)
        {
            String text = String.format("Font Family: %1$s", fontFamilies[i]);
            float x1 = 0;
            y = 10 + i * 16;
            PdfFont font1 = new PdfFont(PdfFontFamily.Courier, 14f);
            PdfFont font2 = new PdfFont(fontFamilies[i], 14f);
            float x2 = x1 + 10 + (float) font1.measureString(text).getWidth();
            page.getCanvas().drawString(text, font1, brush, x1, y);
            page.getCanvas().drawString(text, font2, brush, x2, y);
        }

        //true type font - embedded.
        java.awt.Font font = new java.awt.Font("Arial", java.awt.Font.BOLD,14);
        PdfTrueTypeFont trueTypeFont = new PdfTrueTypeFont(font);
        page.getCanvas().drawString("Font Family: Arial - Embedded", trueTypeFont, brush, 0, (y = y + 16f));

        //right to left
        String arabicText = "\u0627\u0644\u0630\u0647\u0627\u0628\u0021\u0020"
                + "\u0628\u062F\u0648\u0631\u0647\u0020\u062D\u0648\u0644\u0647\u0627\u0021\u0020"
                + "\u0627\u0644\u0630\u0647\u0627\u0628\u0021\u0020"
                + "\u0627\u0644\u0630\u0647\u0627\u0628\u0021\u0020"
                + "\u0627\u0644\u0630\u0647\u0627\u0628\u0021";
        trueTypeFont = new PdfTrueTypeFont(font, true);
        Rectangle2D rctg = new Rectangle2D.Float();
        rctg.setFrame(new Point2D.Float(0, (y = y + 16f)), page.getCanvas().getClientSize());
        PdfStringFormat format = new PdfStringFormat(PdfTextAlignment.Right);
        format.setRightToLeft(true);
        page.getCanvas().drawString(arabicText, trueTypeFont, brush, rctg, format);

        //true type font - not embedded
        font =new java.awt.Font("Batang", java.awt.Font.ITALIC, 14);
        trueTypeFont = new PdfTrueTypeFont(font);
        page.getCanvas().drawString("Font Family: Batang - Not Embedded", trueTypeFont, brush, 0, (y = y + 16f));

        //font file
        String fontFileName = "data/Hawaii_Killer.ttf";
        trueTypeFont = new PdfTrueTypeFont(fontFileName, 20f);
        page.getCanvas().drawString("Hawaii Killer Font", trueTypeFont, brush, 0, (y = y + 16f));
        page.getCanvas().drawString("Hawaii Killer Font, from http://www.1001freefonts.com", new PdfFont(PdfFontFamily.Helvetica, 8f), brush, 10, (y = y + 20f));

        //cjk font
        PdfCjkStandardFont cjkFont = new PdfCjkStandardFont(PdfCjkFontFamily.Monotype_Hei_Medium, 14f);
        page.getCanvas().drawString("How to say 'Font' in Chinese? \u5B57\u4F53", cjkFont, brush, 0, (y = y + 16f));

        cjkFont = new PdfCjkStandardFont(PdfCjkFontFamily.Hanyang_Systems_Gothic_Medium, 14f);
        page.getCanvas().drawString("How to say 'Font' in Japanese? \u30D5\u30A9\u30F3\u30C8", cjkFont, brush, 0, (y = y + 16f));

        cjkFont = new PdfCjkStandardFont(PdfCjkFontFamily.Hanyang_Systems_Shin_Myeong_Jo_Medium, 14f);
        page.getCanvas().drawString("How to say 'Font' in Korean? \uAE00\uAF34", cjkFont, brush, 0, (y = y + 16f));

        // Save pdf file.
        doc.saveToFile("output/font.pdf");
        // Close pdf file
        doc.close();
    }
}



