import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;

import java.awt.*;

public class setSpacing {
    public static void main(String[] args) {
        //Create Word document.
        Document document = new Document();

        //Load the file from disk.
        document.loadFromFile("data/Template_Docx_1.docx");

        //Create a new paragraph
        Paragraph para = new Paragraph(document);

        //Append some texts
        TextRange textRange1 = para.appendText("This is an inserted paragraph.");

        //Set text color
        textRange1.getCharacterFormat().setTextColor(Color.BLUE);

        //Set font size
        textRange1.getCharacterFormat().setFontSize(15);

        //set the spacing before and after.
        para.getFormat().setBeforeAutoSpacing(false);
        para.getFormat().setBeforeSpacing(10);
        para.getFormat().setAfterAutoSpacing(false);
        para.getFormat().setAfterSpacing(10);

        //insert the added paragraph to the first section.
        document.getSections().get(0).getParagraphs().insert(1, para);

        String result = "output/setSpacing.docx";

        //Save to file.
        document.saveToFile(result, FileFormat.Docx_2013);

        //Dispose the document
        document.dispose();
    }
}
