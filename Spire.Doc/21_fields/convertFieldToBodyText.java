import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;

public class convertFieldToBodyText {
    public static void main(String[] args) {

		// Create a new source document object
		Document sourceDocument = new Document();

		// Load the document from the specified input file "data/TextInputField.docx"
		sourceDocument.loadFromFile("data/TextInputField.docx");

		// Iterate through each form field in the first section of the document
		for (FormField field : (Iterable<FormField>) sourceDocument.getSections().get(0).getBody().getFormFields()) {

			// Check if the form field type is Field_Form_Text_Input
			if (field.getType().equals(FieldType.Field_Form_Text_Input)) {
				
				// Get the owner paragraph of the form field
				Paragraph paragraph = field.getOwnerParagraph();
				
				int startIndex = 0;
				int endIndex = 0;

				// Create a new text range with the content of the paragraph
				TextRange textRange = new TextRange(sourceDocument);
				textRange.setText(paragraph.getText());

				// Find the start and end index of the bookmark tags in the paragraph's child objects
				for (DocumentObject obj : (Iterable<DocumentObject>)paragraph.getChildObjects()) {
					if (obj.getDocumentObjectType().equals(DocumentObjectType.Bookmark_Start)) {
						startIndex = paragraph.getChildObjects().indexOf(obj);
					}
					if (obj.getDocumentObjectType().equals(DocumentObjectType.Bookmark_End)) {
						endIndex = paragraph.getChildObjects().indexOf(obj);
					}
				}

				// Remove any form fields or other objects between the bookmark tags
				for (int i = endIndex; i > startIndex; i--) {
					if (paragraph.getChildObjects().get(i) instanceof TextFormField) {
						TextFormField textFormField = (TextFormField) paragraph.getChildObjects().get(i);

						// Remove the text form field
						paragraph.getChildObjects().remove(textFormField);
					} else {
						// Remove the object at the specified index
						paragraph.getChildObjects().removeAt(i);
					}
				}

				// Insert the text range at the start index of the bookmark tags
				paragraph.getChildObjects().insert(startIndex, textRange);
				
				// Exit the loop after processing the first form field
				break;
			}
		}

		// Specify the output file path
		String output = "output/ConvertFieldToBodyText.docx";

		// Save the modified document to the specified output file in DOCX format
		sourceDocument.saveToFile(output, FileFormat.Docx);

		// Dispose the source document resources
		sourceDocument.dispose();
    }
}
