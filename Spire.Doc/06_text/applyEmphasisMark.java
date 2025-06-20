import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.shape.*;

public class applyEmphasisMark {
    public static void main(String[] args) {
        //Create word document
        Document document = new Document();

        //Load the document from disk
        document.loadFromFile("data/sample.docx");

        //Find text to emphasize
        TextSelection[] textSelections = document.findAllString("Spire.Doc for Java", false, true);

        //Set emphasis mark to the found text
        for (TextSelection selection : textSelections) {
            selection.getAsOneRange().getCharacterFormat().setEmphasisMark(Emphasis.Dot);
        }

        //Save the file
        String output = "output/applyEmphasisMark.docx";
        document.saveToFile(output, FileFormat.Docx);

        //Dispose the document
        document.dispose();
    }
}
