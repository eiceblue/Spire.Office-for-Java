import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;

public class image {
    public static void main(String[] args) throws Exception {
        String output = "output/image.docx";

        //create a word document and add a section
        Document document = new Document();
        Section section = document.addSection();

        //insert image
        insertImage(section);

        //save doc file.
        document.saveToFile(output, FileFormat.Docx);
    }

    private static void insertImage(Section section) throws Exception {
        //add paragraph
        Paragraph paragraph = section.addParagraph();
        paragraph.getFormat().setHorizontalAlignment(HorizontalAlignment.Left);
        //Add a image and set its width and height
        DocPicture picture = paragraph.appendPicture("data/spireDoc.png");
        picture.setWidth(100f);
        picture.setHeight(100f);

        paragraph = section.addParagraph();
        paragraph.getFormat().setLineSpacing(20f);
        TextRange tr = paragraph.appendText("Spire.Doc for Java is a professional Word Java library specially designed for developers to create, read, write, convert and print Word document files from any Java platform with fast and high quality performance. ");
        tr.getCharacterFormat().setFontName("Arial");
        tr.getCharacterFormat().setFontSize(14);

        section.addParagraph();
        paragraph = section.addParagraph();
        paragraph.getFormat().setLineSpacing(20f);
        tr = paragraph.appendText("As an independent Word Java component, Spire.Doc for Java doesn't need Microsoft Word to be installed on the machine. However, it can incorporate Microsoft Word document creation capabilities into any developers' Java applications.");
        tr.getCharacterFormat().setFontName("Arial");
        tr.getCharacterFormat().setFontSize(14);
    }
}
