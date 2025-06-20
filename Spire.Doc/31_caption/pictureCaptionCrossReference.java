import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;
import com.spire.doc.interfaces.*;

public class pictureCaptionCrossReference {
    public static void main(String[] args) {
        //Create word document
        Document document = new Document();

        //Create a new section
        Section section = document.addSection();

        //Add the first paragraph
        Paragraph firstPara = section.addParagraph();

        //Add the first picture
        Paragraph par1 = section.addParagraph();

        //Set the after-spacing
        par1.getFormat().setAfterSpacing(10);

        //Load a picture
        DocPicture pic1 = par1.appendPicture("data/spire.Doc.png");

        //Set the picture height
        pic1.setHeight(120);

        //Set the picture width
        pic1.setWidth(120);

        //Add caption to the picture
        CaptionNumberingFormat format = CaptionNumberingFormat.Number;
        IParagraph captionParagraph = pic1.addCaption("Figure", format, CaptionPosition.Below_Item);
        section.addParagraph();

        //Add the second picture
        Paragraph par2 = section.addParagraph();

        //Load a picture
        DocPicture pic2 = par2.appendPicture("data/word.png");

        //Set the picture height
        pic2.setHeight(120);

        //Set the picture width
        pic2.setWidth(120);
        //Add caption to the picture
        captionParagraph = pic2.addCaption("Figure", format, CaptionPosition.Below_Item);
        section.addParagraph();

        //Create a bookmark
        String bookmarkName = "Figure_2";

        //Add a paragraph
        Paragraph paragraph = section.addParagraph();

        //Append a bookmark
        paragraph.appendBookmarkStart(bookmarkName);
        paragraph.appendBookmarkEnd(bookmarkName);

        //Replace bookmark content
        BookmarksNavigator navigator = new BookmarksNavigator(document);
        navigator.moveToBookmark(bookmarkName);
        TextBodyPart part = navigator.getBookmarkContent();
        part.getBodyItems().clear();
        part.getBodyItems().add(captionParagraph);
        navigator.replaceBookmarkContent(part);

        //Create cross-reference field to point to bookmark "Figure_2"
        Field field = new Field(document);
        field.setType(FieldType.Field_Ref);
        field.setCode("REF Figure_2 \\p \\h");
        firstPara.getChildObjects().add(field);
        FieldMark fieldSeparator = new FieldMark(document, FieldMarkType.Field_Separator);
        firstPara.getChildObjects().add(fieldSeparator);

        //Set the display text of the field
        TextRange tr = new TextRange(document);
        tr.setText("Figure 2");
        firstPara.getChildObjects().add(tr);

        FieldMark fieldEnd = new FieldMark(document, FieldMarkType.Field_End);
        firstPara.getChildObjects().add(fieldEnd);

        //Update fields
        document.isUpdateFields(true);

        //Save the file
        String output = "output/pictureCaptionCrossReference.docx";
        document.saveToFile(output, FileFormat.Docx);

        //Dispose the document
        document.dispose();
    }
}
