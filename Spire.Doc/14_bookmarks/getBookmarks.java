import com.spire.doc.*;
import java.io.*;

public class getBookmarks {
    public static void main(String[] args) throws IOException {
        // Set the input file path for the document containing bookmarks
        String input = "data/bookmarks.docx";

        // Set the output file path for the extracted bookmark names
        String output = "output/getBookmarks.txt";

        // Create a new instance of the Document class
        Document document = new Document();

        // Load the document from the specified input file
        document.loadFromFile(input);

        // Get the first bookmark in the document by index
        Bookmark bookmark1 = document.getBookmarks().get(0);

        // Get the bookmark named "Test2" from the document
        Bookmark bookmark2 = document.getBookmarks().get("Test2");

        // Format the result string with the obtained bookmark names
        String result = String.format("The bookmark obtained by index is " + bookmark1.getName()
            + ".\r\nThe bookmark obtained by name is " + bookmark2.getName() + ".\n");

        // Write the result string to the output file
        writeStringToTxt(result, output);

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
