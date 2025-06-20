import com.spire.doc.*;
import com.spire.doc.documents.*;

public class removeFooter {
    public static void main(String[] args) {
        String input = "data/oddAndEvenHeaderFooter.docx";
        String output = "output/removeFooter.docx";

		// Create a new document object
		Document doc = new Document();

		// Load the document from the input file
		doc.loadFromFile(input);

		// Get the first section of the document
		Section section = doc.getSections().get(0);

		HeaderFooter footer;

		// Clear the child objects of the footer for the first page
		footer = section.getHeadersFooters().getByHeaderFooterType(HeaderFooterType.Footer_First_Page);
		if (footer != null) {
			footer.getChildObjects().clear();
		}

		// Clear the child objects of the footer for odd pages
		footer = section.getHeadersFooters().getByHeaderFooterType(HeaderFooterType.Footer_Odd);
		if (footer != null) {
			footer.getChildObjects().clear();
		}

		// Clear the child objects of the footer for even pages
		footer = section.getHeadersFooters().getByHeaderFooterType(HeaderFooterType.Footer_Even);
		if (footer != null) {
			footer.getChildObjects().clear();
		}

		// Save the modified document to the output file
		doc.saveToFile(output, FileFormat.Docx);

		// Dispose of the document object to release resources
		doc.dispose();
    }
}
