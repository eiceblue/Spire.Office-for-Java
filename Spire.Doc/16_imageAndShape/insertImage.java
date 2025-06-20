import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;

public class insertImage {
    public static void main(String[] args){
        String input1 = "data/blankTemplate.docx";
        String input2 = "data/spireDoc.png";
        String output = "output/insertImage.docx";

		// Create a new Document object
		Document doc = new Document();

		// Load the document from input1
		doc.loadFromFile(input1);

		// Get the first section of the document
		Section section = doc.getSections().get(0);

		// Get the first paragraph of the section if it exists, otherwise add a new paragraph
		Paragraph paragraph = section.getParagraphs().getCount() > 0 ? section.getParagraphs().get(0) : section.addParagraph();

		// Append text to the paragraph
		paragraph.appendText("The sample demonstrates how to insert an image into a document.");

		// Apply a built-in style (Heading 2) to the paragraph
		paragraph.applyStyle(BuiltinStyle.Heading_2);

		// Add a new paragraph to the section
		paragraph = section.addParagraph();

		// Append text to the new paragraph
		paragraph.appendText("This is an inserted picture.");

		// Create a new DocPicture object and load the image from input2
		DocPicture picture = new DocPicture(doc);
		picture.loadImage(input2);

		// Set the horizontal and vertical position of the picture
		picture.setHorizontalPosition(50.0F);
		picture.setVerticalPosition(60.0F);

		// Set the width and height of the picture
		picture.setWidth(200);
		picture.setHeight(200);

		// Set the text wrapping style of the picture
		picture.setTextWrappingStyle(TextWrappingStyle.Through);

		// Insert the picture at the beginning of the paragraph's child objects
		paragraph.getChildObjects().insert(0, picture);

		// Save the modified document to the output file
		doc.saveToFile(output, FileFormat.Docx);

		// Clean up resources associated with the document
		doc.dispose();
    }
}
