import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;

public class addImageToEachPage {
    public static void main(String[] args) {
        String input1 = "data/multiPages.docx";
        String input2 = "data/spireDoc.png";
        String output = "output/addImageToEachPage.docx";

		// Create a new Document object
		Document document = new Document();

		// Load the document from the specified input file
		document.loadFromFile(input1);

		// Add a paragraph to the footer of the first section of the document and append a picture to it
		DocPicture picture = document.getSections().get(0).getHeadersFooters().getFooter().addParagraph().appendPicture(input2);

		// Set the vertical origin of the picture to Page
		picture.setVerticalOrigin(VerticalOrigin.Page);

		// Set the horizontal origin of the picture to Page
		picture.setHorizontalOrigin(HorizontalOrigin.Page);

		// Set the vertical alignment of the picture to Bottom
		picture.setVerticalAlignment(ShapeVerticalAlignment.Bottom);

		// Set the text wrapping style of the picture to None
		picture.setTextWrappingStyle(TextWrappingStyle.None);

		// Add a TextBox to the footer of the first section of the document with specified width and height
		TextBox textbox = document.getSections().get(0).getHeadersFooters().getFooter().addParagraph().appendTextBox(150, 20);

		// Set the vertical origin of the TextBox to Page
		textbox.setVerticalOrigin(VerticalOrigin.Page);

		// Set the horizontal origin of the TextBox to Page
		textbox.setHorizontalOrigin(HorizontalOrigin.Page);

		// Set the horizontal position of the TextBox
		textbox.setHorizontalPosition(300);

		// Set the vertical position of the TextBox
		textbox.setVerticalPosition(800);

		// Add a paragraph to the TextBox body and append text to it
		textbox.getBody().addParagraph().appendText("Welcome to E-iceblue");

		// Save the modified document to the specified output file in Docx format
		document.saveToFile(output, FileFormat.Docx);

		// Clean up resources associated with the document
		document.dispose();
    }
}
