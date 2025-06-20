import com.spire.doc.*;

public class removeAndReplaceComment {
    public static void main(String[] args) {
		// Define the input file path and output file path
        String input = "data/commentSample.docx";
        String output = "output/removeAndReplaceComment.docx";

		// Create a new Document object
		Document doc = new Document();

		// Load the document from the specified input file
		doc.loadFromFile(input);

		// Access the first comment, its body, and the first paragraph in the body
		// Replace the text "This is the title" with "This comment is changed."
		doc.getComments().get(0).getBody().getParagraphs().get(0).replace("This is the title", "This comment is changed.", false, false);

		// Remove the comment at index 1 (the second comment)
		doc.getComments().removeAt(1);

		// Save the modified document to the specified output file in Docx format
		doc.saveToFile(output, FileFormat.Docx);

		// Clean up resources associated with the document
		doc.dispose();
    }
}
