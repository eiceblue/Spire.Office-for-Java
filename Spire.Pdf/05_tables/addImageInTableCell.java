import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import com.spire.pdf.tables.*;
import java.awt.*;
import java.awt.geom.Point2D;

public class addImageInTableCell {
    public static void main(String[] args) {
        // Create a new PDF document
        PdfDocument doc = new PdfDocument();

        // Add a new page to the document
        PdfPageBase page = doc.getPages().add();

        // Create a new PDF table
        PdfTable table = new PdfTable();

        // Define the border pen for the table
        PdfSolidBrush brush = new PdfSolidBrush(new PdfRGBColor(Color.black));
        table.getStyle().setBorderPen(new PdfPen(brush, 0.5f));

        // Set the string format for the table header cells
        table.getStyle().getHeaderStyle().setStringFormat(new PdfStringFormat(PdfTextAlignment.Center));

        // Set the header source to use rows, and specify the number of header rows
        table.getStyle().setHeaderSource(PdfHeaderSource.Rows);
        table.getStyle().setHeaderRowCount(1);

        // Enable the display of the table header
        table.getStyle().setShowHeader(true);

        // Set the font and background brush for the table header cells
        PdfTrueTypeFont fontHeader = new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 14));
        table.getStyle().getHeaderStyle().setFont(fontHeader);
        table.getStyle().getHeaderStyle().setBackgroundBrush(PdfBrushes.getCadetBlue());

        // Set the font for the table body cells
        PdfTrueTypeFont fontBody = new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 12));
        table.getStyle().getAlternateStyle().setFont(fontBody);

        // Define the data for the table
        String[] data = {"Column1;Column2", "Insert an image in table cell;"};

        // Split the data into rows and columns
        String[][] dataSource = new String[data.length][];
        for (int i = 0; i < data.length; i++) {
            dataSource[i] = data[i].split("[;]", -1);
        }

        // Set the data source for the table
        table.setDataSource(dataSource);

        // Set the string format for each column in the table
        for (int i = 0; i < table.getColumns().getCount(); i++) {
            PdfColumn column = table.getColumns().get(i);
            column.setStringFormat(new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle));
        }

        // Add an event handler for the beginning layout of a table row
        table.beginRowLayout.add(new BeginRowLayoutEventHandler() {
            @Override
            public void invoke(Object sender, BeginRowLayoutEventArgs args) {
                table_BeginRowLayout(sender, args);
            }
        });

        // Add an event handler for the end layout of a table cell
        table.endCellLayout.add(new EndCellLayoutEventHandler() {
            @Override
            public void invoke(Object sender, EndCellLayoutEventArgs args) {
                table_EndCellLayout(sender, args);
            }
        });

        // Draw the table on the page at the specified location
        table.draw(page, new Point2D.Float(0, 100));

        // Save the PDF document to the specified output file
        doc.saveToFile("output/addImageinATableCell_out.pdf", FileFormat.PDF);
    }
	
	
      // Event handler for the end layout of a table cell.
    static void table_EndCellLayout(Object sender, EndCellLayoutEventArgs args)
    {
        // Check if the current cell is at row index 1 and cell index 1
        if (args.getRowIndex()==1&&args.getCellIndex() == 1)
        {
            // Load the image from file
            PdfImage image = PdfImage.fromFile("data/E-iceblueLogo.png");

            // Calculate the position to center the image within the cell bounds
            float x = (float)((args.getBounds().getWidth() - image.getPhysicalDimension().getWidth()) / 2 + args.getBounds().getX());
            float y = (float) ((args.getBounds().getHeight() - image.getPhysicalDimension().getHeight()) / 2 + args.getBounds().getY());

            // Draw the image on the graphics context of the cell
            args.getGraphics().drawImage(image, x, y);
        }
    }

    // Event handler for the beginning layout of a table row.
    static void table_BeginRowLayout(Object sender, BeginRowLayoutEventArgs args)
    {
        // Check if the current row is at index 1
        if(args.getRowIndex()==1)
        {
            // Load the image from file
            PdfImage image = PdfImage.fromFile("data/E-iceblueLogo.png");

            // Set the minimal height of the row to accommodate the image height plus some extra space (4 units)
            args.setMinimalHeight(image.getPhysicalDimension().getHeight()+4);
        }
    }
}
