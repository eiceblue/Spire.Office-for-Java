import com.spire.pdf.*;
import com.spire.pdf.annotations.PdfInkAnnotation;
import com.spire.pdf.graphics.PdfRGBColor;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class addInkAnnotation {
    public static void main(String[] args) {
        // Create a new PDF document
        PdfDocument doc = new PdfDocument();

        // Add a new page to the PDF document
        PdfPageBase pdfPage = doc.getPages().add();

        // Initialize an ArrayList to hold the ink points
        ArrayList inkList = new ArrayList();

        // Define an array of integer points that represent the ink strokes
        int[] intPoints = new int[]
                {
                        // Each pair represents a point (x, y)
                        100, 800,   // Start of the line
                        200, 800,   // Intermediate point
                        200, 700    // End of the line
                };

        // Add the points to the ink list
        inkList.add(intPoints);

        // Define a rectangle that will be used for the ink annotation area
        Rectangle2D rect = new Rectangle2D.Float();

        // Set the frame of the rectangle to cover the entire page
        rect.setFrame(
                new Point2D.Float(0, 0),
                new Dimension(
                        (int) pdfPage.getActualSize().getWidth(),
                        (int) pdfPage.getActualSize().getHeight()
                )
        );

        // Create an ink annotation using the defined rectangle and ink list
        PdfInkAnnotation ia = new PdfInkAnnotation(rect, inkList);

        // Set the color of the ink annotation to red
        ia.setColor(new PdfRGBColor(Color.RED));

        // Set the width of the border around the ink annotation
        ia.getBorder().setWidth(12);

        // Add text to the ink annotation
        ia.setText("e-iceblue");

        // Add the ink annotation to the current page
        ((PdfNewPage) pdfPage).getAnnotations().add(ia);

        // Save the PDF document to a file
        doc.saveToFile("output/addInkAnnotation.pdf");
        doc.dispose();
    }
}
