import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.TextRange;
import java.io.*;

public class replaceWithHtml {
    public static void main(String[] args) throws IOException {
        String input = "data/replaceWithHtml.docx";
        String inputHtml = "data/replaceWithHtml.txt";
        String output = "output/replaceWithHtml.docx";
        //load Word document
        Document document = new Document();
        document.loadFromFile(input, FileFormat.Docx);

        //find a paragraph and replace its content with html
        TextSelection textSelection = document.findString("[#placeholder]", false, true);
        TextRange textrange =textSelection.getAsOneRange();
        Paragraph par= textrange.getOwnerParagraph();
        String htmlText = readTextFromFile(inputHtml);
        par.appendHTML(htmlText);
        par.getChildObjects().removeAt(0);
        //save the document
        document.saveToFile(output,FileFormat.Docx);
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
