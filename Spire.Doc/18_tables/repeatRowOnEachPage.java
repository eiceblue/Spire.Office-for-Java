import com.spire.doc.*;
import com.spire.doc.documents.*;

import java.awt.*;

public class repeatRowOnEachPage {
    public static void main(String[] args) {
        // Create a new document object
        Document document = new Document();

        // Add a section to the document
        Section section = document.addSection();

        // Add a table to the section, with autofit behavior enabled
        Table table = section.addTable(true);

        // Set the preferred width of the table to 100% of the available width
        PreferredWidth width = new PreferredWidth(WidthType.Percentage, (short) 100);
        table.setPreferredWidth(width);

        // Add a header row to the table
        TableRow row = table.addRow();
        row.isHeader(true);
        row.getRowFormat().setBackColor(Color.lightGray);

        // Add a cell to the header row with a width of 100% of the available width and centered contents
        TableCell cell = row.addCell();
        cell.setCellWidth(100, CellWidthType.Percentage);
        Paragraph paragraph = cell.addParagraph();
        paragraph.appendText("Row Header 1");
        paragraph.getFormat().setHorizontalAlignment(HorizontalAlignment.Center);

        // Add another header row to the table
        row = table.addRow(false, 1);
        row.isHeader(true);
        row.getRowFormat().setBackColor(Color.orange);
        row.setHeight(30f);

        // Add a cell to the second header row with a width of 100% of the available width, vertically aligned in the middle, and centered contents
        cell = row.getCells().get(0);
        cell.setCellWidth(100, CellWidthType.Percentage);
        cell.getCellFormat().setVerticalAlignment(VerticalAlignment.Middle);
        paragraph = cell.addParagraph();
        paragraph.appendText("Row Header 2");
        paragraph.getFormat().setHorizontalAlignment(HorizontalAlignment.Center);

        // Add multiple rows and cells to the table
        for (int i = 0; i < 70; i++) {
            row = table.addRow(false, 2);
            cell = row.getCells().get(0);
            cell.setCellWidth(50f, CellWidthType.Percentage);
            cell.addParagraph().appendText("Column 1 Text");
            cell = row.getCells().get(1);
            cell.setCellWidth(50f, CellWidthType.Percentage);
            cell.addParagraph().appendText("Column 2 Text");
        }

        // Set background color for alternate rows of the table
        for (int j = 1; j < table.getRows().getCount(); j++) {
            if (j % 2 == 0) {
                TableRow row2 = table.getRows().get(j);
                for (int f = 0; f < row2.getCells().getCount(); f++) {
                    row2.getCells().get(f).getCellFormat().setBackColor(Color.PINK);
                }
            }
        }

        // Specify the output file path
        String result = "output/RepeatRowOnEachPage_out.docx";

        // Save the document to the specified output file in DOCX format
        document.saveToFile(result, FileFormat.Docx);

        // Dispose the document resources
        document.dispose();
    }
}
