import com.spire.presentation.*;
import com.spire.presentation.collections.GradientStopCollection;
import java.io.FileWriter;


public class setBrightnessAndTransparencyForGradientStop {

    public static void main(String[] args) throws Exception {
        // Create an Presentation object and load the input file
        Presentation ppt = new Presentation();
        ppt.loadFromFile("data/getAndSetGradientStops.pptx");

        StringBuilder sb = new StringBuilder();

        // Get the first slide
        ISlide slide =  ppt.getSlides().get(0);

        // Iterate through Shapes within a Slide
        for (int j = 0; j < slide.getShapes().size(); j++) {
            // Get the specific shape
            IAutoShape shape = (IAutoShape) ((GroupShape) slide.getShapes().get(j)).getShapes().get(2);
            // Get the collection of gradient stops
            GradientStopCollection stops = shape.getFill().getGradient().getGradientStops();
            sb.append("shape "+j+ ":"+"\r\n");

            // Iterate through the collection of gradient stops
            for (int i = 0; i < stops.size(); i++) {
                // Get transparency and brightness
                float transparency = stops.get(i).getColor().getTransparency();
                float brightness = stops.get(i).getColor().getBrightness();
                sb.append("stops" + i + "transparency ：" + transparency + "  brightness：" + brightness + "\r\n");
            }
            // Set transparency and brightness
            stops.get(0).getColor().setTransparency(0.1f);
            stops.get(0).getColor().setBrightness(-0.1f);
            stops.get(1).getColor().setTransparency(0.51f);
            stops.get(1).getColor().setBrightness(0.5f);
        }
        // Write the data to a txt file and output them
        FileWriter fw = new FileWriter("output/getAndSetGradientStops_output.txt");
        fw.append(sb.toString());
        fw.flush();
        fw.close();
        // Save the file
        ppt.saveToFile("output/getAndSetGradientStops_output.pptx", FileFormat.AUTO);
        ppt.dispose();
    }
}
