import com.spire.pdf.PdfDocument;

public class deleteAllBookmarks {
    public static void main(String[] args) {
		// Create a new PdfDocument object
        PdfDocument doc = new PdfDocument();

        // Load an existing PDF document that contains bookmarks
        doc.loadFromFile("data/BookmarkSample.pdf");

        // Clear the bookmarks collection of the document
        doc.getBookmarks().clear();

        // Save the modified document without any bookmarks
        doc.saveToFile("output/deleteAllBookmarks.pdf");

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }
}
