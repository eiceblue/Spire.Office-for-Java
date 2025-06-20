import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;

public class fromCommentRange {
    public static void main(String[] args) {
        //Create a source document
        Document sourceDoc = new Document();

        // Load the document from disk.
        sourceDoc.loadFromFile("data/Comments.docx");

        //Create a destination document
        Document destinationDoc = new Document();

        //Add section for destination document
        Section destinationSec = destinationDoc.addSection();

        //Get the first comment
        Comment comment = sourceDoc.getComments().get(0);

        //Get the paragraph of obtained comment
        Paragraph para = comment.getOwnerParagraph();

        //Get index of the CommentMarkStart
        int startIndex = para.getChildObjects().indexOf(comment.getCommentMarkStart());

        //Get index of the CommentMarkEnd
        int endIndex = para.getChildObjects().indexOf(comment.getCommentMarkEnd());

        // Traverse paragraph ChildObjects
        for (int i = startIndex; (i <= endIndex); i++) {
            // Clone the ChildObjects of source document
            DocumentObject doobj = para.getChildObjects().get(i).deepClone();

            // Add to destination document
            destinationSec.addParagraph().getChildObjects().add(doobj);
        }

        // Save the destination document
        destinationDoc.saveToFile("output/fromCommentRange.docx", FileFormat.Docx);

        //Dispose the document
        sourceDoc.dispose();
        destinationDoc.dispose();
    }
}
