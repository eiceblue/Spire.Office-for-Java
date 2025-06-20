import com.spire.data.table.DataTable;
import com.spire.data.table.common.JdbcAdapter;
import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import com.spire.pdf.grid.*;
import java.awt.*;
import java.awt.geom.*;
import java.sql.*;
import java.util.*;

public class grid {
    public static void main(String[] args) {
        // Create a PDF document
        PdfDocument doc = new PdfDocument();

        // Create a unit converter for converting measurement units
        PdfUnitConvertor unitCvtr = new PdfUnitConvertor();

        // Create a new PdfMargins object
        PdfMargins margin = new PdfMargins();

        // Set the top margin by converting centimeters to points using the PdfUnitConvertor
        margin.setTop(unitCvtr.convertUnits(2.54f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));

        // Set the bottom margin equal to the top margin
        margin.setBottom(margin.getTop());

        // Set the left margin by converting centimeters to points using the PdfUnitConvertor
        margin.setLeft(unitCvtr.convertUnits(3.17f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));

        // Set the right margin equal to the left margin
        margin.setRight(margin.getLeft());

        // Create a new page with specified size, margins, rotation, and orientation
        PdfPageBase page = doc.getPages().add(PdfPageSize.A4, margin, PdfPageRotateAngle.Rotate_Angle_0, PdfPageOrientation.Landscape);

        // Set the background color of the page to blue
        page.setBackgroundColor(Color.blue);

        // Set the initial y-coordinate for positioning elements on the page
        float y = 10;

        // Get the width of the canvas on the page
        float x1 = (float) page.getCanvas().getClientSize().getWidth();


        // Create a black brush for drawing
        PdfBrush brush1 = PdfBrushes.getBlack();

        // Create a TrueType font with Arial, bold, and size 16
        PdfTrueTypeFont font1 = new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 16), true);

            // Create a string format with center alignment
        PdfStringFormat format1 = new PdfStringFormat(PdfTextAlignment.Center);

        // Draw the "Vendor List" text on the page using the specified font, brush, position, and format
        page.getCanvas().drawString("Vendor List", font1, brush1, page.getCanvas().getClientSize().getWidth() / 2, y, format1);

        // Update the y-coordinate for positioning elements below the text
        y = y + (float) font1.measureString("Vendor List", format1).getHeight();
        y = y + 5;

        // Define the table data
        String[] data = { "VendorName;Address1;City;State;Country",
                "Cacor Corporation;161 Southfield Rd;Southfield;OH;U.S.A.",
                "Underwater;50 N 3rd Street;Indianapolis;IN;U.S.A.",
                "J.W.  Luscher Mfg.;65 Addams Street;Berkely;MA;U.S.A.",
                "Scuba Professionals;3105 East Brace;Rancho Dominguez;CA;U.S.A.",
                "Divers'  Supply Shop;5208 University Dr;Macon;GA;U.S.A.",
                "Techniques;52 Dolphin Drive;Redwood City;CA;U.S.A.",
                "Perry Scuba;3443 James Ave;Hapeville;GA;U.S.A.",
                "Beauchat, Inc.;45900 SW 2nd Ave;Ft Lauderdale;FL;U.S.A.",
                "Amor Aqua;42 West 29th Street;New York;NY;U.S.A.",
                "Aqua Research Corp.;P.O. Box 998;Cornish;NH;U.S.A.",
                "B&K Undersea Photo;116 W 7th Street;New York;NY;U.S.A.",
                "Diving International Unlimited;1148 David Drive;San Diego;DA;U.S.A.",
                "Nautical Compressors;65 NW 167 Street;Miami;FL;U.S.A.",
                "Glen Specialties, Inc.;17663 Campbell Lane;Huntington Beach;CA;U.S.A.",
                "Dive Time;20 Miramar Ave;Long Beach;CA;U.S.A.",
                "Undersea Systems, Inc.;18112 Gotham Street;Huntington Beach;CA;U.S.A.",
                "Felix Diving;310 S Michigan Ave;Chicago;IL;U.S.A.",
                "Central Valley Skin Divers;160 Jameston Ave;Jamaica;NY;U.S.A.",
                "Parkway Dive Shop;241 Kelly Street;South Amboy;NJ;U.S.A.",
                "Marine Camera & Dive;117 South Valley Rd;San Diego;CA;U.S.A.",
                "Dive Canada;275 W Ninth Ave;Vancouver;British Columbia;Canada",
                "Dive & Surf;P.O. Box 20210;Indianapolis;IN;U.S.A.",
                "Fish Research Labs;29 Wilkins Rd Dept. SD;Los Banos;CA;U.S.A." };

        // Create a PdfGrid instance
        PdfGrid grid = new PdfGrid();

        // Set the cell padding for the grid
        grid.getStyle().setCellPadding(new PdfPaddings(1, 1, 1, 1));

        // Split the header row into an array of strings
        String[] header = data[0].split(";");

        // Add columns to the grid based on the number of header elements
        grid.getColumns().add(header.length);

        // Calculate the available width for the columns by subtracting the extra space needed for column separators
        float width = (float) page.getCanvas().getClientSize().getWidth() - (float) (grid.getColumns().getCount() + 1);

        // Set the width of the first column to 25% of the available width
        grid.getColumns().get(0).setWidth(width * 0.25f);

        // Set the width of the second column to 25% of the available width
        grid.getColumns().get(1).setWidth(width * 0.25f);

        // Set the width of the third column to 25% of the available width
        grid.getColumns().get(2).setWidth(width * 0.25f);

        // Set the width of the fourth column to 15% of the available width
        grid.getColumns().get(3).setWidth(width * 0.15f);

        // Set the width of the fifth column to 10% of the available width
        grid.getColumns().get(4).setWidth(width * 0.10f);


        // Add a header row to the grid
        PdfGridRow headerRow = grid.getHeaders().add(1)[0];

        // Set the font style for the header row
        headerRow.getStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 11), true));

        // Set the background brush for the header row using a linear gradient
        headerRow.getStyle().setBackgroundBrush(new PdfLinearGradientBrush(new Point2D.Float(0, 0), new Point2D.Float(x1, 0), new PdfRGBColor(Color.red), new PdfRGBColor(Color.blue)));

        // Iterate over each header element
        for (int i = 0; i < header.length; i++) {
            // Set the value and string format for each header cell
            headerRow.getCells().get(i).setValue(header[i]);
            headerRow.getCells().get(i).setStringFormat(new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle));

            // Set the background brush for the first header cell
            if (i == 0) {
                headerRow.getCells().get(i).getStyle().setBackgroundBrush(PdfBrushes.getGray());
            }
        }

        // Randomly generate colors for each data row and add rows to the grid
        Random random = new Random();
        HashMap<String, Integer> groupByCountry = new HashMap<String, Integer>();

        // Iterate over each data row
        for (int r = 1; r < data.length; r++) {
            PdfGridRow row = grid.getRows().add();
            row.getStyle().setFont(new PdfTrueTypeFont(new Font("Arial", 0, 10), true));

            // Generate random colors for the background brush of each row
            byte[] buffer = new byte[6];
            random.nextBytes(buffer);
            PdfRGBColor color1 = new PdfRGBColor(buffer[0], buffer[1], buffer[2]);
            PdfRGBColor color2 = new PdfRGBColor(buffer[3], buffer[4], buffer[5]);
            row.getStyle().setBackgroundBrush(new PdfLinearGradientBrush(new Point2D.Float(0, 0), new Point2D.Float(x1, 0), color1, color2));

            // Split the data row into an array of values
            String[] rowData = data[r].split(";");

            // Iterate over each value in the data row
            for (int c = 0; c < rowData.length; c++) {
                // Set the value and style for each cell in the row
                row.getCells().get(c).setValue(rowData[c]);

                // Set the background brush for the first cell in each row
                if (c == 0) {
                    row.getCells().get(c).getStyle().setBackgroundBrush(PdfBrushes.getGray());
                }

                // Set the string format based on the cell's position
                if (c < 3) {
                    row.getCells().get(c).setStringFormat(new PdfStringFormat(PdfTextAlignment.Left, PdfVerticalAlignment.Middle));
                } else {
                    row.getCells().get(c).setStringFormat(new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle));
                }

                // Update the groupByCountry map to count occurrences of a specific country in the last column
                if (c == 4) {
                    if (groupByCountry.containsKey(rowData[c])) {
                        groupByCountry.put(rowData[c], groupByCountry.get(rowData[c]) + 1);
                    } else {
                        groupByCountry.put(rowData[c], 1);
                    }
                }
            }
        }

        // Generate a StringBuilder to store total amounts grouped by country
        StringBuilder totalAmount = new StringBuilder();

        // Iterate over the groupByCountry map and append each country and its corresponding count to the StringBuilder
        for (Map.Entry<String, Integer> country : groupByCountry.entrySet()) {
            totalAmount.append(String.format("%1$s:\t%2$s", country.getKey(), country.getValue()));
            totalAmount.append("\r\n");
        }

        // Add a total amount row to the grid
        PdfGridRow totalAmountRow = grid.getRows().add();

        // Set the background brush for the total amount row
        totalAmountRow.getStyle().setBackgroundBrush(PdfBrushes.getPlum());

        // Set the value, font, and string format for the first cell in the total amount row
        totalAmountRow.getCells().get(0).setValue("Total Amount");
        totalAmountRow.getCells().get(0).getStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 10), true));
        totalAmountRow.getCells().get(0).setStringFormat(new PdfStringFormat(PdfTextAlignment.Left, PdfVerticalAlignment.Middle));

        // Set the column span and value for the second cell in the total amount row
        totalAmountRow.getCells().get(1).setColumnSpan(4);
        totalAmountRow.getCells().get(1).setValue(totalAmount.toString());

        // Set the font and string format for the second cell in the total amount row
        totalAmountRow.getCells().get(1).getStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.BOLD | Font.ITALIC, 10), true));
        totalAmountRow.getCells().get(1).setStringFormat(new PdfStringFormat(PdfTextAlignment.Right, PdfVerticalAlignment.Middle));

        // Create a new PdfGrid for the product list
        PdfGrid productList = new PdfGrid();
        productList.getStyle().setFont(new PdfTrueTypeFont(new Font("Arial", 0, 8), true));

        // Set up database connection and retrieve data
        String url = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=" + "data/demo.mdb";
        DataTable dataTable = new DataTable();

        try {
            // Establish a connection to the database
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection conn = DriverManager.getConnection(url);
            Statement sta = conn.createStatement();

            // Execute a SQL query to retrieve the product list for a specific vendor
            String lcCommandText = "SELECT p.Description "
                    + "FROM vendors v "
                    + "INNER JOIN parts p ON v.VendorNo = p.VendorNo "
                    + "WHERE v.VendorName = 'Cacor Corporation'";
            ResultSet resultSet = sta.executeQuery(lcCommandText);

            // Fill the DataTable with the query results using JdbcAdapter
            JdbcAdapter jdbcAdapter = new JdbcAdapter();
            jdbcAdapter.fillDataTable(dataTable, resultSet);

            // Set the DataTable as the data source for the productList PdfGrid
            productList.setDataSource(dataTable);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Set the value of the header cell in the productList to "Cacor Corporation"
        productList.getHeaders().get(0).getCells().get(0).setValue("Cacor Corporation");

        // Set the font style for the header cell to Arial, bold, and a size of 8
        productList.getHeaders().get(0).getCells().get(0).getStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 8), true));

        // Create a Dimension object with dimensions (1, 1)
        Dimension2D dimension2D = new Dimension();
        dimension2D.setSize(1, 1);

        // Set the borders for the header cell using a PdfPen with a PdfTilingBrush and thickness of 0
        productList.getHeaders().get(0).getCells().get(0).getStyle().getBorders().setAll(new PdfPen(new PdfTilingBrush(dimension2D), 0));

        // Set the productList as the value of the first cell in the existing grid
        grid.getRows().get(0).getCells().get(0).setValue(productList);
        grid.getRows().get(0).getCells().get(0).getStringFormat().setAlignment(PdfTextAlignment.Left);

        // Draw the grid on the page and update the vertical position
        PdfLayoutResult result = grid.draw(page, new Point2D.Float(0, y));
        y = y + (float) result.getBounds().getHeight() + 5;

        // Add a text string to the page indicating the total number of vendors
        PdfBrush brush2 = PdfBrushes.getGray();
        PdfTrueTypeFont font2 = new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 9));
        result.getPage().getCanvas().drawString(String.format("* All %1$s vendors in the list", grid.getRows().size() - 1), font2, brush2, 5, y);

        //Save pdf file.
        doc.saveToFile("output/grid.pdf");

        // Close the PDF document
        doc.close();

        // Dispose of the PDF document (frees up system resources)
        doc.dispose();
    }
}
