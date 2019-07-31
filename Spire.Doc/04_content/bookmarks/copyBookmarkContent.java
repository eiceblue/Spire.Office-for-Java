import com.spire.doc.*;
import com.spire.doc.documents.*;

public class copyBookmarkContent {
    public static void main(String[] args) {
        String input = "data/bookmark.docx";
        String output = "output/copyBookmarkContent.docx";

        //load the document from disk.
        Document doc = new Document();
        doc.loadFromFile(input);

        //get the bookmark by name.
        Bookmark bookmark = doc.getBookmarks().get("Test");
        DocumentObject docObj = null;

        //judge if the paragraph includes the bookmark exists in the table,
        //if it exists in cell,then need to find its outermost parent object(Table),
        //and get the start/end index of current object on body.
        if (((Paragraph) bookmark.getBookmarkStart().getOwner()).isInCell()) {
            docObj = bookmark.getBookmarkStart().getOwner().getOwner().getOwner().getOwner();
        } else {
            docObj = bookmark.getBookmarkStart().getOwner();
        }
        int startIndex = doc.getSections().get(0).getBody().getChildObjects().indexOf(docObj);
        if (((Paragraph) bookmark.getBookmarkEnd().getOwner()).isInCell()) {
            docObj = bookmark.getBookmarkEnd().getOwner().getOwner().getOwner().getOwner();
        } else {
            docObj = bookmark.getBookmarkEnd().getOwner();
        }
        int endIndex = doc.getSections().get(0).getBody().getChildObjects().indexOf(docObj);

        //get the start/end index of the bookmark object on the paragraph.
        Paragraph para = (Paragraph) bookmark.getBookmarkStart().getOwner();
        int pStartIndex = para.getChildObjects().indexOf(bookmark.getBookmarkStart());
        para = (Paragraph) bookmark.getBookmarkEnd().getOwner();
        int pEndIndex = para.getChildObjects().indexOf(bookmark.getBookmarkEnd());

        //get the content of current bookmark and copy.
        TextBodySelection select = new TextBodySelection(doc.getSections().get(0).getBody(), startIndex, endIndex, pStartIndex, pEndIndex);
        TextBodyPart body = new TextBodyPart(select);
        for (int i = 0; i < body.getBodyItems().getCount(); i++) {
            doc.getSections().get(0).getBody().getChildObjects().add(body.getBodyItems().get(i).deepClone());
        }

        //save the document.
        doc.saveToFile(output, FileFormat.Docx);
    }
}
