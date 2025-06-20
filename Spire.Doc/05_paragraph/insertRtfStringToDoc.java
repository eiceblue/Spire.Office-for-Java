import com.spire.doc.*;
import com.spire.doc.documents.*;

public class insertRtfStringToDoc {
    public static void main(String[] args) {
        //Create Word document.
        Document document = new Document();

        //Add a new section.
        Section section = document.addSection();

        //Add a paragraph to the section.
        Paragraph para = section.addParagraph();

        //Declare a String variable to store the Rtf string.
        String rtfString = "{\\rtf1\\ansi\\deff0 {\\fonttbl {\\f0 hakuyoxingshu7000;}}\\f0\\fs28 Hello, World}";

        // Append Rtf string to paragraph.
        para.appendRTF(rtfString);

        String result = "output/insertRtfStringToDoc.docx";

        // Save to file.
        document.saveToFile(result, FileFormat.Docx);

        //Dispose the document
        document.dispose();
    }
}
