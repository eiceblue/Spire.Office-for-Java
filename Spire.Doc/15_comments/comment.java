
import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;

public class comment {
    public static void main(String[] args) {
        // Define the input file path for the document
        String input = "data/sample.docx";

        // Define the output file path for the document with inserted comments
        String output = "output/comment.docx";

        // Create a new Document instance
        Document document = new Document();

        // Load the document from the specified input file
        document.loadFromFile(input);

        // Call the InsertComments method to insert comments in the first section of the document
        InsertComments(document.getSections().get(0));

        // Save the modified document to the specified output file in Docx format
        document.saveToFile(output, FileFormat.Docx);

        // Dispose of the document resources
        document.dispose();
    }

    // Custom method to insert comments into a section
    private static void InsertComments(Section section) {
        // Get the second paragraph in the section
        Paragraph paragraph = section.getParagraphs().get(1);

        // Append a comment to the paragraph with the specified text
        Comment comment = paragraph.appendComment("Spire.Doc for java");

        // Set the author of the comment
        comment.getFormat().setAuthor("E-iceblue");

        // Set the initial of the comment
        comment.getFormat().setInitial("CM");
    }
}
