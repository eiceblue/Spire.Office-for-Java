import com.spire.doc.*;
import com.spire.doc.documents.Paragraph;
import com.spire.doc.fields.Comment;

public class comment {
    public static void main(String[] args) {
        String input = "data/comment.docx";
        String output = "output/comment.docx";

        //load the document from disk.
        Document document = new Document();
        document.loadFromFile(input);

        insertComments(document.getSections().get(0));

        //save the document.
        document.saveToFile(output, FileFormat.Docx);
    }

    private static void insertComments(Section section) {
        //insert comment.
        Paragraph paragraph = section.getParagraphs().get(1);
        Comment comment = paragraph.appendComment("Spire.Doc for Java");
        comment.getFormat().setAuthor("E-iceblue");
        comment.getFormat().setInitial("CM");
    }
}
