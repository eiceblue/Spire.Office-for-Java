import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;
import java.awt.*;

public class insertNewText {
    public static void main(String[] args) {
        //Load Document
        String input = "data/Sample.docx";

        //Create a document
        Document doc = new Document();

        //Load a file
        doc.loadFromFile(input);

        //Find all the text string “Word” from the document
        TextSelection[] selections = doc.findAllString("Word", true, true);
        int index = 0;

        //Define a text range
        TextRange range;

        //Insert new text string (New text) after the searched text string
        for (TextSelection selection : selections) {
            range = selection.getAsOneRange();

            //Create a new TextRange
            TextRange newrange = new TextRange(doc);

            //Set the text
            newrange.setText("(New text)");

            //Get the index of the range
            index = range.getOwnerParagraph().getChildObjects().indexOf(range);

            //Insert the new text range after the original text range
            range.getOwnerParagraph().getChildObjects().insert((index + 1), newrange);
        }

        //Find and highlight the newly added text
        TextSelection[] text = doc.findAllString("New text", true, true);
        for (TextSelection selection : text) {
            selection.getAsOneRange().getCharacterFormat().setHighlightColor(Color.yellow);
        }

        //Save the document
        String output = "output/insertNewText.docx";
        doc.saveToFile(output, FileFormat.Docx);

        //Dispose the document
        doc.dispose();
    }
}
