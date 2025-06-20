import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.TextRange;
import java.awt.*;

public class setHyperlinkFormat {
    public static void main(String[] args) {
        String input = "data/BlankTemplate.docx";
		
		// Create a new document object
		Document doc = new Document();

		// Load the document from the specified input file
		doc.loadFromFile(input);

		// Get the first section of the document
		Section section = doc.getSections().get(0);

		// Create a paragraph for the regular link
		Paragraph para1 = section.addParagraph();
		para1.appendText("Regular Link: ");

		// Append a hyperlink to the paragraph with the specified URL and display text
		TextRange txtRange1 = para1.appendHyperlink("www.e-iceblue.com", "www.e-iceblue.com", HyperlinkType.Web_Link);
		txtRange1.getCharacterFormat().setFontName("Times New Roman");
		txtRange1.getCharacterFormat().setFontSize(12f);

		// Insert a blank paragraph
		Paragraph blankPara1 = section.addParagraph();

		// Create a paragraph for the link with changed color
		Paragraph para2 = section.addParagraph();
		para2.appendText("Change Color: ");

		// Append a hyperlink to the paragraph with the specified URL and display text
		TextRange txtRange2 = para2.appendHyperlink("www.e-iceblue.com", "www.e-iceblue.com", HyperlinkType.Web_Link);
		txtRange2.getCharacterFormat().setFontName("Times New Roman");
		txtRange2.getCharacterFormat().setFontSize(12f);
		txtRange2.getCharacterFormat().setTextColor(Color.red);

		// Insert a blank paragraph
		Paragraph blankPara2 = section.addParagraph();

		// Create a paragraph for the link with removed underline
		Paragraph para3 = section.addParagraph();
		para3.appendText("Remove Underline: ");

		// Append a hyperlink to the paragraph with the specified URL and display text
		TextRange txtRange3 = para3.appendHyperlink("www.e-iceblue.com", "www.e-iceblue.com", HyperlinkType.Web_Link);
		txtRange3.getCharacterFormat().setFontName("Times New Roman");
		txtRange3.getCharacterFormat().setFontSize(12f);
		txtRange3.getCharacterFormat().setUnderlineStyle(UnderlineStyle.None);

		// Specify the output file path
		String output = "output/HyperlinkFormat.docx";

		// Save the modified document with formatted hyperlinks to the specified output file in DOCX format
		doc.saveToFile(output, FileFormat.Docx);

		// Dispose the document resources
		doc.dispose();
    }
}
