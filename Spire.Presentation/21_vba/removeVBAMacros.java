import com.spire.presentation.*;

public class removeVBAMacros {
    public static void main(String[] args) throws Exception{
        //Create a PPT document
        Presentation presentation = new Presentation();

        //Load PPT file from disk
        presentation.loadFromFile("data/Macros.ppt");

        //Remove macros
        //Note, at present it only can work on macros in PPT file, has not supported for PPTM file yet.
        presentation.deleteMacros();

        String result = "output/removeVBAMacros.ppt";

        //Save to file
        presentation.saveToFile(result, FileFormat.PPT);
    }
}
