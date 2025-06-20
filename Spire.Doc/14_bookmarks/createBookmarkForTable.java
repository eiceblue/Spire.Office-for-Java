import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;

public class createBookmarkForTable {
    public static void main(String[] args) {
        // Set the output file path for the document with bookmarks for a table
        String output = "output/createBookmarkForTable.docx";

        // Create a new instance of the Document class
        Document document = new Document();

        // Add a section to the document
        Section section = document.addSection();

        // Call the createBookmarkForTable method to create bookmarks and add a table within the section
        createBookmarkForTable(document, section);

        // Save the document to the specified output file in DOCX format
        document.saveToFile(output, FileFormat.Docx);

        // Dispose of the document object to release resources
        document.dispose();
    }

    // Define the createBookmarkForTable method
    private static void createBookmarkForTable(Document doc, Section section) {
        // Add a paragraph to the section
        Paragraph paragraph = section.addParagraph();

        // Append text to the paragraph and set its formatting
        TextRange txtRange = paragraph
            .appendText("The following example demonstrates how to create bookmark for a table in a Word document.");
        txtRange.getCharacterFormat().setItalic(true);

        // Append bookmark start to the paragraph
        paragraph.appendBookmarkStart("CreateBookmark");

        // Append bookmark end to the paragraph
        paragraph.appendBookmarkEnd("CreateBookmark");

        // Add a table to the section
        Table table = section.addTable(true);

        // Reset the cells of the table to have 2 rows and 2 columns
        table.resetCells(2, 2);

        // Add text to the cells of the table
        TextRange range = table.getRows().get(0).getCells().get(0).addParagraph().appendText("sampleA");
        range = table.getRows().get(0).getCells().get(1).addParagraph().appendText("sampleB");
        range = table.getRows().get(1).getCells().get(0).addParagraph().appendText("120");
        range = table.getRows().get(1).getCells().get(1).addParagraph().appendText("260");

        // Get the first bookmark from the document
        Bookmark bookmark = doc.getBookmarks().get(0);

        // Get the name of the bookmark
        String bookmarkName = bookmark.getName();

        // Create a BookmarksNavigator for the document
        BookmarksNavigator navigator = new BookmarksNavigator(doc);

        // Move to the bookmark position in the document
        navigator.moveToBookmark(bookmarkName);

        // Get the TextBodyPart containing the bookmark content
        TextBodyPart part = navigator.getBookmarkContent();

        // Add the table to the BodyItems of the TextBodyPart
        part.getBodyItems().add(table);

        // Replace the bookmark content with the modified TextBodyPart
        navigator.replaceBookmarkContent(part);
    }
}
