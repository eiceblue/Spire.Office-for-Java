import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;

public class insertPageBreakFirstApproach {
    public static void main(String[] args) {
        // Create a new Document object
        Document document = new Document();

        // Load an existing document from the specified file path
        document.loadFromFile("data/Template_Docx_2.docx");

        // Find all occurrences of the word "technology" in the document and retrieve their locations
        TextSelection[] selections = document.findAllString("technology", false, true);

        // Iterate over the found text selections
        for (int i = 0; i < selections.length; i++) {
            TextSelection ts = selections[i];

            // Get the range of the current text selection
            TextRange range = ts.getAsOneRange();

            // Get the paragraph that contains the selected text
            Paragraph paragraph = range.getOwnerParagraph();

            // Get the index of the range within its parent paragraph
            int index = paragraph.getChildObjects().indexOf(range);

            // Create a page break object
            Break pageBreak = new Break(document, BreakType.Page_Break);

            // Insert the page break after the range within the paragraph
            paragraph.getChildObjects().insert(index + 1, pageBreak);
        }

        // Specify the output file path for the modified document
        String result = "output/result-insertPageBreakAtSpecifiedLocation.docx";

        // Save the modified document to the specified file path in the Docx format compatible with Word 2013
        document.saveToFile(result, FileFormat.Docx_2013);

        // Dispose of the document object to release resources
        document.dispose();
    }
}
