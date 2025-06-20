import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;

public class setSuperscriptAndSubscript {
    public static void main(String[] args) {
        //Create word document
        Document document = new Document();

        //Add a new section
        Section section = document.addSection();

        //Add a paragraph
        Paragraph paragraph = section.addParagraph();

        //Append text
        paragraph.appendText("E = mc");
        TextRange range1 = paragraph.appendText("2");

        //Set superscript
        range1.getCharacterFormat().setSubSuperScript(SubSuperScript.Super_Script);

        //Append a line_break
        paragraph.appendBreak(BreakType.Line_Break);

        // Append some text
        paragraph.appendText("F");
        TextRange range2 = paragraph.appendText("n");

        //Set subscript
        range2.getCharacterFormat().setSubSuperScript(SubSuperScript.Sub_Script);

        paragraph.appendText(" = F");

        //Set subscript
        paragraph.appendText("n-1").getCharacterFormat().setSubSuperScript(SubSuperScript.Sub_Script);
        paragraph.appendText(" + F");
        paragraph.appendText("n-2").getCharacterFormat().setSubSuperScript(SubSuperScript.Sub_Script);

        //Loop through the paragraph and get its child objects
        for (Object i : paragraph.getItems()) {
            if (i instanceof TextRange) {
                //Set font size for text range
                ((TextRange) i).getCharacterFormat().setFontSize(36);
            }
        }

        //Save the file
        String output = "output/setSuperscriptAndSubscript.docx";
        document.saveToFile(output, FileFormat.Docx);

        //Dispose the document
        document.dispose();
    }
}
