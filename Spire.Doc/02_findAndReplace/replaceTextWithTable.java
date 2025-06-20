import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;

public class replaceTextWithTable {
    public static void main(String[] args) {
        //Create word document.
        Document document = new Document();

        // Load the file from disk.
        document.loadFromFile("data/Template_Docx_1.docx");

        //Get the first section
        Section section = document.getSections().get(0);

        //Return TextSection by finding the key text string "Christmas Day, December 25".
        TextSelection selection = document.findString("Christmas Day, December 25", true, true);

        //Return TextRange from TextSection
        TextRange range = selection.getAsOneRange();

        //Get Owner-Paragraph
        Paragraph paragraph = range.getOwnerParagraph();

        //Get the owner TextBody
        Body body = paragraph.getOwnerTextBody();

        // Get the index of paragraph
        int index = body.getChildObjects().indexOf(paragraph);

        //Create a new table.
        Table table = section.addTable(true);

        //Set the number of rows and columns
        table.resetCells(3, 3);

        // Remove the paragraph and
        body.getChildObjects().remove(paragraph);

        //Insert table into the collection at the specified index.
        body.getChildObjects().insert(index, table);

        String result = "output/replaceTextWithTable.docx";

        // Save to file.
        document.saveToFile(result, FileFormat.Docx_2013);

        //Dispose the document
        document.dispose();
    }
}
