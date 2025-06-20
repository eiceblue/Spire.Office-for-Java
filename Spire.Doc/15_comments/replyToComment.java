import com.spire.doc.*;
import com.spire.doc.fields.*;

public class replyToComment {
    public static void main(String[] args) {
		// Define the input file paths and output file path
        String input1 = "data/commentSample.docx";
        String input2 = "data/e-iceblue.png";
        String output = "output/replyToComment.docx";

		// Create a new Document object
		Document doc = new Document();

		// Load the document from the specified input file
		doc.loadFromFile(input1);

		// Get the first comment in the document
		Comment comment1 = doc.getComments().get(0);

		// Create a new Comment object associated with the document
		Comment replyComment1 = new Comment(doc);

		// Set the author of the reply comment
		replyComment1.getFormat().setAuthor("E-iceblue");

		// Add a paragraph to the body of the reply comment and append text to it
		replyComment1.getBody().addParagraph().appendText("Spire.Doc for Java is a professional Word Java library on operating Word documents.");

		// Make the reply comment a reply to comment1
		comment1.replyToComment(replyComment1);

		// Create a new DocPicture object associated with the document
		DocPicture docPicture = new DocPicture(doc);

		// Load an image into the DocPicture object
		docPicture.loadImage(input2);

		// Add the DocPicture object to the child objects of the first paragraph in the body of replyComment1
		replyComment1.getBody().getParagraphs().get(0).getChildObjects().add(docPicture);

		// Save the modified document to the specified output file in Docx format
		doc.saveToFile(output, FileFormat.Docx);

		// Clean up resources associated with the document
		doc.dispose();
    }
}
