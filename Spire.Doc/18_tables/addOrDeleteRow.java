import com.spire.doc.*;
import com.spire.doc.documents.*;

public class addOrDeleteRow {
    public static void main(String[] args) {
        String input = "data/tableSample.docx";
        String output = "output/addOrDeleteRow.docx";

        // Create a new document object
        Document document = new Document();

        // Load the document from the input file
        document.loadFromFile(input);

        // Get the first section of the document
        Section section = document.getSections().get(0);

        // Get the first table in the section
        Table table = section.getTables().get(0);

        // Remove the row at index 7 from the table
        table.getRows().removeAt(7);

        // Create a new table row
        TableRow row = new TableRow(document);

        // Add cells to the new row with centered paragraphs containing "Added" text
        for (int i = 0; i < table.getRows().get(0).getCells().getCount(); i++) {
            TableCell tc = row.addCell();
            Paragraph paragraph = tc.addParagraph();
            paragraph.getFormat().setHorizontalAlignment(HorizontalAlignment.Center);
            paragraph.appendText("Added");
        }

        // Insert the new row at index 2 in the table
        table.getRows().insert(2, row);

        // Add a new row at the end of the table
        table.addRow();

        // Save the modified document to the output file
        document.saveToFile(output, FileFormat.Docx);

        // Dispose of the document object to release resources
        document.dispose();
    }
}

