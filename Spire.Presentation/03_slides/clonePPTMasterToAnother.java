import com.spire.presentation.*;

public class clonePPTMasterToAnother {
    public static void main(String[] args) throws Exception {
        //Load PPT1 from disk
        Presentation presentation1 = new Presentation();
        presentation1.loadFromFile("data/cloneMaster1.pptx");

        //Load PPT2 from disk
        Presentation presentation2 = new Presentation();
        presentation2.loadFromFile("data/cloneMaster2.pptx");

        //Add masters from PPT1 to PPT2
        for (Object obj : presentation1.getMasters()) {
            IMasterSlide masterSlide = (IMasterSlide) obj;
            presentation2.getMasters().appendSlide(masterSlide);
        }

        //Save the document
        String result = "output/clonePPTMasterToAnother.pptx";
        presentation2.saveToFile(result, FileFormat.PPTX_2013);
    }
}
