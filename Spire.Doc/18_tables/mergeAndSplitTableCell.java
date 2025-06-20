import com.spire.doc.*;

public class mergeAndSplitTableCell {
    public static void main(String[] args) {
        String inputFile = "data/tableSample.docx";
        String outputFile = "output/mergeAndSplitTableCell.docx";

        // Create a new document object
        Document document = new Document();

        // Load the document from the specified input file
        document.loadFromFile(inputFile);

        // Get the first section of the document
        Section section = document.getSections().get(0);

        // Get the first table in the section
        Table table = section.getTables().get(0);

        // Apply horizontal merge to cells in the specified range (row 6, column 2 to row 6, column 3)
        table.applyHorizontalMerge(6, 2, 3);

        // Apply vertical merge to cells in the specified range (row 2, column 4 to row 2, column 5)
        table.applyVerticalMerge(2, 4, 5);

        // Split a cell into multiple cells at the specified position (row 8, column 3), creating a 2x2 cell grid
        table.getRows().get(8).getCells().get(3).splitCell(2, 2);

        // Save the modified document to the specified output file in DOCX format
        document.saveToFile(outputFile, FileFormat.Docx);

        // Dispose the document resources
        document.dispose();
    }
}
