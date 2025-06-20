import com.spire.presentation.*;


public class specifySlidesConvertion {
    public static void main(String[] args) throws Exception {
        // Specify the input PowerPoint file path
        String inputFile = "data/specificSlideToPDF.pptx";

        // Specify the output PDF file path
        String outputFile = "output/toPDF_result.pdf";

        // Create a new Presentation object
        Presentation ppt = new Presentation();

        // Load the PowerPoint file
        ppt.loadFromFile(inputFile);

        // Save the specified slide (from index 1 to 1) to PDF file format
        ppt.saveToFile(1, 1, outputFile, FileFormat.PDF);

        // Dispose of the Presentation object to release resources
        ppt.dispose();
    }
}
