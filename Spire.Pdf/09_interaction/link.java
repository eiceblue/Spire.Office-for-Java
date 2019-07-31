import com.spire.pdf.*;
import com.spire.pdf.actions.*;
import com.spire.pdf.annotations.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.*;

public class link {
    public static void main(String[] args) throws Exception{
        PdfDocument doc = new PdfDocument();
        //Set margins
        PdfUnitConvertor unitCvtr = new PdfUnitConvertor();
        PdfMargins margin = new PdfMargins();
        margin.setTop(unitCvtr.convertUnits(2.54f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
        margin.setBottom(margin.getTop());
        margin.setLeft(unitCvtr.convertUnits(3.17f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
        margin.setRight(margin.getLeft());
        //Create one page
        PdfPageBase page = doc.getPages().add(PdfPageSize.A4, margin);
        float y = 100;
        float x = 10;
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Lucida Sans Unicode", 0,14));
        String label = "Simple Text Link: ";
        PdfStringFormat format = new PdfStringFormat();
        format.setMeasureTrailingSpaces(true);
        page.getCanvas().drawString(label, font, PdfBrushes.getOrange(), 0, y, format);
        x = (float)font.measureString(label, format).getWidth();
        PdfTrueTypeFont font1 = new PdfTrueTypeFont(new Font("Lucida Sans Unicode",0,14) );
        String url1 = "http://www.e-iceblue.com";
        page.getCanvas().drawString(url1, font1, PdfBrushes.getCadetBlue(), x, y);
        y = y + (float)font1.measureString(url1).getHeight() + 25;
        label = "Web Link: ";
        page.getCanvas().drawString(label, font, PdfBrushes.getOrange(), 0, y, format);
        x = (float)font.measureString(label, format).getWidth();
        String text = "E-iceblue home";
        PdfTextWebLink link2 = new PdfTextWebLink();
        link2.setText(text);
        link2.setUrl(url1);
        link2.setFont(font1);
        link2.setBrush(PdfBrushes.getCadetBlue());
        link2.drawTextWebLink(page.getCanvas(), new Point2D.Float(x, y));
        y = y + (float)font1.measureString(text).getHeight() + 30;
        label = "URI Annotation: ";
        page.getCanvas().drawString(label, font, PdfBrushes.getOrange(), 0, y, format);
        x = (float)font.measureString(label, format).getWidth();
        text = "Google";
        Point2D location = new Point2D.Float(x, y);
        Dimension2D size = font1.measureString(text);
        Rectangle2D linkBounds = new Rectangle2D.Float();
        linkBounds.setFrame(location,size);
        PdfUriAnnotation link3 = new PdfUriAnnotation(linkBounds);
        link3.setBorder(new PdfAnnotationBorder(0));
        link3.setUri("http://www.google.com");
        ((PdfNewPage) ((page instanceof PdfNewPage) ? page : null)).getAnnotations().add(link3);
        page.getCanvas().drawString(text, font1, PdfBrushes.getCadetBlue(), x, y);
        y = y + (float)size.getHeight() + 30;

        label = "URI Annotation Action: ";
        page.getCanvas().drawString(label, font, PdfBrushes.getOrange(), 0, y, format);
        x = (float)font.measureString(label, format).getWidth();
        text = "JavaScript Action (Click Me)";
        location = new Point2D.Float(x - 2, y - 2);
        size = font1.measureString(text);
        size .setSize(size.getWidth() + 5, size.getHeight() + 5);
        linkBounds = new Rectangle2D.Float();
        linkBounds.setFrame(location,size);
        PdfUriAnnotation link4 = new PdfUriAnnotation(linkBounds);
        link4.setBorder(new PdfAnnotationBorder(0.75f));
        link4.setColor(new PdfRGBColor(	new Color(95,158,160)));
        //Script
        String script = "app.alert({"
                + "    cMsg: \"Hello.\","
                + "    nIcon: 3,"
                + "    cTitle: \"JavaScript Action\""
                + "});";
        PdfJavaScriptAction action = new PdfJavaScriptAction(script);
        link4.setAction(action);
        ((PdfNewPage) ((page instanceof PdfNewPage) ? page : null)).getAnnotations().add(link4);
        page.getCanvas().drawString(text, font1, PdfBrushes.getCadetBlue(), x, y);
        y = y + (float)size.getHeight() + 30;

        label = "Need Help:  ";
        page.getCanvas().drawString(label, font, PdfBrushes.getOrange(), 0, y, format);
        x = (float)font.measureString(label, format).getWidth();
        text = "Go to forum to ask questions";
        link2 = new PdfTextWebLink();
        link2.setText(text);
        link2.setUrl("https://www.e-iceblue.com/forum/components-f5.html");
        link2.setFont(font1);
        link2.setBrush(PdfBrushes.getCadetBlue());
        link2.drawTextWebLink(page.getCanvas(), new Point2D.Float(x, y));
        y = y + (float)font1.measureString(text).getHeight() + 30;

        label = "Contact us:  ";
        page.getCanvas().drawString(label, font, PdfBrushes.getOrange(), 0, y, format);
        x = (float)font.measureString(label, format).getWidth();
        text = "Send an email";
        link2 = new PdfTextWebLink();
        link2.setText(text);
        link2.setUrl("mailto:support@e-iceblue.com");
        link2.setFont(font1);
        link2.setBrush(PdfBrushes.getCadetBlue());
        link2.drawTextWebLink(page.getCanvas(), new Point2D.Float(x, y));
        y = y +(float) font1.measureString(text).getHeight() + 30;

        doc.saveToFile("output/link.pdf");
        doc.close();
    }
}
