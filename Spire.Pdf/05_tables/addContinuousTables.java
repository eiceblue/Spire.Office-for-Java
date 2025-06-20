import com.spire.data.table.DataTable;
import com.spire.data.table.common.JdbcAdapter;
import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import com.spire.pdf.tables.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.sql.*;

public class addContinuousTables {
    public static void main(String[] args) {
        // Create a new PDF document
        PdfDocument doc = new PdfDocument();

        // Add a new page to the document
        PdfPageBase page = doc.getPages().add();

        // Set the initial vertical position for drawing the tables
        float y = 20;

        // Define the title for the first table
        String title1 = "Table 1";

        // Draw the first table on the page and get the layout result
        PdfLayoutResult result = DrawPDFTable(title1, y, page, "parts");

        // Update the vertical position based on the height of the drawn table
        y = (float) result.getBounds().getHeight() + 10;

        // Update the page reference to the one returned by the first table drawing
        page = result.getPage();

        // Define the title for the second table
        String title2 = "Table 2";

        // Draw the second table on the page
        DrawPDFTable(title2, y, page, "country");

        // Save the PDF document to the specified output file
        String output = "output/addContinuousTables_out.pdf";
        doc.saveToFile(output);

        // Close the PDF document
        doc.close();

        // Dispose of the PDF document (frees up system resources)
        doc.dispose();
    }
	
     // Draws a PDF table with title and data on the given page.
    private static PdfLayoutResult DrawPDFTable(String title,float y, PdfPageBase page,String dataName)
    {
        // Create a black brush for drawing
        PdfBrush brush = PdfBrushes.getBlack();

        // Create a TrueType font with Arial, plain style, and size 16
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 16));

        // Create a string format with center alignment
        PdfStringFormat format = new PdfStringFormat(PdfTextAlignment.Center);

        // Store the title in a variable
        String title1 = title;

        // Draw the title on the canvas of the page using the specified font, brush, and position
        page.getCanvas().drawString(title1, font, brush, page.getCanvas().getClientSize().getWidth() / 2, y, format);

        // Update the vertical position to account for the height of the drawn title
        y = y + (float) font.measureString(title1, format).getHeight();

        // Add a spacing of 10 units below the title
        y = y + 10;

        // Create a new instance of a PDF table
        PdfTable table = new PdfTable();

        // Set the cell padding for the table to 3 units
        table.getStyle().setCellPadding(3);

        // Set the border pen for the table with the specified brush and line width
        table.getStyle().setBorderPen(new PdfPen(brush, 0.75f));

        // Set the default background brush for the table cells to SkyBlue
        table.getStyle().getDefaultStyle().setBackgroundBrush(PdfBrushes.getSkyBlue());

        // Set the default font for the table cells to Arial, plain style, and size 10
        table.getStyle().getDefaultStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 10)));

        // Set the default string format for the table cells to the previously defined format (center alignment)
        table.getStyle().getDefaultStyle().setStringFormat(format);

        // Set the alternate style for the table cells to a new instance of PdfCellStyle
        table.getStyle().setAlternateStyle(new PdfCellStyle());

        // Set the background brush for the alternate style cells to LightBlue
        table.getStyle().getAlternateStyle().setBackgroundBrush(PdfBrushes.getLightBlue());

        // Set the font for the alternate style cells to Arial, plain style, and size 10
        table.getStyle().getAlternateStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 10)));

        // Set the string format for the alternate style cells to the previously defined format (center alignment)
        table.getStyle().getAlternateStyle().setStringFormat(format);

        // Set the header source for the table to use column captions
        table.getStyle().setHeaderSource(PdfHeaderSource.Column_Captions);

        // Set the background brush for the header style cells to CadetBlue
        table.getStyle().getHeaderStyle().setBackgroundBrush(PdfBrushes.getCadetBlue());

        // Set the font for the header style cells to Arial, bold style, and size 14
        table.getStyle().getHeaderStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 14)));

        // Set the string format for the header style cells to the previously defined format (center alignment)
        table.getStyle().getHeaderStyle().setStringFormat(format);

        // Enable the display of the table header
        table.getStyle().setShowHeader(true);

        // Set the data source for the table
        table.setDataSource(GetData(dataName));

        // Draw the table on the page at the specified position
        PdfLayoutResult result = table.draw(page, new Point2D.Float(0, y));
        return result;
    }
	
      // Retrieves data from a Microsoft Access database using the specified table name.
    private static DataTable GetData(String name) {
        // Set the URL for connecting to the Microsoft Access database
        String url ="jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ="+ "data/demo.mdb";

        // Create a new DataTable to store the retrieved data
        DataTable dataTable = new DataTable();

        try {
            // Load the JDBC-ODBC bridge driver class
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

            try {
                // Establish a connection to the database
                Connection conn =  DriverManager.getConnection(url);

                // Create a statement for executing SQL queries
                Statement sta = conn.createStatement();

                // Execute the SQL query to select all data from the specified table
                ResultSet resultSet = sta.executeQuery("SELECT * FROM " + name);

                // Create a JdbcAdapter to fill the DataTable with the query results
                JdbcAdapter jdbcAdapter = new JdbcAdapter();
                jdbcAdapter.fillDataTable(dataTable, resultSet);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // Return the populated DataTable
        return dataTable;
    }
}
