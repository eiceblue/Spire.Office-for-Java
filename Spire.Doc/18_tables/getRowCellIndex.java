import com.spire.doc.*;
import com.spire.doc.collections.TableCollection;

import java.io.*;

public class getRowCellIndex {
    public static void main(String[] args) throws IOException {
        // Create a new document object
        Document doc = new Document();

        // Load the document from file "data/ReplaceTextInTable.docx"
        doc.loadFromFile("data/ReplaceTextInTable.docx");

        // Get the first section of the document
        Section section = doc.getSections().get(0);

        // Get the first table in the section
        Table table = section.getTables().get(0);

        // Create a StringBuilder to store the content
        StringBuilder content = new StringBuilder();

        // Get the collection of tables in the section
        TableCollection collections = section.getTables();

        // Get the index of the table in the collection
        int tableIndex = collections.indexOf(table);

        // Get the last row in the table
        TableRow row = table.getLastRow();

        // Get the index of the row
        int rowIndex = row.getRowIndex();

        // Get the last cell in the row
        TableCell cell = (TableCell) row.getLastChild();

        // Get the index of the cell
        int cellIndex = cell.getCellIndex();

        // Append the table index, row index, and cell index to the content
        content.append("Table index is " + tableIndex);
        content.append("\r\n");
        content.append("Row index is " + rowIndex);
        content.append("\r\n");
        content.append("Cell index is " + cellIndex);

        // Specify the output file path
        String output = "output/GetRowCellIndex_out.txt";

        // Write the content to the output file
        writeStringToTxt(content.toString(), output);

        // Dispose the document resources
        doc.dispose();
    }

    public static void writeStringToTxt(String content, String txtFileName) throws IOException {
        File file = new File(txtFileName);
        if (file.exists()) {
            file.delete();
        }
        FileWriter fWriter = new FileWriter(txtFileName, true);
        try {
            fWriter.write(content);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fWriter.flush();
                fWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
