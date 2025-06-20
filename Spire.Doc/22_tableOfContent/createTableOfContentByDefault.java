import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;

public class createTableOfContentByDefault {
    public static void main(String[] args) {
		
		// Create a new Document object
		Document doc = new Document();

		// Add a section to the document
		Section section = doc.addSection();

		// Add a paragraph to the section
		Paragraph para = section.addParagraph();

		// Append a table of contents to the paragraph
		para.appendTOC(1, 3);

		// Add another paragraph to the section
		Paragraph par = section.addParagraph();

		// Append text "Flowers" to the paragraph
		TextRange tr = par.appendText("Flowers");

		// Set the font size of the text to 30
		tr.getCharacterFormat().setFontSize(30);

		// Set the horizontal alignment of the paragraph to center
		par.getFormat().setHorizontalAlignment(HorizontalAlignment.Center);

		// Add another paragraph to the section
		Paragraph para1 = section.addParagraph();

		// Append text "Ornithogalum" to the paragraph
		para1.appendText("Ornithogalum");

		// Apply the built-in style "Heading 1" to the paragraph
		para1.applyStyle(BuiltinStyle.Heading_1);

		// Add another paragraph to the section
		para1 = section.addParagraph();

		// Append a picture to the paragraph from the specified file path
		DocPicture picture = para1.appendPicture("data/ornithogalum.jpg");

		// Set the text wrapping style of the picture to Square
		picture.setTextWrappingStyle(TextWrappingStyle.Square);

		// Append text describing Ornithogalum to the paragraph
		para1.appendText("Ornithogalum is a genus of perennial plants...");

		// Add empty paragraphs to the section
		section.addParagraph();
		section.addParagraph();
		section.addParagraph();
		section.addParagraph();

		// Add another paragraph to the section
		Paragraph para2 = section.addParagraph();

		// Append text "Rosa" to the paragraph
		para2.appendText("Rosa");

		// Apply the built-in style "Heading 2" to the paragraph
		para2.applyStyle(BuiltinStyle.Heading_2);

		// Add another paragraph to the section
		para2 = section.addParagraph();

		// Append a picture to the paragraph from the specified file path
		DocPicture picture2 = para2.appendPicture("data/rosa.jpg");

		// Set the text wrapping style of the picture to Square
		picture2.setTextWrappingStyle(TextWrappingStyle.Square);

		// Append text describing Rosa to the paragraph
		para2.appendText("A rose is a woody perennial flowering plant...");

		// Add empty paragraphs to the section
		section.addParagraph();
		section.addParagraph();
		section.addParagraph();
		section.addParagraph();

		// Add another paragraph to the section
		Paragraph para3 = section.addParagraph();

		// Append text "Hyacinth" to the paragraph
		para3.appendText("Hyacinth");

		// Apply the built-in style "Heading 3" to the paragraph
		para3.applyStyle(BuiltinStyle.Heading_3);

		// Add another paragraph to the section
		para3 = section.addParagraph();

		// Append a picture to the paragraph from the specified file path
		DocPicture picture3 = para3.appendPicture("data/hyacinths.JPG");

		// Set the text wrapping style of the picture to Tight
		picture3.setTextWrappingStyle(TextWrappingStyle.Tight);

		// Append text describing Hyacinth to the paragraph
		para3.appendText("Hyacinthus is a small genus of bulbous, fragrant flowering plants...");

		// Add another paragraph to the section
		para3 = section.addParagraph();

		// Append text about hyacinths and Muscari to the paragraph
		para3.appendText("Several species of Brodiea, Scilla, and other plants that were formerly classified in the lily family...");

		// Update the table of contents in the document
		doc.updateTableOfContents();

		// Save the document to a file
		String output = "output/createTableOfContentByDefault.docx";
		doc.saveToFile(output, FileFormat.Docx_2013);

		// Dispose the Document object
		doc.dispose();
    }
}
