import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;
import java.io.*;

public class extractComment {
    public static void main(String[] args) throws IOException {
        // Define the input file path for the document
        String input = "data/commentSample.docx";

        // Define the output file path for the extracted comments
        String output = "output/extractComment.txt";

        // Create a new Document instance
        Document doc = new Document();

        // Load the document from the specified input file
        doc.loadFromFile(input);

        // Iterate over each comment in the document
        for (int i = 0; i < doc.getComments().getCount(); i++) {
            // Get the comment at the current index
            Comment comment = doc.getComments().get(i);

            // Iterate over each paragraph in the comment's body
            for (int j = 0; j < comment.getBody().getParagraphs().getCount(); j++) {
                // Get the paragraph at the current index
                Paragraph para = comment.getBody().getParagraphs().get(j);

                // Get the text of the paragraph and append a line break
                String result = para.getText() + "\r\n";

                // Write the extracted comment to the output text file
                writeStringToTxt(result, output);
            }
        }

        // Dispose of the document resources
        doc.dispose();
    }

    // Custom method to write a string to a text file
    public static void writeStringToTxt(String content, String txtFileName) throws IOException {
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
