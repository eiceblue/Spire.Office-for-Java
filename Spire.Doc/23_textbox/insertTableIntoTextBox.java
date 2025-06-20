import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;

public class insertTableIntoTextBox {
    public static void main(String[] args) {

        // Create a new Document object
        Document doc = new Document();

        // Add a new section to the document
        Section section = doc.addSection();

        // Add a paragraph to the section
        Paragraph paragraph = section.addParagraph();

        // Append a text box with width 300 and height 100 to the paragraph
        TextBox textbox = paragraph.appendTextBox(300, 100);

        // Set the horizontal origin and position of the text box relative to the page
        textbox.getFormat().setHorizontalOrigin(HorizontalOrigin.Page);
        textbox.getFormat().setHorizontalPosition(140);

        // Set the vertical origin and position of the text box relative to the page
        textbox.getFormat().setVerticalOrigin(VerticalOrigin.Page);
        textbox.getFormat().setVerticalPosition(50);

        // Add a paragraph to the text box body and set the text to "Table 1"
        Paragraph textboxParagraph = textbox.getBody().addParagraph();
        TextRange textboxRange = textboxParagraph.appendText("Table 1");

        // Set the font name of the text to Arial
        textboxRange.getCharacterFormat().setFontName("Arial");

        // Add a table to the text box body
        Table table = textbox.getBody().addTable(true);

        // Reset the table to have 4 rows and 4 columns
        table.resetCells(4, 4);

        // Define the data for the table
        String[][] data = new String[][]
                {
                        {"Name", "Age", "Gender", "ID"},
                        {"John", "28", "Male", "0023"},
                        {"Steve", "30", "Male", "0024"},
                        {"Lucy", "26", "female", "0025"}
                };

        // Loop through the table data and add it to the table cells
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                TextRange tableRange = table.getRows().get(i).getCells().get(j).addParagraph().appendText(data[i][j]);

                // Set the font name of the text in the table cells to Arial
                tableRange.getCharacterFormat().setFontName("Arial");
            }
        }

        // Apply a style called "Table_Colorful_2" to the table
        table.applyStyle(DefaultTableStyle.Table_Colorful_2);

        // Define the output file path for saving the document
        String output = "output/insertTableIntoTextBox.docx";

        // Save the document to a file in DOCX format (2013 version) with the specified output file path
        doc.saveToFile(output, FileFormat.Docx_2013);

        // Dispose of the document object to release resources
        doc.dispose();
    }
}
