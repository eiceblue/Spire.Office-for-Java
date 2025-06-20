import com.spire.presentation.*;

public class properties {
    public static void main(String[] args) throws Exception {
        String input = "data/properties.pptx";
        String output = "output/properties_Output.pptx";

        //create PPT document
        Presentation presentation = new Presentation();

        //load the PPT document from disk
        presentation.loadFromFile(input);

        //set the DocumentProperty of PPT document
        presentation.getDocumentProperty().setApplication("Spire.Presentation");
        presentation.getDocumentProperty().setAuthor("E-iceblue");
        presentation.getDocumentProperty().setCompany("E-iceblue Co., Ltd.");
        presentation.getDocumentProperty().setKeywords("Demo File");
        presentation.getDocumentProperty().setComments("This file is used to test Spire.Presentation.");
        presentation.getDocumentProperty().setCategory("Demo");
        presentation.getDocumentProperty().setTitle("This is a demo file.");
        presentation.getDocumentProperty().setSubject("Test");

        //save the document
        presentation.saveToFile(output, FileFormat.PPTX_2013);
        presentation.dispose();
    }
}
