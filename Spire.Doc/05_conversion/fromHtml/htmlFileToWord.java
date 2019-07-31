import com.spire.doc.*;
import com.spire.doc.documents.XHTMLValidationType;

public class htmlFileToWord {
    public static void main(String[] args) {

        String inputFile="data/htmlFileToWord.html";
        String outputFile="output/htmlFileToWord.docx";

        //open an html file.
        Document document = new Document();
        document.loadFromFile(inputFile, FileFormat.Html, XHTMLValidationType.None);

        //save to a Word document.
        document.saveToFile(outputFile, FileFormat.Docx);
    }
}
