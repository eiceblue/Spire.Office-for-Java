import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.ShapeObject;
import java.awt.*;

public class insertWordArt {
    public static void main(String[] args) {
        String input="data/insertWordArt.docx";
        String output="output/insertWordArt.docx";

        //load Word document.
        Document doc = new Document();
        doc.loadFromFile(input);

        //add a paragraph.
        Paragraph paragraph = doc.getSections().get(0).addParagraph();

        //add a shape.
        ShapeObject shape = paragraph.appendShape(250, 70, ShapeType.Text_Wave_4);

        //set the position of the shape.
        shape.setVerticalPosition(20);
        shape.setHorizontalPosition(80);

        //set the text of WordArt.
        shape.getWordArt().setText("Thanks for reading.");

        //set the fill color.
        shape.setFillColor(Color.RED);

        //set the border color of the text.
        shape.setStrokeColor(Color.YELLOW);

        //save docx file.
        doc.saveToFile(output, FileFormat.Docx_2013);
    }
}
