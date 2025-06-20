import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;

public class insertImageAtBookmark {
    public static void main(String[] args) {
        // Define input file paths
        String input1 = "data/bookmarks.docx";
        String input2 = "data/e-iceblue.png";

        // Define output file path
        String output = "output/insertImageAtBookmark.docx";

        // Create a new Document object
        Document doc = new Document();

        // Load the document from input1 file
        doc.loadFromFile(input1);

        // Create a BookmarksNavigator object using the loaded document
        BookmarksNavigator bn = new BookmarksNavigator(doc);

        // Move to the bookmark named "Test2"
        bn.moveToBookmark("Test2", true, true);

        // Create a new Section object
        Section section0 = doc.addSection();

        // Create a new Paragraph object
        Paragraph paragraph = section0.addParagraph();

        // Append the picture from input2 to the paragraph
        DocPicture picture = paragraph.appendPicture(input2);

        // Insert the paragraph at the current bookmark position
        bn.insertParagraph(paragraph);

        // Remove the section from the document
        doc.getSections().remove(section0);

        // Save the modified document to the output file
        doc.saveToFile(output, FileFormat.Docx);

        // Dispose the document object
        doc.dispose();
    }
}
