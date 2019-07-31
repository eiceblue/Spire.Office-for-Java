import com.spire.doc.*;

public class removeBookmark {
    public static void main(String[] args) {
        String input = "data/bookmark.docx";
        String output = "output/removeBookmark.docx";

        //load the document from disk.
        Document document = new Document();
        document.loadFromFile(input);

        //get the bookmark by name.
        Bookmark bookmark = document.getBookmarks().get("Test");

        //remove the bookmark, not its content.
        document.getBookmarks().remove(bookmark);

        //save the document.
        document.saveToFile(output, FileFormat.Docx);
    }
}
