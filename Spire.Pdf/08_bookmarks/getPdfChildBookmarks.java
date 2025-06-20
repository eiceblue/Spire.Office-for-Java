import com.spire.pdf.PdfDocument;
import com.spire.pdf.bookmarks.*;
import java.io.*;

public class getPdfChildBookmarks {
    public static void main(String[] args) throws IOException{
        // Create a new PdfDocument object
        PdfDocument doc = new PdfDocument();

        // Load an existing PDF document that contains bookmarks
        doc.loadFromFile("data/BookmarkSample.pdf");

        // Get the bookmarks collection from the document
        PdfBookmarkCollection bookmarks = doc.getBookmarks();

        // Specify the output file path for the child bookmark information
        String result = "output/getPdfChildBookmarks.txt";

        // Retrieve and write the child bookmarks to the text file
        GetChildBookmark(bookmarks, result);

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();

    }


  // This method retrieves child bookmarks from a PdfBookmarkCollection and writes them to a text file.
    private static void GetChildBookmark(PdfBookmarkCollection bookmarks, String result) throws IOException {
        // Create a StringBuilder object to store the bookmark information
        StringBuilder content = new StringBuilder();

        // Iterate through each bookmark in the collection
        for (int i = 0; i < bookmarks.getCount(); i++) {
            // Get the parent bookmark at the current index
            PdfBookmark parentBookmark = bookmarks.get(i);

            // Check if the parent bookmark has child bookmarks
            if (parentBookmark.getCount() > 0) {
                content.append("Child Bookmarks: " + "\r\n");
                // Iterate through each child bookmark of the parent bookmark
                for (int j = 0; j < parentBookmark.getCount(); j++) {
                    // Get the child bookmark at the current index
                    PdfBookmark childBookmark = parentBookmark.get(j);
                    // Append the title of the child bookmark to the content
                    content.append(childBookmark.getTitle()).append("\r\n");

                    // Get the text style of the child bookmark
                    String textStyle = childBookmark.getDisplayStyle().toString();
                    // Append the text style to the content
                    content.append(textStyle);
                }
            }
        }

        // Write the bookmark information stored in the StringBuilder to the specified text file
        writeStringToTxt(content.toString(), result);
    }

    // This method writes a string content to a text file.
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
