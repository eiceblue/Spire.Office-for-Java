import com.spire.doc.*;
import com.spire.doc.fields.*;

public class addCoverImage {
    public static void main(String[] args) {
        // Create a new Document object
        Document doc = new Document();

        // Load the document from the specified file path ("data/ToEpub.doc")
        doc.loadFromFile("data/ToEpub.doc");

        // Create a DocPicture object using the loaded document
        DocPicture picture = new DocPicture(doc);

        // Load the image to be added as a cover ("data/Cover.png")
        picture.loadImage("data/Cover.png");

        // Specify the output file path for the resulting EPUB file
        String result = "output/addCoverImage.epub";

        // Save the document to EPUB format with the added cover image
        doc.saveToEpub(result, picture);

        // Clean up system resources associated with the Document object
        doc.dispose();
    }
}
