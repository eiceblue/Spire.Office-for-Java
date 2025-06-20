import com.spire.presentation.*;

public class openEncryptedPPT {
    public static void main(String[] args) throws Exception {
        String input = "data/openEncryptedPPT.pptx";
        String output = "output/openEncryptedPPT_output.pptx";

        //create a PowerPoint document
        Presentation presentation = new Presentation();

        //load the file from disk with original password
        presentation.loadFromFile(input, "123456");

        //save as a new PPT with original password
        presentation.saveToFile(output, FileFormat.PPTX_2013);
        presentation.dispose();
    }
}
