import com.spire.pdf.*;
import com.spire.pdf.bookmarks.*;
import com.spire.pdf.general.*;

public class setInheritZoomForBookmarks {
    public static void main(String[] args) {
        // Specify the input and output file paths
        String inputFile = "data/SetInheritZoomForBookmarks.pdf";
        String outputFile = "output/output.pdf";

        // Create a new PdfDocument object
        PdfDocument pdf = new PdfDocument();

        // Load the existing PDF document
        pdf.loadFromFile(inputFile);

        // Get the bookmarks collection from the document
        PdfBookmarkCollection bookmarks = pdf.getBookmarks();

        // Iterate through each bookmark in the collection
        for (int i = 0; i < bookmarks.getCount(); i++) {
            // Get the bookmark at the current index
            PdfBookmark bookmark = bookmarks.get(i);
            // Set the inherit zoom for the bookmark and its child bookmarks
            SetBookmarkAction(bookmark);
        }

        // Save the modified document to a new file
        pdf.saveToFile(outputFile, FileFormat.PDF);

        // Close the PDF document to release resources
        pdf.close();

        // Dispose of the PDF document to free up system resources
        pdf.dispose();
    }

    // This method sets the bookmark action for a given PdfBookmark and its child bookmarks recursively.
    private static void SetBookmarkAction(PdfBookmark bookmark) {
        // Get the destination of the bookmark
        PdfDestination dest = bookmark.getDestination();
        // Set the mode of the destination to Location
        dest.setMode(PdfDestinationMode.Location);
        // Set the zoom level of the destination to 0
        dest.setZoom(0);

        // Iterate through each child bookmark
        for (int i = 0; i < bookmark.getCount(); i++) {
            // Get the child bookmark at the current index
            PdfBookmark childbookmark = bookmark.get(i);
            // Recursively call the SetBookmarkAction method for the child bookmark
            SetBookmarkAction(childbookmark);
        }
    }

}
