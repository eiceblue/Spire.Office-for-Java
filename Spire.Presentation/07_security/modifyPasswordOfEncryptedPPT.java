import com.spire.presentation.*;

public class modifyPasswordOfEncryptedPPT {
    public static void main(String[] args) throws Exception {
        String input = "data/template_Ppt_4.pptx";
        String output = "output/modifyPasswordOfEncryptedPPT.pptx";

        //create a PowerPoint document
        Presentation presentation = new Presentation();

        //load the file from disk with original password
        presentation.loadFromFile(input, "123456");

        //remove the encryption
        presentation.removeEncryption();

        //protect the document by setting a new password
        presentation.protect("654321");

        //save the file
        presentation.saveToFile(output, FileFormat.PPTX_2013);
    }
}
