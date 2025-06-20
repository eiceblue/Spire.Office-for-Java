import com.spire.doc.Document;
import com.spire.doc.FileFormat;
import com.spire.doc.LineDashing;
import com.spire.doc.Section;
import com.spire.doc.documents.HorizontalOrigin;
import com.spire.doc.documents.Paragraph;
import com.spire.doc.documents.TextBoxLineStyle;
import com.spire.doc.documents.VerticalOrigin;
import com.spire.doc.fields.TextBox;
import com.spire.doc.fields.TextRange;
import java.awt.*;

public class textBoxFormat {
    public static void main(String[] args) {
        // Create a new Document object
        Document doc = new Document();

        // Add a new Section to the Document
        Section sec = doc.addSection();

        // Create a new TextBox object and append it to the Section
        TextBox TB = sec.addParagraph().appendTextBox(310, 90);

        // Add a new Paragraph to the TextBox
        Paragraph para = TB.getBody().addParagraph();

        // Append some text to the Paragraph
        TextRange TR = para.appendText("Using Spire.Doc, developers will find " + "a simple and effective method to endow their applications with rich MS Word features. ");

        // Set the font name and size for the text
        TR.getCharacterFormat().setFontName("Cambria ");
        TR.getCharacterFormat().setFontSize(13);

        // Set the position and size of the TextBox on the page
        TB.getFormat().setHorizontalOrigin(HorizontalOrigin.Page);
        TB.getFormat().setHorizontalPosition(120);
        TB.getFormat().setVerticalOrigin(VerticalOrigin.Page);
        TB.getFormat().setVerticalPosition(100);

        // Set the style of the TextBox border
        TB.getFormat().setLineStyle(TextBoxLineStyle.Double);
        TB.getFormat().setLineColor(Color.BLUE);
        TB.getFormat().setLineDashing(LineDashing.Solid);
        TB.getFormat().setLineWidth(5);

        // Set the internal margins of the TextBox
        TB.getFormat().getInternalMargin().setTop(15);
        TB.getFormat().getInternalMargin().setBottom(10);
        TB.getFormat().getInternalMargin().setLeft(12);
        TB.getFormat().getInternalMargin().setRight(10);

        // Save the Document to a file
        String output = "output/textBoxFormat.docx";
        doc.saveToFile(output, FileFormat.Docx_2013);

        // Dispose of the Document object
        doc.dispose();
    }
}
