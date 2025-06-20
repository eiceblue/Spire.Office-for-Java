import com.spire.doc.*;
import com.spire.doc.documents.*;
public class copyParagraph {
    public static void main(String[] args) {
        //Create Word document1.
        Document document1 = new Document();

        // Load the file from disk.
        document1.loadFromFile("data/Template_Docx_5.docx");

        //Create a new document.
        Document document2 = new Document();

        //Get paragraph 1 and paragraph 2 in document1.
        Section s = document1.getSections().get(0);
        Paragraph p1 = s.getParagraphs().get(0);
        Paragraph p2 = s.getParagraphs().get(1);

        //Copy p1 and p2 to document2.
        Section s2 = document2.addSection();
        Paragraph NewPara1 = ((Paragraph)(p1.deepClone()));
        s2.getParagraphs().add(NewPara1);
        Paragraph NewPara2 = ((Paragraph)(p2.deepClone()));
        s2.getParagraphs().add(NewPara2);

        //Add watermark.
        PictureWatermark WM = new PictureWatermark();
        WM.setPicture("data/Logo.jpg");
        document2.setWatermark(WM);

        String result = "output/copyParagraph.docx";

        // Save the file.
        document2.saveToFile(result, FileFormat.Docx_2013);

        //Dispose the document
        document1.dispose();
        document2.dispose();
    }
}
