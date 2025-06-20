import com.spire.doc.*;
import com.spire.doc.collections.FieldCollection;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;

public class convertIfFieldToText {
    public static void main(String[] args) {
     
		// Create a new document object and load the document from the specified input file "data/IfFieldSample.docx"
		Document document = new Document("data/IfFieldSample.docx");

		// Get the collection of fields in the document
		FieldCollection fields = document.getFields();

		// Iterate through each field in the collection
		for (int i = 0; i < fields.getCount(); i++) {
			Field field = fields.get(i);
			
			// Check if the field type is Field_If
			if (field.getType().equals(FieldType.Field_If)) {
				
				// Cast the field to TextRange to access its properties
				TextRange original = (TextRange) field;
				
				// Get the field text
				String text = field.getFieldText();
				
				// Create a new TextRange with the same text as the field
				TextRange textRange = new TextRange(document);
				textRange.setText(text);
				
				// Set the character format of the new TextRange to match the original field's font name and size
				textRange.getCharacterFormat().setFontName(original.getCharacterFormat().getFontName());
				textRange.getCharacterFormat().setFontSize(original.getCharacterFormat().getFontSize());

				// Get the owner paragraph of the field
				Paragraph par = field.getOwnerParagraph();
				
				// Get the index of the field within the child objects of the paragraph
				int index = par.getChildObjects().indexOf(field);
				
				// Remove the field from the paragraph's child objects
				par.getChildObjects().removeAt(index);
				
				// Insert the new TextRange at the same index within the paragraph's child objects
				par.getChildObjects().insert(index, textRange);
			}
		}

		// Specify the output file path
		String result = "output/ConvertIfFieldToText.docx";

		// Save the modified document to the specified output file in DOCX format
		document.saveToFile(result, FileFormat.Docx);

		// Dispose the document resources
		document.dispose();
    }
}
