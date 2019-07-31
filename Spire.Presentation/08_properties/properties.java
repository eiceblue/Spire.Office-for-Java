import com.spire.presentation.*;

public class properties {
    public static void main(String[] args) throws Exception{
        String inputFile = "data/properties.pptx";
        String outputFile = "output/properties_result.pptx";
        Presentation presentation = new Presentation();
        presentation.loadFromFile(inputFile);
        //Set the DocumentProperty of PPT document
        presentation.getDocumentProperty().setApplication("Spire.Presentation");
        presentation.getDocumentProperty().setAuthor("E-iceblue");
        presentation.getDocumentProperty().setCompany("E-iceblue Co., Ltd.");
        presentation.getDocumentProperty().setKeywords("Demo File");
        presentation.getDocumentProperty().setComments("This file is used to test Spire.Presentation.");
        presentation.getDocumentProperty().setCategory("Demo");
        presentation.getDocumentProperty().setTitle("This is a demo file.");
        presentation.getDocumentProperty().setSubject("Test");
        //Save the document
        presentation.saveToFile(outputFile, FileFormat.PPTX_2010);
        presentation.dispose();
    }
}