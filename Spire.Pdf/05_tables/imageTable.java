import com.spire.data.table.*;
import com.spire.data.table.common.JdbcAdapter;
import com.spire.pdf.PdfDocument;
import com.spire.pdf.PdfPageBase;
import com.spire.pdf.PdfPageSize;
import com.spire.pdf.graphics.*;
import com.spire.pdf.tables.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.io.ByteArrayInputStream;
import java.sql.*;

public class imageTable {
    public static void main(String[] args) {

        // Create a new PDF document.
        PdfDocument doc = new PdfDocument();

        // Create a unit converter for converting measurement units.
        PdfUnitConvertor unitCvtr = new PdfUnitConvertor();

        // Create a margins object to set the page margins.
        PdfMargins margin = new PdfMargins();

        // Set the top margin by converting 2.54 centimeters to points.
        margin.setTop(unitCvtr.convertUnits(2.54f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));

        // Set the bottom margin equal to the top margin.
        margin.setBottom(margin.getTop());

        // Set the left margin by converting 3.17 centimeters to points.
        margin.setLeft(unitCvtr.convertUnits(3.17f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));

        // Set the right margin equal to the left margin.
        margin.setRight(margin.getLeft());

        // Add a new page to the document with A4 size and the specified margins.
        PdfPageBase page = doc.getPages().add(PdfPageSize.A4, margin);

        // Initialize the starting Y-coordinate for drawing content on the page.
        float y = 10;

        // Create a black brush for text color.
        PdfBrush brush1 = PdfBrushes.getBlack();

        // Create a TrueType font object with Arial, bold style, and size 16.
        PdfTrueTypeFont font1 = new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 16));

        // Create a string format object with center alignment.
        PdfStringFormat format1 = new PdfStringFormat(PdfTextAlignment.Center);

        // Draw the "Country List" text on the page's canvas at the center of the page.
        page.getCanvas().drawString("Country List", font1, brush1, page.getCanvas().getClientSize().getWidth() / 2, y, format1);

        // Update the Y-coordinate by adding the height of the drawn text.
        y = y + (float) font1.measureString("Country List", format1).getHeight();

        // Add a spacing of 5 units after the title.
        y = y + 5;

        // Create a new PDF table object.
        PdfTable table = new PdfTable();

        // Set cell padding and border properties for the table.
        table.getStyle().setCellPadding(2);
        table.getStyle().setBorderPen(new PdfPen(brush1, 0.75f));

        // Set default style properties for table cells.
        table.getStyle().getDefaultStyle().setBackgroundBrush(PdfBrushes.getSkyBlue());
        table.getStyle().getDefaultStyle().setFont(new PdfTrueTypeFont(new Font("Arial", 0, 10)));

        // Set alternate style properties for alternating rows in the table.
        table.getStyle().setAlternateStyle(new PdfCellStyle());
        table.getStyle().getAlternateStyle().setBackgroundBrush(PdfBrushes.getLightYellow());
        table.getStyle().getAlternateStyle().setFont(new PdfTrueTypeFont(new Font("Arial", 0, 10)));

        // Set the header source to use column captions.
        table.getStyle().setHeaderSource(PdfHeaderSource.Column_Captions);

        // Set style properties for the table header.
        table.getStyle().getHeaderStyle().setBackgroundBrush(PdfBrushes.getCadetBlue());
        table.getStyle().getHeaderStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 11)));
        table.getStyle().getHeaderStyle().setStringFormat(new PdfStringFormat(PdfTextAlignment.Center));

        // Specify that the table should display a header.
        table.getStyle().setShowHeader(true);

        // Specify the URL for connecting to the Microsoft Access database.
        String url = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=" + "data/demo.mdb";

        // Create a new DataTable object.
        DataTable dataTable = new DataTable();

        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            try {

                // Establish a connection to the database.
                Connection conn = DriverManager.getConnection(url);
                Statement sta = conn.createStatement();

                // Execute the SQL query to retrieve data from the "country" table.
                ResultSet resultSet = sta.executeQuery("select Name, '' as Flags, Capital, Continent, Area, Population, Flag as FlagData from country");

                // Create a JDBC adapter for filling the DataTable.
                JdbcAdapter jdbcAdapter = new JdbcAdapter();

                // Fill the DataTable with data from the result set.
                jdbcAdapter.fillDataTable(dataTable, resultSet);

                // Add a new column named "FlagImage" to the DataTable.
                dataTable.getColumns().add(new DataColumn("FlagImage", 0));

                // Set the data source type of the table to direct.
                table.setDataSourceType(PdfTableDataSourceType.Table_Direct);

                // Set the DataTable as the data source for the PDF table.
                table.setDataSource(dataTable);

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        // Calculate the available width for the table by subtracting the total column and border widths from the page canvas width.
        float width = (float) page.getCanvas().getClientSize().getWidth() - (float) (table.getColumns().getCount() + 1) * table.getStyle().getBorderPen().getWidth();

        // Set the width and string format for the first column in the table.
        table.getColumns().get(0).setWidth(width * 0.21f);
        // Set the alignment of text within cells of the first column.
        table.getColumns().get(0).setStringFormat(new PdfStringFormat(PdfTextAlignment.Left, PdfVerticalAlignment.Middle));

        // Set the width and string format for the second column in the table.
        table.getColumns().get(1).setWidth(width * 0.10f);
        table.getColumns().get(1).setStringFormat(new PdfStringFormat(PdfTextAlignment.Left, PdfVerticalAlignment.Middle));

        // Set the width and string format for the third column in the table.
        table.getColumns().get(2).setWidth(width * 0.19f);
        table.getColumns().get(2).setStringFormat(new PdfStringFormat(PdfTextAlignment.Left, PdfVerticalAlignment.Middle));

        // Set the width and string format for the fourth column in the table.
        table.getColumns().get(3).setWidth(width * 0.21f);
        table.getColumns().get(3).setStringFormat(new PdfStringFormat(PdfTextAlignment.Left, PdfVerticalAlignment.Middle));

        // Set the width and string format for the fifth column in the table.
        table.getColumns().get(4).setWidth(width * 0.12f);
        table.getColumns().get(4).setStringFormat(new PdfStringFormat(PdfTextAlignment.Right, PdfVerticalAlignment.Middle));

        // Set the width and string format for the sixth column in the table.
        table.getColumns().get(5).setWidth(width * 0.17f);
        table.getColumns().get(5).setStringFormat(new PdfStringFormat(PdfTextAlignment.Right, PdfVerticalAlignment.Middle));


        // Add a BeginRowLayout event handler to the table
        table.beginRowLayout.add(new BeginRowLayoutEventHandler() {
            @Override
            public void invoke(Object sender, BeginRowLayoutEventArgs args) {
                try {
                    // Call the imageTable_BeginRowLayout method with the sender and arguments.
                    imageTable_BeginRowLayout(sender, args);
                } catch (DataException e) {
                    e.printStackTrace();
                }
            }
        });

        // Add an EndCellLayout event handler to the table
        table.endCellLayout.add(new EndCellLayoutEventHandler() {
            @Override
            public void invoke(Object sender, EndCellLayoutEventArgs args) {
                try {
                    // Call the imageTable_EndCellLayout method with the sender and arguments.
                    imageTable_EndCellLayout(sender, args);
                } catch (DataException e) {
                    e.printStackTrace();
                }
            }
        });

        // Create a PdfTableLayoutFormat object
        PdfTableLayoutFormat tableLayout = new PdfTableLayoutFormat();

        // Specify how the table should break across pages.
        tableLayout.setBreak(PdfLayoutBreakType.Fit_Element);

        // Set the layout type for the table.
        tableLayout.setLayout(PdfLayoutType.Paginate);

        // Set the end column index for the layout.
        tableLayout.setEndColumnIndex(table.getColumns().getCount() - 2 - 1); 

        // Draw the table on the page using the specified layout format and position
        PdfLayoutResult result = table.draw(page, new Point2D.Float(0, y), tableLayout);

        // Update the vertical position for subsequent content
        y = y + (float) result.getBounds().getHeight() + 5;

        // Define the brush and font for drawing the text
        PdfBrush brush2 = PdfBrushes.getGray();
        PdfTrueTypeFont font2 = new PdfTrueTypeFont(new Font("Arial", 0, 9));

        // Draw the text on the page
        page.getCanvas().drawString(String.format("* %1$s countries in the list.", table.getRows().getCount()), font2, brush2, 5, y);

        //Save pdf file.
        doc.saveToFile("output/imageTable.pdf");

        // Close the PDF document
        doc.close();

        // Dispose of the PDF document (frees up system resources)
        doc.dispose();
    }

     // This method is triggered at the end of cell layout in an image table.
    static void imageTable_EndCellLayout(Object sender, EndCellLayoutEventArgs args) throws DataException {
        if (args.getRowIndex() < 0) {
            // If the row index is less than 0, it indicates the header. Skip processing.
            return;
        }

        if (args.getCellIndex() == 1) {
            // Check if the current cell is the second cell (index 1).

            // Get the data source of the PdfTable object.
            Object tempVar = ((PdfTable) ((sender instanceof PdfTable) ? sender : null)).getDataSource();
            DataTable dataTable = (DataTable) ((tempVar instanceof DataTable) ? tempVar : null);

            // Extract the image from the DataTable row and cast it to PdfImage.
            PdfImage image = ((dataTable.getRows().get(args.getRowIndex()).getObject(7) instanceof PdfImage) ? (PdfImage)((dataTable.getRows().get(args.getRowIndex()).getObject(7))) : null);

            // Calculate the X and Y coordinates for centering the image within the cell.
            float x = ((float) args.getBounds().getWidth() - (float) image.getPhysicalDimension().getWidth()) / 2 + (float) args.getBounds().getX();
            float y = ((float) args.getBounds().getHeight() - (float) image.getPhysicalDimension().getHeight()) / 2 + (float) args.getBounds().getY();

            // Draw the image on the graphics object at the calculated position.
            args.getGraphics().drawImage(image, x, y);
        }
    }


    // This method is triggered at the beginning of row layout in an image table.
    static void imageTable_BeginRowLayout(Object sender, BeginRowLayoutEventArgs args) throws DataException {
        if (args.getRowIndex() < 0) {
            // If the row index is less than 0, it indicates the header. Skip processing.
            return;
        }

        // Get the data source of the PdfTable object.
        Object tempVar = ((PdfTable) ((sender instanceof PdfTable) ? sender : null)).getDataSource();
        DataTable dataTable = (DataTable) ((tempVar instanceof DataTable) ? tempVar : null);

        // Extract the image data from the DataTable row and convert it to a byte array input stream.
        byte[] imageData = (byte[]) ((dataTable.getRows().get(args.getRowIndex()).getObject(6) instanceof byte[]) ? (dataTable.getRows().get(args.getRowIndex()).getObject(6)) : null);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(imageData);

        // Create a PdfImage object from the input stream.
        PdfImage image = PdfImage.fromStream(inputStream);

        // Set the minimal height of the row based on the height of the image.
        args.setMinimalHeight(4 + image.getPhysicalDimension().getHeight());

        // Update the DataTable row with the PdfImage object for later use.
        dataTable.getRows().get(args.getRowIndex()).setObject(7, image);
    }
}
