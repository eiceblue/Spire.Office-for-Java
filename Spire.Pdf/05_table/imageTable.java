import com.spire.pdf.PdfDocument;
import com.spire.pdf.PdfPageBase;
import com.spire.pdf.PdfPageSize;
import com.spire.pdf.graphics.*;
import com.spire.pdf.tables.*;
import com.spire.pdf.tables.table.*;
import com.spire.pdf.tables.table.common.JdbcAdapter;
import java.awt.*;
import java.awt.geom.Point2D;
import java.io.ByteArrayInputStream;
import java.sql.*;

public class imageTable {
    public static void main(String[] args) {
        PdfDocument doc = new PdfDocument();
        //Set margin
        PdfUnitConvertor unitCvtr = new PdfUnitConvertor();
        PdfMargins margin = new PdfMargins();
        margin.setTop(unitCvtr.convertUnits(2.54f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
        margin.setBottom(margin.getTop());
        margin.setLeft(unitCvtr.convertUnits(3.17f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
        margin.setRight(margin.getLeft());
        // Create one page
        PdfPageBase page =doc.getPages().add(PdfPageSize.A4, margin);

        float y = 10;
        //title
        PdfBrush brush1 = PdfBrushes.getBlack();
        PdfTrueTypeFont font1 = new PdfTrueTypeFont(new Font("Arial", Font.BOLD,16));
        PdfStringFormat format1 = new PdfStringFormat(PdfTextAlignment.Center);
        page.getCanvas().drawString("Country List", font1, brush1, page.getCanvas().getClientSize().getWidth() / 2, y, format1);
        y = y + (float) font1.measureString("Country List", format1).getHeight();
        y = y + 5;

        //create data table
        PdfTable table = new PdfTable();
        table.getStyle().setCellPadding(2);
        table.getStyle().setBorderPen(new PdfPen(brush1, 0.75f));
        table.getStyle().getDefaultStyle().setBackgroundBrush(PdfBrushes.getSkyBlue());
        table.getStyle().getDefaultStyle().setFont(new PdfTrueTypeFont(new Font("Arial",0, 10)));
        table.getStyle().setAlternateStyle(new PdfCellStyle());
        table.getStyle().getAlternateStyle().setBackgroundBrush(PdfBrushes.getLightYellow());
        table.getStyle().getAlternateStyle().setFont(new PdfTrueTypeFont(new Font("Arial",0, 10)));
        table.getStyle().setHeaderSource(PdfHeaderSource.Column_Captions);
        table.getStyle().getHeaderStyle().setBackgroundBrush(PdfBrushes.getCadetBlue());
        table.getStyle().getHeaderStyle().setFont(new PdfTrueTypeFont(new Font("Arial",Font.BOLD ,11)));
        table.getStyle().getHeaderStyle().setStringFormat(new PdfStringFormat(PdfTextAlignment.Center));
        table.getStyle().setShowHeader(true);

        String url ="jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ="+"data/demo.mdb";
        DataTable dataTable = new DataTable();
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            try {
                Connection conn =  DriverManager.getConnection(url);
                Statement sta  =conn.createStatement();
                ResultSet resultSet = sta.executeQuery("select Name, '' as Flags, Capital, Continent, Area, Population, Flag as FlagData from country");
                JdbcAdapter jdbcAdapter = new JdbcAdapter();
                jdbcAdapter.fillDataTable(dataTable,resultSet);
                dataTable.getColumns().add(new DataColumn("FlagImage",0));
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
        float width =(float) page.getCanvas().getClientSize().getWidth() - (float)(table.getColumns().getCount() + 1) * table.getStyle().getBorderPen().getWidth();
        table.getColumns().get(0).setWidth(width * 0.21f * width);
        table.getColumns().get(0).setStringFormat( new PdfStringFormat(PdfTextAlignment.Left, PdfVerticalAlignment.Middle));
        table.getColumns().get(1).setWidth( width * 0.10f * width);
        table.getColumns().get(1).setStringFormat(new PdfStringFormat(PdfTextAlignment.Left, PdfVerticalAlignment.Middle));
        table.getColumns().get(2).setWidth(width * 0.19f * width);
        table.getColumns().get(2).setStringFormat(new PdfStringFormat(PdfTextAlignment.Left, PdfVerticalAlignment.Middle));
        table.getColumns().get(3).setWidth(width * 0.21f * width);
        table.getColumns().get(3).setStringFormat(new PdfStringFormat(PdfTextAlignment.Left, PdfVerticalAlignment.Middle));
        table.getColumns().get(4).setWidth(width * 0.12f * width);
        table.getColumns().get(4).setStringFormat(new PdfStringFormat(PdfTextAlignment.Right, PdfVerticalAlignment.Middle));
        table.getColumns().get(5).setWidth(width * 0.17f * width);
        table.getColumns().get(5).setStringFormat(new PdfStringFormat(PdfTextAlignment.Right, PdfVerticalAlignment.Middle));


        table.beginRowLayout.add(new BeginRowLayoutEventHandler() {
            @Override
            public void invoke(Object sender, BeginRowLayoutEventArgs args) {
                try {
                    imageTable_BeginRowLayout(sender,args);
                } catch (DataException e) {
                    e.printStackTrace();
                }
            }
        });
        table.endCellLayout.add(new EndCellLayoutEventHandler() {
            @Override
            public void invoke(Object sender, EndCellLayoutEventArgs args) {
                try {
                    imageTable_EndCellLayout(sender,args);
                } catch (DataException e) {
                    e.printStackTrace();
                }
            }
        });

        PdfTableLayoutFormat tableLayout = new PdfTableLayoutFormat();
        tableLayout.setBreak(PdfLayoutBreakType.Fit_Element);
        tableLayout.setLayout(PdfLayoutType.Paginate);
        tableLayout.setEndColumnIndex(table.getColumns().getCount() - 2 - 1);

        PdfLayoutResult result = table.draw(page, new Point2D.Float(0, y), tableLayout);
        y = y + (float) result.getBounds().getHeight() + 5;

        PdfBrush brush2 = PdfBrushes.getGray();
        PdfTrueTypeFont font2 = new PdfTrueTypeFont(new Font("Arial", 0,9));
        page.getCanvas().drawString(String.format("* %1$s countries in the list.", table.getRows().getCount()), font2, brush2, 5, y);

        //Save pdf file.
        doc.saveToFile("output/imageTable.pdf");
        doc.close();
    }

    static void imageTable_EndCellLayout(Object sender, EndCellLayoutEventArgs args) throws DataException {
        if (args.getRowIndex() < 0) {
            //header
            return;
        }
        if (args.getCellIndex() == 1) {
            Object tempVar = ((PdfTable) ((sender instanceof PdfTable) ? sender : null)).getDataSource();
            DataTable dataTable = (DataTable) ((tempVar instanceof DataTable) ? tempVar : null);

            PdfImage image = (PdfImage) ((dataTable.getRows().get(args.getRowIndex()).getObject(7) instanceof PdfImage) ? (PdfImage)((dataTable.getRows().get(args.getRowIndex()).getObject(7))) : null);
            float x = ((float) args.getBounds().getWidth() - (float) image.getPhysicalDimension().getWidth()) / 2 + (float) args.getBounds().getX();
            float y = ((float) args.getBounds().getHeight() - (float) image.getPhysicalDimension().getHeight()) / 2 + (float) args.getBounds().getY();
            args.getGraphics().drawImage(image, x, y);
        }
    }

    static void imageTable_BeginRowLayout(Object sender, BeginRowLayoutEventArgs args) throws DataException {
        if (args.getRowIndex() < 0) {
            //header
            return;
        }
        Object tempVar = ((PdfTable) ((sender instanceof PdfTable) ? sender : null)).getDataSource();
        DataTable dataTable = (DataTable) ((tempVar instanceof DataTable) ? tempVar : null);

        byte[] imageData = (byte[]) ((dataTable.getRows().get(args.getRowIndex()).getObject(6) instanceof byte[]) ? (dataTable.getRows().get(args.getRowIndex()).getObject(6)) : null);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(imageData);
        PdfImage image = PdfImage.fromStream(inputStream);
        args.setMinimalHeight(4 + image.getPhysicalDimension().getHeight());
        dataTable.getRows().get(args.getRowIndex()).setObject(7, image);
    }
}
