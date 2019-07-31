import com.spire.doc.*;

public class toXPS {
    public static void main(String[] args) {

        String inputFile="data/convertedTemplate.docx";
        String outputFile="output/toXPS.xps";

        Document document=new Document();
        document.loadFromFile(inputFile);
        document.saveToFile(outputFile, FileFormat.XPS );
    }
}
