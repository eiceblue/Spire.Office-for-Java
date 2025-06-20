import com.spire.doc.*;
import com.spire.doc.documents.*;
import java.awt.*;

public class paragraphFormatting {
    public static void main(String[] args) {
        // Set the output file path
        String output = "output/paragraphFormatting.docx";

        // Create a new Document object
        Document document = new Document();

        // Add a section to the document
        Section sec = document.addSection();

        // Add a paragraph for the title
        Paragraph para = sec.addParagraph();
        para.appendText("Paragraph Formatting");
        para.applyStyle(BuiltinStyle.Title);

        // Add a paragraph with borders
        para = sec.addParagraph();
        para.appendText("This paragraph is surrounded with borders.");
        para.getFormat().getBorders().setBorderType(BorderStyle.Single);
        para.getFormat().getBorders().setColor(Color.red);

        // Add paragraphs with different horizontal alignments
        para = sec.addParagraph();
        para.appendText("The alignment of this paragraph is Left.");
        para.getFormat().setHorizontalAlignment(HorizontalAlignment.Left);

        para = sec.addParagraph();
        para.appendText("The alignment of this paragraph is Center.");
        para.getFormat().setHorizontalAlignment(HorizontalAlignment.Center);

        para = sec.addParagraph();
        para.appendText("The alignment of this paragraph is Right.");
        para.getFormat().setHorizontalAlignment(HorizontalAlignment.Right);

        para = sec.addParagraph();
        para.appendText("The alignment of this paragraph is justified.");
        para.getFormat().setHorizontalAlignment(HorizontalAlignment.Justify);

        para = sec.addParagraph();
        para.appendText("The alignment of this paragraph is distributed.");
        para.getFormat().setHorizontalAlignment(HorizontalAlignment.Distribute);

        // Add a paragraph with a gray shadow background color
        para = sec.addParagraph();
        para.appendText("This paragraph has the gray shadow.");
        para.getFormat().setBackColor(Color.gray);

        // Add a paragraph with indentations
        para = sec.addParagraph();
        para.appendText(
            "This paragraph has the following indentations: Left indentation is 10pt, right indentation is 10pt, first line indentation is 15pt.");
        para.getFormat().setLeftIndent(10);
        para.getFormat().setRightIndent(10);
        para.getFormat().setFirstLineIndent(15);

        // Add a paragraph with hanging indentation
        para = sec.addParagraph();
        para.appendText("The hanging indentation of this paragraph is 15pt.");
        para.getFormat().setFirstLineIndent(-15);

        // Add a paragraph with spacing settings
        para = sec.addParagraph();
        para.appendText(
            "This paragraph has the following spacing: spacing before is 10pt, spacing after is 20pt, line spacing is at least 10pt.");
        para.getFormat().setAfterSpacing(20);
        para.getFormat().setBeforeSpacing(10);
        para.getFormat().setLineSpacingRule(LineSpacingRule.At_Least);
        para.getFormat().setLineSpacing(10);

        // Save the document to the output file in Docx format
        document.saveToFile(output, FileFormat.Docx);

        // Dispose of the document to release resources
        document.dispose();
    }
}
