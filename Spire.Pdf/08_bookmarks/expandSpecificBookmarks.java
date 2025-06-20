import com.spire.pdf.*;
import com.spire.pdf.bookmarks.*;

public class expandSpecificBookmarks {
    public static void main(String[] args) {
         // Create a new PdfDocument object
        PdfDocument doc = new PdfDocument();
        
        //Load the file from disk.
        doc.loadFromFile("data/expandSpecificBookmarks.pdf");
        
        // Expand the first bookmark
        doc.getBookmarks().get(0).setExpandBookmark(true);
        
        //Set BookMarkExpandOrCollapse as "true" for the first bookmarks
        PdfBookmarkCollection pdfBookmark = doc.getBookmarks().get(1);
        
        //Set BookMarkExpandOrCollapse as "false" for the first level of the second bookmarks
        pdfBookmark.get(0).setExpandBookmark(false);

        String result = "output/expandSpecificBookmarks_out.pdf";
        
        //Save the document
        doc.saveToFile(result);

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }
}
