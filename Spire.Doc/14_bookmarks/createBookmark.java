import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.TextRange;

import java.awt.*;

public class createBookmark {
    public static void main(String[] args) {
        // Set the output file path for the created document with bookmarks
        String output = "output/createBookmark.docx";

        // Create a new instance of the Document class
        Document document = new Document();

        // Add a section to the document
        Section section = document.addSection();

        // Call the createBookmarks method to create bookmarks within the section
        createBookmarks(section);

        // Save the document to the specified output file in DOCX format
        document.saveToFile(output, FileFormat.Docx);

        // Dispose of the document object to release resources
        document.dispose();
    }

    // Define the createBookmarks method
    private static void createBookmarks(Section section) {
        // Add a paragraph to the section
        Paragraph paragraph = section.addParagraph();

        // Append text to the paragraph and set its formatting
        TextRange txtRange =
                paragraph.appendText("The following example demonstrates how to create bookmark in a Word document.");
        txtRange.getCharacterFormat().setItalic(true);

        // Add an empty paragraph to the section
        section.addParagraph();

        // Add another paragraph to the section
        paragraph = section.addParagraph();

        // Append text to the paragraph and set its formatting
        txtRange = paragraph.appendText("Simple Create Bookmark.");
        txtRange.getCharacterFormat().setTextColor(new Color(100, 149, 237));

        // Apply a built-in heading style to the paragraph
        paragraph.applyStyle(BuiltinStyle.Heading_2);

        // Add an empty paragraph to the section
        section.addParagraph();

        // Add another paragraph to the section
        paragraph = section.addParagraph();

        // Append bookmark start and text to the paragraph
        paragraph.appendBookmarkStart("SimpleCreateBookmark");
        paragraph.appendText("This is a simple bookmark.");

        // Append bookmark end to the paragraph
        paragraph.appendBookmarkEnd("SimpleCreateBookmark");

        // Add an empty paragraph to the section
        section.addParagraph();

        // Add another paragraph to the section
        paragraph = section.addParagraph();

        // Append text to the paragraph and set its formatting
        txtRange = paragraph.appendText("Nested Create Bookmark..");
        txtRange.getCharacterFormat().setTextColor(new Color(100, 149, 237));

        // Apply a built-in heading style to the paragraph
        paragraph.applyStyle(BuiltinStyle.Heading_2);

        // Add an empty paragraph to the section
        section.addParagraph();

        // Add another paragraph to the section
        paragraph = section.addParagraph();

        // Append bookmark start and text to the paragraph
        paragraph.appendBookmarkStart("Root");
        txtRange = paragraph.appendText(" This is Root data. ");
        txtRange.getCharacterFormat().setItalic(true);

        // Append bookmark start and text to the paragraph
        paragraph.appendBookmarkStart("NestedLevel1");
        txtRange = paragraph.appendText(" This is Nested Level1. ");
        txtRange.getCharacterFormat().setItalic(true);
        txtRange.getCharacterFormat().setTextColor(new Color(40, 79, 79));

        // Append bookmark start and text to the paragraph
        paragraph.appendBookmarkStart("NestedLevel2");
        txtRange = paragraph.appendText(" This is Nested Level2. ");
        txtRange.getCharacterFormat().setItalic(true);
        txtRange.getCharacterFormat().setTextColor(new Color(105, 105, 105));

        // Append bookmark end to the paragraph
        paragraph.appendBookmarkEnd("NestedLevel2");

        // Append bookmark end to the paragraph
        paragraph.appendBookmarkEnd("NestedLevel1");

        // Append bookmark end to the paragraph
        paragraph.appendBookmarkEnd("Root");
    }
}
