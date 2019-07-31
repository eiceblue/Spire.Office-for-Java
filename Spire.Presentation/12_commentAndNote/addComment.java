import com.spire.presentation.*;
import java.awt.geom.Point2D;

public class addComment {
    public static void main(String[] args) throws Exception {
        String inputFile = "data/addComment.pptx";
        String outputFile = "output/addComment_result.pptx";
        Presentation ppt = new Presentation();
        ppt.loadFromFile(inputFile);
        //Comment author
        ICommentAuthor author = ppt.getCommentAuthors().addAuthor("E-iceblue", "comment:");
        //Add comment
        ppt.getSlides().get(0).addComment(author, "Add comment", new Point2D.Float(44, 19), new java.util.Date());
        //Save the document
        ppt.saveToFile(outputFile, FileFormat.PPTX_2010);
        ppt.dispose();
    }
}
