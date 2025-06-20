import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;

import java.awt.*;

public class formatMergedCells {
    public static void main(String[] args) {
        // Create a new document object
        Document document = new Document();

        // Add a section to the document
        Section section = document.addSection();

        // Add a table to the section using the addTable method
        Table table = addTable(section);

        // Create a new paragraph style
        ParagraphStyle style = new ParagraphStyle(document);
        style.setName("Style");
        style.getCharacterFormat().setTextColor(Color.cyan);
        style.getCharacterFormat().setItalic(true);
        style.getCharacterFormat().setBold(true);
        style.getCharacterFormat().setFontSize(13);
        document.getStyles().add(style);

        // Apply horizontal merge to cells in the table
        table.applyHorizontalMerge(0, 0, 1);

        // Apply the style to the first cell in the table
        table.get(0, 0).getParagraphs().get(0).applyStyle(style.getName());
        table.get(0, 0).getCellFormat().setVerticalAlignment(VerticalAlignment.Middle);
        table.get(0, 0).getParagraphs().get(0).getFormat().setHorizontalAlignment(HorizontalAlignment.Center);

        // Apply vertical merge to cells in the table
        table.applyVerticalMerge(0, 1, 3);

        // Apply the style to the second cell in the table
        table.get(1, 0).getParagraphs().get(0).applyStyle(style.getName());
        table.get(1, 0).getCellFormat().setVerticalAlignment(VerticalAlignment.Middle);
        table.get(1, 0).getParagraphs().get(0).getFormat().setHorizontalAlignment(HorizontalAlignment.Left);

        // Set the width of the second cell in the table
        table.get(1, 0).setCellWidth(20, CellWidthType.Percentage);

        // Specify the output file path
        String output = "output/formatMergedCells.docx";

        // Save the document to the specified file format
        document.saveToFile(output, FileFormat.Docx);

        // Dispose the document resources
        document.dispose();
    }

    // Method to add a table to the section with specified data
    private static Table addTable(Section section) {
        Table table = section.addTable(true);

        // Specify the number of rows and columns for the table
        table.resetCells(4, 3);
        String[][] data =
                {
                        new String[]{"Product", "", "Price"},
                        new String[]{"Spire.Doc", "Pro Edition", "$799"},
                        new String[]{"", "Standard Edition", "$599"},
                        new String[]{"", "Free Edition", "$0"},
                };

        for (int r = 0; r < data.length; r++) {
            TableRow dataRow = table.getRows().get(r);
            dataRow.setHeight(20);
            dataRow.setHeightType(TableRowHeightType.Exactly);
            dataRow.getRowFormat().setBackColor(Color.white);
            for (int c = 0; c < dataRow.getCells().getCount(); c++) {
                if (data[r][c] != null && data[r][c] != "") {
                    TextRange range = dataRow.getCells().get(c).addParagraph().appendText(data[r][c]);
                    range.getCharacterFormat().setFontName("Arial");
                }
            }
        }

        return table;
    }
}
