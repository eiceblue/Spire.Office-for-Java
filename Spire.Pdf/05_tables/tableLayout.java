import com.spire.data.table.DataTable;
import com.spire.data.table.common.JdbcAdapter;
import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import com.spire.pdf.tables.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.sql.*;

public class tableLayout {
    public static void main(String[] args) {
   
        // Create a new PdfDocument
        PdfDocument doc = new PdfDocument();

        // Create a PdfUnitConvertor for unit conversion
        PdfUnitConvertor unitCvtr = new PdfUnitConvertor();

        // Set the margin values in centimeters
        float topMarginInCm = 2.54f;
        float leftMarginInCm = 2.17f;

        // Convert the margin values to points using the PdfUnitConvertor
        float topMarginInPoints = unitCvtr.convertUnits(topMarginInCm, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point);
        float leftMarginInPoints = unitCvtr.convertUnits(leftMarginInCm, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point);

        // Create a PdfMargins object and set the margin values
        PdfMargins margins = new PdfMargins();
        margins.setTop(topMarginInPoints);
        margins.setBottom(topMarginInPoints);
        margins.setLeft(leftMarginInPoints);
        margins.setRight(leftMarginInPoints);

        // Create a new page with A4 size and specified margins
        PdfPageBase page = doc.getPages().add(PdfPageSize.A4, margins);

        // Set up the font, brush, and string format for the title
        PdfBrush brush1 = PdfBrushes.getBlack();
        PdfTrueTypeFont font1 = new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 16));
        PdfStringFormat format1 = new PdfStringFormat(PdfTextAlignment.Center);

        // Draw the title "Part List" at the center of the page
        float y = 10;
        page.getCanvas().drawString("Part List", font1, brush1, page.getCanvas().getClientSize().getWidth() / 2, y, format1);

        // Update the y-coordinate after drawing the title
        y = y + (float) font1.measureString("Part List", format1).getHeight();
        y = y + 5;

        // Create a new PdfTable
        PdfTable table = new PdfTable();

        // Set the cell padding and border pen for the table
        table.getStyle().setCellPadding(2);
        table.getStyle().setBorderPen(new PdfPen(brush1, 0.75f));

        // Set the default style for the table cells
        table.getStyle().getDefaultStyle().setBackgroundBrush(PdfBrushes.getSkyBlue());
        table.getStyle().getDefaultStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 10)));

        // Set the alternate style for alternating rows in the table
        table.getStyle().setAlternateStyle(new PdfCellStyle());
        table.getStyle().getAlternateStyle().setBackgroundBrush(PdfBrushes.getLightYellow());
        table.getStyle().getAlternateStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 10)));

        // Set the header source, style, and properties for the table
        table.getStyle().setHeaderSource(PdfHeaderSource.Column_Captions);
        table.getStyle().getHeaderStyle().setBackgroundBrush(PdfBrushes.getCadetBlue());
        table.getStyle().getHeaderStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 11)));
        table.getStyle().getHeaderStyle().setStringFormat(new PdfStringFormat(PdfTextAlignment.Center));

        // Show the header row in the table
        table.getStyle().setShowHeader(true);

        // Define the URL for the Access database connection
        String url = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=data/demo.mdb";

        // Create a new DataTable to hold the retrieved data
        DataTable dataTable = new DataTable();

        try {
            // Load the JDBC-ODBC bridge driver
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

            try {
                // Establish a connection to the Access database
                Connection conn = DriverManager.getConnection(url);

                // Create a statement to execute SQL queries
                Statement sta = conn.createStatement();

                // Execute the SQL query to retrieve data from the "parts" table
                ResultSet resultSet = sta.executeQuery("SELECT * FROM parts");

                // Create a JdbcAdapter to fill the DataTable with the query results
                JdbcAdapter jdbcAdapter = new JdbcAdapter();
                jdbcAdapter.fillDataTable(dataTable, resultSet);

                // Remove a column from the DataTable (optional)
                dataTable.getColumns().remove(1);

                // Set the data source type and data source for the PdfTable
                table.setDataSourceType(PdfTableDataSourceType.Table_Direct);
                table.setDataSource(dataTable);

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        // Calculate the available width for the table based on the page size and border widths
        float width = (float) page.getCanvas().getClientSize().getWidth() - (table.getColumns().getCount() + 1) * table.getStyle().getBorderPen().getWidth();

        // Set the column widths and string formats for each column in the table
        for (int i = 0; i < table.getColumns().getCount(); i++) {
            if (i == 1) {
                // Set width and alignment for the second column (index 1)
                table.getColumns().get(i).setWidth(width * 0.4f);
                table.getColumns().get(i).setStringFormat(new PdfStringFormat(PdfTextAlignment.Left, PdfVerticalAlignment.Middle));
            } else {
                // Set width and alignment for other columns
                table.getColumns().get(i).setWidth(width * 0.12f);
                table.getColumns().get(i).setStringFormat(new PdfStringFormat(PdfTextAlignment.Right, PdfVerticalAlignment.Middle));
            }
        }

        // Add event handler for the BeginRowLayout event to handle row styling
        table.beginRowLayout.add(new BeginRowLayoutEventHandler() {
            @Override
            public void invoke(Object sender, BeginRowLayoutEventArgs args) {
                layoutTable_BeginRowLayout(sender, args);
            }
        });

        // Define table layout format for pagination and element fitting
        PdfTableLayoutFormat tableLayout = new PdfTableLayoutFormat();
        tableLayout.setBreak(PdfLayoutBreakType.Fit_Element);
        tableLayout.setLayout(PdfLayoutType.Paginate);

        // Draw the table on the page starting at the specified position
        PdfLayoutResult result = table.draw(page, new Point2D.Float(0, y), tableLayout);

        // Update the y-coordinate after drawing the table
        y = (float) result.getBounds().getY() + (float) result.getBounds().getHeight() + 5;

        // Draw additional text below the table
        PdfBrush brush2 = PdfBrushes.getGray();
        PdfTrueTypeFont font2 = new PdfTrueTypeFont(new Font("Arial", 0, 9));
        result.getPage().getCanvas().drawString(String.format("* All %1$s parts in the list", table.getRows().getCount()), font2, brush2, 5, y);

        //Save pdf file.
        doc.saveToFile("output/tableLayout.pdf");

        // Close the PDF document
        doc.close();

        // Dispose of the PDF document (frees up system resources)
        doc.dispose();
    }

   // Sets the background color of alternating rows in the table.
    static void layoutTable_BeginRowLayout(Object sender, BeginRowLayoutEventArgs args) {
        // Check if it is the header row
        if (args.getRowIndex() < 0) {
            // Do nothing for the header row
            return;
        }

        // Set the background color for alternate rows based on the row index
        if (args.getRowIndex() % 2 == 0) {
            // Even row index
            args.getCellStyle().setBackgroundBrush(PdfBrushes.getLightYellow());
        } else {
            // Odd row index
            args.getCellStyle().setBackgroundBrush(PdfBrushes.getSkyBlue());
        }
    }
}
