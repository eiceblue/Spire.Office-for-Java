import com.spire.doc.*;
import com.spire.doc.documents.rendering.*;
import java.awt.*;

public class preserveWordBookmarks {
    public static void main(String[] args) {

        // Specify the input file path for the Word document to be processed
        String inputFile = "data/preserveWordBookmarks.doc";

        // Specify the output file path for the resulting PDF document
        String outputFile = "output/preserveWordBookmarks.pdf";

        // Create a new instance of the Document class
        Document document = new Document();

        // Load the Word document from the specified input file
        document.loadFromFile(inputFile);

        // Create an instance of the ToPdfParameterList class to specify parameters for conversion to PDF
        ToPdfParameterList toPdf = new ToPdfParameterList();

        // Set the option to create bookmarks from Word document bookmarks in the resulting PDF document
        toPdf.setCreateWordBookmarks(true);

        // Set the title for the created bookmarks in the PDF document
        toPdf.setWordBookmarksTitle("Bookmark");

        // Set the color for the created bookmarks in the PDF document
        toPdf.setWordBookmarksColor(Color.GRAY);

        // Set the bookmark layout event handler for customizing the appearance of bookmarks
        document.BookmarkLayout = new BookmarkLevelHandler() {
            @Override
            public void invoke(Object sender, BookmarkLevelEventArgs args) {
                document_BookmarkLayout(sender, args);
            }
        };

        // Save the document to the specified output file in PDF format, using the specified conversion parameters
        document.saveToFile(outputFile, toPdf);

        // Dispose of system resources associated with the document
        document.dispose();
    }

    // Custom bookmark layout event handler method for setting the color and style of bookmarks
    private static void document_BookmarkLayout(Object sender, BookmarkLevelEventArgs args) {

        // Check the level of the bookmark
        if (args.getBookmarkLevel().getLevel() == 2) {
            // Set color to red and style to bold for level 2 bookmarks
            args.getBookmarkLevel().setColor(Color.RED);
            args.getBookmarkLevel().setStyle(BookmarkTextStyle.Bold);
        } else if (args.getBookmarkLevel().getLevel() == 3) {
            // Set color to gray and style to italic for level 3 bookmarks
            args.getBookmarkLevel().setColor(Color.GRAY);
            args.getBookmarkLevel().setStyle(BookmarkTextStyle.Italic);
        } else {
            // Set color to green and style to regular for other bookmark levels
            args.getBookmarkLevel().setColor(Color.GREEN);
            args.getBookmarkLevel().setStyle(BookmarkTextStyle.Regular);
        }
    }
}
