import com.spire.presentation.*;

public class convertPPSToPPTX {
    public static void main(String[] args) throws Exception {
        //Create an instance of presentation document
        Presentation ppt = new Presentation();
        //Load file
        ppt.loadFromFile("data/Conversion.pps");

        //Save the PPS document to PPTX file format
        String result = "output/convertPPSToPPTX_result.pptx";
        ppt.saveToFile(result, FileFormat.PPTX_2013);
    }
}
