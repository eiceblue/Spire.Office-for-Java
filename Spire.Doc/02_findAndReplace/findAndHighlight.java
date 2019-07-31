import com.spire.doc.*;
import com.spire.doc.documents.TextSelection;
import java.awt.*;

public class findAndHighlight {
    public static void main(String[] args) {
        String input = "data/findAndHighlight.docx";
        String output = "output/findAndHighlight.docx";
        //load Word document
        Document document = new Document();
        document.loadFromFile(input);

        //find Text
        TextSelection[] textSelections = document.findAllString("Word", false, true);

        //set highlight
        for (TextSelection selection : textSelections) {
            selection.getAsOneRange().getCharacterFormat().setHighlightColor(Color.YELLOW);
        }

        //save the file
        document.saveToFile(output, FileFormat.Docx_2010);
    }
}
