import com.spire.doc.*;
import java.io.*;

public class htmlStringToWord {
    public static void main(String[] args) throws IOException {

        String inputHtml = "data/replaceWithHtml.txt";
        String outputFile="output/htmlStringToWord.docx";

        Document document = new Document();

        //add a section.
        Section sec = document.addSection();

        String htmlText = readTextFromFile(inputHtml);
        //add a paragraph and append html string.
        sec.addParagraph().appendHTML(htmlText);

        //save to a Word file.
        document.saveToFile(outputFile, FileFormat.Docx);
    }
    public static String readTextFromFile(String fileName) throws IOException{
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String content = null;
        while ((content = br.readLine()) != null) {
            sb.append(content);
        }
        return sb.toString();
    }
}
