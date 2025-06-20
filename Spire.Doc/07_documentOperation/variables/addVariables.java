import com.spire.doc.*;
import com.spire.doc.documents.*;

public class addVariables {
    public static void main(String[] args) throws Exception {
        //Create Word document.
        Document document = new Document();

        //Add a section.
        Section section = document.addSection();

        //Add a paragraph.
        Paragraph paragraph = section.addParagraph();

        //Add a DocVariable field.
        paragraph.appendField("A1", FieldType.Field_Doc_Variable);

        //Add a document variable to the DocVariable field.
        document.getVariables().add("A1", "12");

        //Update fields.
        document.isUpdateFields(true);

        String result = "output/result-addVariables.docx";

        //Save to file.
        document.saveToFile(result, FileFormat.Docx_2013);

        //Dispose the document
        document.dispose();
    }
}
