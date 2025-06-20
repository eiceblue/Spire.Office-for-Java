import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;

import java.awt.*;

public class setTransparentColorForImage {
    public static void main(String[] args) {
        String input = "data/imageTemplate.docx";
        String output = "output/setTransparentColorForImage.docx";

        // Create a new Document object
        Document doc = new Document();

        // Load the document from the input file
        doc.loadFromFile(input);

        // Get the first paragraph in the first section of the document
        Paragraph paragraph = doc.getSections().get(0).getParagraphs().get(0);

        // Iterate through each child object in the paragraph
        for (int i = 0; i < paragraph.getChildObjects().getCount(); i++) {
            // Get the current child object
            DocumentObject obj = paragraph.getChildObjects().get(i);

            // Check if the child object is a DocPicture
            if (obj instanceof DocPicture) {
                // Cast the child object to DocPicture
                DocPicture picture = (DocPicture) obj;

                // Set the transparent color of the picture to blue
                picture.setTransparentColor(Color.BLUE);
            }
        }

        // Save the modified document to the output file in Docx format
        doc.saveToFile(output, FileFormat.Docx);

        // Dispose of the document object to release resources
        doc.dispose();
    }
}
