import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import com.spire.pdf.tables.*;
import java.awt.geom.Point2D;

public class tableInHeaderFooter {
    public static void main(String[] args) {
        // Specify the input and output file paths
        String input = "data/headerAndFooter.pdf";
        String output = "output/tableInHeaderFooter.pdf";

        // Create a PdfDocument object to work with the PDF file
        PdfDocument doc = new PdfDocument();

        // Load the PDF document from the input file
        doc.loadFromFile(input);

        // Call the method to draw a table in the header and footer of each page
        drawTableInHeaderFooter(doc);

        // Save the modified document to the output file
        doc.saveToFile(output);

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }
	
      private static void drawTableInHeaderFooter(PdfDocument doc) {
        // Data for the table
        String[] data = {
                "Column1;Column2",
                "Spire.PDF for .NET;Spire.PDF for JAVA"
        };

        // Y-coordinate position of the table
        float y = 20;
        // Brush for drawing
        PdfBrush brush = PdfBrushes.getBlack();

        // Iterate through each page of the document
        for (int j = 0; j < doc.getPages().getCount(); j++) {
            // Get the current page
            PdfPageBase page = doc.getPages().get(j);

            // Prepare the data source for the table
            String[][] dataSource = new String[data.length][];
            for (int i = 0; i < data.length; i++) {
                dataSource[i] = data[i].split(";");
            }

            // Create and configure the table
            PdfTable table = new PdfTable();
            // Set cell padding
            table.getStyle().setCellPadding(2);
            // Set border pen
            table.getStyle().setBorderPen(new PdfPen(brush, 0.1f));
            // Set header string format
            table.getStyle().getHeaderStyle().setStringFormat(new PdfStringFormat(PdfTextAlignment.Center));
            // Set header source
            table.getStyle().setHeaderSource(PdfHeaderSource.Rows);
            // Set header row count
            table.getStyle().setHeaderRowCount(1);
            // Show the header
            table.getStyle().setShowHeader(true);
            // Set background brush for the header
            table.getStyle().getHeaderStyle().setBackgroundBrush(PdfBrushes.getCadetBlue());
            // Set the data source for the table
            table.setDataSource(dataSource);

            // Configure column settings
            for (int c = 0; c < table.getColumns().getCount(); c++) {
                PdfColumn column = table.getColumns().get(c);
                column.setStringFormat(new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle));
            }

            // Draw the table on the page at the specified position
            table.draw(page, new Point2D.Float(0, y));
        }
    }
}
