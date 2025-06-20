import com.spire.data.table.DataTable;
import com.spire.data.table.common.JdbcAdapter;
import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import com.spire.pdf.tables.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.sql.*;


public class dataSource {
    public static void main(String[] args) {
          // Create a new PDF document
        PdfDocument doc = new PdfDocument();

        // Create a PdfUnitConvertor to convert units
        PdfUnitConvertor unitCvtr = new PdfUnitConvertor();

        // Create a PdfMargins object to set the page margins
        PdfMargins margin = new PdfMargins();

        // Set the top margin by converting 2.54 centimeters to points
        margin.setTop(unitCvtr.convertUnits(2.54f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));

        // Set the bottom margin equal to the top margin
        margin.setBottom(margin.getTop());

        // Set the left margin by converting 3.17 centimeters to points
        margin.setLeft(unitCvtr.convertUnits(3.17f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));

        // Set the right margin equal to the left margin
        margin.setRight(margin.getLeft());

        // Add a new page to the document with A4 size and the specified margins
        PdfPageBase page = doc.getPages().add(PdfPageSize.A4, margin);

        // Set the initial y coordinate for drawing on the page
        float y = 10;

        // Set the font and format for the title
        PdfBrush brush1 = PdfBrushes.getBlack();
        PdfTrueTypeFont font1 = new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 16));
        PdfStringFormat format1 = new PdfStringFormat(PdfTextAlignment.Center);

        // Draw the title "Country List" at the center of the page
        page.getCanvas().drawString("Country List", font1, brush1, page.getCanvas().getClientSize().getWidth() / 2, y, format1);

        // Calculate the height of the title and adjust the y coordinate accordingly
        y += (float) font1.measureString("Country List", format1).getHeight();
        y += 5;

        // Create a new PDF table
        PdfTable table = new PdfTable();

        // Set the padding and border properties for the table
        table.getStyle().setCellPadding(2);
        table.getStyle().setBorderPen(new PdfPen(brush1, 0.75f));

        // Set the default style for table cells
        table.getStyle().getDefaultStyle().setBackgroundBrush(PdfBrushes.getSkyBlue());
        table.getStyle().getDefaultStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 10)));

        // Create a new PdfCellStyle object for the alternate style
        PdfCellStyle alternateStyle = new PdfCellStyle();

        // Set the background brush for the alternate style to LightYellow
        alternateStyle.setBackgroundBrush(PdfBrushes.getLightYellow());

        // Set the font for the alternate style using Arial font with size 10
        alternateStyle.setFont(new PdfTrueTypeFont(new Font("Arial", 0, 10)));

        // Set the header source for the table to Column_Captions
        table.getStyle().setHeaderSource(PdfHeaderSource.Column_Captions);

        // Set the background brush for the header style to CadetBlue
        table.getStyle().getHeaderStyle().setBackgroundBrush(PdfBrushes.getCadetBlue());

        // Set the font for the header style using Arial font with bold and size 11
        table.getStyle().getHeaderStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 11)));

        // Set the string format for the header style to center alignment
        table.getStyle().getHeaderStyle().setStringFormat(new PdfStringFormat(PdfTextAlignment.Center));

        // Set the showHeader property of the table to true
        table.getStyle().setShowHeader(true);

        // Connect to the database and retrieve data from the "country" table
        String url ="jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ="+"data/demo.mdb";
        DataTable dataTable = new DataTable();
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            try {
                Connection conn = DriverManager.getConnection(url);
                Statement sta = conn.createStatement();
                ResultSet resultSet = sta.executeQuery("select Name,Capital,Continent,Area,Population from country ");

                // Fill the data table with the result set from the database
                JdbcAdapter jdbcAdapter = new JdbcAdapter();
                jdbcAdapter.fillDataTable(dataTable, resultSet);

                // Set the data source for the table
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

        // Calculate the available width for the table based on the page size and borders
        float width = (float) page.getCanvas().getClientSize().getWidth() - ((float) (table.getColumns().getCount() + 1) * table.getStyle().getBorderPen().getWidth());

        // Set the width and string format for the first column
        table.getColumns().get(0).setWidth(width * 0.24f);
        table.getColumns().get(0).setStringFormat(new PdfStringFormat(PdfTextAlignment.Left, PdfVerticalAlignment.Middle));

        // Set the width and string format for the second column
        table.getColumns().get(1).setWidth(width * 0.2f);
        table.getColumns().get(1).setStringFormat(new PdfStringFormat(PdfTextAlignment.Left, PdfVerticalAlignment.Middle));

        // Set the width and string format for the third column
        table.getColumns().get(2).setWidth(width * 0.24f);
        table.getColumns().get(2).setStringFormat(new PdfStringFormat(PdfTextAlignment.Left, PdfVerticalAlignment.Middle));

        // Set the width and string format for the fourth column
        table.getColumns().get(3).setWidth(width * 0.13f);
        table.getColumns().get(3).setStringFormat(new PdfStringFormat(PdfTextAlignment.Right, PdfVerticalAlignment.Middle));

        // Set the width and string format for the fifth column
        table.getColumns().get(4).setWidth(width * 0.18f);
        table.getColumns().get(4).setStringFormat(new PdfStringFormat(PdfTextAlignment.Right, PdfVerticalAlignment.Middle));

        // Draw the table on the page at position (0, y) and get the layout result
        PdfLayoutResult result = table.draw(page, new Point2D.Float(0, y));

        // Update the y coordinate to the bottom of the table plus some padding
        y = y + (float) result.getBounds().getHeight() + 5;

        // Set the brush and font for the additional text
        PdfBrush brush2 = PdfBrushes.getGray();
        PdfTrueTypeFont font2 = new PdfTrueTypeFont(new Font("Arial", 0, 9));

        // Draw the additional text with the number of countries in the list
        page.getCanvas().drawString(String.format("* %1$s countries in the list.", table.getRows().getCount()), font2, brush2, 5, y);

        //Save pdf file.
        doc.saveToFile("output/dataSource.pdf");

        // Close the PDF document
        doc.close();

        // Dispose of the PDF document (frees up system resources)
        doc.dispose();
    }
}
