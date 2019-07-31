import com.spire.doc.*;
import com.spire.doc.documents.rendering.*;
import java.awt.*;

public class preserveWordBookmarks {
    public static void main(String[] args) {

        String inputFile="data/preserveWordBookmarks.doc";
        String outputFile="output/preserveWordBookmarks.pdf";

        Document document = new Document();
        document.loadFromFile(inputFile);

        ToPdfParameterList toPdf = new ToPdfParameterList();
        toPdf.setCreateWordBookmarks(true);
        toPdf.setWordBookmarksTitle("Bookmark");
        toPdf.setWordBookmarksColor(Color.GRAY);

        //the event of BookmarkLayout occurs when drawing a bookmark
        document.BookmarkLayout = new BookmarkLevelHandler() {
            @Override
            public void invoke(Object sender, BookmarkLevelEventArgs args) {
                document_BookmarkLayout(sender, args);
            }
        };

        //save the document to a PDF file.
        document.saveToFile(outputFile, toPdf);
    }
    private static void document_BookmarkLayout(Object sender, BookmarkLevelEventArgs args) {

        if (args.getBookmarkLevel().getLevel() == 2) {
            args.getBookmarkLevel().setColor(Color.RED);
            args.getBookmarkLevel().setStyle(BookmarkTextStyle.Bold);
        } else if (args.getBookmarkLevel().getLevel() == 3) {
            args.getBookmarkLevel().setColor(Color.GRAY);
            args.getBookmarkLevel().setStyle(BookmarkTextStyle.Italic);
        } else {
            args.getBookmarkLevel().setColor(Color.GREEN);
            args.getBookmarkLevel().setStyle(BookmarkTextStyle.Regular);
        }
    }
}
