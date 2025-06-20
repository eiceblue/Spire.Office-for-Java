import com.spire.doc.*;
import com.spire.doc.documents.*;

import java.awt.*;

public class createTableDirectly {
    public static void main(String[] args) {
        // Create a new document object
        Document doc = new Document();

        // Add a section to the document
        Section section = doc.addSection();

        // Create a table object
        Table table = new Table(doc);

        // Set the preferred width of the table to 100% of the page width
        table.setPreferredWidth(new PreferredWidth(WidthType.Percentage, (short) 100));

        // Set the border type of the table to single line
        table.getTableFormat().getBorders().setBorderType(BorderStyle.Single);

        // Create a new row for the table
        TableRow row = new TableRow(doc);
        row.setHeight(50.0f);
        table.getRows().add(row);

        // Create the first cell in the row
        TableCell cell1 = new TableCell(doc);
        Paragraph para1 = cell1.addParagraph();
        para1.appendText("Row 1, Cell 1");
        para1.getFormat().setHorizontalAlignment(HorizontalAlignment.Center);
        cell1.getCellFormat().setBackColor(Color.lightGray);
        cell1.getCellFormat().setVerticalAlignment(VerticalAlignment.Middle);
        row.getCells().add(cell1);

        // Create the second cell in the row
        TableCell cell2 = new TableCell(doc);
        Paragraph para2 = cell2.addParagraph();
        para2.appendText("Row 1, Cell 2");
        para2.getFormat().setHorizontalAlignment(HorizontalAlignment.Center);
        cell2.getCellFormat().setBackColor(Color.lightGray);
        cell2.getCellFormat().setVerticalAlignment(VerticalAlignment.Middle);
        row.getCells().add(cell2);

        // Add the table to the section
        section.getTables().add(table);

        // Specify the output file path
        String output = "output/CreateTableDirectly_out.docx";

        // Save the document to the specified file format
        doc.saveToFile(output, FileFormat.Docx_2013);

        // Dispose the document resources
        doc.dispose();
    }
}
