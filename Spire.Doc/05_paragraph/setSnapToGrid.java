import com.spire.doc.*;
import com.spire.doc.documents.*;

public class setSnapToGrid {
    public static void main(String[] args) {
        //Create word document.
        Document document = new Document();

        //Add a new section.
        Section section = document.addSection();

        //define Grid pitch type
        section.getPageSetup().setGridType(GridPitchType.Lines_Only);
        section.getPageSetup().setLinesPerPage(15);

        //Add a new paragraph.
        Paragraph paragraph = section.addParagraph();

        //Append Text.
        paragraph.appendText("With Spire.Doc, you can generate, modify, convert, render and print documents without utilizing Microsoft Word®. But you need MS Word viewer to view the resultant document. ");

        //Set snap to grid
        paragraph.getFormat().setSnapToGrid(true);

        //Save to file.
        document.saveToFile("output/setSnapToGrid.docx", FileFormat.Docx);

        //Dispose the document
        document.dispose();
    }
}
