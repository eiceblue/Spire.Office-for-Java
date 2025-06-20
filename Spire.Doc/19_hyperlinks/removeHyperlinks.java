import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;

import java.awt.*;
import java.util.ArrayList;

public class removeHyperlinks {
    public static void main(String[] args) {
        String input = "data/JAVAHyperlinksTemp_N.docx";

        // Create a new document object
        Document doc = new Document();

        // Load the document from the specified input file
        doc.loadFromFile(input);

        // Find all hyperlinks in the document and store them in an ArrayList
        ArrayList<Field> hyperlinks = FindAllHyperlinks(doc);

        // Iterate through the hyperlinks in reverse order and flatten them
        for (int i = hyperlinks.size() - 1; i >= 0; i--) {
            FlattenHyperlinks(hyperlinks.get(i));
        }

        // Specify the output file path
        String output = "output/RemoveHyperlinks.docx";

        // Save the modified document without hyperlinks to the specified output file in DOCX format
        doc.saveToFile(output, FileFormat.Docx);

        // Dispose the document resources
        doc.dispose();
    }

    // Find all hyperlinks in the document and return them as an ArrayList
    private static ArrayList<Field> FindAllHyperlinks(Document document) {
        ArrayList<Field> hyperlinks = new ArrayList<Field>();

        // Iterate through the sections of the document
        for (Section section : (Iterable<Section>) document.getSections()) {
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
        return hyperlinks;
    }

    // Flatten a hyperlink by removing its field structure and keeping only the displayed text
    private static void FlattenHyperlinks(Field field) {
        // Get the indices of the field and its related objects in the document structure
        int ownerParaIndex = field.getOwnerParagraph().getOwnerTextBody().getChildObjects().indexOf(field.getOwnerParagraph());
        int fieldIndex = field.getOwnerParagraph().getChildObjects().indexOf(field);
        int sepOwnerParaIndex = field.getSeparator().getOwnerParagraph().getOwnerTextBody().getChildObjects().indexOf(field.getSeparator().getOwnerParagraph());
        int sepIndex = field.getSeparator().getOwnerParagraph().getChildObjects().indexOf(field.getSeparator());
        int endIndex = field.getEnd().getOwnerParagraph().getChildObjects().indexOf(field.getEnd());
        int endOwnerParaIndex = field.getEnd().getOwnerParagraph().getOwnerTextBody().getChildObjects().indexOf(field.getEnd().getOwnerParagraph());

        // Format the text between the separator and the end of the field result
        FormatFieldResultText(field.getSeparator().getOwnerParagraph().getOwnerTextBody(), sepOwnerParaIndex, endOwnerParaIndex, sepIndex, endIndex);

        // Remove the end object of the field
        field.getEnd().getOwnerParagraph().getChildObjects().removeAt(endIndex);

        // Iterate through the objects to be removed and remove them from the document structure
        for (int i = sepOwnerParaIndex; i >= ownerParaIndex; i--) {
            if (i == sepOwnerParaIndex && i == ownerParaIndex) {
                for (int j = sepIndex; j >= fieldIndex; j--) {
                    field.getOwnerParagraph().getChildObjects().removeAt(j);
                }
            } else if (i == ownerParaIndex) {
                for (int j = field.getOwnerParagraph().getChildObjects().getCount() - 1; j >= fieldIndex; j--) {
                    field.getOwnerParagraph().getChildObjects().removeAt(j);
                }
            } else if (i == sepOwnerParaIndex) {
                for (int j = sepIndex; j >= 0; j--) {
                    field.getOwnerParagraph().getChildObjects().removeAt(j);
                }
            } else {
                field.getOwnerParagraph().getOwnerTextBody().getChildObjects().removeAt(i);
            }
        }
    }

    // Format the text within a field result based on specified indices
    private static void FormatFieldResultText(Body ownerBody, int sepOwnerParaIndex, int endOwnerParaIndex, int sepIndex, int endIndex) {
        for (int i = sepOwnerParaIndex; i <= endOwnerParaIndex; i++) {
            Paragraph para = (Paragraph) ownerBody.getChildObjects().get(i);
            if (i == sepOwnerParaIndex && i == endOwnerParaIndex) {
                // Iterate through the child objects in the paragraph between the separator and the end index
                for (int j = sepIndex + 1; j < endIndex; j++) {
                    FormatText((TextRange) para.getChildObjects().get(j));
                }
            } else if (i == sepOwnerParaIndex) {
                // Iterate through the remaining child objects in the paragraph starting from the separator index
                for (int j = sepIndex + 1; j < para.getChildObjects().getCount(); j++) {
                    FormatText((TextRange) para.getChildObjects().get(j));
                }
            } else if (i == endOwnerParaIndex) {
                // Iterate through the child objects in the paragraph up to the end index
                for (int j = 0; j < endIndex; j++) {
                    FormatText((TextRange) para.getChildObjects().get(j));
                }
            } else {
                // Iterate through all the child objects in the paragraph
                for (int j = 0; j < para.getChildObjects().getCount(); j++) {
                    FormatText((TextRange) para.getChildObjects().get(j));
                }
            }
        }
    }

    // Format the text range by setting the font color to black and removing underline
    private static void FormatText(TextRange tr) {
        tr.getCharacterFormat().setTextColor(Color.black);
        tr.getCharacterFormat().setUnderlineStyle(UnderlineStyle.None);
    }
}
