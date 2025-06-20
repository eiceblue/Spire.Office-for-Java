import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.TextRange;
import java.awt.*;

public class characterFormatting {
    public static void main(String[] args) {
        // Set the output file path
        String output = "output/characterFormatting.docx";

        // Create a new Document object
        Document document = new Document();

        // Add a section to the document
        Section sec = document.addSection();

        // Add a title paragraph with "Font Styles and Effects" text and apply the Title style
        Paragraph titleParagraph = sec.addParagraph();
        titleParagraph.appendText("Font Styles and Effects ");
        titleParagraph.applyStyle(BuiltinStyle.Title);

        // Add a regular paragraph for each character formatting example

        // Strikethrough Text
        Paragraph paragraph = sec.addParagraph();
        TextRange tr = paragraph.appendText("Strikethough Text");
        tr.getCharacterFormat().isStrikeout(true);

        // Shadow Text
        paragraph.appendBreak(BreakType.Line_Break);
        tr = paragraph.appendText("Shadow Text");
        tr.getCharacterFormat().isShadow(true);

        // Small caps Text
        paragraph.appendBreak(BreakType.Line_Break);
        tr = paragraph.appendText("Small caps Text");
        tr.getCharacterFormat().isSmallCaps(true);

        // Double Strikethough Text
        paragraph.appendBreak(BreakType.Line_Break);
        tr = paragraph.appendText("Double Strikethough Text");
        tr.getCharacterFormat().setDoubleStrike(true);

        // Outline Text
        paragraph.appendBreak(BreakType.Line_Break);
        tr = paragraph.appendText("Outline Text");
        tr.getCharacterFormat().isOutLine(true);

        // AllCaps Text
        paragraph.appendBreak(BreakType.Line_Break);
        tr = paragraph.appendText("AllCaps Text");
        tr.getCharacterFormat().setAllCaps(true);

        // SubScript and SuperScript Text
        paragraph.appendBreak(BreakType.Line_Break);
        tr = paragraph.appendText("Text");
        tr = paragraph.appendText("SubScript");
        tr.getCharacterFormat().setSubSuperScript(SubSuperScript.Sub_Script);
        tr = paragraph.appendText("And");
        tr = paragraph.appendText("SuperScript");
        tr.getCharacterFormat().setSubSuperScript(SubSuperScript.Super_Script);

        // Emboss Text
        paragraph.appendBreak(BreakType.Line_Break);
        tr = paragraph.appendText("Emboss Text");
        tr.getCharacterFormat().setEmboss(true);
        tr.getCharacterFormat().setTextColor(Color.white);

        // Hidden Text
        paragraph.appendBreak(BreakType.Line_Break);
        tr = paragraph.appendText("Hidden:");
        tr = paragraph.appendText("Hidden Text");
        tr.getCharacterFormat().setHidden(true);

        // Engrave Text
        paragraph.appendBreak(BreakType.Line_Break);
        tr = paragraph.appendText("Engrave Text");
        tr.getCharacterFormat().setEngrave(true);
        tr.getCharacterFormat().setTextColor(Color.white);

        // WesternFonts and 中文字体
        paragraph.appendBreak(BreakType.Line_Break);
        tr = paragraph.appendText("WesternFonts 中文字体");
        tr.getCharacterFormat().setFontNameAscii("Calibri");
        tr.getCharacterFormat().setFontNameNonFarEast("Calibri");
        tr.getCharacterFormat().setFontNameFarEast("Simsun-ExtB");

        // Font Size
        paragraph.appendBreak(BreakType.Line_Break);
        tr = paragraph.appendText("Font Size");
        tr.getCharacterFormat().setFontSize(20);

        // Font Color
        paragraph.appendBreak(BreakType.Line_Break);
        tr = paragraph.appendText("Font Color");
        tr.getCharacterFormat().setTextColor(Color.red);

        // Bold Italic Text
        paragraph.appendBreak(BreakType.Line_Break);
        tr = paragraph.appendText("Bold Italic Text");
        tr.getCharacterFormat().setBold(true);
        tr.getCharacterFormat().setItalic(true);

        // Underline Style
        paragraph.appendBreak(BreakType.Line_Break);
        tr = paragraph.appendText("Underline Style");
        tr.getCharacterFormat().setUnderlineStyle(UnderlineStyle.Single);

        // Highlight Text
        paragraph.appendBreak(BreakType.Line_Break);
        tr = paragraph.appendText("Highlight Text");
        tr.getCharacterFormat().setHighlightColor(Color.yellow);

        // Text has shading
        paragraph.appendBreak(BreakType.Line_Break);
        tr = paragraph.appendText("Text has shading");
        tr.getCharacterFormat().setTextBackgroundColor(Color.GREEN);

        // Border Around Text
        paragraph.appendBreak(BreakType.Line_Break);
        tr = paragraph.appendText("Border Around Text");
        tr.getCharacterFormat().getBorder().setBorderType(BorderStyle.Single);

        // Text Scale
        paragraph.appendBreak(BreakType.Line_Break);
        tr = paragraph.appendText("Text Scale");
        tr.getCharacterFormat().setTextScale((short)150);

        // Character Spacing is 2 point
        paragraph.appendBreak(BreakType.Line_Break);
        tr = paragraph.appendText("Character Spacing is 2 point");
        tr.getCharacterFormat().setCharacterSpacing(2);

        // Save the document to the output file in Docx format
        document.saveToFile(output, FileFormat.Docx);

        // Release the resources associated with the document
        document.dispose();
    }
}
