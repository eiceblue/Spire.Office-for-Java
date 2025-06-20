import com.spire.pdf.*;
import com.spire.pdf.bookmarks.*;
import java.io.*;

public class getAllPdfBookmarks {
    public static void main(String[] args) throws IOException{
		// Create a new PdfDocument object
        PdfDocument doc = new PdfDocument();

        // Load an existing PDF document that contains bookmarks
        doc.loadFromFile("data/BookmarkSample.pdf");

        // Get the bookmarks collection from the document
        PdfBookmarkCollection bookmarks = doc.getBookmarks();

        // Specify the output file path for the bookmark information
        String result = "output/getAllPdfBookmarks.txt";

        // Retrieve and write the bookmarks to the text file
        GetBookmarks(bookmarks, result);

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();

    }

      private static void GetBookmarks(PdfBookmarkCollection bookmarks, String result) throws IOException {
        // Create a StringBuilder object to store the bookmark information
        StringBuilder content = new StringBuilder();

        // Check if the bookmarks collection is not empty
        if (bookmarks.getCount() > 0) {
            content.append("Pdf bookmarks:");
            // Iterate through each bookmark in the collection
            for (int i = 0; i < bookmarks.getCount(); i++) {
                // Get the parent bookmark at the current index
                PdfBookmark parentBookmark = bookmarks.get(i);
                // Append the title of the parent bookmark to the content
                content.append(parentBookmark.getTitle()).append("\r\n");

                // Get the text style of the parent bookmark
                String textStyle = parentBookmark.getDisplayStyle().toString();
                // Append the text style to the content
                content.append(textStyle).append("\r\n");

                // Recursively process child bookmarks of the parent bookmark
                GetChildBookmark(parentBookmark, content);
            }
        }

        // Write the bookmark information stored in the StringBuilder to the specified text file
        writeStringToTxt(content.toString(),result);
    }

    private static void GetChildBookmark(PdfBookmark parentBookmark, StringBuilder content) {
        // Check if the parent bookmark has child bookmarks
        if (parentBookmark.getCount() > 0) {
            content.append("Pdf bookmarks:" + "\r\n");
            // Iterate through each child bookmark of the parent bookmark
            for (int i = 0; i < parentBookmark.getCount(); i++) {
                // Get the child bookmark at the current index
                PdfBookmark childBookmark = parentBookmark.get(i);
                // Append the title of the child bookmark to the content
                content.append(childBookmark.getTitle()).append("\r\n");

                // Get the text style of the child bookmark
                String textStyle = childBookmark.getDisplayStyle().toString();
                // Append the text style to the content
                content.append(textStyle).append("\r\n");

                // Recursively process child bookmarks of the child bookmark
                GetChildBookmark(childBookmark, content);
            }
        }
    }

    public static void writeStringToTxt(String content, String txtFileName) throws IOException {
        // Create a FileWriter object with the specified file name, in append mode
        FileWriter fWriter = new FileWriter(txtFileName, true);
        try {
            // Write the content to the text file
            fWriter.write(content);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                // Flush the writer to ensure all data is written
                fWriter.flush();
                // Close the writer to release resources
                fWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
