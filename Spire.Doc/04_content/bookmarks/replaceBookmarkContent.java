import com.spire.doc.*;
import com.spire.doc.documents.BookmarksNavigator;

public class replaceBookmarkContent {
    public static void main(String[] args) {
        String input = "data/bookmark.docx";
        String output = "output/replaceBookmarkContent.docx";

        //load the document from disk.
        Document doc = new Document();
        doc.loadFromFile(input);

        //locate the bookmark.
        BookmarksNavigator bookmarkNavigator = new BookmarksNavigator(doc);
        bookmarkNavigator.moveToBookmark("Test");

        //replace the context with new.
        bookmarkNavigator.replaceBookmarkContent("This is replaced content.",false);

        //save the document.
        doc.saveToFile(output, FileFormat.Docx);
    }
}
