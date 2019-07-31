import com.spire.doc.*;
import com.spire.doc.documents.DocumentObjectType;
import com.spire.doc.fields.DocPicture;
import com.spire.doc.interfaces.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;

public class extractImage {
    public static void main(String[] args) throws IOException {
        String input = "data/extractImage.docx";

        //open document
        Document document = new Document(input);

        //document elements, each of them has child elements
        Queue<ICompositeObject> nodes = new LinkedList<ICompositeObject>();

        nodes.add(document);

        //embedded images list.
        List<BufferedImage> images = new ArrayList<BufferedImage>();

        //traverse
        while (nodes.size() > 0) {
            ICompositeObject node = nodes.poll();

            for (int i = 0; i < node.getChildObjects().getCount(); i++) {
                IDocumentObject child = node.getChildObjects().get(i);
                if (child instanceof ICompositeObject) {
                    nodes.add((ICompositeObject) child);

                    if (child.getDocumentObjectType() == DocumentObjectType.Picture) {
                        DocPicture picture = (DocPicture) child;
                        images.add(picture.getImage());
                    }
                }
            }
        }
        //save images
        for (int i = 0; i < images.size(); i++) {
            File file = new File(String.format("output/extractImageAndText-%d.png", i));
            ImageIO.write(images.get(i), "PNG", file);
        }
    }
}
