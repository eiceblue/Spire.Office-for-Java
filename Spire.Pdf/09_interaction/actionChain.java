import com.spire.pdf.*;
import com.spire.pdf.actions.*;
import com.spire.pdf.general.*;
import com.spire.pdf.graphics.*;
import com.spire.pdf.tables.*;
import com.spire.pdf.tables.table.DataTable;
import com.spire.pdf.tables.table.common.JdbcAdapter;
import java.awt.*;
import java.awt.geom.*;
import java.sql.*;

public class actionChain {
    public static void main(String[] args) {
        //Create a pdf document.
        PdfDocument doc = new PdfDocument();
        //Draw pages
        PdfPageBase lastPage = DrawPartsTable2(doc);

        //Script
        String script = "app.alert({"
                + "    cMsg: \"I'll lead; you must follow me.\","
                + "    nIcon: 3,"
                + "    cTitle: \"JavaScript Action\""
                + "});";
        PdfJavaScriptAction action1 = new PdfJavaScriptAction(script);
        doc.setAfterOpenAction(action1);

        //Script
        script = "app.alert({"
                + "    cMsg: \"The firt page!\","
                + "    nIcon: 3,"
                + "    cTitle: \"JavaScript Action\""
                + "});";
        PdfJavaScriptAction action2 = new PdfJavaScriptAction(script);
        action1.setNextAction(action2);

        PdfDestination dest = new PdfDestination(lastPage);
        dest.setZoom(1);
        PdfGoToAction action3 = new PdfGoToAction(dest);
        action2.setNextAction(action3);

        //Script
        script = "app.alert({"
                + "    cMsg: \"Oh sorry, it's the last page. I'm missing!\","
                + "    nIcon: 3,"
                + "    cTitle: \"JavaScript Action\""
                + "});";
        PdfJavaScriptAction action4 = new PdfJavaScriptAction(script);
        action3.setNextAction(action4);

        //Save pdf file.
        doc.saveToFile("output/actionChain.pdf");
        doc.close();
    }
    static PdfPageBase DrawPartsTable2(PdfDocument doc) {
        String inputFile = "data/demo.mdb";
        //margin
        PdfUnitConvertor unitCvtr = new PdfUnitConvertor();
        PdfMargins margin = new PdfMargins();
        margin.setTop(unitCvtr.convertUnits(2.54f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
        margin.setBottom(margin.getTop());
        margin.setLeft(unitCvtr.convertUnits(3.17f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
        margin.setRight(margin.getLeft());

        // Create one page
        PdfPageBase page = doc.getPages().add(PdfPageSize.A4, margin);

        float y = 10;

        //title
        PdfBrush brush1 = PdfBrushes.getBlack();
        PdfTrueTypeFont font1 = new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 16));
        PdfStringFormat format1 = new PdfStringFormat(PdfTextAlignment.Center);
        page.getCanvas().drawString("Part List", font1, brush1, page.getCanvas().getClientSize().getWidth() / 2, y, format1);
        y = y + (float) font1.measureString("Part List", format1).getHeight();
        y = y + 5;

        //create data table
        PdfTable table = new PdfTable();
        table.getStyle().setCellPadding(2);
        table.getStyle().setBorderPen(new PdfPen(brush1, 0.75f));
        table.getStyle().getDefaultStyle().setBackgroundBrush(PdfBrushes.getSkyBlue());
        table.getStyle().getDefaultStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 10/*FontStyle.Regular*/)));
        table.getStyle().setAlternateStyle(new PdfCellStyle());
        table.getStyle().getAlternateStyle().setBackgroundBrush(PdfBrushes.getLightYellow());
        table.getStyle().getAlternateStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 10/*,FontStyle.Regular*/)));
        table.getStyle().setHeaderSource(PdfHeaderSource.Column_Captions);
        table.getStyle().getHeaderStyle().setBackgroundBrush(PdfBrushes.getCadetBlue());
        table.getStyle().getHeaderStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 11/*, FontStyle.Bold*/)));
        table.getStyle().getHeaderStyle().setStringFormat(new PdfStringFormat(PdfTextAlignment.Center));
        table.getStyle().setShowHeader(true);

        String url = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=" + inputFile;
        DataTable dataTable = new DataTable();
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            try {
                Connection conn = DriverManager.getConnection(url);
                Statement sta = conn.createStatement();
                ResultSet resultSet = sta.executeQuery(" select Description, OnHand, OnOrder, Cost, ListPrice from parts ");
                JdbcAdapter jdbcAdapter = new JdbcAdapter();
                jdbcAdapter.fillDataTable(dataTable, resultSet);

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

        float width = (float) (page.getCanvas().getClientSize().getWidth() - (table.getColumns().getCount() + 1) * table.getStyle().getBorderPen().getWidth());
        for (int i = 0; i < table.getColumns().getCount(); i++) {
            if (i == 0) {
                table.getColumns().get(i).setWidth(width * 0.40f * width);
                table.getColumns().get(i).setStringFormat(new PdfStringFormat(PdfTextAlignment.Left, PdfVerticalAlignment.Middle));
            } else {
                table.getColumns().get(i).setWidth(width * 0.15f * width);
                table.getColumns().get(i).setStringFormat(new PdfStringFormat(PdfTextAlignment.Right, PdfVerticalAlignment.Middle));
            }
        }

        PdfTableLayoutFormat tableLayout = new PdfTableLayoutFormat();
        tableLayout.setBreak(PdfLayoutBreakType.Fit_Element);
        tableLayout.setLayout(PdfLayoutType.Paginate);

        PdfLayoutResult result = table.draw(page, new Point2D.Float(0, y), tableLayout);
         y = (float) result.getBounds().getY()+(float)result.getBounds().getHeight() + 5;

        PdfBrush brush2 = PdfBrushes.getGray();
        PdfTrueTypeFont font2 = new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 9));
        result.getPage().getCanvas().drawString(String.format("* %1$s parts in the list.", table.getRows().getCount()), font2, brush2, 5, y);
        return result.getPage();
    }
}
