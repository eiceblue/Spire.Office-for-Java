import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.*;

public class drawShape {
    public static void main(String[] args) {
          // Create a PDF document
        PdfDocument doc = new PdfDocument();

        // Add a new page
        PdfPageBase page = doc.getPages().add();

        //To draw a spiral shape on a PDF page
        drawSpiral(page);

        // To draw a path on a PDF page
        drawPath(page);

        // To draw a pie chart on a PDF page
        drawPie(page);

        // To draw a rectangle on a PDF page
        drawRectangle(page);

        // To draw an ellipse on a PDF page
        drawEllipse(page);

        // Save pdf file
        doc.saveToFile("output/drawShape.pdf");

        // Close the PDF document
        doc.close();

        // Dispose of the PDF document (frees up system resources)
        doc.dispose();
    }

  
    // Function to draw a path on a PDF page
    static void drawPath(PdfPageBase page)
    {
        // Define an array of points to use for the path
        Point2D[] points = new Point2D.Float[5];

        for (int i = 0; i < points.length; i++) {
            // Calculate x-coordinate based on angle
            float x = (float)Math.cos(i * 2 * Math.PI / 5);
            // Calculate y-coordinate based on angle
            float y = (float)Math.sin(i * 2 * Math.PI / 5);
            // Create a new point with the calculated coordinates
            points[i] = new Point2D.Float(x, y);
        }

        // Create a new PdfPath object
        PdfPath path = new PdfPath();

        // Add a line segment from points[2] to points[0]
        path.addLine(points[2], points[0]);

        // Add a line segment from points[0] to points[3]
        path.addLine(points[0], points[3]);

        // Add a line segment from points[3] to points[1]
        path.addLine(points[3], points[1]);

        // Add a line segment from points[1] to points[4]
        path.addLine(points[1], points[4]);

        // Add a line segment from points[4] to points[2]
        path.addLine(points[4], points[2]);

        // Save the current graphics state
        PdfGraphicsState state = page.getCanvas().save();

        // Create a pen with color and width
        PdfPen pen = new PdfPen(new PdfRGBColor(new Color(0,191,255)), 0.02f);

        // Create a solid brush with color
        PdfBrush brush1 = new PdfSolidBrush(new PdfRGBColor(new Color(95,158,160)));

        // Scale the transformation matrix of the canvas
        page.getCanvas().scaleTransform(50f, 50f);

        // Translate the transformation matrix of the canvas
        page.getCanvas().translateTransform(5f, 1.2f);

        // Draw the path on the canvas using the pen
        page.getCanvas().drawPath(pen, path);

        // Translate the transformation matrix of the canvas
        page.getCanvas().translateTransform(2f, 0f);

        // Set the fill mode of the path to alternate
        path.setFillMode(PdfFillMode.Alternate);

        // Draw the path on the canvas using the pen and brush
        page.getCanvas().drawPath(pen, brush1, path);

        // Translate the transformation matrix of the canvas
        page.getCanvas().translateTransform(2f, 0f);

        // Set the fill mode of the path to winding
        path.setFillMode(PdfFillMode.Winding);

        // Draw the path on the canvas using the pen and brush
        page.getCanvas().drawPath(pen, brush1, path);


        // Create a linear gradient brush with start and end points and colors
        PdfLinearGradientBrush brush2 = new PdfLinearGradientBrush(new Point2D.Float(-2, 0), new Point2D.Float(2, 0), new PdfRGBColor(Color.red), new PdfRGBColor(Color.blue));

        // Translate the transformation matrix of the canvas
        page.getCanvas().translateTransform(-4f, 2f);

        // Set the fill mode of the path to alternate
        path.setFillMode(PdfFillMode.Alternate);

        // Draw the path on the canvas using the pen and brush
        page.getCanvas().drawPath(pen, brush2, path);

        // Create a radial gradient brush object
        PdfRadialGradientBrush brush3 = new PdfRadialGradientBrush(new Point2D.Float(0f, 0f), 0f, new Point2D.Float(0f, 0f), 1f, new PdfRGBColor(Color.red), new PdfRGBColor(Color.blue));

        // Translate the canvas by (2, 0)
        page.getCanvas().translateTransform(2f, 0f);

        // Set the fill mode of the path to Winding
        path.setFillMode(PdfFillMode.Winding);

        // Draw the path using the specified pen and brush
        page.getCanvas().drawPath(pen, brush3, path);

        // Create a tiling brush object
        PdfTilingBrush brush4 = new PdfTilingBrush(new Rectangle2D.Float(0, 0, 4f, 4f));

        // Draw a rectangle on the tiling brush graphics
        brush4.getGraphics().drawRectangle(brush2, 0, 0, 4f, 4f);

        // Translate the canvas by (2, 0)
        page.getCanvas().translateTransform(2f, 0f);

        // Set the fill mode of the path to Winding
        path.setFillMode(PdfFillMode.Winding);

        // Draw the path using the specified pen and tiling brush
        page.getCanvas().drawPath(pen, brush4, path);

        // Restore the saved graphics state
        page.getCanvas().restore(state);
    }

    //Function to draw a spiral shape on a PDF page
    static void drawSpiral(PdfPageBase page)
    {
        //Save the current graphics state
        PdfGraphicsState state = page.getCanvas().save();

        //Create a blue pen for drawing
        PdfPen pen = PdfPens.getDeepSkyBlue();

        //Number of points to draw
        int nPoints = 1000;

        //Radii of the two circles forming the spiral
        double r1 = 30;
        double r2 = 25;

        //Parameter of the spiral
        double p = 35;

        //Coordinates of the starting point of the spiral
        double x1 = r1 + r2 - p;
        double y1 = 0;
        double x2 = 0;
        double y2 = 0;

        //Translate the canvas to the desired position
        page.getCanvas().translateTransform(100, 100);

        //Loop through each point and draw a line segment
        for (int i = 0; i < nPoints; i++)
        {
            //Calculate the angle and coordinates of the current point
            double t = i * Math.PI / 90;
            x2 = (r1 + r2) * Math.cos(t) - p * Math.cos((r1 + r2) * t / r2);
            y2 = (r1 + r2) * Math.sin(t) - p * Math.sin((r1 + r2) * t / r2);

            //Draw a line segment between the current and previous points
            page.getCanvas().drawLine(pen, (float)x1, (float)y1, (float)x2, (float)y2);

            //Update the coordinates of the previous point
            x1 = x2;
            y1 = y2;
        }

        //Restore the original graphics state
        page.getCanvas().restore(state);
    }

    //Function to draw a pie chart on a PDF page
    static void drawPie(PdfPageBase page)
    {
        //Save the current graphics state
        PdfGraphicsState state = page.getCanvas().save();

        //Create a red pen for drawing
        PdfPen pen = new PdfPen(new PdfRGBColor(new Color(139,0,0)), 2f);

        //Draw a pie chart with a radius of 100, starting at 90 degrees and ending at 360 degrees
        page.getCanvas().drawPie(pen, 220, 320, 100, 90, 360, 360);

        //Restore the original graphics state
        page.getCanvas().restore(state);
    }

    //Function to draw a rectangle on a PDF page
    static void drawRectangle(PdfPageBase page)
    {
        //Save the current graphics state
        PdfGraphicsState state = page.getCanvas().save();

        //Create an orange pen for drawing
        PdfPen pen = new PdfPen(new PdfRGBColor(new Color(210,105,30)), 1f);

        //Draw a rectangle with a top-left corner at (20, 310) and a width and height of 150 and 120
        page.getCanvas().drawRectangle(pen, new Rectangle(new Point(20, 310), new Dimension(150, 120)));

        //Restore the original graphics state
        page.getCanvas().restore(state);
    }

    // Function to draw an ellipse on a PDF page
    static void drawEllipse(PdfPageBase page)
    {
        // Save the current graphics state
        PdfGraphicsState state = page.getCanvas().save();

        // Create a brush with the specified color
        PdfBrush brush = new PdfSolidBrush(new PdfRGBColor(new Color(95,158,160)));
        page.getCanvas().drawEllipse(brush, 380, 325, 80, 80);

        // Restore the original graphics state
        page.getCanvas().restore(state);
    }
}

