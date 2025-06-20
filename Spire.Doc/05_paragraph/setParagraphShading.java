import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;
import java.awt.*;

public class setParagraphShading {
    public static void main(String[] args) {
        //Create Word document.
        Document document = new Document();

        //Load the file from disk.
        document.loadFromFile("data/Template_Docx_1.docx");

        //Get a paragraph.
        Paragraph paragaph = document.getSections().get(0).getParagraphs().get(0);

        //Set background color for the paragraph.
        paragaph.getFormat().setBackColor(Color.yellow);

        //Set background color for the selected text of paragraph.
        paragaph = document.getSections().get(0).getParagraphs().get(2);

        //Get the target string
        TextSelection selection = paragaph.find("Christmas", true, false);

        //Get the text selection as a text range
        TextRange range = selection.getAsOneRange();

        //Get the format and set background color
        range.getCharacterFormat().setTextBackgroundColor(Color.yellow);

        String result = "output/setParagraphShading.docx";

        //Save to file.
        document.saveToFile(result, FileFormat.Docx_2013);

        //Dispose the document
        document.dispose();
    }
}
