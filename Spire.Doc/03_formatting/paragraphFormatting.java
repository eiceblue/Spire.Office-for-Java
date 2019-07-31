import com.spire.doc.*;
import com.spire.doc.documents.*;
import java.awt.*;

public class paragraphFormatting {
    public static void main(String[] args) {
        String output="output/paragraphFormatting.docx";

        //initialize a document
        Document document = new Document();
        Section sec = document.addSection();
        Paragraph para = sec.addParagraph();
        para.appendText("Paragraph Formatting");
        para.applyStyle(BuiltinStyle.Title);

        para = sec.addParagraph();
        para.appendText("This paragraph is surrounded with borders.");
        para.getFormat().getBorders().setBorderType(BorderStyle.Single);
        para.getFormat().getBorders().setColor(Color.red);

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

        para = sec.addParagraph();
        para.appendText("This paragraph has the gray shadow.");
        para.getFormat().setBackColor(Color.gray);

        para = sec.addParagraph();
        para.appendText("This paragraph has the following indentations: Left indentation is 10pt, right indentation is 10pt, first line indentation is 15pt.");
        para.getFormat().setLeftIndent(10);
        para.getFormat().setRightIndent(10);
        para.getFormat().setFirstLineIndent(15);

        para = sec.addParagraph();
        para.appendText("The hanging indentation of this paragraph is 15pt.");
        //negative value represents hanging indentation
        para.getFormat().setFirstLineIndent(-15);

        para = sec.addParagraph();
        para.appendText("This paragraph has the following spacing: spacing before is 10pt, spacing after is 20pt, line spacing is at least 10pt.");
        para.getFormat().setAfterSpacing(20);
        para.getFormat().setBeforeSpacing(10);
        para.getFormat().setLineSpacingRule(LineSpacingRule.At_Least);
        para.getFormat().setLineSpacing(10);

        //save as docx file.
        document.saveToFile(output, FileFormat.Docx);
    }
}
