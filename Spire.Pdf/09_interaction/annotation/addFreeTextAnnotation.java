import com.spire.pdf.*;
import com.spire.pdf.annotations.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;


public class addFreeTextAnnotation {
    public static void main(String[] args) {
        PdfDocument doc = new PdfDocument();
        PdfPageBase page = doc.getPages().add();

        Rectangle2D.Float rect = new Rectangle2D.Float(0, 300, 100, 80);
        //Add free text annotation
        PdfFreeTextAnnotation textAnnotation = new PdfFreeTextAnnotation(rect);
        textAnnotation.setText("\n  Spire.PDF");
        PdfAnnotationBorder border = new PdfAnnotationBorder(1f);
        PdfFont font = new PdfFont(PdfFontFamily.Times_Roman, 20);
        textAnnotation.setFont(font);
        textAnnotation.setBorder(border);
        textAnnotation.setBorderColor(new PdfRGBColor(Color.GRAY));
        textAnnotation.setLineEndingStyle(PdfLineEndingStyle.Slash);
        textAnnotation.setColor(new PdfRGBColor(new Color(173,216,230)));
        textAnnotation.setOpacity(0.8f);
        page.getAnnotationsWidget().add(textAnnotation);

        rect = new Rectangle2D.Float(150, 200, 150, 40);
        textAnnotation = new PdfFreeTextAnnotation(rect);
        textAnnotation.setText("\nHigh Fidelity Pdf file Conversion");
        border = new PdfAnnotationBorder(1f);
        font = new PdfFont(PdfFontFamily.Helvetica, 10);
        textAnnotation.setFont(font);
        textAnnotation.setBorder(border);
        textAnnotation.setBorderColor(new PdfRGBColor(new Color(250,250,210)));
        textAnnotation.setLineEndingStyle(PdfLineEndingStyle.ClosedArrow);
        textAnnotation.setColor(new PdfRGBColor(new Color(255,182,193)));
        textAnnotation.setOpacity(0.8f);
        page.getAnnotationsWidget().add(textAnnotation);

        rect = new Rectangle2D.Float(150, 280, 280, 40);
        textAnnotation = new PdfFreeTextAnnotation(rect);
        textAnnotation.setText("\nEasily Manipulate document and Form fields");
        border = new PdfAnnotationBorder(1f);
        font = new PdfFont(PdfFontFamily.Helvetica, 10);
        textAnnotation.setFont(font);
        textAnnotation.setBorder(border);
        textAnnotation.setBorderColor(new PdfRGBColor(Color.GRAY));
        textAnnotation.setLineEndingStyle(PdfLineEndingStyle.Circle);
        textAnnotation.setColor(new PdfRGBColor(new Color(	135,206,250)));
        textAnnotation.setOpacity(0.8f);
        page.getAnnotationsWidget().add(textAnnotation);

        rect = new Rectangle2D.Float(150, 360, 200, 40);
        textAnnotation = new PdfFreeTextAnnotation(rect);
        textAnnotation.setText("\nSecurity features");
        border = new PdfAnnotationBorder(1f);
        font = new PdfFont(PdfFontFamily.Helvetica, 10);
        textAnnotation.setFont(font);
        textAnnotation.setBorder(border);
        textAnnotation.setBorderColor(new PdfRGBColor(Color.PINK));
        textAnnotation.setLineEndingStyle(PdfLineEndingStyle.ClosedArrow);
        textAnnotation.setColor(new PdfRGBColor(new Color(	144,238,144)));
        textAnnotation.setOpacity(0.8f);
        page.getAnnotationsWidget().add(textAnnotation);

        rect = new Rectangle2D.Float(150, 440, 200, 40);
        textAnnotation = new PdfFreeTextAnnotation(rect);
        textAnnotation.setText("\nExtract data from Pdf documents");
        border = new PdfAnnotationBorder(1f);
        font = new PdfFont(PdfFontFamily.Helvetica, 10);
        textAnnotation.setFont(font);
        textAnnotation.setBorder(border);
        textAnnotation.setBorderColor(new PdfRGBColor(new Color(	255,69,0)));
        textAnnotation.setLineEndingStyle(PdfLineEndingStyle.ClosedArrow);
        textAnnotation.setColor(new PdfRGBColor(new Color(250,250,210)));
        textAnnotation.setOpacity(0.8f);
        page.getAnnotationsWidget().add(textAnnotation);
        doc.saveToFile("output/addFreeTextAnnotation.pdf");
        doc.close();
    }
}
