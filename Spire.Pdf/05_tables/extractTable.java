import com.spire.pdf.*;
import com.spire.pdf.utilities.*;
import java.io.FileWriter;

public class extractTable {
    public static void main(String[] args) throws Exception {
         // Specify the output file path and name
        String outputFile = "output/extractTable.txt";

        // Load the PDF document
        PdfDocument pdfDocument = new PdfDocument();
        pdfDocument.loadFromFile("data/tableSample.pdf");

        // Create a StringBuilder to hold extracted table data
        StringBuilder builder = new StringBuilder();

        // Create a PdfTableExtractor instance using the loaded PDF document
        PdfTableExtractor extractor = new PdfTableExtractor(pdfDocument);

        // Initialize an array to store extracted tables
        PdfTable[] tableLists = null;

        // Iterate over each page in the PDF document
        for (int pageIndex = 0; pageIndex < pdfDocument.getPages().getCount(); pageIndex++) {
            // Extract tables from the current page
            tableLists = extractor.extractTable(pageIndex);

            // Check if any tables were extracted
            if (tableLists != null && tableLists.length > 0) {
                for (PdfTable table : tableLists) {
                    // Get the number of rows and columns in the table
                    int row = table.getRowCount();
                    int column = table.getColumnCount();

                    // Iterate over each cell in the table
                    for (int i = 0; i < row; i++) {
                        for (int j = 0; j < column; j++) {
                            // Get the text content of the current cell
                            String text = table.getText(i, j);

                            // Append the text to the StringBuilder along with a space separator
                            builder.append(text + "  ");
                        }

                        // Append a new line character after each row
                        builder.append("\r\n");
                    }
                }
            }
        }

        // Create a FileWriter to write the extracted table data to the output file
        FileWriter fileWriter = new FileWriter(outputFile);
        fileWriter.write(builder.toString());
        fileWriter.flush();
        fileWriter.close();

        // Close the PDF document
        pdfDocument.close();

        // Dispose of the PDF document (frees up system resources)
        pdfDocument.dispose();
    }
}
