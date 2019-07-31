import com.spire.presentation.*;

public class setDocumentReadOnly {
    public static void main(String[] args) throws Exception {
        String inputFile ="data/setDocumentReadOnly.pptx";
        String outputFile="output/setDocumentReadOnly_result.pptx";

        Presentation presentation = new Presentation();
        presentation.loadFromFile(inputFile);
        String password = "123456";
        presentation.protect(password);
        presentation.saveToFile(outputFile, FileFormat.PPTX_2010);
        presentation.dispose();
    }
}
