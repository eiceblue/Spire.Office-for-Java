import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;

public class replaceWithImage {
    public static void main(String[] args) {
        //Create word document.
        Document doc = new Document();

        // Load the file from disk.
        doc.loadFromFile("data/Template.docx");

        //Find the string "E-iceblue" in the document.
        TextSelection[] selections = doc.findAllString("E-iceblue", true, true);
        int index = 0;
        TextRange range = null;

        // Remove the text and replace it with image.
        for (TextSelection selection : selections) {

            //Create a DocPicture
            DocPicture pic = new DocPicture(doc);

            //Load an image
            pic.loadImage("data/E-iceblue.png");

            //Get the TextRange
            range = selection.getAsOneRange();

            // Get the index of the TextRange
            index = range.getOwnerParagraph().getChildObjects().indexOf(range);

            //Insert the picture
            range.getOwnerParagraph().getChildObjects().insert(index, pic);

            // Remove the text
            range.getOwnerParagraph().getChildObjects().remove(range);
        }

        String output = "output/replaceWithImage.docx";

        // Save to file.
        doc.saveToFile(output, FileFormat.Docx);

        //Dispose the document
        doc.dispose();
    }
}
