import com.spire.doc.*;
import com.spire.doc.documents.*;
import java.awt.*;

public class findKeyWordsInPara {
    public static void main(String[] args) {
        //Input file path
        String input = "data/Sample.docx";

        //Output file path
        String output ="output/findKeyWordsInPara_output.docx";

        //Create word document
        Document document = new Document();

        //Load a document
        document.loadFromFile(input);

        //Get the first section
        Section s = document.getSections().get(0);

        //Get the second paragraph
        Paragraph para = s.getParagraphs().get(1);

        //Find all matched keywords
        TextSelection[] textSelections = para.findAllString("Word", false, true);

        //Highlight text
        for (TextSelection selection : textSelections)
        {
            selection.getAsOneRange().getCharacterFormat().setHighlightColor(new Color(255, 255, 0));
        }

        // Save to file
        document.saveToFile(output, FileFormat.Docx_2013);

        //Dispose the document
        document.dispose();
    }
}
