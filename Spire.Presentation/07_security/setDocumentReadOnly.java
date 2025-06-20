import com.spire.presentation.*;

public class setDocumentReadOnly {
    public static void main(String[] args) throws Exception {
        String input = "data/templateA.pptx";
        String output = "output/setDocumentReadOnly_output.pptx";

        //create a PowerPoint document.
        Presentation presentation = new Presentation();

        //load the file from disk.
        presentation.loadFromFile(input);

        //Protect the document with the password
        String password = "123456";
        presentation.protect(password);

        //save the file
        presentation.saveToFile(output, FileFormat.PPTX_2013);
        presentation.dispose();
    }
}
