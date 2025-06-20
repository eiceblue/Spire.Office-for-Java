import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;

public class insertPictureIntoComment {
    public static void main(String[] args) {
        // Define the input file paths for the document and image
        String input1 = "data/sample.docx";
        String input2 = "data/e-iceblue.png";

        // Define the output file path for the document with inserted picture into a comment
        String output = "output/insertPictureIntoComment.docx";

        // Create a new Document instance
        Document doc = new Document();

        // Load the document from the specified input file
        doc.loadFromFile(input1);

        // Get the third paragraph in the first section of the document
        Paragraph paragraph = doc.getSections().get(0).getParagraphs().get(2);

        // Append a comment to the paragraph with the specified text
        Comment comment = paragraph.appendComment("This is a comment.");

        // Set the author of the comment
        comment.getFormat().setAuthor("E-iceblue");

        // Create a new DocPicture instance for the document
        DocPicture docPicture = new DocPicture(doc);

        // Load the image from the specified input file into the DocPicture
        docPicture.loadImage(input2);

        // Add the DocPicture as a child object of a paragraph within the comment's body
        comment.getBody().addParagraph().getChildObjects().add(docPicture);

        // Save the modified document to the specified output file in Docx format
        doc.saveToFile(output, FileFormat.Docx);

        // Dispose of the document resources
        doc.dispose();
    }
}
