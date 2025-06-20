import com.spire.pdf.*;
import com.spire.pdf.actions.*;
import com.spire.pdf.general.PdfDestination;
import com.spire.pdf.graphics.*;
import com.spire.pdf.tables.*;
import com.spire.pdf.tables.table.DataTable;
import com.spire.pdf.tables.table.common.JdbcAdapter;
import java.awt.*;
import java.awt.geom.Point2D;
import java.sql.*;

public class actionChain {
    public static void main(String[] args) {
        // Set the output file path for the generated PDF document
        String output = "output/actionChain.pdf";

        // Create a new PdfDocument object
        PdfDocument doc = new PdfDocument();

        // Draw the parts table on the PDF document and retrieve the last page
        PdfPageBase lastPage = drawPartsTable2(doc);

        // Define JavaScript action 1
        String script = "app.alert({"
                + "    cMsg: \"I'll lead; you must follow me.\","
                + "    nIcon: 3,"
                + "    cTitle: \"JavaScript Action\""
                + "});";
        PdfJavaScriptAction action1 = new PdfJavaScriptAction(script);

        // Set action1 as the after open action for the document
        doc.setAfterOpenAction(action1);

        // Define JavaScript action 2
        script = "app.alert({"
                + "    cMsg: \"The first page!\","
                + "    nIcon: 3,"
                + "    cTitle: \"JavaScript Action\""
                + "});";
        PdfJavaScriptAction action2 = new PdfJavaScriptAction(script);

        // Set action2 as the next action for action1
        action1.setNextAction(action2);

        // Create a go-to action that navigates to the last page of the document
        PdfDestination dest = new PdfDestination(lastPage);
        dest.setZoom(1);
        PdfGoToAction action3 = new PdfGoToAction(dest);

        // Set action3 as the next action for action2
        action2.setNextAction(action3);

        // Define JavaScript action 4
        script = "app.alert({"
                + "    cMsg: \"Oh sorry, it's the last page. I'm missing!\","
                + "    nIcon: 3,"
                + "    cTitle: \"JavaScript Action\""
                + "});";
        PdfJavaScriptAction action4 = new PdfJavaScriptAction(script);

        // Set action4 as the next action for action3
        action3.setNextAction(action4);

        // Save the document to the specified output file path
        doc.saveToFile(output, FileFormat.PDF);

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }
	
        static PdfPageBase drawPartsTable2(PdfDocument doc) {
        // Specify the input file path
        String inputFile = "data/demo.mdb";

        // Set up unit converter and margins
        PdfUnitConvertor unitCvtr = new PdfUnitConvertor();
        PdfMargins margin = new PdfMargins();
        margin.setTop(unitCvtr.convertUnits(2.54f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
        margin.setBottom(margin.getTop());
        margin.setLeft(unitCvtr.convertUnits(3.17f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
        margin.setRight(margin.getLeft());

        // Add a new page to the document with specified size and margins
        PdfPageBase page = doc.getPages().add(PdfPageSize.A4, margin);

        // Initial vertical position for drawing elements
        float y = 10;

        // Define the brush, font, and format for the title
        PdfBrush brush1 = PdfBrushes.getBlack();
        PdfTrueTypeFont font1 = new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 16));
        PdfStringFormat format1 = new PdfStringFormat(PdfTextAlignment.Center);

        // Draw the title "Part List" at the center of the page
        page.getCanvas().drawString("Part List", font1, brush1, page.getCanvas().getClientSize().getWidth() / 2, y, format1);
        y = y + (float) font1.measureString("Part List", format1).getHeight(); // Increment vertical position
        y = y + 5; // Add some padding

        // Create a new PdfTable object and set its style properties
        PdfTable table = new PdfTable();
        // Set cell padding and border pen
        table.getStyle().setCellPadding(2);
        table.getStyle().setBorderPen(new PdfPen(brush1, 0.75f));

        // Set default style for table cells
        table.getStyle().getDefaultStyle().setBackgroundBrush(PdfBrushes.getSkyBlue());
        table.getStyle().getDefaultStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 10)));

        // Set alternate style for table cells
        table.getStyle().setAlternateStyle(new PdfCellStyle());
        table.getStyle().getAlternateStyle().setBackgroundBrush(PdfBrushes.getLightYellow());
        table.getStyle().getAlternateStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 10)));

        // Specify the header source and style
        table.getStyle().setHeaderSource(PdfHeaderSource.Column_Captions);
        table.getStyle().getHeaderStyle().setBackgroundBrush(PdfBrushes.getCadetBlue());
        table.getStyle().getHeaderStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 11)));
        table.getStyle().getHeaderStyle().setStringFormat(new PdfStringFormat(PdfTextAlignment.Center));

        // Show the header row
        table.getStyle().setShowHeader(true);

        // Specify the URL for connecting to the Microsoft Access database
        String url = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=" + inputFile;

        // Create a DataTable to hold the retrieved data from the database
        DataTable dataTable = new DataTable();

        try {
            // Load the JDBC-ODBC bridge driver
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

            try {
                // Establish a connection to the database
                Connection conn = DriverManager.getConnection(url);
                Statement sta = conn.createStatement();

                // Execute the SQL query to retrieve data from the "parts" table
                ResultSet resultSet = sta.executeQuery("SELECT Description, OnHand, OnOrder, Cost, ListPrice FROM parts");

                // Fill the DataTable with the retrieved data using JdbcAdapter
                JdbcAdapter jdbcAdapter = new JdbcAdapter();
                jdbcAdapter.fillDataTable(dataTable, resultSet);

                // Set the table's data source to the populated DataTable
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

        // Calculate the available width for the table based on page size and borders
        float width = (float) (page.getCanvas().getClientSize().getWidth() - (table.getColumns().getCount() + 1) * table.getStyle().getBorderPen().getWidth());

        // Set the column widths and alignment
        for (int i = 0; i < table.getColumns().getCount(); i++) {
            if (i == 0) {
                table.getColumns().get(i).setWidth(width * 0.40f * width);
                table.getColumns().get(i).setStringFormat(new PdfStringFormat(PdfTextAlignment.Left, PdfVerticalAlignment.Middle));
            } else {
                // Set width and alignment for other columns
                table.getColumns().get(i).setWidth(width * 0.15f * width);
                table.getColumns().get(i).setStringFormat(new PdfStringFormat(PdfTextAlignment.Right, PdfVerticalAlignment.Middle));
            }
        }

        // Specify the table layout format
        PdfTableLayoutFormat tableLayout = new PdfTableLayoutFormat();
        tableLayout.setBreak(PdfLayoutBreakType.Fit_Element);
        tableLayout.setLayout(PdfLayoutType.Paginate);

        // Draw the table on the page and get the layout result
        PdfLayoutResult result = table.draw(page, new Point2D.Float(0, y), tableLayout);

        // Update the vertical position after table drawing
        y = (float) result.getBounds().getY() + (float) result.getBounds().getHeight() + 5;

        // Display the number of parts in the list
        PdfBrush brush2 = PdfBrushes.getGray();
        PdfTrueTypeFont font2 = new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 9));
        result.getPage().getCanvas().drawString(String.format("* %1$s parts in the list.", table.getRows().getCount()), font2, brush2, 5, y);

        return result.getPage();
    }
}
