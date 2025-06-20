import com.spire.doc.*;
import com.spire.doc.documents.*;

public class insertDocAtBookmark {
    public static void main(String[] args) {
        // Set the input file path for the first document containing bookmarks
        String input1 = "data/bookmarks.docx";

        // Set the input file path for the second document to be inserted
        String input2 = "data/insert-LL.docx";

        // Set the output file path for the merged document with inserted content
        String output = "output/insertDocAtBookmark.docx";

        // Create a new instance of the Document class for the first document
        Document document1 = new Document();

        // Load the first document from the specified input file
        document1.loadFromFile(input1);

        // Create a new instance of the Document class for the second document
        Document document2 = new Document();

        // Load the second document from the specified input file
        document2.loadFromFile(input2);

        // Get the first section of the first document
        Section section1 = document1.getSections().get(0);

        // Create a BookmarksNavigator for the first document
        BookmarksNavigator bn = new BookmarksNavigator(document1);

        // Move to the bookmark position named "Test2" in the first document, preserving formatting and expanding the
        // selection
        bn.moveToBookmark("Test2", true, true);

        // Get the BookmarkStart object at the current bookmark position
        BookmarkStart start = bn.getCurrentBookmark().getBookmarkStart();

        // Get the owner paragraph of the BookmarkStart
        Paragraph para = start.getOwnerParagraph();

        // Get the index of the owner paragraph within the body of the first document's section
        int index = section1.getBody().getChildObjects().indexOf(para);

        // Iterate through the sections and paragraphs of the second document
        for (int i = 0; i < document2.getSections().getCount(); i++) {
            for (int j = 0; j < document2.getSections().get(i).getParagraphs().getCount(); j++) {
                // Deep clone each paragraph from the second document
                Paragraph insertPara = (Paragraph)document2.getSections().get(i).getParagraphs().get(j).deepClone();

                // Insert the cloned paragraph into the body of the first document's section, incrementing the index
                section1.getBody().getChildObjects().insert(index++ + 1, insertPara);
            }
        }

        // Save the modified first document to the specified output file in DOCX format
        document1.saveToFile(output, FileFormat.Docx);

        // Dispose of the document objects to release resources
        document1.dispose();
        document2.dispose();
    }
}
