import com.spire.doc.*;

public class removeBookmark {
    public static void main(String[] args) {
        // Define the input file path for the document to be processed
        String input = "data/bookmarks.docx";

        // Define the output file path for the modified document
        String output = "output/removeBookmark.docx";

        // Create a new Document object
        Document document = new Document();

        // Load the document from the specified input file
        document.loadFromFile(input);

        // Get the bookmark named "Test2" from the document's bookmarks collection
        Bookmark bookmark = document.getBookmarks().get("Test2");

        // Remove the retrieved bookmark from the document's bookmarks collection
        document.getBookmarks().remove(bookmark);

        // Save the modified document to the specified output file in .docx format
        document.saveToFile(output, FileFormat.Docx);

        // Release system resources used by the Document object
        document.dispose();
    }
}
