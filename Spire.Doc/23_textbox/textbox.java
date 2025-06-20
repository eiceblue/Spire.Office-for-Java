import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;
import java.awt.*;

public class textbox {
    public static void main(String[] args) {
        // Create a new Document object
        Document document = new Document();

        // Add a section to the document
        Section section = document.addSection();

        // Call the insertTextbox method to insert textboxes into the section
        insertTextbox(section);

        // Specify the output file path
        String output = "output/textbox.docx";

        // Save the document to the specified file path with the Docx_2013 format
        document.saveToFile(output, FileFormat.Docx_2013);

        // Dispose the document
        document.dispose();
    }

    public static void insertTextbox(Section section) {
        // Add empty paragraphs to create space
        section.addParagraph();
        Paragraph paragraph = section.addParagraph();

        // Insert TextBox1 with specific formatting
        TextBox textBox1 = paragraph.appendTextBox(240, 35);
        textBox1.getFormat().setHorizontalAlignment(ShapeHorizontalAlignment.Left);
        textBox1.getFormat().setLineColor(Color.GRAY);
        textBox1.getFormat().setLineStyle(TextBoxLineStyle.Simple);
        textBox1.getFormat().setFillColor(Color.GREEN);

        // Add a paragraph inside TextBox1 and set its text content and formatting
        Paragraph para = textBox1.getBody().addParagraph();
        TextRange txtrg = para.appendText("Textbox 1 in the document");
        txtrg.getCharacterFormat().setFontName("Lucida Sans Unicode");
        txtrg.getCharacterFormat().setFontSize(14);
        txtrg.getCharacterFormat().setTextColor(Color.white);
        para.getFormat().setHorizontalAlignment(HorizontalAlignment.Center);

        // Add more empty paragraphs for spacing
        section.addParagraph();
        section.addParagraph();
        section.addParagraph();
        paragraph = section.addParagraph();

        // Insert TextBox2 with specific formatting
        TextBox textBox2 = paragraph.appendTextBox(240, 35);
        textBox2.getFormat().setHorizontalAlignment(ShapeHorizontalAlignment.Left);
        textBox2.getFormat().setLineColor(Color.red);
        textBox2.getFormat().setLineStyle(TextBoxLineStyle.Thick_Thin);
        textBox2.getFormat().setFillColor(Color.blue);
        textBox2.getFormat().setLineDashing(LineDashing.Dot);

        // Add a paragraph inside TextBox2 and set its text content and formatting
        para = textBox2.getBody().addParagraph();
        txtrg = para.appendText("Textbox 2 in the document");
        txtrg.getCharacterFormat().setFontName("Lucida Sans Unicode");
        txtrg.getCharacterFormat().setFontSize(14);
        txtrg.getCharacterFormat().setTextColor(Color.pink);
        para.getFormat().setHorizontalAlignment(HorizontalAlignment.Center);

        // Add more empty paragraphs for spacing
        section.addParagraph();
        section.addParagraph();
        section.addParagraph();
        paragraph = section.addParagraph();

        // Insert TextBox3 with specific formatting
        TextBox textBox3 = paragraph.appendTextBox(240, 35);
        textBox3.getFormat().setHorizontalAlignment(ShapeHorizontalAlignment.Left);
        textBox3.getFormat().setLineColor(Color.MAGENTA);
        textBox3.getFormat().setLineStyle(TextBoxLineStyle.Triple);
        textBox3.getFormat().setFillColor(Color.pink);
        textBox3.getFormat().setLineDashing(LineDashing.Dash_Dot_Dot);

        // Add a paragraph inside TextBox3 and set its text content and formatting
        para = textBox3.getBody().addParagraph();
        txtrg = para.appendText("Textbox 3 in the document");
        txtrg.getCharacterFormat().setFontName("Lucida Sans Unicode");
        txtrg.getCharacterFormat().setFontSize(14);
        txtrg.getCharacterFormat().setTextColor(Color.red);
        para.getFormat().setHorizontalAlignment(HorizontalAlignment.Center);
    }
}
