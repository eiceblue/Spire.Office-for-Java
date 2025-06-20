import com.spire.doc.*;
import com.spire.doc.documents.*;

public class changeTOCTabStyle {
    public static void main(String[] args) {

		// Create a new Document object
		Document doc = new Document();

		// Load the document from a file
		doc.loadFromFile("data/template_Toc.docx");

		// Iterate through sections in the document
		for (int s = 0; s < doc.getSections().getCount(); s++) {
			// Get the current section
			Section section = doc.getSections().get(s);

			// Iterate through child objects in the section's body
			for (int i = 0; i < section.getBody().getChildObjects().getCount(); i++) {
				// Get the current child object
				DocumentObject obj = section.getBody().getChildObjects().get(i);

				// Check if the child object is a StructureDocumentTag
				if (obj instanceof StructureDocumentTag) {
					// Cast the child object to StructureDocumentTag
					StructureDocumentTag tag = (StructureDocumentTag) obj;

					// Iterate through child objects in the StructureDocumentTag
					for (int j = 0; j < tag.getChildObjects().getCount(); j++) {
						// Get the current child object
						DocumentObject cObj = tag.getChildObjects().get(j);

						// Check if the child object is a Paragraph
						if (cObj instanceof Paragraph) {
							// Cast the child object to Paragraph
							Paragraph para = (Paragraph) cObj;

							// Check if the Paragraph has a specific style name
							if (para.getStyleName().equals("TOC2")) {
								// Iterate through tabs in the Paragraph's format
								for (int t = 0; t < para.getFormat().getTabs().getCount(); t++) {
									// Get the current tab
									Tab tab = para.getFormat().getTabs().get(t);

									// Adjust the position of the tab
									tab.setPosition(tab.getPosition() + 20);

									// Set the tab leader to No Leader
									tab.setTabLeader(TabLeader.No_Leader);
								}
							}
						}
					}
				}
			}
		}

		// Save the modified document to a file
		String output = "output/changeTOCTabStyle.docx";
		doc.saveToFile(output, FileFormat.Docx_2013);

		// Dispose the Document object
		doc.dispose();
    }
}
