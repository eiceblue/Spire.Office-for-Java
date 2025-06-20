import com.spire.presentation.Presentation;

import java.io.FileOutputStream;
import java.util.List;

public class toSVGZ {
    public static void main(String[] args) throws Exception {
        // Specify the input PowerPoint file path
        String inputFile = "data/toSVGZ.pptx";

        // Specify the output directory path
        String outputFile = "output/";

        // Create a new Presentation object
        Presentation ppt = new Presentation();

        // Load the PowerPoint file
        ppt.loadFromFile(inputFile);

        // Save each slide as SVGZ format
        List<byte[]> bytes = ppt.saveToSVGZ();

        // Iterate through the saved SVGZ bytes and write them to individual files
        for (int i = 0; i < bytes.size(); i++) {
            // Create a FileOutputStream for writing the SVGZ content to a file
            FileOutputStream fileOutputStream = new FileOutputStream(outputFile + "slide" + i + ".svgz");

            // Write the SVGZ content to the file
            fileOutputStream.write(bytes.get(i));

            // Flush and close the FileOutputStream
            fileOutputStream.flush();
            fileOutputStream.close();
        }

        // Dispose of the Presentation object to release resources
        ppt.dispose();
    }
}
