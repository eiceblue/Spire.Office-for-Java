
import com.spire.pdf.PdfDocument;
import com.spire.pdf.bookmarks.*;

public class getBookmarkPageNumber {
    public static void main(String[] args) {
        // Create a new PdfDocument object
        PdfDocument doc = new PdfDocument();

        // Load an existing PDF document that contains bookmarks
        doc.loadFromFile("data/BookmarkSample.pdf");

        // Get Bookmar Collection
        PdfBookmarkCollection bookmarks = doc.getBookmarks();

        // Get the first bookmark
        PdfBookmark bookmark = bookmarks.get(0);

        // Obtain the page of bookmark
        int pageNumber = doc.getPages().indexOf(bookmark.getDestination().getPage())+1;

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }
}
