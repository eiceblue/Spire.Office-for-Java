
import com.spire.pdf.*;
import com.spire.pdf.bookmarks.*;

public class setInheritZoom {
    public static void main(String[] args) {
        // Create a new PdfDocument object
        PdfDocument doc = new PdfDocument();

        // Load an existing PDF document that contains bookmarks
        doc.loadFromFile("data/BookmarkSample.pdf");

        // Get the bookmarks collection from the document
        PdfBookmarkCollection bookmarks = doc.getBookmarks();

        // Iterate through each bookmark in the collection
        for (int i = 0; i < bookmarks.getCount(); i++) {
            // Get the bookmark at the current index
            PdfBookmark bookmark = bookmarks.get(i);
            // Set the zoom level of the bookmark's destination to 0.5
            bookmark.getDestination().setZoom(0.5f);
        }

        // Save the modified document to a new file
        doc.saveToFile("output/SetInheritZoom_out.pdf");

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();

    }
}
