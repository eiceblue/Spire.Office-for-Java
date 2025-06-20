import com.spire.doc.*;

public class addOrRemoveColumn {
    public static void main(String[] args) {
        String input = "data/tableSample.docx";
        String output = "output/addOrRemoveColumn.docx";

        // Create a new document object
        Document doc = new Document();

        // Load the document from the input file
        doc.loadFromFile(input);

        // Get the first section of the document
        Section section = doc.getSections().get(0);

        // Get the first table in the section
        Table table = section.getTables().get(0);

        int columnIndex1 = 0;

        // Add a column to the table at columnIndex1
        addColumn(table, columnIndex1);

        int columnIndex2 = 2;

        // Remove the column at columnIndex2 from the table
        removeColumn(table, columnIndex2);

        // Save the modified document to the output file
        doc.saveToFile(output, FileFormat.Docx);

        // Dispose of the document object to release resources
        doc.dispose();
    }

    // Method to add a column to the table at a specific columnIndex
    private static void addColumn(Table table, int columnIndex) {
        for (int r = 0; r < table.getRows().getCount(); r++) {
            TableCell addCell = new TableCell(table.getDocument());
            table.getRows().get(r).getCells().insert(columnIndex, addCell);
        }
    }

    // Method to remove a column from the table at a specific columnIndex
    private static void removeColumn(Table table, int columnIndex) {
        for (int r = 0; r < table.getRows().getCount(); r++) {
            table.getRows().get(r).getCells().removeAt(columnIndex);
        }
    }
}
