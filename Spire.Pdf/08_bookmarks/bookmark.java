import com.spire.pdf.*;
import com.spire.pdf.actions.*;
import com.spire.pdf.bookmarks.*;
import com.spire.pdf.general.*;
import com.spire.pdf.graphics.*;
import com.spire.pdf.grid.*;
import com.spire.pdf.tables.*;
import com.spire.pdf.tables.table.*;
import com.spire.pdf.tables.table.common.JdbcAdapter;
import java.awt.*;
import java.awt.geom.Point2D;
import java.sql.*;

public class bookmark {
    public static void main(String[] args) throws Exception{
        // Create a new PDF document
        PdfDocument doc = new PdfDocument();

        // Create a PdfUnitConvertor object for unit conversion
        PdfUnitConvertor unitCvtr = new PdfUnitConvertor();

        // Create a PdfMargins object to store margin settings
        PdfMargins margin = new PdfMargins();

        // Set the top margin by converting 2.54 centimeters to points
        margin.setTop(unitCvtr.convertUnits(2.54f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));

        // Set the bottom margin equal to the top margin
        margin.setBottom(margin.getTop());

        // Set the left margin by converting 3.17 centimeters to points
        margin.setLeft(unitCvtr.convertUnits(3.17f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));

        // Set the right margin equal to the left margin
        margin.setRight(margin.getLeft());

        // Create a new section in the document
        PdfSection section = doc.getSections().add();

        // Set the page size of the section to A4
        section.getPageSettings().setSize(PdfPageSize.A4);

        // Set the margin settings of the section
        section.getPageSettings().setMargins(margin);

        // Add a new page to the section
        PdfPageBase page = section.getPages().add();

        // Set up initial position and styles for text elements
        float y = 10;
        PdfBrush brush1 = PdfBrushes.getBlack();
        PdfTrueTypeFont font1 = new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 16));
        PdfStringFormat format1 = new PdfStringFormat(PdfTextAlignment.Center);

        // Draw the title "Sales Report" at the top of the page
        page.getCanvas().drawString("Sales Report", font1, brush1, page.getCanvas().getClientSize().getWidth() / 2, y, format1);
        y = y + (float) font1.measureString("Sales Report", format1).getHeight();
        y = y + 5;

        // Connect to the database and prepare the necessary SQL queries
        String url = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=" + "data/demo.mdb";
        DataTable dataTable = new DataTable();
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection conn = DriverManager.getConnection(url);
        PreparedStatement partQueryCommand = Bookmark_PreparePartQueryCommand(conn);
        PreparedStatement orderItemQueryCommand = Bookmark_PrepareOrderItemQueryCommand(conn);

        // Retrieve vendors from the database and process each vendor
        DataTable vendors = Bookmark_GetVendors(conn);
        for (int i = 0; i < vendors.getRows().size(); i++) {
            if (i > 0) {
                // Start a new page for each vendor, if necessary
                page = section.getPages().add();
                y = 0;
            }

            // Create a title for the current vendor using its index and name
            String vendorTitle = String.format("%1$s. %2$s", i + 1, vendors.getRows().get(i).getArrayList()[1]);

            // Draw the vendor details on the page and get the layout result
            PdfLayoutResult drawVendorLayoutResult = Bookmark_DrawVendor(page, vendors, i, vendorTitle, y);
            
            // Create a PdfDestination object representing the destination point for the bookmark
            PdfDestination vendorBookmarkDest = new PdfDestination(page, new Point2D.Float(0, y));

            // Add the vendor title as a bookmark to the document
            doc.getBookmarks().add(vendorTitle);

            // Create a PdfBookmark object for the vendor and add it to the document's bookmark collection
            PdfBookmark vendorBookmark = doc.getBookmarks().add(vendorTitle);

            // Set the color of the vendor bookmark to saddle brown (RGB: 139, 69, 19)
            vendorBookmark.setColor(new PdfRGBColor(new Color(139, 69, 19)));

            // Set the display style of the vendor bookmark to bold
            vendorBookmark.setDisplayStyle(PdfTextStyle.Bold);

            // Create a PdfGoToAction object linking the vendor bookmark to its destination
            vendorBookmark.setAction(new PdfGoToAction(vendorBookmarkDest));

            // Update the vertical position for the next element
            y = (float) drawVendorLayoutResult.getBounds().getY() + (float) drawVendorLayoutResult.getBounds().getHeight() + 5;
            page = drawVendorLayoutResult.getPage();

            // Retrieve parts for the current vendor and process each part
            DataTable parts = Bookmark_GetParts(partQueryCommand, (Double) vendors.getRows().get(i).getArrayList()[0]);
            for (int j = 0; j < parts.getRows().size(); j++) {
                if (j > 0) {
                    // Start a new page for each part, if necessary
                    page = section.getPages().add();
                    y = 0;
                }

                // Create a title for the current part using its indices and name
                String partTitle = String.format("%1$s.%2$s. %3$s", i + 1, j + 1, parts.getRows().get(j).getArrayList()[1]);

                // Draw the part details on the page and get the layout result
                PdfLayoutResult drawPartLayoutResult = Bookmark_DrawPart(page, parts, j, partTitle, y);

                // Set up bookmark destination and create a bookmark for the current part
                PdfDestination partBookmarkDest = new PdfDestination(page, new Point2D.Float(0, y));
                PdfBookmark partBookmark = vendorBookmark.add(partTitle);
                partBookmark.setColor(new PdfRGBColor(new Color(255, 127, 80)));
                partBookmark.setDisplayStyle(PdfTextStyle.Italic);
                partBookmark.setAction(new PdfGoToAction(partBookmarkDest));

                // Update the vertical position for the next element
                y = (float) drawPartLayoutResult.getBounds().getY() + (float) drawPartLayoutResult.getBounds().getHeight() + 5;
                page = drawPartLayoutResult.getPage();

                // Create a title for the order items related to the current part
                String orderItemsTitle = String.format("%1$s - Order Items", parts.getRows().get(j).getArrayList()[1]);

                // Retrieve order items for the current part and draw them on the page
                DataTable orderItems = Bookmark_GetParts(orderItemQueryCommand, (Double) parts.getRows().get(j).getArrayList()[0]);
                Bookmark_DrawOrderItems(page, orderItems, orderItemsTitle, y);
            }
        }

        //Save pdf file.
        doc.saveToFile("output/bookmarks.pdf");

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
        }
		
     // Retrieves a DataTable containing vendor information from the database.
    static DataTable Bookmark_GetVendors(Connection poConn) throws Exception {
        try {
            // Create a statement object to execute SQL queries.
            Statement loState = poConn.createStatement();

            // Define the SQL query to retrieve vendor information.
            String query = "SELECT VendorNo, VendorName, Address1, City, State, Zip, Country, Phone, FAX FROM vendors";

            // Execute the query and obtain the result set.
            ResultSet resultSet = loState.executeQuery(query);

            // Create a new DataTable object to store the query results.
            DataTable dataTable = new DataTable();

            // Create a JdbcAdapter instance to populate the DataTable with the result set.
            JdbcAdapter adapter = new JdbcAdapter();
            adapter.fillDataTable(dataTable, resultSet);

            // Return the populated DataTable.
            return dataTable;
        } catch (SQLException e) {
            // Print the stack trace if an SQL exception occurs.
            e.printStackTrace();
        } catch (Exception e) {
            // Print the stack trace if any other exception occurs.
            e.printStackTrace();
        }

        // Return null if an error occurred.
        return null;
    }

    // Retrieves a DataTable containing parts for a specific vendor from the database.
    static DataTable Bookmark_GetParts(PreparedStatement poStatement, double vendorId) {
        try {
            // Set the vendorId parameter in the prepared statement.
            poStatement.setString(1, vendorId + "");

            // Execute the query and obtain the result set.
            ResultSet resultSet = poStatement.executeQuery();

            // Create a new DataTable object to store the query results.
            DataTable dataTable = new DataTable();

            // Create a JdbcAdapter instance to populate the DataTable with the result set.
            JdbcAdapter adapter = new JdbcAdapter();
            adapter.fillDataTable(dataTable, resultSet);

            // Return the populated DataTable.
            return dataTable;
        } catch (SQLException e) {
            // Print the stack trace if an SQL exception occurs.
            e.printStackTrace();
        } catch (Exception e) {
            // Print the stack trace if any other exception occurs.
            e.printStackTrace();
        }

        // Return null if an error occurred.
        return null;
    }

    // Draws a vendor information section of the DataTable on a PDF page with specified formatting.
    static PdfLayoutResult Bookmark_DrawVendor(PdfPageBase page, DataTable vendors, int index, String title, float y) {
        // Create a TrueType font with Arial, bold, size 11
        PdfTrueTypeFont font1 = new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 11));

        // Get the DataRow from the DataTable based on the index
        DataRow row = vendors.getRows().get(index);

        // Draw the title on the page using font1
        page.getCanvas().drawString(title, font1, PdfBrushes.getBlack(), 0, y);

        // Increase the y-coordinate based on the height of the title plus 1 to leave some space
        y = y + (float)font1.measureString(title).getHeight() + 1;

        // Initialize a 2D array to hold the vendor data
        Object[][] data = new Object[vendors.getColumns().size()][];

        for (int i = 0; i < vendors.getColumns().size(); i++) {
            data[i] = new Object[2];
            data[i][0] = vendors.getColumns().get(i).getColumnName();

            try {
                // Get the value of the specific column in the DataRow and populate the corresponding data array element
                data[i][1] = vendors.getRows().get(index).getArrayList()[i];
            } catch (DataException e) {
                e.printStackTrace();
            }
        }

        // Create a new PdfGrid instance
        PdfGrid grid = new PdfGrid();

        // Set cell padding for the grid
        grid.getStyle().setCellPadding(new PdfPaddings(2, 2, 1, 1));

        // Set the data source for the grid
        grid.setDataSource(data);

        // Calculate the available width for the grid based on the page size and column count
        float width = (float)page.getCanvas().getClientSize().getWidth() - (grid.getColumns().getCount() + 1) * 0.75f;

        // Set the width of the first column to represent 20% of the available width
        grid.getColumns().get(0).setWidth(width * 0.20f);

        // Set the width of the second column to represent 80% of the available width
        grid.getColumns().get(1).setWidth(width * 0.80f);

        // Create a TrueType font with Arial, bold, size 10 for styling the grid cells
        PdfTrueTypeFont font2 = new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 10));

        // Apply formatting to each row and its cells in the grid
        for (int i = 0; i < grid.getRows().size(); i++) {
            grid.getRows().get(i).getStyle().setFont(font2);
            grid.getRows().get(i).getCells().get(0).getStyle().setBackgroundBrush(PdfBrushes.getCadetBlue());
            grid.getRows().get(i).getCells().get(1).getStyle().setBackgroundBrush(PdfBrushes.getSkyBlue());
        }

        // Create a PdfGridLayoutFormat object to define the grid layout
        PdfGridLayoutFormat layout = new PdfGridLayoutFormat();
        layout.setBreak(PdfLayoutBreakType.Fit_Page);
        layout.setLayout(PdfLayoutType.Paginate);

        // Draw the grid on the page at the specified position with the defined layout format
        return grid.draw(page, new Point2D.Float(0, y), layout);

    }

    // Draws a part of the DataTable on a PDF page with specified formatting.
    static PdfLayoutResult Bookmark_DrawPart(PdfPageBase page, DataTable parts, int index, String title, float y) {
        // Create a TrueType font with Arial, bold, size 10
        PdfTrueTypeFont font1 = new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 10));

        // Get the DataRow from the DataTable based on the index
        DataRow row = parts.getRows().get(index);

        // Draw the title on the page using font1
        page.getCanvas().drawString(title, font1, PdfBrushes.getBlack(), 0, y);

        // Increase the y-coordinate based on the height of the title plus 1 to leave some space
        y = y + (float)font1.measureString(title).getHeight() + 1;

        // Create a 2D array to hold the table data
        Object[][] data = new Object[2][];
        data[0] = new String[parts.getColumns().size()];

        // Populate the first row of the data array with column names
        for (int i = 0; i < parts.getColumns().size(); i++) {
            data[0][i] = parts.getColumns().get(i).getColumnName();
        }

        try {
            // Get the values of the DataRow and populate the second row of the data array
            data[1] = row.getArrayList();
        } catch (DataException e) {
            e.printStackTrace();
        }

        // Create a new PdfTable instance
        PdfTable table = new PdfTable();

        // Set cell padding for the table
        table.getStyle().setCellPadding(2);

        // Set border pen for the table
        table.getStyle().setBorderPen(new PdfPen(PdfBrushes.getBlack(), 0.75f));

        // Set background brush for the default style of the table cells
        table.getStyle().getDefaultStyle().setBackgroundBrush(PdfBrushes.getGreenYellow());

        // Set font for the default style of the table cells
        table.getStyle().getDefaultStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 9)));

        // Set the header source as rows
        table.getStyle().setHeaderSource(PdfHeaderSource.Rows);

        // Set the number of header rows to display
        table.getStyle().setHeaderRowCount(1);

        // Set background brush for the header style
        table.getStyle().getHeaderStyle().setBackgroundBrush(PdfBrushes.getForestGreen());

        // Set font for the header style
        table.getStyle().getHeaderStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 9)));

        // Set string format for the header style to center align the text
        table.getStyle().getHeaderStyle().setStringFormat(new PdfStringFormat(PdfTextAlignment.Center));

        // Enable showing the table header
        table.getStyle().setShowHeader(true);

        // Set the data source for the table
        table.setDataSource(data);

        // Calculate the available width for the table based on the page size and border width
        float width = (float)page.getCanvas().getClientSize().getWidth() - (float)(table.getColumns().getCount() + 1) * table.getStyle().getBorderPen().getWidth();

        // Set the column widths of the table
        for (int i = 0; i < table.getColumns().getCount(); i++) {
            table.getColumns().get(i).setWidth(i == 1 ? width * 0.35f : width * 0.13f);
        }

        // Create a PdfTableLayoutFormat object to define the table layout
        PdfTableLayoutFormat tableLayout = new PdfTableLayoutFormat();
        tableLayout.setBreak(PdfLayoutBreakType.Fit_Page);
        tableLayout.setLayout(PdfLayoutType.Paginate);

        // Draw the table on the page at the specified position with the defined layout format
        return table.draw(page, new Point2D.Float(0, y), tableLayout);

    }

    // This method draws order items in a table format on a PDF page.
    static PdfLayoutResult Bookmark_DrawOrderItems(PdfPageBase page, DataTable orderItems, String title, float y) {
        // Create a TrueType font with Arial, bold, size 9
        PdfTrueTypeFont font1 = new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 9));

        // Draw the title on the page using the font1
        page.getCanvas().drawString(title, font1, PdfBrushes.getBlack(), 0, y);

        // Increase the y-coordinate based on the height of the title plus 1 to leave some space
        y = y + (float)font1.measureString(title).getHeight() + 1;

        // Create a new PdfTable instance
        PdfTable table = new PdfTable();

        // Set cell padding for the table
        table.getStyle().setCellPadding(2);

        // Set border pen for the table
        table.getStyle().setBorderPen(new PdfPen(PdfBrushes.getBlack(), 0.75f));

        // Set background brush for the default style of the table cells
        table.getStyle().getDefaultStyle().setBackgroundBrush(PdfBrushes.getMediumTurquoise());

        // Set font for the default style of the table cells
        table.getStyle().getDefaultStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 8)));

        // Create a new PdfCellStyle instance for alternate style of the table cells
        PdfCellStyle alternateStyle = new PdfCellStyle();

        // Set background brush for the alternate style of the table cells
        alternateStyle.setBackgroundBrush(PdfBrushes.getPaleTurquoise());

        // Set font for the alternate style of the table cells
        alternateStyle.setFont(new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 8)));

        // Set the alternate style for the table
        table.getStyle().setAlternateStyle(alternateStyle);

        // Set the header source as column captions
        table.getStyle().setHeaderSource(PdfHeaderSource.Column_Captions);

        // Set background brush for the header style
        table.getStyle().getHeaderStyle().setBackgroundBrush(PdfBrushes.getTeal());

        // Set font for the header style
        table.getStyle().getHeaderStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 8)));

        // Set string format for the header style to center align the text
        table.getStyle().getHeaderStyle().setStringFormat(new PdfStringFormat(PdfTextAlignment.Center));

        // Enable showing the table header
        table.getStyle().setShowHeader(true);

        // Set the data source for the table as the orderItems collection
        table.setDataSource(orderItems);

        // Set string format for columns starting from index 2
        for (int i = 2; i < table.getColumns().getCount(); i++) {
            table.getColumns().get(i).setStringFormat(new PdfStringFormat(PdfTextAlignment.Right));
        }

        // Configure table layout
        PdfTableLayoutFormat tableLayout = new PdfTableLayoutFormat();
        tableLayout.setBreak(PdfLayoutBreakType.Fit_Page);
        tableLayout.setLayout(PdfLayoutType.Paginate);

        // Draw the table on the page
        return table.draw(page, new Point2D.Float(0, y), tableLayout);
    }

    // This method prepares a PreparedStatement for querying parts based on vendor number.
    static PreparedStatement Bookmark_PreparePartQueryCommand(Connection poConn) {
        try {
            // Prepare the SQL query with placeholders for the vendor number parameter
            PreparedStatement loStatement = poConn.prepareStatement("SELECT PartNo, Description, OnHand, OnOrder, Cost, ListPrice "
                    + "FROM parts WHERE VendorNo = ?");

            return loStatement;
        } catch (SQLException e) {
            // Print the stack trace if an exception occurs during SQL preparation
            e.printStackTrace();
        }

        return null;
    }


    // This method prepares a PreparedStatement for querying order items based on part number.
    static PreparedStatement Bookmark_PrepareOrderItemQueryCommand(Connection poConn) {
        try {
            // Prepare the SQL query with placeholders for the part number parameter
            PreparedStatement loStatement = poConn.prepareStatement("SELECT OrderNo, ItemNo, Qty, Discount "
                    + "FROM items WHERE PartNo = ?");

            return loStatement;
        } catch (SQLException e) {
            // Print the stack trace if an exception occurs during SQL preparation
            e.printStackTrace();
        }

        return null;
    }
}
