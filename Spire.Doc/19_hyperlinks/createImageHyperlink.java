import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.DocPicture;

public class createImageHyperlink {
    public static void main(String[] args) {
        String input = "data/BlankTemplate.docx";
		
		// Create a new document object
		Document doc = new Document();

		// Load the document from the specified input file
		doc.loadFromFile(input);

		// Get the first section of the document
		Section section = doc.getSections().get(0);

		// Add a paragraph to the section
		Paragraph paragraph = section.addParagraph();

		// Create a DocPicture and load an image from the specified file
		DocPicture picture = new DocPicture(doc);
		picture.loadImage("data/spireDoc.png");

		// Append a hyperlink to the paragraph with the image and set its URL and type
		paragraph.appendHyperlink("https://www.e-iceblue.com/Introduce/doc-for-java.html", picture, HyperlinkType.Web_Link);

		// Specify the output file path
		String output = "output/CreateImageHyperlink.docx";

		// Save the document to the specified output file in DOCX format
		doc.saveToFile(output, FileFormat.Docx);

		// Dispose the document resources
		doc.dispose();
    }
}
