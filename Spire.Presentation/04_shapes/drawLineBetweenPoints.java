import com.spire.presentation.*;
import java.awt.geom.Point2D;

/**
 * This class demonstrates how to draw a line between two points on a PowerPoint slide.
 */
public class drawLineBetweenPoints {

    public static void main(String[] args) throws Exception {
        // Create a new PowerPoint presentation
        Presentation ppt = new Presentation();

        // Get the first slide of the presentation
        ISlide slide = ppt.getSlides().get(0);

        // Define the starting point and ending point for the line
        Point2D startPoint = new Point2D.Float(50, 70);
        Point2D endPoint = new Point2D.Float(150, 120);

        // Append a line shape between the specified points to the slide
        slide.getShapes().appendShape(ShapeType.LINE, startPoint, endPoint);

        // Save the presentation to a file
        ppt.saveToFile("output/DrawLineBetweenPoints.pptx", FileFormat.PPTX_2013);

        // Dispose the resources
        ppt.dispose();
    }
}

