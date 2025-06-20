import com.spire.doc.*;
import com.spire.doc.documents.*;

public class setIndentByCharacter {
    public static void main(String[] args) {
        // Create a new Document object
        Document document = new Document();

        // Add a section to the document
        Section sec = document.addSection();

        // Add a paragraph for the title
        Paragraph para = sec.addParagraph();
        para.appendText("Paragraph Formatting");
        para.applyStyle(BuiltinStyle.Title);

        // Add a paragraph with indent settings
        para = sec.addParagraph();
        para.appendText(
                "This paragraph is indent as follows: Indent 2 characters on the left and 5 characters on the right.");
        para.getFormat().setLeftIndentChars(2);
        para.getFormat().setRightIndentChars(5f);

        // Save the document to the output file in Docx format
        document.saveToFile("output/SetIndentByCharacter_result.docx", FileFormat.Docx);

        // Dispose of the document to release resources
        document.dispose();
    }
}
