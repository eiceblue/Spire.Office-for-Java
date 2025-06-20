
import com.spire.pdf.PdfDocument;

public class expandBookmarks {
    public static void main(String[] args) {
		// Create a new PdfDocument object
        PdfDocument doc = new PdfDocument();

        // Load an existing PDF document that contains bookmarks
        doc.loadFromFile("data/BookmarkSample.pdf");

        // Set the viewer preferences to expand bookmarks
        doc.getViewerPreferences().setBookMarkExpandOrCollapse(true);

        // Save the modified document with expanded bookmarks
        doc.saveToFile("output/expandBookmarks.pdf");

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }
}
