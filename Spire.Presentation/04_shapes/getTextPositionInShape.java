import com.spire.presentation.*;

import java.awt.geom.Point2D;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class getTextPositionInShape {
    public static void main(String[] args) throws Exception {
        // Specify the input PowerPoint file path
        String inputFile = "data/GetTextPositionInShape.pptx";

        // Specify the output text file path
        String outputFile = "output/output.txt";

        // Create a new Presentation object
        Presentation ppt = new Presentation();

        // Load the PowerPoint file
        ppt.loadFromFile(inputFile);

        // Create a StringBuilder to store text information
        StringBuilder sb = new StringBuilder();

        // Access the first slide in the presentation
        ISlide slide = ppt.getSlides().get(0);

        // Iterate through all the shapes in the slide
        for (int i = 0; i < slide.getShapes().getCount(); i++) {
            // Get the current shape
            IShape shape = slide.getShapes().get(i);

            // Check if the shape is an AutoShape
            if (shape instanceof IAutoShape) {
                // Cast the shape to an AutoShape
                IAutoShape autoshape = (IAutoShape) shape;

                // Get the text content of the AutoShape
                String text = autoshape.getTextFrame().getText();

                // Obtain the text position information within the AutoShape
                Point2D point = autoshape.getTextFrame().getTextLocation();

                // Append information about the shape, text, and location to the StringBuilder
                sb.append("Shape " + i + "：" + text + "\r\n" + "location：" + point.toString());
                sb.append("\r\n");
            }
        }

        // Write the collected information to a text file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write(sb.toString());
        }

        // Dispose of the Presentation object to release resources
        ppt.dispose();
    }
}
