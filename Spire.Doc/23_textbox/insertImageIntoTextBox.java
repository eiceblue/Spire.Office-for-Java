import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;

public class insertImageIntoTextBox {
    public static void main(String[] args) {
        // Create a new Word document
        Document doc = new Document();

        // Add a new section to the document
        Section section = doc.addSection();

        // Add a new paragraph to the section
        Paragraph paragraph = section.addParagraph();

        // Create a new text box within the paragraph
        TextBox tb = paragraph.appendTextBox(220, 220);

        // Set the horizontal and vertical position of the text box to the center of the page
        tb.getFormat().setHorizontalOrigin(HorizontalOrigin.Page);
        tb.getFormat().setHorizontalPosition(50);
        tb.getFormat().setVerticalOrigin(VerticalOrigin.Page);
        tb.getFormat().setVerticalPosition(50);

        //Set the fill effect of textbox as picture
        tb.getFormat().getFillEffects().setType(BackgroundType.Picture);

        //Fill the textbox with a picture
        tb.getFormat().getFillEffects().setPicture("data/spire.Doc.png");

        //Save the document
        String output = "output/insertImageIntoTextBox.docx";
        doc.saveToFile(output, FileFormat.Docx);

        // Dispose the document
        doc.dispose();
    }
}
