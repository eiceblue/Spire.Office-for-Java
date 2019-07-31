import com.spire.doc.*;
import com.spire.doc.documents.Paragraph;

public class helloWorld {
    public static void main(String[] args) {
        String output = "output/helloWorld.docx";
        //create Word document
        Document document = new Document();

        //create a new section
        Section section = document.addSection();

        //create a new paragraph
        Paragraph paragraph = section.addParagraph();

        //append text
        paragraph.appendText("Hello World!");

        //save the file
        document.saveToFile(output, FileFormat.Docx);
    }
}
