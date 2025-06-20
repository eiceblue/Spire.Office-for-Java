import java.awt.*;
import java.awt.geom.Rectangle2D;
import com.spire.pdf.*;
import com.spire.pdf.annotations.*;
import com.spire.pdf.graphics.*;

public class setFreeTextAnnotationAlignment {

    public static void main(String[] args) {
		        // Create a new PdfDocument object
        PdfDocument pdf = new PdfDocument();

        // Add a new page to the PDF document
        PdfPageBase page = pdf.getPages().add();

        // Define the rectangle for the free text annotation
        Rectangle2D rect = new Rectangle2D.Float(0, 300, 200, 80);

        // Create a PdfFreeTextAnnotation with the specified rectangle
        PdfFreeTextAnnotation textAnnotation = new PdfFreeTextAnnotation(rect);

        // Set the text content of the free text annotation
        textAnnotation.setText("\n  Spire.PDF");

        // Create a PdfAnnotationBorder object to define the border of the annotation
        PdfAnnotationBorder border = new PdfAnnotationBorder(1f);

        // Create a PdfFont object for the annotation's font
        PdfFont font = new PdfFont(PdfFontFamily.Times_Roman, 20);

        // Set the font of the text annotation.
        textAnnotation.setFont(font);

        // Set the border style of the text annotation.
        textAnnotation.setBorder(border);

        // Set the border color of the text annotation to gray.
        textAnnotation.setBorderColor(new PdfRGBColor(Color.gray));

        // Set the line ending style of the text annotation to a slash.
        textAnnotation.setLineEndingStyle(PdfLineEndingStyle.Slash);

        // Set the color of the text annotation to blue.
        textAnnotation.setColor(new PdfRGBColor(Color.blue));

        // Set the opacity (transparency) of the text annotation to 0.8 (80% opaque).
        textAnnotation.setOpacity(0.8f);

        // Set the text alignment of the text annotation to center.
        textAnnotation.setAnnotTextAlignment(PdfAnnotationTextAlignment.Center);

        // Add the free text annotation to the page's annotation collection
        page.getAnnotationsWidget().add(textAnnotation);

        // Specify the file path to save the modified document
        String output = "SetFreeTextAnnotationAlignment.pdf";

        // Save the modified PDF document to the specified file path
        pdf.saveToFile(output);

        // Close the PDF document
        pdf.close();

        // Dispose of the PDF document to free up system resources
        pdf.dispose();

    }
}
