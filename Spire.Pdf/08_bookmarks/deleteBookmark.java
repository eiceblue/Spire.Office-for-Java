import com.spire.pdf.PdfDocument;

public class deleteBookmark {
    public static void main(String[] args) {
        // Create a new PdfDocument object
        PdfDocument doc = new PdfDocument();

        // Load an existing PDF document that contains bookmarks
        doc.loadFromFile("data/deleteBookmark.pdf");

        // Remove the bookmark at index 0 from the bookmarks collection of the document
        doc.getBookmarks().removeAt(0);

        // Save the modified document without the removed bookmark
        doc.saveToFile("output/deleteBookmark.pdf");

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }
}
