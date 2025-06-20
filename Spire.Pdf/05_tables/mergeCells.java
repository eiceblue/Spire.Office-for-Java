import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import com.spire.pdf.grid.*;
import java.awt.*;
import java.awt.geom.Point2D;


public class mergeCells {
    public static void main(String[] args) {
          // Create a new PDF document
        PdfDocument document = new PdfDocument();

        // Add a new page to the document
        PdfPageBase page = document.getPages().add();

        // Create a new grid
        PdfGrid grid = new PdfGrid();

        // Add 5 columns to the grid
        grid.getColumns().add(5);

        // Set the width of each column to 100
        for (int j = 0; j < grid.getColumns().getCount(); j++) {
            grid.getColumns().get(j).setWidth(100);
        }

        // Add two rows to the grid
        PdfGridRow row0 = grid.getRows().add();
        PdfGridRow row1 = grid.getRows().add();

        // Set the height of each row to 21.0
        float height = 21.0f;
        for (int i = 0; i < grid.getRows().size(); i++) {
            grid.getRows().get(i).setHeight(height);
        }

        // Set font styles for row 0 and row 1
        row0.getStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 16), true));
        row1.getStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.ITALIC, 16), true));

        // Set value and merging properties for cell at row 0, column 0
        row0.getCells().get(0).setValue("Corporation");
        row0.getCells().get(0).setRowSpan(2);

        // Set value, formatting, and merging properties for cell at row 0, column 1
        row0.getCells().get(1).setValue("B&K Undersea Photo");
        row0.getCells().get(1).setStringFormat(new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle));
        row0.getCells().get(1).setColumnSpan(3);

        // Set value, font style, formatting, and background color for cell at row 0, column 4
        row0.getCells().get(4).setValue("World");
        row0.getCells().get(4).getStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.BOLD + Font.ITALIC, 10), true));
        row0.getCells().get(4).setStringFormat(new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle));
        row0.getCells().get(4).getStyle().setBackgroundBrush(PdfBrushes.getLightGreen());

        // Set value, formatting, and merging properties for cell at row 1, column 1
        row1.getCells().get(1).setValue("Diving International Unlimited");
        row1.getCells().get(1).setStringFormat(new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle));
        row1.getCells().get(1).setColumnSpan(4);

        // Draw the grid on the page at the specified location (10, 150)
        grid.draw(page, new Point2D.Float(10, 150));

        // Save the document to the specified output file path
        document.saveToFile("output/mergeCells.pdf");

        // Close the PDF document
        document.close();

        // Dispose of the PDF document (frees up system resources)
        document.dispose();
    }
}
