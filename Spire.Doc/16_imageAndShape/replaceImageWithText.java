import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;
import java.util.ArrayList;

public class replaceImageWithText {
    public static void main(String[] args) {
        String input="data/imageTemplate.docx";
        String output="output/replaceImageWithText.docx";

		// Create a new Document object
		Document doc = new Document();

		// Load the document from the input file
		doc.loadFromFile(input);

		// Initialize a counter for image labels
		int j = 1;

		// Iterate through all sections of the document
		for (int i = 0; i < doc.getSections().getCount(); i++) {
			Section sec = doc.getSections().get(i);
			
			// Iterate through all paragraphs in the section
			for (int p = 0; p < sec.getParagraphs().getCount(); p++) {
				Paragraph para = sec.getParagraphs().get(p);
				
				// Create an ArrayList to store picture objects found in the paragraph
				ArrayList<DocumentObject> pictures = new ArrayList<DocumentObject>();
				
				// Iterate through all child objects of the paragraph
				for (int o = 0; o < para.getChildObjects().getCount(); o++) {
					DocumentObject docObj = para.getChildObjects().get(o);
					
					// Check if the child object is a Picture
					if (docObj.getDocumentObjectType() == DocumentObjectType.Picture) {
						pictures.add(docObj);
					}
				}
				
				// Iterate through all picture objects in the ArrayList
				for (int m = 0; m < pictures.size(); m++) {
					DocumentObject pic = pictures.get(m);
					int index = para.getChildObjects().indexOf(pic);
					
					// Create a new TextRange object with the image label and insert it before the picture object
					TextRange range = new TextRange(doc);
					range.setText(String.format("Here was image-%d", j));
					para.getChildObjects().insert(index, range);
					
					// Remove the picture object from the paragraph's child objects
					para.getChildObjects().remove(pic);
					
					// Increment the image label counter
					j++;
				}
			}
		}

		// Save the modified document to the output file
		doc.saveToFile(output, FileFormat.Docx);

		// Clean up resources associated with the document
		doc.dispose();
    }
}
