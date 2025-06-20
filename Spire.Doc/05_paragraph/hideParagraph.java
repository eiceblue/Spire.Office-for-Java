import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;

public class hideParagraph {
    public static void main(String[] args) {
        //Create Word document.
        Document document = new Document();

        // Load the file from disk.
        document.loadFromFile("data/Template_Docx_1.docx");

        //Get the first section
        Section sec = document.getSections().get(0);

        //Get the first paragraph
        Paragraph para = sec.getParagraphs().get(0);

        // Loop through the textranges and
        for (Object docObj : para.getChildObjects()) {
            DocumentObject obj = (DocumentObject)docObj;
            if ((obj instanceof TextRange)) {
                TextRange range = ((TextRange)(obj));

                //Set CharacterFormat's Hidden property as true to hide the texts.
                range.getCharacterFormat().setHidden(true);
            }
        }

        String result = "output/hideParagraph.docx";

        // Save to file.
        document.saveToFile(result, FileFormat.Docx_2013);

        //Dispose the document
        document.dispose();
    }
}
