import com.spire.presentation.*;

import java.util.Date;

public class addDigitalSignature {
    public static void main(String[] args) throws Exception {
        //Load a PowerPoint Document
        Presentation ppt = new Presentation();
        ppt.loadFromFile("data/addDigitalSignature.pptx");

        //Add a digital signature
        ppt.addDigitalSignature("data/gary.pfx", "e-iceblue", "Gary", new Date());

        //Save the PowerPoint Document
        String result = "output/addDigitalSignature_out.pptx";
        ppt.saveToFile(result, FileFormat.PPTX_2013);
    }
}
