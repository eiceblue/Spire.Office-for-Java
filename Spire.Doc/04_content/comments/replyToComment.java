import com.spire.doc.*;
import com.spire.doc.FileFormat;
import com.spire.doc.fields.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class replyToComment {
    public static void main(String[] args) throws IOException {
        String inputImage = "data/logo.png";
        String input = "data/replyToComment.docx";
        String output = "output/replyToComment.docx";
        //load the document from disk.
        Document doc = new Document();
        doc.loadFromFile(input);

        //get the first comment.
        Comment comment1 = doc.getComments().get(0);

        //create a new comment and specify the author and content.
        Comment replyComment1 = new Comment(doc);
        replyComment1.getFormat().setAuthor("E-iceblue");
        replyComment1.getBody().addParagraph().appendText("Spire.Doc for Java is a professional Word Java library on operating Word documents.");

        //add the new comment as a reply to the selected comment.
        comment1.replyToComment(replyComment1);

        DocPicture docPicture = new DocPicture(doc);
        BufferedImage img = ImageIO.read(new File(inputImage));
        docPicture.loadImage(img);
        //insert a picture in the comment
        replyComment1.getBody().getParagraphs().get(0).getChildObjects().add(docPicture);

        //save the document.
        doc.saveToFile(output, FileFormat.Docx);
    }
}
