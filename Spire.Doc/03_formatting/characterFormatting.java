import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.TextRange;
import java.awt.*;

public class characterFormatting {
    public static void main(String[] args) {
        String output="output/characterFormatting.docx";
        //initialize a document
        Document document = new Document();
        Section sec = document.addSection();
        Paragraph titleParagraph = sec.addParagraph();
        titleParagraph.appendText("Font Styles and Effects ");
        titleParagraph.applyStyle(BuiltinStyle.Title);

        Paragraph paragraph = sec.addParagraph();
        TextRange tr = paragraph.appendText("Strikethough Text");
        tr.getCharacterFormat().isStrikeout(true);

        paragraph.appendBreak(BreakType.Line_Break);
        tr = paragraph.appendText("Shadow Text");
        tr.getCharacterFormat().isShadow(true);

        paragraph.appendBreak(BreakType.Line_Break);
        tr = paragraph.appendText("Small caps Text");
        tr.getCharacterFormat().isSmallCaps(true);

        paragraph.appendBreak(BreakType.Line_Break);
        tr = paragraph.appendText("Double Strikethough Text");
        tr.getCharacterFormat().setDoubleStrike(true);

        paragraph.appendBreak(BreakType.Line_Break);
        tr = paragraph.appendText("Outline Text");
        tr.getCharacterFormat().isOutLine(true);

        paragraph.appendBreak(BreakType.Line_Break);
        tr = paragraph.appendText("AllCaps Text");
        tr.getCharacterFormat().setAllCaps(true);

        paragraph.appendBreak(BreakType.Line_Break);
        tr = paragraph.appendText("Text");
        tr = paragraph.appendText("SubScript");
        tr.getCharacterFormat().setSubSuperScript(SubSuperScript.Sub_Script);

        tr = paragraph.appendText("And");
        tr = paragraph.appendText("SuperScript");
        tr.getCharacterFormat().setSubSuperScript(SubSuperScript.Super_Script);

        paragraph.appendBreak(BreakType.Line_Break);
        tr = paragraph.appendText("Emboss Text");
        tr.getCharacterFormat().setEmboss(true);
        tr.getCharacterFormat().setTextColor(Color.white);

        paragraph.appendBreak(BreakType.Line_Break);
        tr = paragraph.appendText("Hidden:");
        tr = paragraph.appendText("Hidden Text");
        tr.getCharacterFormat().setHidden(true);

        paragraph.appendBreak(BreakType.Line_Break);
        tr = paragraph.appendText("Engrave Text");
        tr.getCharacterFormat().setEngrave(true);
        tr.getCharacterFormat().setTextColor(Color.white);

        paragraph.appendBreak(BreakType.Line_Break);
        tr = paragraph.appendText("WesternFonts 中文字体");
        tr.getCharacterFormat().setFontNameAscii("Calibri");
        tr.getCharacterFormat().setFontNameNonFarEast("Calibri");
        tr.getCharacterFormat().setFontNameFarEast("Simsun-ExtB");

        paragraph.appendBreak(BreakType.Line_Break);
        tr = paragraph.appendText("Font Size");
        tr.getCharacterFormat().setFontSize(20);

        paragraph.appendBreak(BreakType.Line_Break);
        tr = paragraph.appendText("Font Color");
        tr.getCharacterFormat().setTextColor(Color.red);

        paragraph.appendBreak(BreakType.Line_Break);
        tr = paragraph.appendText("Bold Italic Text");
        tr.getCharacterFormat().setBold(true);
        tr.getCharacterFormat().setItalic(true);

        paragraph.appendBreak(BreakType.Line_Break);
        tr = paragraph.appendText("Underline Style");
        tr.getCharacterFormat().setUnderlineStyle(UnderlineStyle.Single);

        paragraph.appendBreak(BreakType.Line_Break);
        tr = paragraph.appendText("Highlight Text");
        tr.getCharacterFormat().setHighlightColor(Color.yellow);

        paragraph.appendBreak(BreakType.Line_Break);
        tr = paragraph.appendText("Text has shading");
        tr.getCharacterFormat().setTextBackgroundColor(Color.GREEN);

        paragraph.appendBreak(BreakType.Line_Break);
        tr = paragraph.appendText("Border Around Text");
        tr.getCharacterFormat().getBorder().setBorderType(BorderStyle.Single);

        paragraph.appendBreak(BreakType.Line_Break);
        tr = paragraph.appendText("Text Scale");
        tr.getCharacterFormat().setTextScale((short) 150);

        paragraph.appendBreak(BreakType.Line_Break);
        tr = paragraph.appendText("Character Spacing is 2 point");
        tr.getCharacterFormat().setCharacterSpacing(2);

        document.saveToFile(output, FileFormat.Docx);
    }
}
