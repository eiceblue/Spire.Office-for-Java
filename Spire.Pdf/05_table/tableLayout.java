import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import com.spire.pdf.tables.*;
import com.spire.pdf.tables.table.*;
import com.spire.pdf.tables.table.common.JdbcAdapter;
import java.awt.*;
import java.awt.geom.Point2D;
import java.sql.*;

public class tableLayout {
    public static void main(String[] args) {
        PdfDocument doc = new PdfDocument();

        //Set margin
        PdfUnitConvertor unitCvtr = new PdfUnitConvertor();
        PdfMargins margin = new PdfMargins();
        margin.setTop(unitCvtr.convertUnits(2.54f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
        margin.setBottom(margin.getTop());
        margin.setLeft(unitCvtr.convertUnits(2.17f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
        margin.setRight(margin.getLeft());

        // Create one page
        PdfPageBase page = doc.getPages().add(PdfPageSize.A4, margin);

        float y = 10;

        //Draw title
        PdfBrush brush1 = PdfBrushes.getBlack();
        PdfTrueTypeFont font1 = new PdfTrueTypeFont(new Font("Arial",Font.BOLD ,16));
        PdfStringFormat format1 = new PdfStringFormat(PdfTextAlignment.Center);
        page.getCanvas().drawString("Part List", font1, brush1, page.getCanvas().getClientSize().getWidth() / 2, y, format1);
        y = y + (float) font1.measureString("Part List", format1).getHeight();
        y = y + 5;

        //Create data table
        PdfTable table = new PdfTable();
        table.getStyle().setCellPadding(2);
        table.getStyle().setBorderPen(new PdfPen(brush1, 0.75f));
        table.getStyle().getDefaultStyle().setBackgroundBrush(PdfBrushes.getSkyBlue());
        table.getStyle().getDefaultStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 10)));
        table.getStyle().setAlternateStyle(new PdfCellStyle());
        table.getStyle().getAlternateStyle().setBackgroundBrush(PdfBrushes.getLightYellow());
        table.getStyle().getAlternateStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 10)));
        table.getStyle().setHeaderSource(PdfHeaderSource.Column_Captions);
        table.getStyle().getHeaderStyle().setBackgroundBrush(PdfBrushes.getCadetBlue());
        table.getStyle().getHeaderStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 11)));
        table.getStyle().getHeaderStyle().setStringFormat(new PdfStringFormat(PdfTextAlignment.Center));
        table.getStyle().setShowHeader(true);


        String url ="jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ="+ "data/demo.mdb";
        DataTable dataTable = new DataTable();
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            try {
                Connection conn =  DriverManager.getConnection(url);
                Statement sta  =conn.createStatement();
                ResultSet resultSet = sta.executeQuery(" select * from parts  ");
                JdbcAdapter jdbcAdapter = new JdbcAdapter();
                jdbcAdapter.fillDataTable(dataTable,resultSet);
                dataTable.getColumns().remove(1);
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
        float width = (float) page.getCanvas().getClientSize().getWidth() - (table.getColumns().getCount() + 1) * table.getStyle().getBorderPen().getWidth();
        for (int i = 0; i < table.getColumns().getCount(); i++) {
            if (i == 1) {
                table.getColumns().get(i).setWidth(width * 0.4f * width);
                table.getColumns().get(i).setStringFormat( new PdfStringFormat(PdfTextAlignment.Left, PdfVerticalAlignment.Middle));
            } else {
                table.getColumns().get(i).setWidth(width * 0.12f * width);
                table.getColumns().get(i).setStringFormat( new PdfStringFormat(PdfTextAlignment.Right, PdfVerticalAlignment.Middle));
            }
        }
        table.beginRowLayout.add(new BeginRowLayoutEventHandler() {
            @Override
            public void invoke(Object sender, BeginRowLayoutEventArgs args) {
                layoutTable_BeginRowLayout(sender,args);

            }});
        PdfTableLayoutFormat tableLayout = new PdfTableLayoutFormat();
        tableLayout.setBreak(PdfLayoutBreakType.Fit_Element);
        tableLayout.setLayout(PdfLayoutType.Paginate);
        PdfLayoutResult result = table.draw(page, new Point2D.Float(0, y), tableLayout);
         y = (float) result.getBounds().getY()+(float)result.getBounds().getHeight() + 5;


        PdfBrush brush2 = PdfBrushes.getGray();
        PdfTrueTypeFont font2 = new PdfTrueTypeFont(new Font("Arial", 0,9));
        result.getPage().getCanvas().drawString(String.format("* All %1$s parts in the list", table.getRows().getCount()), font2, brush2, 5, y);

        //Save pdf file.
        doc.saveToFile("output/tableLayout.pdf");
        doc.close();
    }

    static void layoutTable_BeginRowLayout(Object sender, BeginRowLayoutEventArgs args) {
        if (args.getRowIndex() < 0) {
            //header
            return;
        }
        if (args.getRowIndex() % 2 == 0) {
            args.getCellStyle().setBackgroundBrush(PdfBrushes.getLightYellow());
        } else {
            args.getCellStyle().setBackgroundBrush(PdfBrushes.getSkyBlue());
        }
    }
}
