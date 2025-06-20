import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;
import java.awt.*;

public class insertFootnote {
    public static void main(String[] args) {
        // Create a Document object
        Document document = new Document();

        // Load a Word document
        document.loadFromFile("data/insertFootnote.docx");

        // Find the text "Spire.Doc" in the document
        TextSelection selection = document.findString("Spire.Doc", false, true);

        // Get the TextRange
        TextRange textRange = selection.getAsOneRange();

        // Get the owner paragraph
        Paragraph paragraph = textRange.getOwnerParagraph();

        // Get the index of the  paragraph
        int index = paragraph.getChildObjects().indexOf(textRange);

        // Append a footnote to the paragraph
        Footnote footnote = paragraph.appendFootnote(FootnoteType.Footnote);

        // Insert the footnote
        paragraph.getChildObjects().insert(index + 1, footnote);

        // Add text to the body of the footnote
        textRange = footnote.getTextBody().addParagraph().appendText("Welcome to evaluate Spire.Doc");

        // Set the format of the text in the footnote
        textRange.getCharacterFormat().setFontName("Arial Black");
        textRange.getCharacterFormat().setFontSize(10);
        textRange.getCharacterFormat().setTextColor(new Color(255, 140, 0));

        // Set the format of the footnote marker
        footnote.getMarkerCharacterFormat().setFontName("Calibri");
        footnote.getMarkerCharacterFormat().setFontSize(12);
        footnote.getMarkerCharacterFormat().setBold(true);
        footnote.getMarkerCharacterFormat().setTextColor(new Color(0, 0, 139));

        // Save the modified document
        String output = "output/insertFootnote.docx";
        document.saveToFile(output, FileFormat.Docx_2010);

        // Dispose of the document
        document.dispose();
    }
}
