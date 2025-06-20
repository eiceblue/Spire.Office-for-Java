import com.spire.presentation.*;
import com.spire.presentation.drawing.FillFormatType;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

/**
 * This class demonstrates how to create an irregular polygon shape in a PowerPoint presentation.
 */
public class createIrregularPolygon {

    public static void main(String[] args) throws Exception {
        // Create a new PowerPoint presentation
        Presentation ppt = new Presentation();

        // Get the first slide of the presentation
        ISlide slide = ppt.getSlides().get(0);

        // Define the points for the irregular polygon shape
        List<Point2D> points = new ArrayList<>();
        points.add(new Point2D.Float(50f, 50f));
        points.add(new Point2D.Float(50f, 150f));
        points.add(new Point2D.Float(60f, 200f));
        points.add(new Point2D.Float(200f, 200f));
        points.add(new Point2D.Float(220f, 150f));
        points.add(new Point2D.Float(150f, 90f));
        points.add(new Point2D.Float(50f, 50f));

        // Append the irregular polygon shape to the slide
        IAutoShape autoShape = slide.getShapes().appendFreeformShape(points);

        // Set the fill type of the shape to none (transparent)
        autoShape.getFill().setFillType(FillFormatType.NONE);

        // Save the presentation to a file
        ppt.saveToFile("output/CreateIrregularPolygon.pptx", FileFormat.PPTX_2013);

        // Dispose the resources
        ppt.dispose();
    }
}

