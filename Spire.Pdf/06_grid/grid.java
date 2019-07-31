import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import com.spire.pdf.grid.*;
import com.spire.pdf.tables.table.DataTable;
import com.spire.pdf.tables.table.common.JdbcAdapter;
import java.awt.*;
import java.awt.geom.*;
import java.sql.*;
import java.util.*;

public class grid {
    public static void main(String[] args) {
        //Create a pdf document.
        PdfDocument doc = new PdfDocument();

        //Set margin
        PdfUnitConvertor unitCvtr = new PdfUnitConvertor();
        PdfMargins margin = new PdfMargins();
        margin.setTop(unitCvtr.convertUnits(2.54f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
        margin.setBottom(margin.getTop());
        margin.setLeft(unitCvtr.convertUnits(3.17f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
        margin.setRight(margin.getLeft());

        // Create one page
        PdfPageBase page = doc.getPages().add(PdfPageSize.A4, margin, PdfPageRotateAngle.Rotate_Angle_0, PdfPageOrientation.Landscape);
        page.setBackgroundColor(Color.blue);

        float y = 10;
        float x1 = (float) page.getCanvas().getClientSize().getWidth();

        //title
        PdfBrush brush1 = PdfBrushes.getBlack();
        PdfTrueTypeFont font1 = new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 16), true);
        PdfStringFormat format1 = new PdfStringFormat(PdfTextAlignment.Center);
        page.getCanvas().drawString("Vendor List", font1, brush1, page.getCanvas().getClientSize().getWidth() / 2, y, format1);
        y = y + (float) font1.measureString("Vendor List", format1).getHeight();
        y = y + 5;

        String[] data = {"VendorName;Address1;City;State;Country", "Cacor Corporation;161 Southfield Rd;Southfield;OH;U.S.A.", "Underwater;50 N 3rd Street;Indianapolis;IN;U.S.A.", "J.W.  Luscher Mfg.;65 Addams Street;Berkely;MA;U.S.A.", "Scuba Professionals;3105 East Brace;Rancho Dominguez;CA;U.S.A.", "Divers'  Supply Shop;5208 University Dr;Macon;GA;U.S.A.", "Techniques;52 Dolphin Drive;Redwood City;CA;U.S.A.", "Perry Scuba;3443 James Ave;Hapeville;GA;U.S.A.", "Beauchat, Inc.;45900 SW 2nd Ave;Ft Lauderdale;FL;U.S.A.", "Amor Aqua;42 West 29th Street;New York;NY;U.S.A.", "Aqua Research Corp.;P.O. Box 998;Cornish;NH;U.S.A.", "B&K Undersea Photo;116 W 7th Street;New York;NY;U.S.A.", "Diving International Unlimited;1148 David Drive;San Diego;DA;U.S.A.", "Nautical Compressors;65 NW 167 Street;Miami;FL;U.S.A.", "Glen Specialties, Inc.;17663 Campbell Lane;Huntington Beach;CA;U.S.A.", "Dive Time;20 Miramar Ave;Long Beach;CA;U.S.A.", "Undersea Systems, Inc.;18112 Gotham Street;Huntington Beach;CA;U.S.A.", "Felix Diving;310 S Michigan Ave;Chicago;IL;U.S.A.", "Central Valley Skin Divers;160 Jameston Ave;Jamaica;NY;U.S.A.", "Parkway Dive Shop;241 Kelly Street;South Amboy;NJ;U.S.A.", "Marine Camera & Dive;117 South Valley Rd;San Diego;CA;U.S.A.", "Dive Canada;275 W Ninth Ave;Vancouver;British Columbia;Canada", "Dive & Surf;P.O. Box 20210;Indianapolis;IN;U.S.A.", "Fish Research Labs;29 Wilkins Rd Dept. SD;Los Banos;CA;U.S.A."};
        PdfGrid grid = new PdfGrid();
        grid.getStyle().setCellPadding(new PdfPaddings(1, 1, 1, 1));

        String[] header = data[0].split(";");
        grid.getColumns().add(header.length);
        float width = (float) page.getCanvas().getClientSize().getWidth() - (float) (grid.getColumns().getCount() + 1);
        grid.getColumns().get(0).setWidth(width * 0.25f);
        grid.getColumns().get(1).setWidth(width * 0.25f);
        grid.getColumns().get(2).setWidth(width * 0.25f);
        grid.getColumns().get(3).setWidth(width * 0.15f);
        grid.getColumns().get(4).setWidth(width * 0.10f);

        PdfGridRow headerRow = grid.getHeaders().add(1)[0];
        headerRow.getStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 11), true));

        headerRow.getStyle().setBackgroundBrush(new PdfLinearGradientBrush(new Point2D.Float(0, 0), new Point2D.Float(x1, 0), new PdfRGBColor(Color.red), new PdfRGBColor(Color.blue)));
        for (int i = 0; i < header.length; i++) {
            headerRow.getCells().get(i).setValue(header[i]);
            headerRow.getCells().get(i).setStringFormat(new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle));
            if (i == 0) {
                headerRow.getCells().get(i).getStyle().setBackgroundBrush(PdfBrushes.getGray());
            }
        }

        Random random = new Random();
        HashMap<String, Integer> groupByCountry = new HashMap<String, Integer>();
        for (int r = 1; r < data.length; r++) {

            PdfGridRow row = grid.getRows().add();
            row.getStyle().setFont(new PdfTrueTypeFont(new Font("Arial", 0, 10), true));
            byte[] buffer = new byte[6];
            random.nextBytes(buffer);
            PdfRGBColor color1 = new PdfRGBColor(buffer[0], buffer[1], buffer[2]);
            PdfRGBColor color2 = new PdfRGBColor(buffer[3], buffer[4], buffer[5]);
            row.getStyle().setBackgroundBrush(new PdfLinearGradientBrush(new Point2D.Float(0, 0), new Point2D.Float(x1, 0), color1, color2));
            String[] rowData = data[r].split(";");
            for (int c = 0; c < rowData.length; c++) {
                row.getCells().get(c).setValue(rowData[c]);
                if (c == 0) {
                    row.getCells().get(c).getStyle().setBackgroundBrush(PdfBrushes.getGray());
                }
                if (c < 3) {
                    row.getCells().get(c).setStringFormat(new PdfStringFormat(PdfTextAlignment.Left, PdfVerticalAlignment.Middle));
                } else {
                    row.getCells().get(c).setStringFormat(new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle));
                }
                if (c == 4) {
                    if (groupByCountry.containsKey(rowData[c])) {
                        groupByCountry.put(rowData[c], groupByCountry.get(rowData[c]) + 1);
                    } else {
                        groupByCountry.put(rowData[c], 1);
                    }
                }
            }
        }
        StringBuilder totalAmount = new StringBuilder();
        for (Map.Entry<String, Integer> country : groupByCountry.entrySet()) {
            totalAmount.append(String.format("%1$s:\t%2$s", country.getKey(), country.getValue()));
            totalAmount.append("\r\n");
        }


        PdfGridRow totalAmountRow = grid.getRows().add();
        totalAmountRow.getStyle().setBackgroundBrush(PdfBrushes.getPlum());
        totalAmountRow.getCells().get(0).setValue("Total Amount");
        totalAmountRow.getCells().get(0).getStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 10), true));
        totalAmountRow.getCells().get(0).setStringFormat(new PdfStringFormat(PdfTextAlignment.Left, PdfVerticalAlignment.Middle));
        totalAmountRow.getCells().get(1).setColumnSpan(4);
        totalAmountRow.getCells().get(1).setValue(totalAmount.toString());
        totalAmountRow.getCells().get(1).getStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.BOLD | Font.ITALIC, 10), true));
        totalAmountRow.getCells().get(1).setStringFormat(new PdfStringFormat(PdfTextAlignment.Right, PdfVerticalAlignment.Middle));

        //Append product list
        PdfGrid productList = new PdfGrid();
        productList.getStyle().setFont(new PdfTrueTypeFont(new Font("Arial", 0, 8), true));

        String url = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=" + "data/demo.mdb";
        DataTable dataTable = new DataTable();
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            try {
                Connection conn = DriverManager.getConnection(url);
                Statement sta = conn.createStatement();
                String lcCommandText = " select p.Description "
                        + " from vendors v "
                        + "     inner join parts p "
                        + "     on v.VendorNo = p.VendorNo "
                        + " where v.VendorName = 'Cacor Corporation'";
                ResultSet resultSet = sta.executeQuery(lcCommandText);
                JdbcAdapter jdbcAdapter = new JdbcAdapter();
                jdbcAdapter.fillDataTable(dataTable, resultSet);

                productList.setDataSource(dataTable);

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        productList.getHeaders().get(0).getCells().get(0).setValue("Cacor Corporation");
        productList.getHeaders().get(0).getCells().get(0).getStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 8), true));
        Dimension2D dimension2D = new Dimension();
        dimension2D.setSize(1, 1);
        productList.getHeaders().get(0).getCells().get(0).getStyle().getBorders().setAll(new PdfPen(new PdfTilingBrush(dimension2D), 0));
        grid.getRows().get(0).getCells().get(0).setValue(productList);
        grid.getRows().get(0).getCells().get(0).getStringFormat().setAlignment(PdfTextAlignment.Left);

        PdfLayoutResult result = grid.draw(page, new Point2D.Float(0, y));
        y = y + (float) result.getBounds().getHeight() + 5;

        PdfBrush brush2 = PdfBrushes.getGray();
        PdfTrueTypeFont font2 = new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 9));
        result.getPage().getCanvas().drawString(String.format("* All %1$s vendors in the list", grid.getRows().size() - 1), font2, brush2, 5, y);

        //Save pdf file.
        doc.saveToFile("output/grid.pdf");
        doc.close();

    }
}
