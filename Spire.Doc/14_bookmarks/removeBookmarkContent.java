import com.spire.doc.*;
import com.spire.doc.documents.*;

public class removeBookmarkContent {
    public static void main(String[] args) {
        // Define the input file path for the document to be processed
        String input = "data/bookmarks.docx";

        // Define the output file path for the modified document
        String output = "output/removeBookmarkContent.docx";

        // Create a new Document object
        Document document = new Document();

        // Load the document from the specified input file
        document.loadFromFile(input);

        // Get the bookmark named "Test2" from the document's bookmarks collection
        Bookmark bookmark = document.getBookmarks().get("Test2");

        // Get the Paragraph that contains the start position of the bookmark
        Paragraph para = (Paragraph)bookmark.getBookmarkStart().getOwner();

        // Determine the index of the bookmark start within its parent paragraph
        int startIndex = para.getChildObjects().indexOf(bookmark.getBookmarkStart());

        // Get the Paragraph that contains the end position of the bookmark
        para = (Paragraph)bookmark.getBookmarkEnd().getOwner();

        // Determine the index of the bookmark end within its parent paragraph
        int endIndex = para.getChildObjects().indexOf(bookmark.getBookmarkEnd());

        // Remove the content between the bookmark start and end positions
        for (int i = startIndex + 1; i < endIndex; i++) {
            para.getChildObjects().removeAt(startIndex + 1);
        }

        // Save the modified document to the specified output file in .docx format
        document.saveToFile(output, FileFormat.Docx);

        // Release system resources used by the Document object
        document.dispose();
    }
}
