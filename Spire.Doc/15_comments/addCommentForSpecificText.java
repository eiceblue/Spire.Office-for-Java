import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;

public class addCommentForSpecificText {
    public static void main(String[] args) {
        // Create a new Document instance
        Document document = new Document();

        // Load the document from the specified input file
        document.loadFromFile("data/commentTemplate.docx");

        // Call the InsertComments method to insert comments in the document based on the provided keystring
        InsertComments(document, "Development");

        // Save the modified document to the specified output file in Docx format
        document.saveToFile("output/addCommentForTextRange.docx", FileFormat.Docx);

        // Dispose of the document resources
        document.dispose();
    }

    // Custom method to insert comments into the document
    private static void InsertComments(Document doc, String keystring) {
        // Find the text selection matching the keystring in the document
        TextSelection find = doc.findString(keystring, false, true);

        // Create a comment mark for the start of the comment
        CommentMark commentMarkStart = new CommentMark(doc, 1, CommentMarkType.Comment_Start);

        // Create a comment mark for the end of the comment
        CommentMark commentMarkEnd = new CommentMark(doc, 1, CommentMarkType.Comment_End);

        // Create a comment with the desired content and author
        Comment comment = new Comment(doc);
        comment.getBody().addParagraph().setText("Test comments");
        comment.getFormat().setAuthor("E-iceblue");

        // Get the text range as a single range
        TextRange range = find.getAsOneRange();

        // Get the owner paragraph of the text range
        Paragraph para = range.getOwnerParagraph();

        // Get the index of the text range in the child objects of the paragraph
        int index = para.getChildObjects().indexOf(range);

        // Add the comment as a child object of the paragraph
        para.getChildObjects().add(comment);

        // Insert the comment mark at the appropriate index in the paragraph's child objects
        para.getChildObjects().insert(index, commentMarkStart);
        para.getChildObjects().insert(index + 2, commentMarkEnd);
    }
}
