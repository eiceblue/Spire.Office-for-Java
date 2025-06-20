import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;

public class addTCField {
    public static void main(String[] args) {
		// Create a new document object
		Document document = new Document();

		// Add a section to the document
		Section section = document.addSection();

		// Add a paragraph to the section
		Paragraph paragraph = section.addParagraph();

		// Append a TC field with the specified entry text to the paragraph
		Field field = paragraph.appendField("TC", FieldType.Field_TOC_Entry);
		field.setCode("TC " + "\"Entry Text\"" + " \\f" + " t");

		// Save the document to the specified output file in DOCX format
		document.saveToFile("output/addTCField.docx", FileFormat.Docx);

		// Dispose the document resources
		document.dispose();
    }
}
