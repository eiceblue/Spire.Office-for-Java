import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.TextRange;

public class embedPrivateFont {
    public static void main(String[] args) {
        // Set the input file path
        String inputFile = "data/BlankTemplate.docx";

        // Set the font file path
        String fontFile = "data/PT_Serif-Caption-Web-Regular.ttf";

        // Set the output file path
        String outputFile = "output/embedPrivateFont.docx";

        // Create a new Document object
        Document doc = new Document();

        // Load the document from the input file
        doc.loadFromFile(inputFile);

        // Get the first section of the document
        Section section = doc.getSections().get(0);

        // Add a new paragraph to the section
        Paragraph p = section.addParagraph();

        // Append text to the paragraph
        TextRange range = p.appendText(
            "Spire.Doc for Java is a professional Word Java library specifically designed for developers to create, read, write, convert and print Word document files from Java platform with fast and high quality performance.");

        // Set the font name to "PT Serif Caption" and font size to 20 for the text range
        range.getCharacterFormat().setFontName("PT Serif Caption");
        range.getCharacterFormat().setFontSize(20);

        // Enable embedding fonts in the document
        doc.setEmbedFontsInFile(true);

        // Add the private font to the document's private font list
        doc.getPrivateFontList().add(new PrivateFontPath("PT Serif Caption", fontFile));

        // Save the modified document to the output file in Docx format
        doc.saveToFile(outputFile, FileFormat.Docx);

        // Release the resources associated with the document
        doc.dispose();
    }
}
