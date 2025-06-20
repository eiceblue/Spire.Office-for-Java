import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;

public class resetImageSize {
    public static void main(String[] args) {
        String input="data/imageTemplate.docx";
        String output="output/resetImageSize.docx";

		// Create a new Document object
		Document doc = new Document();

		// Load the document from the input file
		doc.loadFromFile(input);

		// Get the first section of the document
		Section section = doc.getSections().get(0);

		// Get the first paragraph of the section
		Paragraph paragraph = section.getParagraphs().get(0);

		// Iterate through all child objects of the paragraph
		for (int i = 0; i < paragraph.getChildObjects().getCount(); i++) {
			DocumentObject docObj = paragraph.getChildObjects().get(i);
			
			// Check if the child object is an instance of DocPicture
			if (docObj instanceof DocPicture) {
				// Cast the child object to DocPicture and modify its width and height
				DocPicture picture = (DocPicture) docObj;
				picture.setWidth(50f);
				picture.setHeight(50f);
			}
		}

		// Save the modified document to the output file
		doc.saveToFile(output, FileFormat.Docx);

		// Clean up resources associated with the document
		doc.dispose();
    }
}
