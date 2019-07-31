import com.spire.doc.*;

public class toHtml {
    public static void main(String[] args) {

        String inputFile="data/toHtmlTemplate.docx";
        String outputFile="output/toHtml.html";

        //create word document
        Document document = new Document();
        document.loadFromFile(inputFile);

        //save html file.
        document.saveToFile(outputFile, FileFormat.Html);
    }
}
