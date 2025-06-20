import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.TextRange;

import java.awt.*;

public class multiStylesInAParagraph {
    public static void main(String[] args) {
        // Set the output file path
        String outputFile = "output/multiStylesInAParagraph.docx";

        // Create a new Document object
        Document doc = new Document();

        // Add a section to the document
        Section section = doc.addSection();

        // Add a paragraph to the section
        Paragraph para = section.addParagraph();

        // Append text with multiple styles to the paragraph
        TextRange range = para.appendText("Spire.Doc for Java ");
        range.getCharacterFormat().setFontName("Calibri");
        range.getCharacterFormat().setFontSize(16);
        range.getCharacterFormat().setTextColor(Color.blue);
        range.getCharacterFormat().setBold(true);
        range.getCharacterFormat().setUnderlineStyle(UnderlineStyle.Single);

        range = para.appendText("is a professional Word Java library");
        range.getCharacterFormat().setFontName("Calibri");
        range.getCharacterFormat().setFontSize(15);

        // Save the document to the output file in Docx format
        doc.saveToFile(outputFile, FileFormat.Docx);

        // Dispose of the document to release resources
        doc.dispose();
    }
}
