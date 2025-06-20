import com.spire.doc.*;
import com.spire.doc.documents.*;

public class removeHeader {
    public static void main(String[] args) {
        String input = "data/oddAndEvenHeaderFooter.docx";
        String output = "output/removeHeader.docx";

		// Create a new document object
		Document doc = new Document();

		// Load the document from the input file
		doc.loadFromFile(input);

		// Get the first section of the document
		Section section = doc.getSections().get(0);

		HeaderFooter header;

		// Clear the child objects of the header for the first page
		header = section.getHeadersFooters().getByHeaderFooterType(HeaderFooterType.Header_First_Page);
		if (header != null) {
			header.getChildObjects().clear();
		}

		// Clear the child objects of the header for odd pages
		header = section.getHeadersFooters().getByHeaderFooterType(HeaderFooterType.Header_Odd);
		if (header != null) {
			header.getChildObjects().clear();
		}

		// Clear the child objects of the header for even pages
		header = section.getHeadersFooters().getByHeaderFooterType(HeaderFooterType.Header_Even);
		if (header != null) {
			header.getChildObjects().clear();
		}

		// Save the modified document to the output file
		doc.saveToFile(output, FileFormat.Docx);

		// Dispose of the document object to release resources
		doc.dispose();
    }
}
