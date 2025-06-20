import com.spire.doc.*;
import com.spire.doc.documents.*;

import java.awt.*;

public class addTableByArray {
    public static void main(String[] args) {
        String output = "output/addTableByArray.docx";

        // Create a new document object
        Document document = new Document();

        // Add a section to the document
        Section section = document.addSection();

        // Create a new paragraph style with specific formatting
        ParagraphStyle style = new ParagraphStyle(document);
        style.getCharacterFormat().setFontSize(20f);
        style.getCharacterFormat().setBold(true);
        style.getCharacterFormat().setTextColor(Color.ORANGE);

        // Add the style to the document's styles collection
        document.getStyles().add(style);

        // Add a paragraph to the section and set its text as "Table"
        Paragraph para = section.addParagraph();
        para.appendText("Table");

        // Set the horizontal alignment of the paragraph to center
        para.getFormat().setHorizontalAlignment(HorizontalAlignment.Center);

        // Apply the previously created style to the paragraph
        para.applyStyle(style.getName());

        // Add a table to the section with headers enabled
        Table table = section.addTable(true);

        // Define the data for the table
        String[][] data = {
                {"Name", "Capital", "Continent", "Area", "Population"},
                {"Argentina", "Buenos Aires", "South America", "2777815", "32300003"},
                {"Bolivia", "La Paz", "South America", "1098575", "7300000"},
                {"Brazil", "Brasilia", "South America", "8511196", "150400000"},
        };

        int rowCount = data.length;
        int columnCount = data[0].length;

        // Reset the cells of the table with the specified row and column count
        table.resetCells(rowCount, columnCount);

        // Populate the table with the data
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                table.getRows().get(i).getCells().get(j).addParagraph().appendText(data[i][j]);
            }
        }

        // Save the modified document to the output file
        document.saveToFile(output, FileFormat.Docx);

        // Dispose of the document object to release resources
        document.dispose();
    }
}
