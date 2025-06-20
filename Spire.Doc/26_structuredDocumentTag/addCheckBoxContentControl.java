import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;

public class addCheckBoxContentControl {
    public static void main(String[] args) {
        //Create a document
        Document document = new Document();

        //Add a new section.
        Section section = document.addSection();

        //Add a paragraph
        Paragraph paragraph = section.addParagraph();

        //Append textRange for the paragraph
        TextRange txtRange = paragraph.appendText("The following example shows how to add CheckBox content control in a Word document. \n");

        //Append textRange
        txtRange = paragraph.appendText("Add CheckBox Content Control:  ");

        //Set the font format
        txtRange.getCharacterFormat().setItalic(true);

        //Create StructureDocumentTagInline for document
        StructureDocumentTagInline sdt = new StructureDocumentTagInline(document);

        //Add sdt in paragraph
        paragraph.getChildObjects().add(sdt);

        //Specify the type
        sdt.getSDTProperties().setSDTType(SdtType.Check_Box);

        //Set properties for control
        SdtCheckBox scb = new SdtCheckBox();
        sdt.getSDTProperties().setControlProperties(scb);

        //Add textRange format
        TextRange tr = new TextRange(document);
        tr.getCharacterFormat().setFontName("MS Gothic");
        tr.getCharacterFormat().setFontSize(12);

        //Add textRange to StructureDocumentTagInline
        sdt.getChildObjects().add(tr);

        //Set checkBox as checked
        scb.setChecked(true);

        //Save to file
        String output = "output/addCheckBoxContentControl.docx";
        document.saveToFile(output, FileFormat.Docx);

        // Dispose the document
        document.dispose();
    }
}
