import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;

public class executeConditionalField {
    public static void main(String[] args) throws Exception {
        // Create a new Document object
        Document doc = new Document();

        // Add a section to the document
        Section section = doc.addSection();

        // Add a paragraph to the section and create the first IF field
        Paragraph paragraph = section.addParagraph();
        CreateIFField1(doc, paragraph);

        // Add another paragraph to the section and create the second IF field
        paragraph = section.addParagraph();
        CreateIFField2(doc, paragraph);

        // Define field names and values for mail merge
        String[] fieldName = { "Count", "Age" };
        String[] fieldValue = { "2", "30" };

        // Execute the mail merge with the specified field names and values
        doc.getMailMerge().execute(fieldName, fieldValue);

        // Set the document to update fields
        doc.isUpdateFields(true);

        // Specify the path for the resulting document
        String result = "output/ExecuteConditionalField_out.docx";

        // Save the document to the output path
        doc.saveToFile(result, FileFormat.Docx);

        // Dispose of the document
        doc.dispose();
    }

    // Method to create the first IF field
    private static void CreateIFField1(Document document, Paragraph paragraph) {
        // Create a new IfField object and set its type and code
        IfField ifField = new IfField(document);
        ifField.setType(FieldType.Field_If);
        ifField.setCode("IF ");

        // Add the IfField to the paragraph
        paragraph.getItems().add(ifField);

        // Append the merge field, comparison operator, and text for condition results
        paragraph.appendField("Count", FieldType.Field_Merge_Field);
        paragraph.appendText(" > ");
        paragraph.appendText("\"1\" ");
        paragraph.appendText("\"Greater than one\" ");
        paragraph.appendText("\"Less than one\"");

        // Create a FieldMark object for the end of the IfField
        FieldMark fieldMark = new FieldMark(document);
        fieldMark.setType(FieldMarkType.Field_End);

        // Add the FieldMark to the paragraph and set it as the end of the IfField
        paragraph.getItems().add(fieldMark);
        ifField.setEnd(fieldMark);
    }

    // Method to create the second IF field
    private static void CreateIFField2(Document document, Paragraph paragraph) {
        // Create a new IfField object and set its type and code
        IfField ifField = new IfField(document);
        ifField.setType(FieldType.Field_If);
        ifField.setCode("IF ");

        // Add the IfField to the paragraph
        paragraph.getItems().add(ifField);

        // Append the merge field, comparison operator, and text for condition results
        paragraph.appendField("Age", FieldType.Field_Merge_Field);
        paragraph.appendText(" > ");
        paragraph.appendText("\"50\" ");
        paragraph.appendText("\"The old man\" ");
        paragraph.appendText("\"The young man\"");

        // Create a FieldMark object for the end of the IfField
        FieldMark fieldMark = new FieldMark(document);
        fieldMark.setType(FieldMarkType.Field_End);

        // Add the FieldMark to the paragraph and set it as the end of the IfField
        paragraph.getItems().add(fieldMark);
        ifField.setEnd(fieldMark);
    }
}
