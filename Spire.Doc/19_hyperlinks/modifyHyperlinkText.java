import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.Field;

import java.util.ArrayList;

public class modifyHyperlinkText {
    public static void main(String[] args) {
        String input = "data/JAVAHyperlinksTemp_N.docx";

        // Create a new document object
        Document doc = new Document();

        // Load the document from the specified input file
        doc.loadFromFile(input);

        // Create an ArrayList to store hyperlink fields
        ArrayList<Field> hyperlinks = new ArrayList<Field>();

        // Iterate through the sections of the document
        for (Section section : (Iterable<Section>) doc.getSections()) {
            // Iterate through the child objects in the section's body
            for (DocumentObject object : (Iterable<DocumentObject>) section.getBody().getChildObjects()) {
                // Check if the object is a paragraph
                if (object.getDocumentObjectType().equals(DocumentObjectType.Paragraph)) {
                    Paragraph paragraph = (Paragraph) object;
                    // Iterate through the child objects in the paragraph
                    for (DocumentObject cObject : (Iterable<DocumentObject>) paragraph.getChildObjects()) {
                        // Check if the child object is a field
                        if (cObject.getDocumentObjectType().equals(DocumentObjectType.Field)) {
                            Field field = (Field) cObject;
                            // Check if the field type is a hyperlink
                            if (field.getType().equals(FieldType.Field_Hyperlink)) {
                                // Add the hyperlink field to the list
                                hyperlinks.add(field);
                            }
                        }
                    }
                }
            }
        }

        // Modify the text of the first hyperlink field in the list
        hyperlinks.get(0).setFieldText("Modified Text");

        // Specify the output file path
        String output = "output/ModifyHyperlinkText.docx";

        // Save the modified document to the specified output file in DOCX format
        doc.saveToFile(output, FileFormat.Docx);

        // Dispose the document resources
        doc.dispose();
    }
}
