import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.Field;

import java.io.*;
import java.util.ArrayList;

public class findHyperlinks {
    public static void main(String[] args) throws IOException {
        String input = "data/JAVAHyperlinksTemp_N.docx";

        // Create a new document object
        Document doc = new Document();

        // Load the document from the specified input file
        doc.loadFromFile(input);

        // Create an ArrayList to store hyperlink fields and a string to hold the extracted hyperlinks' text
        ArrayList<Field> hyperlinks = new ArrayList<Field>();
        String hyperlinksText = "";

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

                                // Append the field's text to the hyperlinksText string
                                hyperlinksText += field.getFieldText() + "\r\n";
                            }
                        }
                    }
                }
            }
        }

        // Specify the output file path
        String output = "output/HyperlinksText.txt";

        // Write the hyperlinks text to a text file
        writeStringToTxt(hyperlinksText, output);

        // Dispose the document resources
        doc.dispose();
    }

    public static void writeStringToTxt(String content, String txtFileName) throws IOException {
        File file = new File(txtFileName);
        if (file.exists()) {
            file.delete();
        }
        FileWriter fWriter = new FileWriter(txtFileName, true);
        try {
            fWriter.write(content);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fWriter.flush();
                fWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
