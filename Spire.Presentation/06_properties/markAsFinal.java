import com.spire.presentation.*;

public class markAsFinal {
    public static void main(String[] args) throws Exception {
        String input = "data/markAsFinal.pptx";
        String output = "output/markAsFinal_Output.pptx";

        //create PPT document
        Presentation presentation = new Presentation();

        //load the PPT document from disk
        presentation.loadFromFile(input);

        //mark the document as final
        presentation.getDocumentProperty().set("_MarkAsFinal", true);

        //save the file
        presentation.saveToFile(output, FileFormat.PPTX_2013);
        presentation.dispose();
    }
}
