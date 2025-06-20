import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.*;

public class drawPolygonWithShadowFill {
    public static void main(String[] args) {
       // Specify the output path
        String output = "output/drawPolygonWithShadowFill_output.xlsx";

        // Create a PDF document
        PdfDocument doc = new PdfDocument();

        // Create a page
        PdfPageBase page = doc.getPages().add();

        // Define points for the triangle
        Point2D[] points = new Point2D.Float[3];
        points[0] = new Point2D.Float(130, 172);
        points[1] = new Point2D.Float(160, 120);
        points[2] = new Point2D.Float(190, 172);

        // Define the gradient brush
        PdfLinearGradientBrush brush = new PdfLinearGradientBrush(new Point2D.Float(-2, 0), new Point2D.Float(2, 0), new PdfRGBColor(255, 255, 255), new PdfRGBColor(211, 211, 211));

        // Define the tiling brush for shadow effect
        PdfTilingBrush brushT = new PdfTilingBrush(new Rectangle2D.Float(0, 0, 4f, 4f));

        // Set the transparency and draw a rectangle to create the shadow effect
        brushT.getGraphics().setTransparency(0.5f);
        brushT.getGraphics().drawRectangle(brush, 0, 0, 4f, 4f);

        // Set the rotation of the tiling brush
        brushT.setRotation(135);

        // Draw the polygon with the shadow fill
        page.getCanvas().drawPolygon(brushT, points);

        // Save the document to file
        doc.saveToFile(output);

        // Close the PDF document
        doc.close();

        // Dispose of the PDF document (frees up system resources)
        doc.dispose();
    }
}
