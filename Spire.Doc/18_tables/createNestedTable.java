import com.spire.doc.*;

public class createNestedTable {
    public static void main(String[] args) {
        // Create a new document
        Document doc = new Document();
        Section section = doc.addSection();

        // Add a table
        Table table = section.addTable(true);
        table.resetCells(2, 2);

        // Set column width
        table.getRows().get(0).getCells().get(0).setCellWidth(70f,CellWidthType.Point);
        table.getRows().get(1).getCells().get(0).setCellWidth(70f,CellWidthType.Point);
        table.autoFit(AutoFitBehaviorType.Auto_Fit_To_Window);

        // Insert content to cells
        table.get(0, 0).addParagraph().appendText("Spire.Doc for Java");
        String text = "Spire.Doc for Java is a professional Word" +
                "Java library specifically designed for developers to create," +
                "read, write, convert and print Word document files from Java" +
                "platform with fast and high quality performance.";
        table.get(0, 1).addParagraph().appendText(text);

        // Add a nested table to cell (first row, second column)
        Table nestedTable = table.get(0, 1).addTable(true);
        nestedTable.resetCells(4, 3);
        nestedTable.autoFit(AutoFitBehaviorType.Auto_Fit_To_Contents);

        // Add content to nested cells
        nestedTable.get(0, 0).addParagraph().appendText("NO.");
        nestedTable.get(0, 1).addParagraph().appendText("Item");
        nestedTable.get(0, 2).addParagraph().appendText("Price");

        nestedTable.get(1, 0).addParagraph().appendText("1");
        nestedTable.get(1, 1).addParagraph().appendText("Pro Edition");
        nestedTable.get(1, 2).addParagraph().appendText("$799");

        nestedTable.get(2, 0).addParagraph().appendText("2");
        nestedTable.get(2, 1).addParagraph().appendText("Standard Edition");
        nestedTable.get(2, 2).addParagraph().appendText("$599");

        nestedTable.get(3, 0).addParagraph().appendText("3");
        nestedTable.get(3, 1).addParagraph().appendText("Free Edition");
        nestedTable.get(3, 2).addParagraph().appendText("$0");

        // Save the document
        String output = "output/CreateNestedTable.docx";
        doc.saveToFile(output, FileFormat.Docx_2013);

        // Dispose the document object to release resources
        doc.dispose();
    }
}
