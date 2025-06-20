import com.spire.doc.*;
import com.spire.doc.documents.*;
public class setTextDirection {
    public static void main(String[] args) {
        //Create a new document
        Document doc = new Document();

        //Add the first section
        Section section1 = doc.addSection();
        //Set text direction for all text in a section
        section1.setTextDirection( TextDirection.Right_To_Left);

        //Create a new ParagraphStyle
        ParagraphStyle style = new ParagraphStyle(doc);

        //Set the style name, font name and font size
        style.setName("FontStyle");
        style.getCharacterFormat().setFontName("Arial");
        style.getCharacterFormat().setFontSize(15);

        //Add the style to the document
        doc.getStyles().add(style);

        //Add two paragraphs and apply the font style
        Paragraph p = section1.addParagraph();
        p.appendText("Only Spire.Doc, no Microsoft Office automation");
        p.applyStyle(style.getName());
        p = section1.addParagraph();
        p.appendText("Convert file documents with high quality");
        p.applyStyle(style.getName());

        //Set text direction for a part of text

        //Add the second section
        Section section2 = doc.addSection();

        //Add a table
        Table table = section2.addTable();
        table.resetCells(1, 1);
        TableCell cell = table.getRows().get(0).getCells().get(0);
        table.getRows().get(0).setHeight(150);
        table.getRows().get(0).getCells().get(0).setWidth(10);

        //Set vertical text direction of table
        cell.getCellFormat().setTextDirection(TextDirection.Right_To_Left_Rotated);
        cell.addParagraph().appendText("This is vertical style");

        //Add a paragraph and set horizontal text direction
        p = section2.addParagraph();
        p.appendText("This is horizontal style");
        p.applyStyle(style.getName());

        //Save and launch document
        String output = "output/setTextDirection.docx";
        doc.saveToFile(output, FileFormat.Docx);

        //Dispose the document
        doc.dispose();
    }
}
