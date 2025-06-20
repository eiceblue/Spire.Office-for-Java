import com.spire.doc.*;
import com.spire.doc.collections.BookmarkCollection;
import java.io.FileWriter;
import java.io.IOException;

public class getNonHiddenBookmarks {
    public static void main(String[] args) throws IOException {
        // Set the input file path for the document containing bookmarks
        String input = "data/HasHiddenBk.docx";

        // Set the output file path for the extracted bookmark names
        String output = "output/HasHiddenBk_out.txt";

        // Create a new instance of the Document class
        com.spire.doc.Document doc = new com.spire.doc.Document();

        // Load the document
        doc.loadFromFile(input);

        // Retrieve all bookmark collections
        BookmarkCollection collection = doc.getBookmarks();

        // Initialize an empty string to store the extracted text
        String text = "";

        // Get bookmark name
        if (collection != null && collection.getCount() > 0)
        {
            for (Object object : collection)
            {
                Bookmark bookmark = (Bookmark) object;
                String name = bookmark.getName();
                if(!bookmark.isHidden())
                {
                    text += String.format("The bookmark name is : " + name +"\n");
                }
                else
                {
                    text += String.format("The hidden bookmark name is : " + name +"\n");
                }

            }
        }
        // Write the result string to the output file
        writeStringToTxt(text, output);

        // Dispose of the document object to release resources
        document.dispose();
    }

    // Define the writeStringToTxt method to write content to a text file
    public static void writeStringToTxt(String content, String txtFileName) throws IOException {
        // Create a FileWriter object to write to the text file in append mode
        FileWriter fWriter = new FileWriter(txtFileName, true);

        try {
            // Write the content to the text file
            fWriter.write(content);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                // Flush and close the FileWriter
                fWriter.flush();
                fWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
