import com.spire.doc.*;

import java.util.regex.*;

public class removeTableOfContent {
    public static void main(String[] args) {

		// Create a new Document object
		Document document = new Document();

		// Load an existing Word document from the specified file path
		document.loadFromFile("data/tableOfContent.docx");

		// Get the body of the first section in the document
		Body body = document.getSections().get(0).getBody();

		// Define a pattern to match the style names of table of contents paragraphs
		String pattern = "TOC\\w+";

		// Iterate over paragraphs in the body
		for (int i = 0; i < body.getParagraphs().getCount(); i++) {
			// Get the style name of the current paragraph
			String styleName = body.getParagraphs().get(i).getStyleName();
			
			// Check if the style name matches the defined pattern
			if (Pattern.matches(pattern, styleName)) {
				// If it matches, remove the paragraph from the body
				body.getParagraphs().removeAt(i);
				i--;
			}
		}

		// Save the modified document to a new file
		String output = "output/removeTableOfContent.docx";
		document.saveToFile(output, FileFormat.Docx_2013);

		// Dispose the Document object
		document.dispose();
    }
}
