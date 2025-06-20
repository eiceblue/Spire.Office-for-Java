import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;

import java.awt.*;

public class insertSymbol {
    public static void main(String[] args) {
        //Create Word document.
        Document document = new Document();

        //Add a section.
        Section section = document.addSection();

        //Add a paragraph.
        Paragraph paragraph = section.addParagraph();

        //Use unicode characters to create symbol Ä.
        TextRange tr = paragraph.appendText("\u00c4".toString());

        //Set the color of symbol Ä.
        tr.getCharacterFormat().setTextColor(Color.red);

        //Add symbol Ë.
        paragraph.appendText("\u00cb".toString());

        String result = "output/insertSymbol.docx";

        //Save to file.
        document.saveToFile(result, FileFormat.Docx_2013);

        //Dispose the document
        document.dispose();
    }
}
