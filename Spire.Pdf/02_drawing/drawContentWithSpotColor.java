import com.spire.pdf.*;
import com.spire.pdf.colorspace.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.Point2D;

public class drawContentWithSpotColor {
    public static void main(String[] args) {
        //Load the document from disk
        PdfDocument pdf = new PdfDocument();
        //Add a page
        PdfPageBase page = pdf.getPages().add();
        PdfRGBColor pdfRGBColor = new PdfRGBColor(new Color(148,0,211));
        //Initialize an instance of PdfSeparationColorSpace
        PdfSeparationColorSpace cs = new PdfSeparationColorSpace("MySpotColor",pdfRGBColor);

        //Set tini = 1 for the cs
        PdfSeparationColor color = new PdfSeparationColor(cs, 1f);

        //Create a brush with spot color
        PdfSolidBrush brush = new PdfSolidBrush(color);

        //Draw a string
        page.getCanvas().drawString("Tint=1.0", new PdfFont(PdfFontFamily.Helvetica, 10f), brush, new Point2D.Float(160, 160));

        //Draw pie with spot color(DarkViolet)
        page.getCanvas().drawPie(brush, 148, 200, 60, 60, 360, 360);

        page.getCanvas().drawString("Tint=0.7", new PdfFont(PdfFontFamily.Helvetica, 10f), brush, new Point2D.Float(230, 160));
        color = new PdfSeparationColor(cs, 0.7f);
        brush = new PdfSolidBrush(color);
        page.getCanvas().drawPie(brush, 218, 200, 60, 60, 360, 360);

        page.getCanvas().drawString("Tint=0.4", new PdfFont(PdfFontFamily.Helvetica, 10f), brush, new Point2D.Float(300, 160));
        color = new PdfSeparationColor(cs, 0.4f);
        brush = new PdfSolidBrush(color);
        page.getCanvas().drawPie(brush, 288, 200, 60, 60, 360, 360);

        page.getCanvas().drawString("Tint=0.1", new PdfFont(PdfFontFamily.Helvetica, 10f), brush, new Point2D.Float(370, 160));
        color = new PdfSeparationColor(cs, 0.1f);
        brush = new PdfSolidBrush(color);
        page.getCanvas().drawPie(brush, 358, 200, 60, 60, 360, 360);
        pdfRGBColor = new PdfRGBColor(new Color(128,0,128));
        //Draw pie with spot color(Purple)
        cs = new PdfSeparationColorSpace("MySpotColor", pdfRGBColor);
        color = new PdfSeparationColor(cs, 1f);
        brush = new PdfSolidBrush(color);
        page.getCanvas().drawPie(brush, 148, 280, 60, 60, 360, 360);

        color = new PdfSeparationColor(cs, 0.7f);
        brush = new PdfSolidBrush(color);
        page.getCanvas().drawPie(brush, 218, 280, 60, 60, 360, 360);

        color = new PdfSeparationColor(cs, 0.4f);
        brush = new PdfSolidBrush(color);
        page.getCanvas().drawPie(brush, 288, 280, 60, 60, 360, 360);

        color = new PdfSeparationColor(cs, 0.1f);
        brush = new PdfSolidBrush(color);
        page.getCanvas().drawPie(brush, 358, 280, 60, 60, 360, 360);
        pdfRGBColor = new PdfRGBColor(new Color(72,61,139));
        //Draw pie with spot color(DarkSlateBlue)
        cs = new PdfSeparationColorSpace("MySpotColor",pdfRGBColor);
        color = new PdfSeparationColor(cs, 1f);
        brush = new PdfSolidBrush(color);

        page.getCanvas().drawPie(brush, 148, 360, 60, 60, 360, 360);

        color = new PdfSeparationColor(cs, 0.7f);
        brush = new PdfSolidBrush(color);
        page.getCanvas().drawPie(brush, 218, 360, 60, 60, 360, 360);

        color = new PdfSeparationColor(cs, 0.4f);
        brush = new PdfSolidBrush(color);
        page.getCanvas().drawPie(brush, 288, 360, 60, 60, 360, 360);

        color = new PdfSeparationColor(cs, 0.1f);
        brush = new PdfSolidBrush(color);
        page.getCanvas().drawPie(brush, 358, 360, 60, 60, 360, 360);

        //Save the document
        pdf.saveToFile("output/drawContentWithSpotColor.pdf");
    }
}
