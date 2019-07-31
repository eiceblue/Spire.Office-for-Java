import com.spire.doc.*;

public class decrypt {
    public static void main(String[] args) {

        String inputFile="data/decrypt.docx";
        String outputFile="output/decrypt.docx";

        //create word document
        Document document = new Document();
        document.loadFromFile(inputFile, FileFormat.Docx, "E-iceblue");

        //save as doc file.
        document.saveToFile(outputFile, FileFormat.Docx);
    }
}
