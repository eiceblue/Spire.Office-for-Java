import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;
import java.util.regex.*;

public class replaceContentWithDoc {
    public static void main(String[] args) {
        //Create word document
        Document document1 = new Document();

        // Load the first document from disk
        document1.loadFromFile("data/ReplaceContentWithDoc.docx");

        //Create word document
        Document document2 = new Document();

        // Load the second document from disk
        document2.loadFromFile("data/Insert.docx");

        //Get the first section of the first document
        Section section1 = document1.getSections().get(0);

        //Create a regex
        Pattern regex=Pattern.compile("\\[MY_DOCUMENT\\]");

        //Find the text by regex
        TextSelection[] textSections = document1.findAllPattern(regex);

        //Travel the found pattern
        for (TextSelection seletion : textSections) {
            // Get the paragraph
            Paragraph para = seletion.getAsOneRange().getOwnerParagraph();
            // Get textRange
            TextRange textRange = seletion.getAsOneRange();
            // Get the para index
            int index = section1.getBody().getChildObjects().indexOf(para);

            //Insert the paragraphs of document2
            for (Object sectionObj: document2.getSections()) {
                Section section2=(Section)sectionObj;
                for (Object paragraphObj : section2.getParagraphs()) {
                    Paragraph paragraph=(Paragraph)paragraphObj;
                    section1.getBody().getChildObjects().insert(index, paragraph.deepClone());
                }
            }

            // Remove the found textRange
            para.getChildObjects().remove(textRange);
        }

        // Save the document.
        document1.saveToFile("output/replaceContentWithDoc.docx", FileFormat.Docx_2013);

        //Dispose the documents
        document1.dispose();
        document2.dispose();
    }
}
