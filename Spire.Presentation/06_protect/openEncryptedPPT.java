import com.spire.presentation.*;

public class openEncryptedPPT {
    public static void main(String[] args) throws Exception{
        String inputFile ="data/openEncryptedPPT.pptx";
        String outputFile="output/openEncryptedPPT_result.pptx";

        Presentation presentation = new Presentation();
        presentation.loadFromFile(inputFile, "123456");
        //Save as a new PPT with original password
        presentation.saveToFile(outputFile, FileFormat.PPTX_2010);
        presentation.dispose();
    }
}
