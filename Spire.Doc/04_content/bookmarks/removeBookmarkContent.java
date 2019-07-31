import com.spire.doc.*;
import com.spire.doc.documents.Paragraph;

public class removeBookmarkContent {
    public static void main(String[] args) {
        String input = "data/bookmark.docx";
        String output = "output/removeBookmarkContent.docx";

        //load the document from disk.
        Document document = new Document();
        document.loadFromFile(input);

        //get the bookmark by name.
        Bookmark bookmark = document.getBookmarks().get("Test");

        Paragraph para = (Paragraph) bookmark.getBookmarkStart().getOwner();
        int startIndex = para.getChildObjects().indexOf(bookmark.getBookmarkStart());
        para = (Paragraph) bookmark.getBookmarkEnd().getOwner();
        int endIndex = para.getChildObjects().indexOf(bookmark.getBookmarkEnd());

        //remove the content object, and start from next one of BookmarkStart object, end up with previous one of BookmarkEnd object.
        //this method is only to remove the content of the bookmark.
        for (int i = startIndex + 1; i < endIndex; i++) {
            para.getChildObjects().removeAt(startIndex + 1);
        }

        //save the document
        document.saveToFile(output, FileFormat.Docx);
    }
}
