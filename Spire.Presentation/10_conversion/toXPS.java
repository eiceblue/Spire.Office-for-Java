
import com.spire.presentation.*;


public class toXPS {
    public static void main(String[] args) throws Exception {
        String inputFile ="data/toPDF.pptx";
        String outputFile="output/toXPS_result.xps";

        Presentation ppt = new Presentation();
        ppt.loadFromFile(inputFile);

        //Save the PPT to XPS file format
        ppt.saveToFile(outputFile, FileFormat.XPS);
        ppt.dispose();
    }
}
