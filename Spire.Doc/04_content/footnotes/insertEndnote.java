import com.spire.doc.*;
import com.spire.doc.documents.Paragraph;
import com.spire.doc.fields.*;
import java.awt.*;

public class insertEndnote {
    public static void main(String[] args) {
        String input = "data/insertEndnote.doc";
        String output = "output/insertEndnote.docx";

        //create a document and load file
        Document doc = new Document();
        doc.loadFromFile(input);
        Section s = doc.getSections().get(0);
        Paragraph p = s.getParagraphs().get(1);

        //add endnote
        Footnote endnote = p.appendFootnote(FootnoteType.Endnote);

        //append text
        TextRange text = endnote.getTextBody().addParagraph().appendText("Reference: Wikipedia");

        //set text format
        text.getCharacterFormat().setFontName("Impact");
        text.getCharacterFormat().setFontSize(14);
        text.getCharacterFormat().setTextColor(new Color(255, 140, 0) /*Color.getDarkOrange()*/);

        //set marker format of endnote
        endnote.getMarkerCharacterFormat().setFontName("Calibri");
        endnote.getMarkerCharacterFormat().setFontSize(20);
        endnote.getMarkerCharacterFormat().setTextColor(new Color(0, 0, 139)/*Color.getDarkBlue()*/);

        //save the document
        doc.saveToFile(output, FileFormat.Docx);
    }
}
