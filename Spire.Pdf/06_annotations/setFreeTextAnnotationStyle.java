import com.spire.pdf.*;
import com.spire.pdf.annotations.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class setFreeTextAnnotationStyle {
    public static void main(String[] args) {
        // Create a new PDF document.
        PdfDocument doc = new PdfDocument();

        // Add a page.
        PdfPageBase page = doc.getPages().add();

        // Define the rectangle for the first free text annotation.
        Rectangle2D.Double rect = new Rectangle2D.Double(150, 120, 150, 30);

        // Create a new free text annotation with the defined rectangle.
        PdfFreeTextAnnotation textAnnotation = new PdfFreeTextAnnotation(rect);

        // Set the text content of the annotation.
        textAnnotation.setText("\nFree Text Annotation Formatting");

        // Set the font for the annotation.
        PdfFont font = new PdfFont(PdfFontFamily.Times_Roman, 10);
        textAnnotation.setFont(font);

        // Set the border style for the annotation.
        PdfAnnotationBorder border = new PdfAnnotationBorder(1f);
        textAnnotation.setBorder(border);

        // Set the border color for the annotation to orange.
        textAnnotation.setBorderColor(new PdfRGBColor(Color.orange));

        // Set the line ending style for the annotation to a circle.
        textAnnotation.setLineEndingStyle(PdfLineEndingStyle.Circle);

        // Set the color for the annotation to green.
        textAnnotation.setColor(new PdfRGBColor(Color.green));

        // Set the opacity (transparency) for the annotation to 0.8 (80% opaque).
        textAnnotation.setOpacity(0.8f);

        // Add the first free text annotation to the page's widget annotations.
        page.getAnnotationsWidget().add(textAnnotation);

        // Create the second free text annotation with new rectangle and set different properties.
        rect = new Rectangle2D.Double(150, 200, 150, 40);
        textAnnotation = new PdfFreeTextAnnotation(rect);
        textAnnotation.setText("\nFree Text Annotation Formatting");
        border = new PdfAnnotationBorder(1f);
        font = new PdfFont(PdfFontFamily.Helvetica, 10);
        textAnnotation.setFont(font);
        textAnnotation.setBorder(border);
        textAnnotation.setBorderColor(new PdfRGBColor(Color.yellow));
        textAnnotation.setLineEndingStyle(PdfLineEndingStyle.RClosedArrow);
        textAnnotation.setColor(new PdfRGBColor(Color.pink));
        textAnnotation.setOpacity(0.8f);
        page.getAnnotationsWidget().add(textAnnotation);

        // Create the third free text annotation with new rectangle and set different properties.
        rect = new Rectangle2D.Double(150, 280, 280, 40);
        textAnnotation = new PdfFreeTextAnnotation(rect);
        textAnnotation.setText("\nHow to Set Free Text Annotation Formatting in Pdf file");
        border = new PdfAnnotationBorder(1f);
        font = new PdfFont(PdfFontFamily.Helvetica, 10);
        textAnnotation.setFont(font);
        textAnnotation.setBorder(border);
        textAnnotation.setBorderColor(new PdfRGBColor(Color.gray));
        textAnnotation.setLineEndingStyle(PdfLineEndingStyle.Circle);
        textAnnotation.setColor(new PdfRGBColor(Color.yellow));
        textAnnotation.setOpacity(0.8f);
        page.getAnnotationsWidget().add(textAnnotation);

        // Create the forth free text annotation with new rectangle and set different properties.
        rect = new Rectangle2D.Double(150, 360, 200, 40);
        textAnnotation = new PdfFreeTextAnnotation(rect);
        textAnnotation.setText("\nFree Text Annotation Formatting");
        border = new PdfAnnotationBorder(1f);
        font = new PdfFont(PdfFontFamily.Helvetica, 10);
        textAnnotation.setFont(font);
        textAnnotation.setBorder(border);
        textAnnotation.setBorderColor(new PdfRGBColor(Color.pink));
        textAnnotation.setLineEndingStyle(PdfLineEndingStyle.RClosedArrow);
        textAnnotation.setColor(new PdfRGBColor(Color.LIGHT_GRAY));
        textAnnotation.setOpacity(0.8f);
        page.getAnnotationsWidget().add(textAnnotation);

        String result = "output/setFreeTextAnnotationFormatting_out.pdf";
        //Save the document
        doc.saveToFile(result);

        // Close the PDF document
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }
}
