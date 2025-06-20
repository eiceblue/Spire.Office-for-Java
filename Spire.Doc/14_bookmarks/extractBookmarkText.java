import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;
import java.io.*;

public class extractBookmarkText {
    public static void main(String[] args) throws IOException {
        // Set the input file path for the document containing bookmarks
        String input = "data/bookmarks.docx";

        // Set the output file path for the extracted bookmark text
        String output = "output/extractBookmarkText.txt";

        // Create a new instance of the Document class
        Document doc = new Document();

        // Load the document from the specified input file
        doc.loadFromFile(input);

        // Create a BookmarksNavigator for the document
        BookmarksNavigator navigator = new BookmarksNavigator(doc);

        // Move to the bookmark position named "Test2" in the document
        navigator.moveToBookmark("Test2");

        // Get the TextBodyPart containing the bookmark content
        TextBodyPart textBodyPart = navigator.getBookmarkContent();

        // Iterate through the body items of the TextBodyPart
        for (int i = 0; i < textBodyPart.getBodyItems().getCount(); i++) {
            // Check if the body item is a paragraph
            if (textBodyPart.getBodyItems().get(i) instanceof Paragraph) {
                // Cast the body item to a Paragraph
                Paragraph itemPara = (Paragraph)textBodyPart.getBodyItems().get(i);

                // Iterate through the child objects of the paragraph
                for (int j = 0; j < itemPara.getChildObjects().getCount(); j++) {
                    // Check if the child object is a TextRange
                    if (itemPara.getChildObjects().get(j) instanceof TextRange) {
                        // Cast the child object to a TextRange
                        TextRange textrange = (TextRange)(itemPara.getChildObjects().get(j));

                        // Get the text from the TextRange
                        String text = textrange.getText();

                        // Write the extracted text to the output file
                        writeStringToTxt(text, output);
                    }
                }
            }
        }

        // Dispose of the document object to release resources
        doc.dispose();
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
