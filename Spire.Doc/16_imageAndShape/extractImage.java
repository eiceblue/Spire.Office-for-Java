import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;
import com.spire.doc.interfaces.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;

public class extractImage {
    public static void main(String[] args) throws IOException {
        String input = "data/extractImage.docx";

        // Create a new Document object and load it from the input file
        Document document = new Document(input);

        // Create a Queue to store composite objects
        Queue<ICompositeObject> nodes = new LinkedList<ICompositeObject>();

        // Add the document as the first node in the queue
        nodes.add(document);

        // Create a List to store extracted images
        List<BufferedImage> images = new ArrayList<BufferedImage>();

        // Traverse the document tree using breadth-first search
        while (nodes.size() > 0) {
            // Retrieve and remove the next node from the queue
            ICompositeObject node = nodes.poll();

            // Iterate through the child objects of the current node
            for (int i = 0; i < node.getChildObjects().getCount(); i++) {
                // Get the current child object
                IDocumentObject child = node.getChildObjects().get(i);

                // Check if the child object is a composite object
                if (child instanceof ICompositeObject) {
                    // Add the composite object to the queue for further traversal
                    nodes.add((ICompositeObject) child);
                    if (child.getDocumentObjectType() == DocumentObjectType.Picture) 
                 {
                    // Extract the image from the picture and add it to the list
                    DocPicture picture = (DocPicture) child;
                    images.add(picture.getImage());
		}
                }
            }
        }

        // Iterate through the extracted images and save them to separate files
        for (int i = 0; i < images.size(); i++) {
            File file = new File(String.format("output/extractImageAndText-%d.png", i));
            ImageIO.write(images.get(i), "PNG", file);
        }

        // Clean up resources associated with the document
        document.dispose();
    }
}
