import com.spire.pdf.*;
import com.spire.pdf.actions.*;
import com.spire.pdf.annotations.*;
import com.spire.pdf.general.*;
import com.spire.pdf.graphics.*;
import com.spire.pdf.tables.*;
import com.spire.pdf.tables.table.DataTable;
import com.spire.pdf.tables.table.common.JdbcAdapter;
import java.awt.*;
import java.awt.geom.*;
import java.sql.*;

public class action {
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
        PdfPageBase page = doc.getPages().add(PdfPageSize.A4, margin);
        float y = 10;
        //Draw title
        PdfBrush brush1 = PdfBrushes.getBlack();
        PdfTrueTypeFont font1 = new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 16));
        PdfStringFormat format1 = new PdfStringFormat(PdfTextAlignment.Center);
        page.getCanvas().drawString("Part List", font1, brush1, page.getCanvas().getClientSize().getWidth() / 2, y, format1);
        y = y + (float) font1.measureString("Part List", format1).getHeight();
        y = y + 2;

        //Table top
        PdfDestination tableTopDest = new PdfDestination(page);
        tableTopDest.setLocation(new Point2D.Float(0, y));
        tableTopDest.setMode(PdfDestinationMode.Location);
        tableTopDest.setZoom(1f);

        //Draw table
        PdfTrueTypeFont buttonFont = new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 10));
        float buttonWidth = 70;
        float buttonHeight = buttonFont.getHeight() * 1.5f;
        float tableTop = y;
        PdfLayoutResult tableLayoutResult = DrawPartsTable1(page, y + buttonHeight + 5);

        //Table bottom
        PdfDestination tableBottomDest = new PdfDestination(tableLayoutResult.getPage());
        tableBottomDest.setLocation(new Point2D.Float(0, (float) tableLayoutResult.getBounds().getY()));
        tableBottomDest.setMode(PdfDestinationMode.Location);
        tableBottomDest.setZoom(1f);

        //Go to table bottom
        float x = (float) page.getCanvas().getClientSize().getWidth() - buttonWidth;
        PdfStringFormat format2 = new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle);
        Rectangle2D buttonBounds = new Rectangle2D.Float(x, tableTop, buttonWidth, buttonHeight);
        page.getCanvas().drawRectangle(PdfBrushes.getDarkGray(), buttonBounds);
        page.getCanvas().drawString("To Bottom", buttonFont, PdfBrushes.getCadetBlue(), buttonBounds, format2);
        PdfGoToAction action1 = new PdfGoToAction(tableBottomDest);
        PdfActionAnnotation annotation1 = new PdfActionAnnotation(buttonBounds, action1);
        annotation1.setBorder(new PdfAnnotationBorder(0.75f));
        annotation1.setColor(new PdfRGBColor(Color.lightGray));
        ((PdfNewPage) ((page instanceof PdfNewPage) ? page : null)).getAnnotations().add(annotation1);

        //Go to table top
        float tableBottom = (float) tableLayoutResult.getBounds().getY()+(float)tableLayoutResult.getBounds().getHeight()+5;
        buttonBounds = new Rectangle2D.Float(x, tableBottom, buttonWidth, buttonHeight);
        tableLayoutResult.getPage().getCanvas().drawRectangle(PdfBrushes.getDarkGray(), buttonBounds);
        tableLayoutResult.getPage().getCanvas().drawString("To Top", buttonFont, PdfBrushes.getCadetBlue(), buttonBounds, format2);
        PdfGoToAction action2 = new PdfGoToAction(tableTopDest);
        PdfActionAnnotation annotation2 = new PdfActionAnnotation(buttonBounds, action2);
        annotation2.setBorder(new PdfAnnotationBorder(0.75f));
        annotation2.setColor(new PdfRGBColor(Color.lightGray));
        com.spire.pdf.PdfPageBase tempVar = tableLayoutResult.getPage();
        ((PdfNewPage) ((tempVar instanceof PdfNewPage) ? tempVar : null)).getAnnotations().add(annotation2);

        //Goto last page
        PdfNamedAction action3 = new PdfNamedAction(PdfActionDestination.Last_Page);
        doc.setAfterOpenAction(action3);

        //Script
        String script = "app.alert({"
                + "    cMsg: \"Oh no, you want to leave me.\","
                + "    nIcon: 3,"
                + "    cTitle: \"JavaScript Action\""
                + "});";
        PdfJavaScriptAction action4 = new PdfJavaScriptAction(script);
        doc.setBeforeCloseAction(action4);

        //Save pdf file.
        doc.saveToFile("output/action.pdf");
        doc.close();
    }

    static PdfLayoutResult DrawPartsTable1(PdfPageBase page, float y) {
        String inputFile = "data/demo.mdb";
        PdfBrush brush1 = PdfBrushes.getBlack();

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

        return result;
    }
}
