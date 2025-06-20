import com.spire.pdf.*;
import com.spire.pdf.annotations.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.EnumSet;

public class invisibleFreeTextAnnotation {
    public static void main(String[] args) {
		// Create a new PdfDocument object
        PdfDocument doc = new PdfDocument();

        // Load the existing PDF document from the specified file path
        doc.loadFromFile("data/template_Pdf_4.pdf");

        // Get the first page of the PDF document
        PdfPageBase page = doc.getPages().get(0);

        // Define the rectangle for the first invisible free text annotation
        Rectangle2D.Double rect1 = new Rectangle2D.Double(100, 120, 150, 30);

        // Create a new PdfFreeTextAnnotation with the specified rectangle
        PdfFreeTextAnnotation freeTextAnnotation1 = new PdfFreeTextAnnotation(rect1);

        // Set the text content of the first invisible free text annotation
        freeTextAnnotation1.setText("Invisible Free Text Annotation");

        // Create a new PdfFont object for the annotation's font
        PdfFont font = new PdfFont(PdfFontFamily.Times_Roman, 10);

        // Create a new PdfAnnotationBorder object to define the border of the annotation
        PdfAnnotationBorder border = new PdfAnnotationBorder(1f);

        // Customize the properties of the first invisible free text annotation
        // Set the font for the first invisible free text annotation
        freeTextAnnotation1.setFont(font);

        // Set the border for the first invisible free text annotation
        freeTextAnnotation1.setBorder(border);

        // Set the border color for the first invisible free text annotation to orange
        freeTextAnnotation1.setBorderColor(new PdfRGBColor(Color.orange));

        // Set the line ending style for the first invisible free text annotation to circle
        freeTextAnnotation1.setLineEndingStyle(PdfLineEndingStyle.Circle);

        // Set the color for the first invisible free text annotation to green
        freeTextAnnotation1.setColor(new PdfRGBColor(Color.green));

        // Set the opacity for the first invisible free text annotation to 0.8
        freeTextAnnotation1.setOpacity(0.8f);

        // Invisible free text annotation.
        freeTextAnnotation1.setFlags(EnumSet.of(PdfAnnotationFlags.No_View));

        // Add the first invisible free text annotation to the page's annotation collection
        page.getAnnotationsWidget().add(freeTextAnnotation1);

        // Define the rectangle for the second visible free text annotation
        Rectangle2D.Double rect2 = new Rectangle2D.Double(100, 180, 150, 30);

        // Create a new PdfFreeTextAnnotation with the specified rectangle
        PdfFreeTextAnnotation freeTextAnnotation2 = new PdfFreeTextAnnotation(rect2);

        // Set the text content of the second visible free text annotation
        freeTextAnnotation2.setText("Show Free Text Annotation");

        // Customize the properties of the second visible free text annotation
        freeTextAnnotation2.setFont(font);
        freeTextAnnotation2.setBorder(border);
        freeTextAnnotation2.setBorderColor(new PdfRGBColor(Color.pink));
        freeTextAnnotation2.setLineEndingStyle(PdfLineEndingStyle.Circle);
        freeTextAnnotation2.setColor(new PdfRGBColor(Color.yellow));
        freeTextAnnotation2.setOpacity(0.8f);

        // Add the second visible free text annotation to the page's annotation collection
        page.getAnnotationsWidget().add(freeTextAnnotation2);

        // Specify the file path to save the modified document
        String result = "output/invisibleFreeTextAnnotation_out.pdf";

        // Save the modified PDF document to the specified file path
        doc.saveToFile(result);

        // Close the PDF document
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }
}
