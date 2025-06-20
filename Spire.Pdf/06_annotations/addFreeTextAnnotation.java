import com.spire.pdf.*;
import com.spire.pdf.annotations.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class addFreeTextAnnotation {
    public static void main(String[] args) {
          // Create a new PdfDocument
        PdfDocument doc = new PdfDocument();

        // Add a new page to the document
        PdfPageBase page = doc.getPages().add();

        // Define the rectangle for the text annotation
        Rectangle2D.Float rect = new Rectangle2D.Float(0, 300, 100, 80);

        // Create a new PdfFreeTextAnnotation with the specified rectangle
        PdfFreeTextAnnotation textAnnotation = new PdfFreeTextAnnotation(rect);

        // Set the text content for the annotation
        textAnnotation.setText("\n  Spire.PDF");

        // Create a border for the annotation with a width of 1 unit
        PdfAnnotationBorder border = new PdfAnnotationBorder(1f);

        // Set the font for the text annotation
        PdfFont font = new PdfFont(PdfFontFamily.Times_Roman, 20);
        textAnnotation.setFont(font);

        // Set the border for the annotation
        textAnnotation.setBorder(border);

        // Set the border color for the annotation to gray
        textAnnotation.setBorderColor(new PdfRGBColor(Color.GRAY));

        // Set the line ending style for the annotation to slash
        textAnnotation.setLineEndingStyle(PdfLineEndingStyle.Slash);

        // Set the color for the annotation to a custom RGB color
        textAnnotation.setColor(new PdfRGBColor(new Color(173, 216, 230)));

        // Set the opacity for the annotation to 0.8 (80%)
        textAnnotation.setOpacity(0.8f);

        // Add the text annotation to the page's annotations collection
        ((PdfNewPage) page).getAnnotations().add(textAnnotation);

        // Define the rectangle and create a new PdfFreeTextAnnotation
        rect = new Rectangle2D.Float(150, 200, 150, 40);
        textAnnotation = new PdfFreeTextAnnotation(rect);
        textAnnotation.setText("\nHigh Fidelity Pdf file Conversion");

        // Set the border, font, and other properties for the annotation
        border = new PdfAnnotationBorder(1f);
        font = new PdfFont(PdfFontFamily.Helvetica, 10);
        textAnnotation.setFont(font);
        textAnnotation.setBorder(border);
        textAnnotation.setBorderColor(new PdfRGBColor(new Color(250, 250, 210)));
        textAnnotation.setLineEndingStyle(PdfLineEndingStyle.ClosedArrow);
        textAnnotation.setColor(new PdfRGBColor(new Color(255, 182, 193)));
        textAnnotation.setOpacity(0.8f);

        // Add the annotation to the page's annotations collection
        ((PdfNewPage) page).getAnnotations().add(textAnnotation);

        // Define the rectangle and create a new PdfFreeTextAnnotation
        rect = new Rectangle2D.Float(150, 280, 280, 40);
        textAnnotation = new PdfFreeTextAnnotation(rect);
        textAnnotation.setText("\nEasily Manipulate document and Form fields");

        // Set the border, font, and other properties
        border = new PdfAnnotationBorder(1f);
        font = new PdfFont(PdfFontFamily.Helvetica, 10);
        textAnnotation.setFont(font);
        textAnnotation.setBorder(border);
        textAnnotation.setBorderColor(new PdfRGBColor(Color.GRAY));
        textAnnotation.setLineEndingStyle(PdfLineEndingStyle.Circle);
        textAnnotation.setColor(new PdfRGBColor(new Color(135, 206, 250)));
        textAnnotation.setOpacity(0.8f);

        // Add the annotation to the page's annotations collection
        ((PdfNewPage) page).getAnnotations().add(textAnnotation);

        // Define the rectangle and create a new PdfFreeTextAnnotation for the annotation
        rect = new Rectangle2D.Float(150, 360, 200, 40);
        textAnnotation = new PdfFreeTextAnnotation(rect);
        textAnnotation.setText("\nSecurity features");

        // Set the border, font, and other properties for the annotation
        border = new PdfAnnotationBorder(1f);
        font = new PdfFont(PdfFontFamily.Helvetica, 10);
        textAnnotation.setFont(font);
        textAnnotation.setBorder(border);
        textAnnotation.setBorderColor(new PdfRGBColor(Color.PINK));
        textAnnotation.setLineEndingStyle(PdfLineEndingStyle.ClosedArrow);
        textAnnotation.setColor(new PdfRGBColor(new Color(144, 238, 144)));
        textAnnotation.setOpacity(0.8f);

        // Add the annotation to the page's annotations collection
        ((PdfNewPage) page).getAnnotations().add(textAnnotation);

        // Define the rectangle and create a new PdfFreeTextAnnotation 
        rect = new Rectangle2D.Float(150, 440, 200, 40);
        textAnnotation = new PdfFreeTextAnnotation(rect);
        textAnnotation.setText("\nExtract data from Pdf documents");

        // Set the border, font, and other properties for the annotation
        border = new PdfAnnotationBorder(1f);
        font = new PdfFont(PdfFontFamily.Helvetica, 10);
        textAnnotation.setFont(font);
        textAnnotation.setBorder(border);
        textAnnotation.setBorderColor(new PdfRGBColor(new Color(255, 69, 0)));
        textAnnotation.setLineEndingStyle(PdfLineEndingStyle.ClosedArrow);
        textAnnotation.setColor(new PdfRGBColor(new Color(250, 250, 210)));
        textAnnotation.setOpacity(0.8f);

        // Add the annotation to the page's annotations collection
        ((PdfNewPage) page).getAnnotations().add(textAnnotation);

        // Save the document to a file named "output/addFreeTextAnnotation.pdf"
        doc.saveToFile("output/addFreeTextAnnotation.pdf");

        // Close the PDF document
        doc.close();

        // Dispose of the PDF document (frees up system resources)
        doc.dispose();
    }
}
