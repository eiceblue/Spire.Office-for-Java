import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;

import java.util.ArrayList;

public class updateImage {
    public static void main(String[] args) {
        String input1 = "data/imageTemplate.docx";
        String input2 = "data/e-iceblue.png";
        String output = "output/updateImage.docx";

        // Create a new Document object
        Document doc = new Document();

        // Load the document from input1 file
        doc.loadFromFile(input1);

        // Create an ArrayList to store DocumentObject instances of pictures
        ArrayList<DocumentObject> pictures = new ArrayList<>();

        // Iterate through each section in the document
        for (int i = 0; i < doc.getSections().getCount(); i++) {
            // Get the current section
            Section sec = doc.getSections().get(i);

            // Iterate through each paragraph in the section
            for (int p = 0; p < sec.getParagraphs().getCount(); p++) {
                // Get the current paragraph
                Paragraph para = sec.getParagraphs().get(p);

                // Iterate through each child object in the paragraph
                for (int o = 0; o < para.getChildObjects().getCount(); o++) {
                    // Get the current child object
                    DocumentObject docObj = para.getChildObjects().get(o);

                    // Check if the child object is a Picture
                    if (docObj.getDocumentObjectType() == DocumentObjectType.Picture) {
                        // Add the picture object to the pictures ArrayList
                        pictures.add(docObj);
                    }
                }
            }
        }

        // Get the first picture from the pictures ArrayList
        DocPicture picture = (DocPicture) pictures.get(0);

        // Load the image from input2 file to the picture object
        picture.loadImage(input2);

        // Save the modified document to the output file in Docx format
        doc.saveToFile(output, FileFormat.Docx);

        // Dispose of the document object to release resources
        doc.dispose();
    }
}
