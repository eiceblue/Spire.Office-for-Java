import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.DocPicture;

public class setVerticalAlignment {
    public static void main(String[] args) {
        // Create a new document object
        Document doc = new Document();

        // Add a section to the document
        Section section = doc.addSection();

        // Add a table to the section, with autofit behavior enabled
        Table table = section.addTable(true);

        // Reset the number of cells in the table to 3 columns and 3 rows
        table.resetCells(3, 3);

        // Apply vertical merge for the cells in the first column, from row 0 to row 2
        table.applyVerticalMerge(0, 0, 2);

        // Set the vertical alignment of specific cells in the table
        table.getRows().get(0).getCells().get(0).getCellFormat().setVerticalAlignment(VerticalAlignment.Middle);
        table.getRows().get(0).getCells().get(1).getCellFormat().setVerticalAlignment(VerticalAlignment.Top);
        table.getRows().get(0).getCells().get(2).getCellFormat().setVerticalAlignment(VerticalAlignment.Top);
        table.getRows().get(1).getCells().get(1).getCellFormat().setVerticalAlignment(VerticalAlignment.Middle);
        table.getRows().get(1).getCells().get(2).getCellFormat().setVerticalAlignment(VerticalAlignment.Middle);
        table.getRows().get(2).getCells().get(1).getCellFormat().setVerticalAlignment(VerticalAlignment.Bottom);
        table.getRows().get(2).getCells().get(2).getCellFormat().setVerticalAlignment(VerticalAlignment.Bottom);

        // Add a paragraph to the cell at row 0, column 0 and insert an image
        Paragraph paraPic = table.getRows().get(0).getCells().get(0).addParagraph();
        DocPicture pic = paraPic.appendPicture("data/E-iceblue.png");

        // Define the data for the table
        String[][] data = {
                {"", "Spire.Office", "Spire.DataExport"},
                {"", "Spire.Doc", "Spire.DocViewer"},
                {"", "Spire.XLS", "Spire.PDF"}
        };

        // Populate the table with data
        for (int r = 0; r < 3; r++) {
            TableRow dataRow = table.getRows().get(r);
            dataRow.setHeight(50f);
            for (int c = 0; c < 3; c++) {
                if (c == 1) {
                    // Add a paragraph to the cell and set its content and width
                    Paragraph par = dataRow.getCells().get(c).addParagraph();
                    par.appendText(data[r][c]);
                    dataRow.getCells().get(c).setCellWidth((section.getPageSetup().getClientWidth()) / 2, CellWidthType.Point);
                }
                if (c == 2) {
                    // Add a paragraph to the cell and set its content and width
                    Paragraph par = dataRow.getCells().get(c).addParagraph();
                    par.appendText(data[r][c]);
                    dataRow.getCells().get(c).setCellWidth((section.getPageSetup().getClientWidth()) / 2, CellWidthType.Point);
                }
            }
        }

        // Specify the output file path
        String output = "output/SetVerticalAlignment.docx";

        // Save the document to the specified output file in DOCX format
        doc.saveToFile(output, FileFormat.Docx);

        // Dispose the document resources
        doc.dispose();
    }
}
