import com.spire.presentation.*;

public class removeEncyption {
    public static void main(String[] args) throws Exception {
        String inputFile ="data/removeEncyption.pptx";
        String outputFile="output/removeEncyption_result.pptx";

        Presentation presentation = new Presentation();
        presentation.loadFromFile(inputFile, FileFormat.PPTX_2010, "123456");
        presentation.removeEncryption();
        presentation.saveToFile(outputFile, FileFormat.PPTX_2010);
        presentation.dispose();
    }
}
