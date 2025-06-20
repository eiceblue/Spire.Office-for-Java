import com.spire.doc.*;
import com.spire.doc.collections.*;
import com.spire.doc.documents.*;

public class insertPageBreakSecondApproach {
    public static void main(String[] args) {
        // Create a new Document object
        Document document = new Document();

        // Load an existing document from the specified file path
        document.loadFromFile("data/Template_Docx_1.docx");

        // Get the first section of the document and access its paragraphs
        Section section = document.getSections().get(0);
        ParagraphCollection paragraphs = section.getParagraphs();

        // Append a page break to the fourth paragraph in the section
        paragraphs.get(3).appendBreak(BreakType.Page_Break);

        // Specify the output file path for the modified document
        String result = "output/result-insertPageBreakSecondApproach.docx";

        // Save the modified document to the specified file path in the Docx format compatible with Word 2013
        document.saveToFile(result, FileFormat.Docx_2013);

        // Dispose of the document object to release resources
        document.dispose();
    }
}
