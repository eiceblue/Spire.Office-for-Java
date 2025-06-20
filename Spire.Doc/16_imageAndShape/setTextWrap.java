import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;

public class setTextWrap {
    public static void main(String[] args) {
        String input = "data/imageTemplate.docx";
        String output = "output/setTextWrap.docx";

        // Create a new Document object
        Document doc = new Document();

        // Load the document from the input file
        doc.loadFromFile(input);

        // Iterate through each section in the document
        for (int i = 0; i < doc.getSections().getCount(); i++) {
            // Get the current section
            Section sec = doc.getSections().get(i);

            // Iterate through each paragraph in the section
            for (int j = 0; j < sec.getParagraphs().getCount(); j++) {
                // Get the current paragraph
                Paragraph para = sec.getParagraphs().get(j);

                // Iterate through each child object in the paragraph
                for (int p = 0; p < para.getChildObjects().getCount(); p++) {
                    // Get the current child object
                    DocumentObject docObj = para.getChildObjects().get(p);

                    // Check if the child object is a Picture
                    if (docObj.getDocumentObjectType() == DocumentObjectType.Picture) {
                        // Cast the child object to DocPicture
                        DocPicture picture = (DocPicture) docObj;

                        // Set the text wrapping style of the picture to Through
                        picture.setTextWrappingStyle(TextWrappingStyle.Through);

                        // Set the text wrapping type of the picture to Both
                        picture.setTextWrappingType(TextWrappingType.Both);
                    }
                }
            }
        }

        // Save the modified document to the output file in Docx format
        doc.saveToFile(output, FileFormat.Docx);

        // Dispose of the document object to release resources
        doc.dispose();
    }
}
