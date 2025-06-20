import com.spire.pdf.PdfDocument;
import com.spire.pdf.bookmarks.*;
import com.spire.pdf.graphics.PdfRGBColor;
import java.awt.*;

public class updateBookmark {
    public static void main(String[] args) {
		// Create a new PdfDocument object
        PdfDocument doc = new PdfDocument();

        // Load the existing PDF document
        doc.loadFromFile("data/updateBookmark.pdf");

        // Get the first bookmark
        PdfBookmark bookmark = doc.getBookmarks().get(0);

        //Change the title of the bookmark
        bookmark.setTitle("Modified BookMark");

        //Set the color of the bookmark
        bookmark.setColor(new PdfRGBColor(Color.black));

        //Set the outline text style of the bookmark
        bookmark.setDisplayStyle(PdfTextStyle.Bold);

        //Edit child bookmarks of the parent bookmark
        editChildBookmark(bookmark);

        doc.saveToFile("output/updateBookmark.pdf");

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }

     // This method edits the child bookmarks of a given parent bookmark.
    static void editChildBookmark(PdfBookmark parentBookmark) {
        // Iterate through each child bookmark of the parent bookmark
        for (PdfBookmark childBookmark : (Iterable<PdfBookmark>) parentBookmark) {
            // Set the color of the child bookmark to blue
            childBookmark.setColor(new PdfRGBColor(Color.BLUE));
            // Set the display style of the child bookmark to regular
            childBookmark.setDisplayStyle(PdfTextStyle.Regular);
            // Recursively call the editChild2Bookmark method for the child bookmark
            editChild2Bookmark(childBookmark);
        }
    }

    // This method edits the second level child bookmarks of a given child bookmark.
    static void editChild2Bookmark(PdfBookmark childBookmark) {
        // Iterate through each second level child bookmark of the child bookmark
        for (PdfBookmark child2Bookmark : (Iterable<PdfBookmark>) childBookmark) {
            // Set the color of the second level child bookmark to "rgb(255,160,122)"
            child2Bookmark.setColor(new PdfRGBColor(new Color(255, 160, 122)));
            // Set the display style of the second level child bookmark to italic
            child2Bookmark.setDisplayStyle(PdfTextStyle.Italic);
        }
    }
}
