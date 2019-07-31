import com.spire.doc.*;
import com.spire.doc.documents.*;

public class addOrDeleteRow {
    public static void main(String[] args) {

        String inputFile="data/tableSample.docx";
        String outputFile="output/addOrDeleteRow.docx";

        //create a document
        Document document = new Document();
        //load file
        document.loadFromFile(inputFile);

        Section section = document.getSections().get(0);
        Table table = section.getTables().get(0);

        //delete the seventh row
        table.getRows().removeAt(7);

        //add a row and insert it into specific position
        TableRow row = new TableRow(document);
        for (int i = 0; i < table.getRows().get(0).getCells().getCount(); i++) {
            TableCell tc = row.addCell();
            Paragraph paragraph = tc.addParagraph();
            paragraph.getFormat().setHorizontalAlignment(HorizontalAlignment.Center);
            paragraph.appendText("Added");
        }
        table.getRows().insert(2, row);

        //add a row at the end of table
        table.addRow();

        //save to file
        document.saveToFile(outputFile, FileFormat.Docx);
    }
}
