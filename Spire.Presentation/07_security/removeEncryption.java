import com.spire.presentation.*;

public class removeEncryption {
    public static void main(String[] args) throws Exception {
        String input = "data/template_Ppt_4.pptx";
        String output = "output/removeEncryption.pptx";

        //create a PowerPoint document.
        Presentation presentation = new Presentation();

        //load the file from disk.
        presentation.loadFromFile(input, "123456");

        //remove encryption.
        presentation.removeEncryption();

        //save the file.
        presentation.saveToFile(output, FileFormat.PPTX_2013);
    }
}
