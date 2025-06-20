import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;
import java.util.ArrayList;

public class removeContentWithComment {
    public static void main(String[] args) {
		// Define the input file path and output file path
        String input = "data/commentSample.docx";
        String output = "output/removeContentWithComment.docx";

		// Create a new Document object
		Document document = new Document();

		// Load the document from the specified input file
		document.loadFromFile(input);

		// Get the second comment in the document
		Comment comment = document.getComments().get(1);

		// Get the paragraph that contains the obtained comment
		Paragraph para = comment.getOwnerParagraph();

		// Find the index of the CommentMarkStart in the paragraph's child objects
		int startIndex = para.getChildObjects().indexOf(comment.getCommentMarkStart());

		// Find the index of the CommentMarkEnd in the paragraph's child objects
		int endIndex = para.getChildObjects().indexOf(comment.getCommentMarkEnd());

		// Create an ArrayList to store TextRange objects
		ArrayList<TextRange> list = new ArrayList<TextRange>();

		// Iterate over the child objects between startIndex and endIndex
		for (int i = startIndex; i < endIndex; i++) {
			// Check if the current child object is an instance of TextRange
			if (para.getChildObjects().get(i) instanceof TextRange) {
				// Add the TextRange object to the list
				list.add((TextRange) para.getChildObjects().get(i));
			}
		}

		// Create a new TextRange object associated with the document
		TextRange textRange = new TextRange(document);

		// Set the text of the new TextRange to null
		textRange.setText(null);

		// Insert the new TextRange object at the endIndex position in the paragraph's child objects
		para.getChildObjects().insert(endIndex, textRange);

		// Remove the previous TextRange objects from the paragraph's child objects
		for (int i = 0; i < list.size(); i++) {
			para.getChildObjects().remove(list.get(i));
		}

		// Save the modified document to the specified output file in Docx format
		document.saveToFile(output, FileFormat.Docx);

		// Clean up resources associated with the document
		document.dispose();
    }
}
