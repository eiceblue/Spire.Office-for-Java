import com.spire.doc.*;

public class combineAndSplitTables {
    public static void main(String[] args) {
        // Combine tables
        CombineTables();

        // Split a table
        SplitTable();
    }

    private static void CombineTables() {
        // Load document from disk
        Document doc = new Document();
        doc.loadFromFile("data/CombineAndSplitTables.docx");

        // Get the first section
        Section section = doc.getSections().get(0);

        // Get the first and second table
        Table table1 = section.getTables().get(0);
        Table table2 = section.getTables().get(1);

        // Add the rows of table2 to table1
        for (int i = 0; i < table2.getRows().getCount(); i++) {
            table1.getRows().add(table2.getRows().get(i).deepClone());
        }

        // Remove table2
        section.getTables().remove(table2);

        // Save the Word file
        String output = "output/CombineTables_out.docx";
        section.getDocument().saveToFile(output, FileFormat.Docx);

        //Dispose of the document object to release resources
        doc.dispose();
    }

    private static void SplitTable() {
        // Load document from disk
        Document doc = new Document();
        doc.loadFromFile("data/CombineAndSplitTables.docx");

        // Get the first section
        Section section = doc.getSections().get(0);

        // Get the first table
        Table table = section.getTables().get(0);

        // We will split the table at the third row
        int splitIndex = 2;

        // Create a new table for the split table
        Table newTable = new Table(section.getDocument());

        // Add rows to the new table
        for (int i = splitIndex; i < table.getRows().getCount(); i++) {
            newTable.getRows().add(table.getRows().get(i).deepClone());
        }

        // Remove rows from the original table
        for (int i = table.getRows().getCount() - 1; i >= splitIndex; i--) {
            table.getRows().removeAt(i);
        }

        // Add the new table in section
        section.getTables().add(newTable);

        // Save the Word file
        String output = "output/SplitTable_out.docx";
        section.getDocument().saveToFile(output, FileFormat.Docx);

        //Dispose of the document object to release resources
        doc.dispose();
    }
}
