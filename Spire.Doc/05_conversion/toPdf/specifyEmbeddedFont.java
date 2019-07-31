import com.spire.doc.*;
import java.util.*;

public class specifyEmbeddedFont {
    public static void main(String[] args) {

        String inputFile="data/convertedTemplate.docx";
        String outputFile="output/specifyEmbeddedFont.pdf";

        Document document = new Document();
        document.loadFromFile(inputFile);

        //specify embedded font
        ToPdfParameterList parms = new ToPdfParameterList();
        List<String> part = new ArrayList();
        part.add("Lucida Sans Unicode");
        parms.setEmbeddedFontNameList(part);

        document.saveToFile(outputFile, parms);
    }
}
