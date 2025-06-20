import com.spire.doc.*;
import com.spire.doc.documents.*;

public class copyBookmarkContent {
    public static void main(String[] args) {
        // Set the input file path for the document with a bookmark
        String input = "data/bookmark.docx";

        // Set the output file path for the document to be created
        String output = "output/copyBookmarkContent.docx";

        // Create a new instance of the Document class
        Document doc = new Document();

        // Load the document from the specified input file
        doc.loadFromFile(input);

        // Get the bookmark named "Test" from the document
        Bookmark bookmark = doc.getBookmarks().get("Test");

        // Declare a DocumentObject variable to store the parent object of the bookmark start/end
        DocumentObject docObj = null;

        // Check if the paragraph containing the bookmark is within a cell of a table
        // If it is within a cell, find the outermost parent object (Table) and get its start/end index on the document
        // body
        if (((Paragraph)bookmark.getBookmarkStart().getOwner()).isInCell()) {
            docObj = bookmark.getBookmarkStart().getOwner().getOwner().getOwner().getOwner();
        } else {
            docObj = bookmark.getBookmarkStart().getOwner();
        }

        // Get the start index of the parent object on the document body
        int startIndex = doc.getSections().get(0).getBody().getChildObjects().indexOf(docObj);

        // Check if the paragraph containing the bookmark end is within a cell of a table
        // If it is within a cell, find the outermost parent object (Table) and get its start/end index on the document
        // body
        if (((Paragraph)bookmark.getBookmarkEnd().getOwner()).isInCell()) {
            docObj = bookmark.getBookmarkEnd().getOwner().getOwner().getOwner().getOwner();
        } else {
            docObj = bookmark.getBookmarkEnd().getOwner();
        }

        // Get the end index of the parent object on the document body
        int endIndex = doc.getSections().get(0).getBody().getChildObjects().indexOf(docObj);

        // Get the paragraph containing the bookmark start and its index within the paragraph
        Paragraph para = (Paragraph)bookmark.getBookmarkStart().getOwner();
        int pStartIndex = para.getChildObjects().indexOf(bookmark.getBookmarkStart());

        // Get the paragraph containing the bookmark end and its index within the paragraph
        para = (Paragraph)bookmark.getBookmarkEnd().getOwner();
        int pEndIndex = para.getChildObjects().indexOf(bookmark.getBookmarkEnd());

        // Create a TextBodySelection based on the start and end indices of the parent object and paragraph indices
        TextBodySelection select =
            new TextBodySelection(doc.getSections().get(0).getBody(), startIndex, endIndex, pStartIndex, pEndIndex);

        // Create a TextBodyPart using the TextBodySelection
        TextBodyPart body = new TextBodyPart(select);

        // Iterate through the items in the TextBodyPart and add them to the document's body
        for (int i = 0; i < body.getBodyItems().getCount(); i++) {
            doc.getSections().get(0).getBody().getChildObjects().add(body.getBodyItems().get(i).deepClone());
        }

        // Save the modified document to the specified output file in DOCX format
        doc.saveToFile(output, FileFormat.Docx);

        // Dispose of the document object to release resources
        doc.dispose();
    }
}
