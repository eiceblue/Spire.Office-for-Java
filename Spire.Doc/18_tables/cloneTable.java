import com.spire.doc.*;

public class cloneTable {
    public static void main(String[] args) {
        String input = "data/TableTemplate.docx";

        // Create a new Document instance
        Document doc = new Document();

        // Load the document from the input file
        doc.loadFromFile(input);

        // Get the first section of the document
        Section se = doc.getSections().get(0);

        // Get the original table from the section
        Table original_Table = se.getTables().get(0);

        // Deep clone the original table to create a copy
        Table copied_Table = original_Table.deepClone();

        // Set the text for the last row in the copied table
        String[] st = new String[]{"Spire.Presentation for Java", "A professional " +
                "PowerPoint® compatible library that enables developers to create, read, " +
                "write, modify, convert and Print PowerPoint documents in Java Applications"};
        TableRow lastRow = copied_Table.getRows().get(copied_Table.getRows().getCount() - 1);
        for (int i = 0; i < lastRow.getCells().getCount() - 1; i++) {
            lastRow.getCells().get(i).getParagraphs().get(0).setText(st[i]);
        }

        // Add the copied table to the section
        se.getTables().add(copied_Table);

        // Specify the output file path
        String output = "output/CloneTable.docx";

        // Save the modified document to the output file in Docx format
        doc.saveToFile(output, FileFormat.Docx);

        // Dispose of the document object to release resources
        doc.dispose();
    }
}
