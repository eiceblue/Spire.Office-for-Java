import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;
import com.spire.doc.interfaces.*;
import java.awt.*;

public class tableCaptionCrossReference {
    public static void main(String[] args) {
        //Create word document
        Document document = new Document();

        //Add a new section
        Section section = document.addSection();

        //Create a table
        Table table = section.addTable(true);

        //Set the number of rows and columns
        table.resetCells(2, 3);
        //Add caption to the table
        IParagraph captionParagraph = table.addCaption("Table", CaptionNumberingFormat.Number, CaptionPosition.Below_Item);

        //Create a bookmark
        String bookmarkName = "Table_1";

        //Add a paragraph
        Paragraph paragraph = section.addParagraph();

        //Append the bookmark
        paragraph.appendBookmarkStart(bookmarkName);
        paragraph.appendBookmarkEnd(bookmarkName);

        //Create a BookmarksNavigator
        BookmarksNavigator navigator = new BookmarksNavigator(document);

        //MOve the navigator to the bookmark
        navigator.moveToBookmark(bookmarkName);
        TextBodyPart part = navigator.getBookmarkContent();
        part.getBodyItems().clear();
        part.getBodyItems().add(captionParagraph);
        //Replace bookmark content
        navigator.replaceBookmarkContent(part);

        //Create cross-reference field to point to bookmark "Table_1"
        Field field = new Field(document);
        field.setType(FieldType.Field_Ref);
        field.setCode("REF Table_1 \\p \\h");

        //Insert line breaks
        for (int i = 0; i < 3; i++) {
            paragraph.appendBreak(BreakType.Line_Break);
        }

        //Insert field to paragraph
        paragraph = section.addParagraph();
        TextRange range = paragraph.appendText("This is a table caption cross-reference, ");
        range.getCharacterFormat().setFontSize(14);
        paragraph.getChildObjects().add(field);

        //Insert FieldSeparator object
        FieldMark fieldSeparator = new FieldMark(document, FieldMarkType.Field_Separator);
        paragraph.getChildObjects().add(fieldSeparator);

        //Set display text of the field
        TextRange tr = new TextRange(document);
        tr.setText("Table 1");
        tr.getCharacterFormat().setFontSize(14);
        tr.getCharacterFormat().setTextColor(Color.cyan);
        paragraph.getChildObjects().add(tr);

        //Insert FieldEnd object to mark the end of the field
        FieldMark fieldEnd = new FieldMark(document, FieldMarkType.Field_End);
        paragraph.getChildObjects().add(fieldEnd);

        //Update fields
        document.isUpdateFields(true);

        //Save the file
        String output = "output/tableCaptionCrossReference.docx";
        document.saveToFile(output, FileFormat.Docx);

        //Dispose the document
        document.dispose();
    }
}
