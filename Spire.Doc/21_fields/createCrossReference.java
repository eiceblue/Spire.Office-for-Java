import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;

public class createCrossReference {
    public static void main(String[] args) {
		// Create a new document object
		Document document = new Document();

		// Add a section to the document
		Section section = document.addSection();

		// Add a paragraph to the section
		Paragraph paragraph = section.addParagraph();

		// Append a bookmark start tag with the specified name "MyBookmark" to the paragraph
		paragraph.appendBookmarkStart("MyBookmark");

		// Append the text "Text inside a bookmark" to the paragraph
		paragraph.appendText("Text inside a bookmark");

		// Append a bookmark end tag with the specified name "MyBookmark" to the paragraph
		paragraph.appendBookmarkEnd("MyBookmark");

		// Add line breaks to the paragraph (repeated 4 times)
		for (int i = 0; i < 4; i++) {
			paragraph.appendBreak(BreakType.Line_Break);
		}

		// Create a new field object
		Field field = new Field(document);

		// Set the field type to Field_Ref
		field.setType(FieldType.Field_Ref);

		// Set the field code to reference the bookmark named "MyBookmark" and include page number and hyperlink
		field.setCode("REF MyBookmark \\p \\h");

		// Add a new paragraph to the section
		paragraph = section.addParagraph();

		// Append the text "For more information, see " to the paragraph
		paragraph.appendText("For more information, see ");

		// Add the field as a child object of the paragraph
		paragraph.getChildObjects().add(field);

		// Add a field separator mark after the field
		FieldMark fieldSeparator = new FieldMark(document, FieldMarkType.Field_Separator);
		paragraph.getChildObjects().add(fieldSeparator);

		// Add a text range object with the text "above" after the field separator mark
		TextRange tr = new TextRange(document);
		tr.setText("above");
		paragraph.getChildObjects().add(tr);

		// Add a field end mark after the text range
		FieldMark fieldEnd = new FieldMark(document, FieldMarkType.Field_End);
		paragraph.getChildObjects().add(fieldEnd);

		// Specify the output file path
		String result = "output/CreateCrossReferenceToBookmark.docx";

		// Save the document to the specified output file in DOCX format (compatible with Word 2013)
		document.saveToFile(result, FileFormat.Docx_2013);

		// Dispose the document resources
		document.dispose();
    }
}
