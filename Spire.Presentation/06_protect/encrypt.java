import com.spire.presentation.*;
public class encrypt {
    public static void main(String[] args)throws Exception{
        String inputFile ="data/encrypt.pptx";
        String outputFile="output/encrypt_result.pptx";
        Presentation presentation = new Presentation();
        presentation.loadFromFile(inputFile);
        String strPassword = "e-iceblue";
        presentation.encrypt(strPassword);
        presentation.saveToFile(outputFile, FileFormat.PPTX_2010);
        presentation.dispose();
    }
}
