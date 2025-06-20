import com.spire.doc.*;
import com.spire.doc.documents.*;

public class replaceBookmarkContent {
    public static void main(String[] args) {
        // Define the input file path for the document to be loaded
        String input = "data/bookmarks.docx";

        // Define the output file path for the document with replaced bookmark content
        String output = "output/replaceBookmarkContent.docx";

        // Create a new Document instance
        Document doc = new Document();

        // Load the document from the specified input file
        doc.loadFromFile(input);

        // Create a BookmarksNavigator instance using the loaded document
        BookmarksNavigator bookmarkNavigator = new BookmarksNavigator(doc);

        // Move the navigator to the bookmark named "Test2"
        bookmarkNavigator.moveToBookmark("Test2");

        // Replace the content of the bookmark with the specified replacement content
        bookmarkNavigator.replaceBookmarkContent("This is replaced content.", false);

        // Save the modified document to the specified output file in Docx format
        doc.saveToFile(output, FileFormat.Docx);

        // Dispose of the document resources
        doc.dispose();
    }
}
