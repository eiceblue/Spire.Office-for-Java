import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;

public class startFromFormField {
    public static void main(String[] args) {
        //Create the source document
        Document sourceDocument = new Document();

        // Load the source document from disk.
        sourceDocument.loadFromFile("data/TextInputField-Az.docx");

        //Create a destination document
        Document destinationDoc = new Document();

        //Add a section
        Section section = destinationDoc.addSection();

        //Define a variables
        int index = 0;

        // Traverse FormFields
        for ( Object fieldObj: sourceDocument.getSections().get(0).getBody().getFormFields()) {
            FormField field = (FormField)fieldObj;

            // Find FieldFormTextInput type field
            if (field.getType() == FieldType.Field_Form_Text_Input) {
                // Get the paragraph
                Paragraph paragraph = field.getOwnerParagraph();
                // Get the index
                index = sourceDocument.getSections().get(0).getBody().getChildObjects().indexOf(paragraph);
                break;
            }
        }

        // Extract the content
        for (int i = index; i < (index + 3); i++) {
            // Clone the ChildObjects of source document
            DocumentObject doobj = sourceDocument.getSections().get(0).getBody().getChildObjects().get(i).deepClone();
            // Add to destination document
            section.getBody().getChildObjects().add(doobj);
        }

        // Save the document.
        destinationDoc.saveToFile("output/startFromFormField.docx", FileFormat.Docx);

        //Dispose the document
        sourceDocument.dispose();
        destinationDoc.dispose();
    }
}
