import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;

public class changeCase {
    public static void main(String[] args) {
        // Create a new document
        String input = "data/Text1.docx";
        Document doc = new Document();

        //Load from file
        doc.loadFromFile(input);

        TextRange textRange;
        //Get the first paragraph
        Paragraph para1 = doc.getSections().get(0).getParagraphs().get(1);

        //Set the text ranges' CharacterFormat to AllCaps
        for (Object docObj : para1.getChildObjects()) {
            DocumentObject obj=(DocumentObject)docObj;
            if ((obj instanceof TextRange)) {
                textRange = ((TextRange)(obj));
                textRange.getCharacterFormat().setAllCaps(true);
            }
        }

        //Get the forth paragraph
        Paragraph para2 = doc.getSections().get(0).getParagraphs().get(3);

        // //Set the text ranges' CharacterFormat to SmallCaps
        for (Object docObj : para2.getChildObjects()) {
            DocumentObject obj=(DocumentObject)docObj;
            if ((obj instanceof TextRange)) {
                textRange = ((TextRange)(obj));
                textRange.getCharacterFormat().isSmallCaps(true);
            }
        }

        //Save the document
        String output = "output/changeCase.docx";
        doc.saveToFile(output, FileFormat.Docx_2013);

        //Dispose the document
        doc.dispose();
    }
}
