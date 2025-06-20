import com.spire.pdf.*;
import com.spire.pdf.annotations.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.Date;

public class createSquareAndCircleAnnotation {
    public static void main(String[] args) {
         // Create a new instance of PdfDocument
        PdfDocument pdf = new PdfDocument();

        // Add a new page to the document
        PdfPageBase page = pdf.getPages().add();

        // Define the font for drawing text
        PdfFont font = new PdfFont(PdfFontFamily.Helvetica, 20);

        // Draw a circle annotation
        // Define the text for the annotation
        String text1 = "This is Circle annotation";

        // Define the brush color for the annotation
        PdfBrush brush1 = PdfBrushes.getBlue();

        // Measure the dimensions of the text
        Dimension2D dimension1 = font.measureString(text1);

        // Increase the dimensions by 35 units in width and 20 units in height
        dimension1.setSize(dimension1.getWidth() + 35, dimension1.getHeight() + 20);

        // Draw the text on the PDF page at coordinates (50, 100) using the specified font and brush
        page.getCanvas().drawString(text1, font, brush1, 50, 100);

        // Create a rectangle bounds for the annotation
        Rectangle2D.Float annotationBounds1 = new Rectangle2D.Float();

        // Set the position and size of the rectangle bounds
        annotationBounds1.setFrame(new Point2D.Float(36, (float) 90), dimension1);

        // Create a circle annotation with the specified bounds
        PdfSquareAndCircleAnnotation annotation1 = new PdfSquareAndCircleAnnotation(annotationBounds1);

        // Set the subtype of the annotation to Circle
        annotation1.setSubType(PdfSquareAndCircleAnnotationType.Circle);

        // Define the rectangular difference array for the annotation
        float[] f1 = {0.5f, 0.5f, 0.5f, 0.5f};
        annotation1.setRectangularDifferenceArray(f1);

        // Set the text content of the annotation
        annotation1.setText("Circle annotation test");

        // Set the color of the annotation to red
        annotation1.setColor(new PdfRGBColor(Color.RED));

        // Set the modified date of the annotation to the current date
        annotation1.setModifiedDate(new Date());

        // Set the name of the annotation
        annotation1.setName("*****");

        // Create a line border for the annotation
        LineBorder border1 = new LineBorder();

        // Set the width of the border to 2 units
        border1.setBorderWidth(2);

        // Set the line border for the annotation
        annotation1.setLineBorder(border1);

        // Add the annotation to the annotations widget of the PDF page
        page.getAnnotationsWidget().add(annotation1);

        // Draw a square annotation
        String text2 = "This is Square annotation";
        PdfBrush brush2 = PdfBrushes.getBlue();
        Dimension2D dimension2 = font.measureString(text2);
        dimension2.setSize(dimension2.getWidth() + 20, dimension2.getHeight() + 10);
        page.getCanvas().drawString(text2, font, brush2, 50, 200);
        Rectangle2D.Float annotationBounds2 = new Rectangle2D.Float();
        annotationBounds2.setFrame(new Point2D.Float(45, (float) 195), dimension2);
        PdfSquareAndCircleAnnotation annotation2 = new PdfSquareAndCircleAnnotation(annotationBounds2);
        annotation2.setSubType(PdfSquareAndCircleAnnotationType.Square);
        float[] f2 = {0.5f, 0.5f, 0.5f, 0.5f};
        annotation2.setRectangularDifferenceArray(f2);
        annotation2.setText("Square annotation test");
        annotation2.setColor(new PdfRGBColor(Color.RED));
        annotation2.setModifiedDate(new Date());
        annotation2.setName("*****");
        LineBorder border2 = new LineBorder();
        border2.setBorderWidth(2);
        annotation2.setLineBorder(border2);
        page.getAnnotationsWidget().add(annotation2);

        // Set the file path for saving the document
        String outputFile = "output/createSquareAndCircleAnnotation.pdf";

        // Save the document
        pdf.saveToFile(outputFile, FileFormat.PDF);

        // Close the PDF document
        pdf.close();

        // Dispose of the PDF document (frees up system resources)
        pdf.dispose();
    }
}
