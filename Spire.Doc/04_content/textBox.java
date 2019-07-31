import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;
import java.awt.*;

public class textBox {
    public static void main(String[] args) throws Exception {

        String outputFile="output/textBox.docx";

        //create a Word document and add a section.
        Document document = new Document();
        Section section = document.addSection();

        insertTextbox(section);

        //save to file
        document.saveToFile(outputFile, FileFormat.Docx);
    }
    private static void insertTextbox(Section section) throws Exception{
        Paragraph paragraph = section.getParagraphs().getCount() > 0 ? section.getParagraphs().get(0) : section.addParagraph();
        paragraph = section.addParagraph();
        paragraph = section.addParagraph();
        //insert and format the first textbox.
        TextBox textBox1 = paragraph.appendTextBox(240, 35);
        textBox1.getFormat().setHorizontalAlignment(ShapeHorizontalAlignment.Left);

        textBox1.getFormat().setLineColor(Color.GRAY);
        textBox1.getFormat().setLineStyle(TextBoxLineStyle.Simple);
        textBox1.getFormat().setFillColor(Color.ORANGE);
        Paragraph para = textBox1.getBody().addParagraph();
        TextRange txtrg = para.appendText("Textbox 1 in the document");
        txtrg.getCharacterFormat().setFontName("Lucida Sans Unicode");
        txtrg.getCharacterFormat().setFontSize(14);
        txtrg.getCharacterFormat().setTextColor(Color.WHITE);
        para.getFormat().setHorizontalAlignment(HorizontalAlignment.Center);

        //insert and format the second textbox.
        paragraph = section.addParagraph();
        paragraph = section.addParagraph();
        paragraph = section.addParagraph();
        paragraph = section.addParagraph();
        TextBox textBox2 = paragraph.appendTextBox(240, 35);
        textBox2.getFormat().setHorizontalAlignment(ShapeHorizontalAlignment.Left);
        textBox2.getFormat().setLineColor(new Color(240,135,152));
        textBox2.getFormat().setLineStyle(TextBoxLineStyle.Thin_Thick);
        textBox2.getFormat().setFillColor(Color.green);
        textBox2.getFormat().setLineDashing(LineDashing.Dot);
        para = textBox2.getBody().addParagraph();
        txtrg = para.appendText("Textbox 2 in the document");
        txtrg.getCharacterFormat().setFontName("Lucida Sans Unicode");
        txtrg.getCharacterFormat().setFontSize(14);
        txtrg.getCharacterFormat().setTextColor(Color.PINK);
        para.getFormat().setHorizontalAlignment(HorizontalAlignment.Center);

        //insert and format the third textbox.
        paragraph = section.addParagraph();
        paragraph = section.addParagraph();
        paragraph = section.addParagraph();
        paragraph = section.addParagraph();
        TextBox textBox3 = paragraph.appendTextBox(240, 35);
        textBox3.getFormat().setHorizontalAlignment(ShapeHorizontalAlignment.Left);
        textBox3.getFormat().setLineColor(new Color(240,135,152));
        textBox3.getFormat().setLineStyle(TextBoxLineStyle.Triple);
        textBox3.getFormat().setFillColor(Color.lightGray);
        textBox3.getFormat().setLineDashing(LineDashing.Dash_Dot_Dot);
        para = textBox3.getBody().addParagraph();
        txtrg = para.appendText("Textbox 3 in the document");
        txtrg.getCharacterFormat().setFontName("Lucida Sans Unicode");
        txtrg.getCharacterFormat().setFontSize(14);
        txtrg.getCharacterFormat().setTextColor(new Color(240,135,152));
        para.getFormat().setHorizontalAlignment(HorizontalAlignment.Center);
    }
}
