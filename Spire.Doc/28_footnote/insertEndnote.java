import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;
import java.awt.*;

public class insertEndnote {
    public static void main(String[] args) {
        // Create a Document object
        Document doc = new Document();

        // Load a Word document
        doc.loadFromFile("data/insertEndnote.doc");

        // Get the first section from the document
        Section s = doc.getSections().get(0);

        // Get the second paragraph from the section
        Paragraph p = s.getParagraphs().get(1);

        // Add an endnote to the paragraph
        Footnote endnote = p.appendFootnote(FootnoteType.Endnote);

        // Append text to the endnote's text body
        TextRange text = endnote.getTextBody().addParagraph().appendText("Reference: Wikipedia");

        // Set the format of the text in the endnote
        text.getCharacterFormat().setFontName("Impact");
        text.getCharacterFormat().setFontSize(14);
        text.getCharacterFormat().setTextColor(new Color(255, 140, 0));

        // Set the marker format of the endnote
        endnote.getMarkerCharacterFormat().setFontName("Calibri");
        endnote.getMarkerCharacterFormat().setFontSize(20);
        endnote.getMarkerCharacterFormat().setTextColor(new Color(0, 0, 139));

        // Save the modified document
        String output = "output/insertEndnote.docx";
        doc.saveToFile(output, FileFormat.Docx);

        // Dispose the document
        doc.dispose();
    }
}
