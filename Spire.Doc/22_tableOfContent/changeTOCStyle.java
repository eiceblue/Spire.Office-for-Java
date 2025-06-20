import com.spire.doc.*;
import com.spire.doc.documents.*;
import java.awt.*;

public class changeTOCStyle {
    public static void main(String[] args) {
 
		// Create a new empty document
		Document doc = new Document();

		// Load an existing document from the specified file path
		doc.loadFromFile("data/template_Toc.docx");

		// Create a custom Table of Contents (TOC) style and set its properties
		ParagraphStyle tocStyle = (ParagraphStyle) Style.createBuiltinStyle(BuiltinStyle.Toc_1, doc);
		tocStyle.getCharacterFormat().setFontName("Aleo");
		tocStyle.getCharacterFormat().setFontSize(15f);
		tocStyle.getCharacterFormat().setTextColor(Color.LIGHT_GRAY);

		// Add the custom TOC style to the document's styles collection
		doc.getStyles().add(tocStyle);

		// Iterate through the sections in the document
		for (int s = 0; s < doc.getSections().getCount(); s++) {
			Section section = doc.getSections().get(s);

			// Iterate through the child objects in the section's body
			for (int i = 0; i < section.getBody().getChildObjects().getCount(); i++) {
				DocumentObject obj = section.getBody().getChildObjects().get(i);

				// Check if the object is a StructureDocumentTag (SDT)
				if (obj instanceof StructureDocumentTag) {
					StructureDocumentTag tag = (StructureDocumentTag) obj;

					// Iterate through the child objects in the SDT
					for (int j = 0; j < tag.getChildObjects().getCount(); j++) {
						DocumentObject cObj = tag.getChildObjects().get(j);

						// Check if the child object is a paragraph
						if (cObj instanceof Paragraph) {
							Paragraph para = (Paragraph) cObj;

							// Check if the paragraph has the style name "TOC1"
							if (para.getStyleName().equals("TOC1")) {
								// Apply the custom TOC style to the paragraph
								para.applyStyle(tocStyle.getName());
							}
						}
					}
				}
			}
		}

		// Specify the file path for the resulting document
		String output = "output/changeTOCStyle.docx";

		// Save the document to the specified file path in Docx 2013 format
		doc.saveToFile(output, FileFormat.Docx_2013);

		// Dispose of the document resources
		doc.dispose();
    }
}
