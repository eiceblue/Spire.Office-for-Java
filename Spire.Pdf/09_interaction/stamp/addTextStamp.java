import com.spire.pdf.*;
import com.spire.pdf.annotations.*;
import com.spire.pdf.annotations.appearance.PdfAppearance;
import com.spire.pdf.graphics.*;

import java.awt.*;
import java.awt.geom.*;
import java.text.SimpleDateFormat;

public class addTextStamp {
    public static void main(String[] args) {
        PdfDocument document = new PdfDocument();
        document.loadFromFile("data/stamp.pdf");

        PdfPageBase page = document.getPages().get(0);
        //Create a pdf template
        PdfTemplate template = new PdfTemplate(125, 55);
        PdfTrueTypeFont font1 = new PdfTrueTypeFont(new Font("Elephant", Font.ITALIC,10), true);
        PdfSolidBrush brush = new PdfSolidBrush(new PdfRGBColor(139,0, 0));
        PdfPen pen = new PdfPen(brush);
        Rectangle2D rectangle = new Rectangle2D.Float();
        rectangle.setFrame(new Point2D.Float(5, 5), template.getSize());
        int CornerRadius = 20;
        PdfPath path = new PdfPath();
        path.addArc(template.getBounds().getX(), template.getBounds().getY(), CornerRadius, CornerRadius, 180, 90);
        path.addArc(template.getBounds().getX() + template.getWidth() - CornerRadius,template.getBounds().getY(), CornerRadius, CornerRadius, 270, 90);
        path.addArc(template.getBounds().getX() + template.getWidth() - CornerRadius, template.getBounds().getY()+ template.getHeight() - CornerRadius, CornerRadius, CornerRadius, 0, 90);
        path.addArc(template.getBounds().getX(), template.getBounds().getY() + template.getHeight() - CornerRadius, CornerRadius, CornerRadius, 90, 90);
        path.addLine( template.getBounds().getX(), template.getBounds().getY() + template.getHeight() - CornerRadius, template.getBounds().getX(), template.getBounds().getY() + CornerRadius / 2);
        template.getGraphics().drawPath(pen, path);

        //Draw stamp text
        String s1 = "REVISED\n";
        String s2 = "by E-iceblue at " + dateToString(new java.util.Date(),"MM dd, yyyy");
        template.getGraphics().drawString(s1, font1, brush, new Point2D.Float(5, 10));
        PdfTrueTypeFont font2 = new PdfTrueTypeFont(new Font("Lucida Sans Unicode", Font.BOLD,9), true);
        template.getGraphics().drawString(s2, font2, brush, new Point2D.Float(2, 30));

        //Create a rubber stamp
        PdfRubberStampAnnotation stamp = new PdfRubberStampAnnotation(rectangle);
        PdfAppearance appearance = new PdfAppearance(stamp);
        appearance.setNormal(template);
        stamp.setAppearance(appearance);

        //Draw stamp into page
        page.getAnnotationsWidget().add(stamp);

        document.saveToFile("output/addTextStamp.pdf");
        document.close();
    }
    public static String dateToString(java.util.Date poDate,String pcFormat){
        SimpleDateFormat loFormat= new SimpleDateFormat(pcFormat);
        return  loFormat.format(poDate);
    }
}
