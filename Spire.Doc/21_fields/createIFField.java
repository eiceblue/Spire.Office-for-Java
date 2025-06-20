import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;
import com.spire.doc.interfaces.IParagraphBase;

public class createIFField {
    public static void main(String[] args) throws Exception {

		// Create a new document object
		Document document = new Document();

		// Add a section to the document
		Section section = document.addSection();

		// Add a paragraph to the section
		Paragraph paragraph = section.addParagraph();

		// Create an IF field and add it to the paragraph using a helper method named "CreateIfField"
		CreateIfField(document, paragraph);

		// Specify the field names and field values for the mail merge operation
		String[] fieldName = { "Count" };
		String[] fieldValue = { "2" };

		// Execute the mail merge operation with the specified field names and field values
		document.getMailMerge().execute(fieldName, fieldValue);

		// Enable updating of fields in the document
		document.isUpdateFields(true);

		// Specify the output file path
		String result = "output/CreateAnIFField.docx";

		// Save the modified document to the specified output file in DOCX format (compatible with Word 2013)
		document.saveToFile(result, FileFormat.Docx_2013);

		// Dispose the document resources
		document.dispose();
		}

		static void CreateIfField(Document document, Paragraph paragraph) {
			// Create a new IF field
			IfField ifField = new IfField(document);
			
			// Set the field type to Field_If
			ifField.setType(FieldType.Field_If);
			
			// Set the field code for the IF field
			ifField.setCode("IF");
			
			// Add the IF field to the paragraph
			paragraph.getItems().add(ifField);
			
			// Append other text and fields to the paragraph
			paragraph.appendField("Count", FieldType.Field_Merge_Field);
			paragraph.appendText(" > ");
			paragraph.appendText("\"100\" ");
			paragraph.appendText("\"Thanks\" ");
			paragraph.appendText("\"The minimum order is 100 units\"");
			
			// Create a field end mark and add it to the paragraph
			IParagraphBase endPara = document.createParagraphItem(ParagraphItemType.Field_Mark);
			FieldMark end=(FieldMark)endPara;
			end.setType(FieldMarkType.Field_End);
			paragraph.getItems().add(end);
			
			// Set the field end mark for the IF field
			ifField.setEnd(end);
		}
}
