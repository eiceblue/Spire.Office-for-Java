import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.formatting.CellFormat;

import java.awt.*;

public class modifyTableFormat {
    public static void main(String[] args) {
        // Create a new document object
        Document document = new Document();

        // Load the document from file "data/ModifyTableFormat.docx"
        document.loadFromFile("data/ModifyTableFormat.docx");

        // Get the first section of the document
        Section section = document.getSections().get(0);

        // Get the tables in the section
        Table tb1 = section.getTables().get(0);
        Table tb2 = section.getTables().get(1);
        Table tb3 = section.getTables().get(2);

        // Modify the format of table tb1
        MoidfyTableFormat(tb1);

        // Modify the format of table tb2
        ModifyRowFormat(tb2);

        // Modify the format of table tb3
        ModifyCellFormat(tb3);

        // Specify the output file path
        String output = "output/ModifyTableFormat_out.docx";

        // Save the modified document to the output file in DOCX format
        document.saveToFile(output, FileFormat.Docx_2013);

        // Dispose the document resources
        document.dispose();
    }

    // Method to modify the table format
    private static void MoidfyTableFormat(Table table) {
        // Set the preferred width of the table
        table.setPreferredWidth(new PreferredWidth(WidthType.Twip, (short) 6000));

        // Apply a predefined table style to the table
        table.applyStyle(DefaultTableStyle.Table_3_Deffects_2);

        // Set padding for all sides of the table
        table.getTableFormat().getPaddings().setAll(5f);

        // Set the title and description for the table
        table.setTitle("Spire.Doc for Java");
        table.setTableDescription("Spire.Doc for Java is a professional Word Java library");
    }

    // Method to modify the row format
    private static void ModifyRowFormat(Table table) {
        // Set the cell spacing for the first row
        table.getRows().get(0).getRowFormat().setCellSpacing(2f);

        // Set the height of the second row to a specific value
        table.getRows().get(1).setHeightType(TableRowHeightType.Exactly);
        table.getRows().get(1).setHeight(20f);

        // Set the background color for the third row
        table.getRows().get(2).getRowFormat().setBackColor(Color.gray);
    }

    // Method to modify the cell format
    private static void ModifyCellFormat(Table table) {
        // Set vertical alignment and horizontal alignment for the cell in the first row and first column
        table.getRows().get(0).getCells().get(0).getCellFormat().setVerticalAlignment(VerticalAlignment.Middle);
        table.getRows().get(0).getCells().get(0).getParagraphs().get(0).getFormat().setHorizontalAlignment(HorizontalAlignment.Center);

        // Set the background color for the cell in the second row and first column
        table.getRows().get(1).getCells().get(0).getCellFormat().setBackColor(Color.gray);

        // Set borders for the cell in the third row and first column
        CellFormat cellFormat = table.getRows().get(2).getCells().get(0).getCellFormat();
        cellFormat.getBorders().setBorderType(BorderStyle.Single);
        cellFormat.getBorders().setLineWidth(1f);
        cellFormat.getBorders().getLeft().setColor(Color.red);
        cellFormat.getBorders().getRight().setColor(Color.red);
        cellFormat.getBorders().getTop().setColor(Color.red);
        cellFormat.getBorders().getBottom().setColor(Color.red);

        // Set text direction for the cell in the fourth row and first column
        table.getRows().get(3).getCells().get(0).getCellFormat().setTextDirection(TextDirection.Right_To_Left);
    }
}
