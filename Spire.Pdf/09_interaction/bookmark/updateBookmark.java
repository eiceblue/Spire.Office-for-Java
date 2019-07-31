import com.spire.pdf.PdfDocument;
import com.spire.pdf.bookmarks.*;
import com.spire.pdf.graphics.PdfRGBColor;
import java.awt.*;

public class updateBookmark {
    public static void main(String[] args) {
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile("data/updateBookmark.pdf");

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
        doc.close();
    }

    static void editChildBookmark(PdfBookmark parentBookmark) {
        for (PdfBookmark childBookmark : (Iterable<PdfBookmark>) parentBookmark) {
            childBookmark.setColor(new PdfRGBColor(Color.BLUE));
            childBookmark.setDisplayStyle(PdfTextStyle.Regular);
            editChild2Bookmark(childBookmark);
        }
    }
    static void editChild2Bookmark(PdfBookmark childBookmark) {
        for (PdfBookmark child2Bookmark : (Iterable<PdfBookmark>) childBookmark) {
            child2Bookmark.setColor(new PdfRGBColor(new Color(255,160,122)) );
            child2Bookmark.setDisplayStyle(PdfTextStyle.Italic);
        }
    }
}
