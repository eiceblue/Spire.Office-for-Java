import com.spire.doc.*;
import com.spire.doc.documents.Paragraph;

public class preventPageBreakInTable {
    public static void main(String[] args) {
        // Create a new document object
        Document document = new Document();

        // Load the document from file "data/JAVATemplate_N.docx"
        document.loadFromFile("data/JAVATemplate_N.docx");

        // Get the first table in the first section of the document
        Table table = document.getSections().get(0).getTables().get(0);

        // Iterate over each row in the table
        for (TableRow row : (Iterable<TableRow>) table.getRows()) {
            // Iterate over each cell in the row
            for (TableCell cell : (Iterable<TableCell>) row.getCells()) {
                // Iterate over each paragraph in the cell
                for (Paragraph p : (Iterable<Paragraph>) cell.getParagraphs()) {
                    // Set the keep follow property to true, preventing page breaks within the paragraph
                    p.getFormat().setKeepFollow(true);
                }
            }
        }

        // Specify the output file path
        String result = "output/Result-PreventPageBreaksInWordTable.docx";

        // Save the modified document to the output file in DOCX format
        document.saveToFile(result, FileFormat.Docx);

        // Dispose the document resources
        document.dispose();
    }
}
