import com.spire.doc.*;
import java.util.regex.Pattern;

public class replaceTextByRegex {
    public static void main(String[] args) {
        String input = "data/replaceTextByRegex.docx";
        String output = "output/replaceTextByRegex.docx";
        //load Word document
        Document document = new Document();
        document.loadFromFile(input, FileFormat.Docx);

        //create a regex, match the text that starts with "#"
        String regEx="\\#\\w+\\b";
        Pattern pattern= Pattern.compile(regEx);

        //replace the text by regex
        document.replace(pattern,"Spire.Doc");

        //save the document
        document.saveToFile(output,FileFormat.Docx);
    }
}
