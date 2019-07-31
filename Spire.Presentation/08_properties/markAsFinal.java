import com.spire.presentation.FileFormat;
import com.spire.presentation.Presentation;

public class markAsFinal {
    public static void main(String[] args) throws Exception {
        String inputFile = "data/markAsFinal.pptx";
        String outputFile = "output/markAsFinal_result.pptx";
        Presentation presentation = new Presentation();
        presentation.loadFromFile(inputFile);
        presentation.getDocumentProperty().set("_MarkAsFinal", true);
        presentation.saveToFile(outputFile, FileFormat.PPTX_2010);
        presentation.dispose();
    }
}

