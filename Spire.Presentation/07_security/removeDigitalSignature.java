import com.spire.presentation.*;

public class removeDigitalSignature {
    public static void main(String[] args) throws Exception {
        //Load a PowerPoint Document
        Presentation ppt = new Presentation();
        ppt.loadFromFile("data/digitalSignature.pptx");

        //If the file contains the digital signature
        if (ppt.isDigitallySigned()) {
            //Removes digital signature
            ppt.removeAllDigitalSignatures();
        }

        ppt.saveToFile("output/removeDigitalSignature_out.pptx", FileFormat.PPTX_2013);
    }
}
