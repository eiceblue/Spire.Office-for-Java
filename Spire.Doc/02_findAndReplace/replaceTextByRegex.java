import com.spire.doc.*;
import java.util.regex.*;

public class replaceTextByRegex {
    public static void main(String[] args) {
        //Create word document
        Document doc = new Document();

        // Load the document from disk.
        doc.loadFromFile("data/ReplaceTextByRegex.docx");

        //Compiles the given regular expression into a pattern.
        Pattern regex=Pattern.compile("\\#\\w+\\b");

        // replace the text by regex
        doc.replace(regex,"Spire.Doc");

        // save the document
        doc.saveToFile("output/replaceTextByRegex.docx", FileFormat.Docx_2013);

        //Dispose the document
        doc.dispose();
    }
}
