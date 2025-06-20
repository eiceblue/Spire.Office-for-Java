import com.spire.doc.*;

public class setColumnWidth {
    public static void main(String[] args) {
        String inputFile = "data/tableSample.docx";
        String outputFile = "output/setColumnWidth.docx";

        // Create a new document object
        Document document = new Document();

        // Load the document from the specified input file
        document.loadFromFile(inputFile);

        // Get the first section of the document
        Section section = document.getSections().get(0);

        // Get the first table in the section
        Table table = section.getTables().get(0);

        // Loop through each row in the table
        for (int i = 0; i < table.getRows().getCount(); i++) {
            // Set the width type of the first cell in each row to point, 200 points
            table.getRows().get(i).getCells().get(0).setCellWidth(200,CellWidthType.Point);
        }

        // Save the modified document to the specified output file in DOCX format
        document.saveToFile(outputFile, FileFormat.Docx);

        // Dispose the document resources
        document.dispose();
    }
}
