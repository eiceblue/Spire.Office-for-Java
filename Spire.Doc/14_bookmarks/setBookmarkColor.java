import com.spire.doc.*;
import java.awt.*;

public class setBookmarkColor {
    public static void main(String[] args) {
        // Define the input file path for the document to be loaded
        String input = "data/bookmarkTemplate.docx";

        // Define the output file path for the PDF with modified bookmark settings
        String output = "output/setBookmarkColor.pdf";

        // Create a new Document instance
        Document doc = new Document();

        // Load the document from the specified input file
        doc.loadFromFile(input);

        // Create a ToPdfParameterList instance to specify the PDF conversion settings
        ToPdfParameterList toPdf = new ToPdfParameterList();

        // Enable the creation of Word bookmarks in the PDF
        toPdf.setCreateWordBookmarks(true);

        // Set the title of the Word bookmarks in the PDF
        toPdf.setWordBookmarksTitle("Changed bookmark");

        // Set the color of the Word bookmarks to gray
        toPdf.setWordBookmarksColor(Color.gray);

        // Set the bookmark layout handler for the document
        doc.BookmarkLayout = new com.spire.doc.documents.rendering.BookmarkLevelHandler() {
            @Override
            public void invoke(Object sender, com.spire.doc.documents.rendering.BookmarkLevelEventArgs args) {
                document_BookmarkLayout(sender, args);
            }
        };

        // Save the modified document to the specified output file in PDF format with the specified PDF conversion
        // settings
        doc.saveToFile(output, toPdf);

        // Dispose of the document resources
        doc.dispose();
    }

    // Custom method to handle bookmark layout customization
    private static void document_BookmarkLayout(Object sender,
        com.spire.doc.documents.rendering.BookmarkLevelEventArgs args) {
        // Customize bookmark appearance based on its level
        if (args.getBookmarkLevel().getLevel() == 2) {
            args.getBookmarkLevel().setColor(Color.red);
            args.getBookmarkLevel().setStyle(BookmarkTextStyle.Bold);
        } else if (args.getBookmarkLevel().getLevel() == 3) {
            args.getBookmarkLevel().setColor(Color.gray);
            args.getBookmarkLevel().setStyle(BookmarkTextStyle.Italic);
        } else {
            args.getBookmarkLevel().setColor(Color.green);
            args.getBookmarkLevel().setStyle(BookmarkTextStyle.Regular);
        }
    }
}
