import com.spire.presentation.*;

public class toPPTX {
    public static void main(String[] args) throws Exception {
        String inputFile ="data/toPPTX.ppt";
        String outputFile="output/toPPTX_result.pptx";
        Presentation pt = new Presentation();
        //Load the PPT file from disk
        pt.loadFromFile(inputFile);
        //Save the PPT document to PPTX file format
        pt.saveToFile(outputFile, FileFormat.PPTX_2013);
        pt.dispose();
    }
}
