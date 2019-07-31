import com.spire.doc.*;

public class encrypt {
    public static void main(String[] args) {

        String inputFile="data/encrypt.docx";
        String outputFile="output/encrypt.docx";

        //create word document
        Document document = new Document();

        //load Word document.
        document.loadFromFile(inputFile);

        //encrypt document with password specified
        document.encrypt("E-iceblue");

        //save as docx file.
        document.saveToFile(outputFile, FileFormat.Docx);
    }
}
