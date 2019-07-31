import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.TextRange;
import java.awt.*;

public class createBookmark {
    public static void main(String[] args) {
        String output = "output/createBookmark.docx";

        //create word document.
        Document document = new Document();

        //create a new section.
        Section section = document.addSection();

        //create bookmark
        createBookmarks(section);

        //save the document.
        document.saveToFile(output, FileFormat.Docx);
    }
    private static void createBookmarks(Section section) {
        Paragraph paragraph = section.addParagraph();
        TextRange txtRange = paragraph.appendText("The following example demonstrates how to create bookmark in a Word document.");
        txtRange.getCharacterFormat().setItalic(true);

        section.addParagraph();
        paragraph = section.addParagraph();
        txtRange = paragraph.appendText("Simple Create Bookmark.");
        txtRange.getCharacterFormat().setTextColor(new Color(100, 149, 237));
        paragraph.applyStyle(BuiltinStyle.Heading_2);

        //write simple CreateBookmarks.
        section.addParagraph();
        paragraph = section.addParagraph();
        paragraph.appendBookmarkStart("SimpleCreateBookmark");
        paragraph.appendText("This is a simple bookmark.");
        paragraph.appendBookmarkEnd("SimpleCreateBookmark");

        section.addParagraph();
        paragraph = section.addParagraph();
        txtRange = paragraph.appendText("Nested Create Bookmark..");
        txtRange.getCharacterFormat().setTextColor(new Color(100, 149, 237));
        paragraph.applyStyle(BuiltinStyle.Heading_2);

        //write nested CreateBookmarks.
        section.addParagraph();
        paragraph = section.addParagraph();
        paragraph.appendBookmarkStart("Root");
        txtRange = paragraph.appendText(" This is Root data. ");
        txtRange.getCharacterFormat().setItalic(true);
        paragraph.appendBookmarkStart("NestedLevel1");
        txtRange = paragraph.appendText(" This is Nested Level1. ");
        txtRange.getCharacterFormat().setItalic(true);
        txtRange.getCharacterFormat().setTextColor(new Color(40, 79, 79));
        paragraph.appendBookmarkStart("NestedLevel2");
        txtRange = paragraph.appendText(" This is Nested Level2. ");
        txtRange.getCharacterFormat().setItalic(true);
        txtRange.getCharacterFormat().setTextColor(new Color(105, 105, 105));
        paragraph.appendBookmarkEnd("NestedLevel2");
        paragraph.appendBookmarkEnd("NestedLevel1");
        paragraph.appendBookmarkEnd("Root");
    }
}
