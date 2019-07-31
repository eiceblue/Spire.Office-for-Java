import com.spire.doc.*;

public class toSVG {
    public static void main(String[] args) {

        String inputFile="data/convertedTemplate.docx";
        String outputFile="output/toSVG.svg";

        //create word document
        Document document = new Document();
        document.loadFromFile(inputFile);
        document.saveToFile(outputFile, FileFormat.SVG);
    }
}
