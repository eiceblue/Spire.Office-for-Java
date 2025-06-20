import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;
import java.util.*;

public class fromBookmark {
    public static void main(String[] args) {
        //Create the first document.
        Document sourcedocument = new Document();
        // Load the source document from disk.
        sourcedocument.loadFromFile("data/Bookmark.docx");

        //Create a destination document.
        Document destinationDoc = new Document();
        //Add a section for destination document.
        Section section = destinationDoc.addSection();

        //Add a paragraph for destination document.
        Paragraph paragraph = section.addParagraph();
        //Locate the bookmark in source document.
        BookmarksNavigator navigator = new BookmarksNavigator(sourcedocument);
        // Find bookmark by name.
        navigator.moveToBookmark("Test", true, true);
        //get text body part.
        TextBodyPart textBodyPart = navigator.getBookmarkContent();

        //Create a TextRange type list.
        List<TextRange> list = new ArrayList<TextRange>();

        // Traverse the items of text body
        for (Object item : textBodyPart.getBodyItems()) {
            // if it is paragraph
            if ((item instanceof Paragraph)) {
                // Traverse the ChildObjects of the paragraph
                for (Object childObject : ((Paragraph)(item)).getChildObjects()) {
                    // if it is TextRange
                    if ((childObject instanceof TextRange)) {
                        // Add it into list
                        TextRange range = ((TextRange)(childObject));
                        list.add(range);
                    }
                }
            }
        }

        // Add the extract content to destinationDoc document
        for (int m = 0; m < list.size(); m++) {
            paragraph.getItems().add(list.get(m).deepClone());
        }

        // Save the document.
        destinationDoc.saveToFile("output/fromBookmark.docx", FileFormat.Docx);

        //Dispose the documents
        sourcedocument.dispose();
        destinationDoc.dispose();
    }
}
