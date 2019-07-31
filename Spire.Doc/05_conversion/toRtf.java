import com.spire.doc.*;

public class toRtf {
    public static void main(String[] args) {

        String inputFile="data/convertedTemplate.docx";
        String outputFile="output/toRtf.rtf";

        //create word document
        Document document = new Document();
        document.loadFromFile(inputFile);

        //save to file.
        document.saveToFile(outputFile, FileFormat.Rtf);
    }
}
