import com.spire.presentation.*;

public class encrypt {
    public static void main(String[] args) throws Exception {
        String input ="data/templateA.pptx";
        String output="output/encrypt_output.pptx";

        //create PPT document
        Presentation presentation = new Presentation();

        //load the PPT document from disk
        presentation.loadFromFile(input);
        String strPassword = "e-iceblue";

        //encrypy the document with the password
        presentation.encrypt(strPassword);

        //save the file
        presentation.saveToFile(output, FileFormat.PPTX_2013);
        presentation.dispose();
    }
}
