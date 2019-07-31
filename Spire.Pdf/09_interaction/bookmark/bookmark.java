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
            //Create a pdf document.
            PdfDocument doc = new PdfDocument();
            //Set margin
            PdfUnitConvertor unitCvtr = new PdfUnitConvertor();
            PdfMargins margin = new PdfMargins();
            margin.setTop(unitCvtr.convertUnits(2.54f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
            margin.setBottom(margin.getTop());
            margin.setLeft(unitCvtr.convertUnits(3.17f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
            margin.setRight(margin.getLeft());

            //Create section
            PdfSection section = doc.getSections().add();
            section.getPageSettings().setSize(PdfPageSize.A4);
            section.getPageSettings().setMargins(margin);

            // Create one page
            PdfPageBase page = section.getPages().add();

            float y = 10;

            //Title
            PdfBrush brush1 = PdfBrushes.getBlack();
            PdfTrueTypeFont font1 = new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 16));
            PdfStringFormat format1 = new PdfStringFormat(PdfTextAlignment.Center);
            page.getCanvas().drawString("Sales Report", font1, brush1, page.getCanvas().getClientSize().getWidth() / 2, y, format1);
            y = y + (float) font1.measureString("Sales Report", format1).getHeight();
            y = y + 5;

            String url = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=" + "data/demo.mdb";
            DataTable dataTable = new DataTable();
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection conn = DriverManager.getConnection(url);

            PreparedStatement partQueryCommand = Bookmark_PreparePartQueryCommand(conn);
            PreparedStatement orderItemQueryCommand = Bookmark_PrepareOrderItemQueryCommand(conn);

            DataTable vendors = Bookmark_GetVendors(conn);
            for (int i = 0; i < vendors.getRows().size(); i++) {
                if (i > 0) {
                    //Next page
                  page =  section.getPages().add();
                    y = 0;
                }
                //Draw vendor
                String vendorTitle = String.format("%1$s. %2$s", i + 1, vendors.getRows().get(i).getArrayList()[1]);
                PdfLayoutResult drawVendorLayoutResult = Bookmark_DrawVendor(page, vendors, i, vendorTitle, y);

                //Add vendor bookmark
                PdfDestination vendorBookmarkDest = new PdfDestination(page, new Point2D.Float(0, y));
                doc.getBookmarks().add(vendorTitle);
                PdfBookmark vendorBookmark = doc.getBookmarks().add(vendorTitle);
                vendorBookmark.setColor(new PdfRGBColor(new Color(139, 69, 19)) /*saddleBrown*/);
                vendorBookmark.setDisplayStyle(PdfTextStyle.Bold);
                vendorBookmark.setAction(new PdfGoToAction(vendorBookmarkDest));

                y = (float) drawVendorLayoutResult.getBounds().getY() + (float) drawVendorLayoutResult.getBounds().getHeight() + 5;
                page = drawVendorLayoutResult.getPage();


                //Get parts of vendor
                DataTable parts = Bookmark_GetParts(partQueryCommand, (Double) vendors.getRows().get(i).getArrayList()[0]);
                for (int j = 0; j < parts.getRows().size(); j++) {
                    if (j > 0) {
                        //Next page
                        page = section.getPages().add();
                        y = 0;
                    }
                    //Draw part
                    String partTitle = String.format("%1$s.%2$s. %3$s", i + 1, j + 1, parts.getRows().get(j).getArrayList()[1]);
                    PdfLayoutResult drawPartLayoutResult = Bookmark_DrawPart(page, parts, j, partTitle, y);

                    //Add part bookmark
                    PdfDestination partBookmarkDest = new PdfDestination(page, new Point2D.Float(0, y));
                    PdfBookmark partBookmark = vendorBookmark.add(partTitle);
                    partBookmark.setColor(new PdfRGBColor(new Color(255, 127, 80)));
                    partBookmark.setDisplayStyle(PdfTextStyle.Italic);
                    partBookmark.setAction(new PdfGoToAction(partBookmarkDest));

                    y = (float) drawPartLayoutResult.getBounds().getY() + (float) drawPartLayoutResult.getBounds().getHeight() + 5;
                    page = drawPartLayoutResult.getPage();

                    //Get order items
                    String orderItemsTitle = String.format("%1$s - Order Items", parts.getRows().get(j).getArrayList()[1]);
                    DataTable orderItems = Bookmark_GetParts(orderItemQueryCommand, (Double) parts.getRows().get(j).getArrayList()[0]);
                    Bookmark_DrawOrderItems(page, orderItems, orderItemsTitle, y);
                }
            }

            //Save pdf file.
            doc.saveToFile("output/bookmarks.pdf");
            doc.close();
        }
        static DataTable Bookmark_GetVendors(Connection poConn) throws Exception {
            try {
                Statement loState = poConn.createStatement();
                String query = " SELECT VendorNo, VendorName, Address1, City, State, Zip, Country, Phone, FAX   FROM vendors ";
                ResultSet resultSet = loState.executeQuery(query);
                DataTable dataTable = new DataTable();
                JdbcAdapter adapter = new JdbcAdapter();
                adapter.fillDataTable(dataTable, resultSet);
                return dataTable;
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        static DataTable Bookmark_GetParts(PreparedStatement poStatement, double vendorId) {
            try {
                poStatement.setString(1, vendorId + "");

                ResultSet resultSet = poStatement.executeQuery();
                DataTable dataTable = new DataTable();
                JdbcAdapter adapter = new JdbcAdapter();
                adapter.fillDataTable(dataTable, resultSet);
                return dataTable;
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
        static PdfLayoutResult Bookmark_DrawVendor(PdfPageBase page, DataTable vendors, int index, String title, float y) {
            //Draw title
            PdfTrueTypeFont font1 = new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 11));
            DataRow row = vendors.getRows().get(index);
            page.getCanvas().drawString(title, font1, PdfBrushes.getBlack(), 0, y);
            y = y + (float) font1.measureString(title).getHeight() + 1;

            //Draw table
            Object[][] data = new Object[vendors.getColumns().size()][];
            for (int i = 0; i < vendors.getColumns().size(); i++) {
                data[i] = new Object[2];
                data[i][0] = vendors.getColumns().get(i).getColumnName();
                try {
                    data[i][1] = vendors.getRows().get(index).getArrayList()[i];///*.ItemArray*/;
                } catch (DataException e) {
                    e.printStackTrace();
                }
            }

            PdfGrid grid = new PdfGrid();
            grid.getStyle().setCellPadding(new PdfPaddings(2, 2, 1, 1));
            grid.setDataSource(data);

            float width = (float) page.getCanvas().getClientSize().getWidth() - (grid.getColumns().getCount() + 1) * 0.75f;
            grid.getColumns().get(0).setWidth(width * 0.20f);
            grid.getColumns().get(1).setWidth(width * 0.80f);

            PdfTrueTypeFont font2 = new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 10));
            for (int i = 0; i < grid.getRows().size(); i++) {
                grid.getRows().get(i).getStyle().setFont(font2);
                grid.getRows().get(i).getCells().get(0).getStyle().setBackgroundBrush(PdfBrushes.getCadetBlue());
                grid.getRows().get(i).getCells().get(1).getStyle().setBackgroundBrush(PdfBrushes.getSkyBlue());
            }

            PdfGridLayoutFormat layout = new PdfGridLayoutFormat();
            layout.setBreak(PdfLayoutBreakType.Fit_Page);
            layout.setLayout(PdfLayoutType.Paginate);

            return grid.draw(page, new Point2D.Float(0, y), layout);
        }

        static PdfLayoutResult Bookmark_DrawPart(PdfPageBase page, DataTable parts, int index, String title, float y) {
            //Draw title
            PdfTrueTypeFont font1 = new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 10));
            DataRow row = parts.getRows().get(index);
            page.getCanvas().drawString(title, font1, PdfBrushes.getBlack(), 0, y);
            y = y + (float) font1.measureString(title).getHeight() + 1;

            //Draw table
            Object[][] data = new Object[2][];
            data[0] = new String[parts.getColumns().size()];
            for (int i = 0; i < parts.getColumns().size(); i++) {
                data[0][i] = parts.getColumns().get(i).getColumnName();
            }
            try {
                data[1] = row.getArrayList();
            } catch (DataException e) {
                e.printStackTrace();
            }

            PdfTable table = new PdfTable();
            table.getStyle().setCellPadding(2);
            table.getStyle().setBorderPen(new PdfPen(PdfBrushes.getBlack(), 0.75f));
            table.getStyle().getDefaultStyle().setBackgroundBrush(PdfBrushes.getGreenYellow());
            table.getStyle().getDefaultStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 9)));
            table.getStyle().setHeaderSource(PdfHeaderSource.Rows);
            table.getStyle().setHeaderRowCount(1);
            table.getStyle().getHeaderStyle().setBackgroundBrush(PdfBrushes.getForestGreen());
            table.getStyle().getHeaderStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 9)));
            table.getStyle().getHeaderStyle().setStringFormat(new PdfStringFormat(PdfTextAlignment.Center));
            table.getStyle().setShowHeader(true);
            table.setDataSource(data);

            float width = (float) page.getCanvas().getClientSize().getWidth() - (float) (table.getColumns().getCount() + 1) * table.getStyle().getBorderPen().getWidth();
            for (int i = 0; i < table.getColumns().getCount(); i++) {
                table.getColumns().get(i).setWidth(i == 1 ? width * 0.35f : width * 0.13f);
            }

            PdfTableLayoutFormat tableLayout = new PdfTableLayoutFormat();
            tableLayout.setBreak(PdfLayoutBreakType.Fit_Page);
            tableLayout.setLayout(PdfLayoutType.Paginate);

            return table.draw(page, new Point2D.Float(0, y), tableLayout);
        }

        static PdfLayoutResult Bookmark_DrawOrderItems(PdfPageBase page, DataTable orderItems, String title, float y) {
            //Draw title
            PdfTrueTypeFont font1 = new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 9));
            page.getCanvas().drawString(title, font1, PdfBrushes.getBlack(), 0, y);
            y = y + (float) font1.measureString(title).getHeight() + 1;

            PdfTable table = new PdfTable();
            table.getStyle().setCellPadding(2);
            table.getStyle().setBorderPen(new PdfPen(PdfBrushes.getBlack(), 0.75f));
            table.getStyle().getDefaultStyle().setBackgroundBrush(PdfBrushes.getMediumTurquoise());
            table.getStyle().getDefaultStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 8)));
            table.getStyle().setAlternateStyle(new PdfCellStyle());
            table.getStyle().getAlternateStyle().setBackgroundBrush(PdfBrushes.getPaleTurquoise());
            table.getStyle().getAlternateStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 8)));
            table.getStyle().setHeaderSource(PdfHeaderSource.Column_Captions);
            table.getStyle().getHeaderStyle().setBackgroundBrush(PdfBrushes.getTeal());
            table.getStyle().getHeaderStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 8)));
            table.getStyle().getHeaderStyle().setStringFormat(new PdfStringFormat(PdfTextAlignment.Center));
            table.getStyle().setShowHeader(true);
            table.setDataSource(orderItems);
            for (int i = 2; i < table.getColumns().getCount(); i++) {
                table.getColumns().get(i).setStringFormat(new PdfStringFormat(PdfTextAlignment.Right));

            }

            PdfTableLayoutFormat tableLayout = new PdfTableLayoutFormat();
            tableLayout.setBreak(PdfLayoutBreakType.Fit_Page);
            tableLayout.setLayout(PdfLayoutType.Paginate);

            return table.draw(page, new Point2D.Float(0, y), tableLayout);
        }

        static PreparedStatement Bookmark_PreparePartQueryCommand(Connection poConn) {

            try {
                PreparedStatement loStatement = poConn.prepareStatement(" SELECT PartNo, Description, OnHand, OnOrder, Cost, ListPrice "
                        + " FROM parts WHERE VendorNo = ?");
                return loStatement;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }

        static PreparedStatement Bookmark_PrepareOrderItemQueryCommand(Connection poConn) {

            try {
                PreparedStatement loStatement = poConn.prepareStatement("SELECT OrderNo, ItemNo, Qty, Discount "
                        + " FROM items WHERE PartNo = ?");
                return loStatement;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
