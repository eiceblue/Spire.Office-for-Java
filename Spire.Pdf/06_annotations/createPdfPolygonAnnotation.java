import com.spire.pdf.*;
import com.spire.pdf.annotations.*;
import com.spire.pdf.graphics.PdfRGBColor;
import java.awt.*;
import java.awt.geom.*;
import java.util.Date;

public class createPdfPolygonAnnotation {
    public static void main(String[] args) {
        // Create a new instance of PdfDocument
        PdfDocument pdf = new PdfDocument();

        // Add a new page to the document
        PdfPageBase page = pdf.getPages().add();

        // Specify the vertex coordinates to form a complete shape for the polygon annotation
        Point2D[] vertices = new Point2D[] {
                new Point2D.Float(0, 30),
                new Point2D.Float(30, 15),
                new Point2D.Float(60, 30),
                new Point2D.Float(45, 50),
                new Point2D.Float(15, 50),
                new Point2D.Float(0, 30)
        };

        // Create a polygon annotation based on the specified vertex coordinates and the page
        PdfPolygonAnnotation polygon = new PdfPolygonAnnotation(page, vertices);

        // Set properties of the polygon annotation, such as color, text, author, subject, border effect, and modified date
        polygon.setColor(new PdfRGBColor(Color.pink));
        polygon.setText("This is a polygon annotation");
        polygon.setAuthor("E-ICEBLUE");
        polygon.setSubject("polygon annotation demo");
        polygon.setBorderEffect(PdfBorderEffect.Big_Cloud);
        polygon.setModifiedDate(new Date());

        // Add the polygon annotation to the page's annotations widget
        page.getAnnotationsWidget().add(polygon);

        // Set the file path for saving the document
        String result = "output/createPdfPolygonAnnotation_out.pdf";

        // Save the document
        pdf.saveToFile(result);

        // Close the PDF document
        pdf.close();

        // Dispose of the PDF document (frees up system resources)
        pdf.dispose();
    }
}
