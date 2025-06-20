import com.spire.doc.*;
import com.spire.doc.documents.*;

import java.awt.*;

public class setDiagonalBorder {
    public static void main(String[] args) {
        String output = "output/setDiagonalBorder.docx";

        // Create a new document object
        Document document = new Document();

        // Add a section to the document
        Section section = document.addSection();

        // Add a table to the section, with autofit behavior enabled
        Table table = section.addTable(true);

        // Reset the number of cells in the table to 4 columns and 3 rows
        table.resetCells(4, 3);

        // Set the horizontal alignment of the table to center
        table.getTableFormat().setHorizontalAlignment(RowAlignment.Center);

        // Set the diagonal down border for the first cell in the first row
        table.getFirstRow().getCells().get(0).getCellFormat().getBorders().getDiagonalDown().setBorderType(BorderStyle.Double);
        table.getFirstRow().getCells().get(0).getCellFormat().getBorders().getDiagonalDown().setColor(Color.GREEN);
        table.getFirstRow().getCells().get(0).getCellFormat().getBorders().getDiagonalDown().setLineWidth(2f);

        // Set the diagonal up border for the last cell in the table
        table.getLastCell().getCellFormat().getBorders().getDiagonalUp().setBorderType(BorderStyle.Single);
        table.getLastCell().getCellFormat().getBorders().getDiagonalUp().setColor(Color.RED);
        table.getLastCell().getCellFormat().getBorders().getDiagonalUp().setLineWidth(0.8f);

        // Save the document to the specified output file in DOCX format
        document.saveToFile(output, FileFormat.Docx);

        // Dispose the document resources
        document.dispose();
    }
}
