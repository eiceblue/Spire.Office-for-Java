import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;
import java.awt.*;

public class insertFootnote {
    public static void main(String[] args) {
        String input = "data/insertFootnote.docx";
        String output = "output/insertFootnote.docx";
        Document document = new Document();
        document.loadFromFile(input);
        TextSelection selection = document.findString("Spire.Doc", false, true);

        TextRange textRange = selection.getAsOneRange();
        Paragraph paragraph = textRange.getOwnerParagraph();
        int index = paragraph.getChildObjects().indexOf(textRange);
        Footnote footnote = paragraph.appendFootnote(FootnoteType.Footnote);
        paragraph.getChildObjects().insert(index + 1, footnote);

        textRange = footnote.getTextBody().addParagraph().appendText("Welcome to evaluate Spire.Doc");
        textRange.getCharacterFormat().setFontName("Arial Black");
        textRange.getCharacterFormat().setFontSize(10);
        textRange.getCharacterFormat().setTextColor(new Color(255, 140, 0));

        footnote.getMarkerCharacterFormat().setFontName("Calibri");
        footnote.getMarkerCharacterFormat().setFontSize(12);
        footnote.getMarkerCharacterFormat().setBold(true);
        footnote.getMarkerCharacterFormat().setTextColor(new Color(0, 0, 139));

        document.saveToFile(output, FileFormat.Docx_2010);
    }
}
