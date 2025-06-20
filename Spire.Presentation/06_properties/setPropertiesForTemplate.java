import com.spire.presentation.*;

public class setPropertiesForTemplate {
    public static void main(String[] args) throws Exception {
        //string for .pptx file
        String pptxResult = "output/setPropertiesForTemplate.pptx";

        //string for .odp file
        String odpResult = "output/setPropertiesForTemplate.odp";

        //string for .ppt file
        String pptResult = "output/setPropertiesForTemplate.ppt";

        //create the .pptx template
        setPropertiesForTemplate(pptxResult, FileFormat.PPTX_2013);

        //create the .odp template
        setPropertiesForTemplate(odpResult, FileFormat.ODP);

        //create the .ppt template
        setPropertiesForTemplate(pptResult, FileFormat.PPT);
    }
    private static void setPropertiesForTemplate(String filePath, FileFormat fileFormat) throws Exception {
        //create a document
        Presentation presentation = new Presentation();

        //set the DocumentProperty
        presentation.getDocumentProperty().setApplication("Spire.Presentation");
        presentation.getDocumentProperty().setAuthor("E-iceblue");
        presentation.getDocumentProperty().setCompany("E-iceblue Co., Ltd.");
        presentation.getDocumentProperty().setKeywords("Demo File");
        presentation.getDocumentProperty().setComments("This file is used to test Spire.Presentation.");
        presentation.getDocumentProperty().setCategory("Demo");
        presentation.getDocumentProperty().setTitle("This is a demo file.");
        presentation.getDocumentProperty().setSubject("Test");

        //save to template file
        presentation.saveToFile(filePath, fileFormat);
    }
}
