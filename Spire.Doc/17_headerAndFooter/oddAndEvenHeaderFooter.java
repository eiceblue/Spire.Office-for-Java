import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;

public class oddAndEvenHeaderFooter {
    public static void main(String[] args) {
        String input = "data/multiPages.docx";
        String output = "output/oddAndEvenHeaderFooter.docx";

		// Create a new document object
		Document doc = new Document();

		// Load the document from the input file
		doc.loadFromFile(input);

		// Get the first section of the document
		Section section = doc.getSections().get(0);

		// Set different odd and even pages header/footer
		section.getPageSetup().setDifferentOddAndEvenPagesHeaderFooter(true);

		// Add a paragraph to the odd header
		Paragraph P3 = section.getHeadersFooters().getOddHeader().addParagraph();
		TextRange OH = P3.appendText("Odd Header");
		P3.getFormat().setHorizontalAlignment(HorizontalAlignment.Center);
		OH.getCharacterFormat().setFontName("Arial");
		OH.getCharacterFormat().setFontSize(10);

		// Add a paragraph to the even header
		Paragraph P4 = section.getHeadersFooters().getEvenHeader().addParagraph();
		TextRange EH = P4.appendText("Even Header from E-iceblue Using Spire.Doc");
		P4.getFormat().setHorizontalAlignment(HorizontalAlignment.Center);
		EH.getCharacterFormat().setFontName("Arial");
		EH.getCharacterFormat().setFontSize(10);

		// Add a paragraph to the odd footer
		Paragraph P2 = section.getHeadersFooters().getOddFooter().addParagraph();
		TextRange OF = P2.appendText("Odd Footer");
		P2.getFormat().setHorizontalAlignment(HorizontalAlignment.Center);
		OF.getCharacterFormat().setFontName("Arial");
		OF.getCharacterFormat().setFontSize(10);

		// Add a paragraph to the even footer
		Paragraph P1 = section.getHeadersFooters().getEvenFooter().addParagraph();
		TextRange EF = P1.appendText("Even Footer from E-iceblue Using Spire.Doc");
		EF.getCharacterFormat().setFontName("Arial");
		EF.getCharacterFormat().setFontSize(10);
		P1.getFormat().setHorizontalAlignment(HorizontalAlignment.Center);

		// Save the document to the output file
		doc.saveToFile(output, FileFormat.Docx);

		// Dispose of the document object to release resources
		doc.dispose();
    }
}
