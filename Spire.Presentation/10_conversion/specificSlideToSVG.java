import com.spire.presentation.*;

import java.io.FileOutputStream;
import java.util.List;

public class specificSlideToSVG {
    public static void main(String[] args) throws Exception {
        // Specify the input PowerPoint file path
        String inputFile = "data/toSVG.pptx";

        // Specify the output directory path
        String outputFile = "output/";

        // Create a new Presentation object
        Presentation ppt = new Presentation();

        // Load the PowerPoint file
        ppt.loadFromFile(inputFile);

        // Save specified slides (from index 0 to 1) as SVG format
        List<byte[]> bytes = ppt.saveToSVG(0, 1);

        // Iterate through the saved SVG bytes and write them to individual files
        for (int i = 0; i < bytes.size(); i++) {
            // Create a FileOutputStream for writing the SVG content to a file
            FileOutputStream fileOutputStream = new FileOutputStream(outputFile + "slide" + (i + 1) + ".svg");

            // Write the SVG content to the file
            fileOutputStream.write(bytes.get(i));

            // Flush and close the FileOutputStream
            fileOutputStream.flush();
            fileOutputStream.close();
        }

        // Dispose of the Presentation object to release resources
        ppt.dispose();
    }
}
