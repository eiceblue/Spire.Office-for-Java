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
        // Output file path for the generated PDF
        String output = "output/action.pdf";

        // Create a new PDF document
        PdfDocument doc = new PdfDocument();

        // Set up unit converter and margins
        PdfUnitConvertor unitCvtr = new PdfUnitConvertor();
        PdfMargins margin = new PdfMargins();
        margin.setTop(unitCvtr.convertUnits(2.54f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
        margin.setBottom(margin.getTop());
        margin.setLeft(unitCvtr.convertUnits(3.17f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
        margin.setRight(margin.getLeft());

        // Add a new page with specified dimensions and margins
        PdfPageBase page = doc.getPages().add(PdfPageSize.A4, margin);

        // Set initial y-coordinate position
        float y = 10;

        // Define brush, font, and string format for drawing the title
        PdfBrush brush1 = PdfBrushes.getBlack();
        PdfTrueTypeFont font1 = new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 16));
        PdfStringFormat format1 = new PdfStringFormat(PdfTextAlignment.Center);

        // Draw the title "Part List" at the top of the page
        page.getCanvas().drawString("Part List", font1, brush1, page.getCanvas().getClientSize().getWidth() / 2, y, format1);

        // Update y-coordinate position after drawing the title
        y = y + (float) font1.measureString("Part List", format1).getHeight();
        y = y + 2;

        // Define a destination for navigating to the top of the table
        PdfDestination tableTopDest = new PdfDestination(page);
        tableTopDest.setLocation(new Point2D.Float(0, y));
        tableTopDest.setMode(PdfDestinationMode.Location);
        tableTopDest.setZoom(1f);

        // Define font and dimensions for buttons
        PdfTrueTypeFont buttonFont = new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 10));
        float buttonWidth = 70;
        float buttonHeight = buttonFont.getHeight() * 1.5f;

        // Store the initial y-coordinate position of the table
        float tableTop = y;

        // Call the method to draw the parts table and obtain the layout result
        PdfLayoutResult tableLayoutResult = drawPartsTable1(page, y + buttonHeight + 5);

        // Define a destination for navigating to the bottom of the table
        PdfDestination tableBottomDest = new PdfDestination(tableLayoutResult.getPage());
        tableBottomDest.setLocation(new Point2D.Float(0, (float) tableLayoutResult.getBounds().getY()));
        tableBottomDest.setMode(PdfDestinationMode.Location);
        tableBottomDest.setZoom(1f);

        // Calculate the x-coordinate position for the buttons
        float x = (float) page.getCanvas().getClientSize().getWidth() - buttonWidth;

        // Define string format for button text alignment
        PdfStringFormat format2 = new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle);

        // Create and draw the "To Bottom" button
        Rectangle2D buttonBounds = new Rectangle2D.Float(x, tableTop, buttonWidth, buttonHeight);
        page.getCanvas().drawRectangle(PdfBrushes.getDarkGray(), buttonBounds);
        page.getCanvas().drawString("To Bottom", buttonFont, PdfBrushes.getCadetBlue(), buttonBounds, format2);

        // Create and add a GoTo action annotation to navigate to the bottom of the table
        PdfGoToAction action1 = new PdfGoToAction(tableBottomDest);
        PdfActionAnnotation annotation1 = new PdfActionAnnotation(buttonBounds, action1);
        annotation1.setBorder(new PdfAnnotationBorder(0.75f));
        annotation1.setColor(new PdfRGBColor(Color.lightGray));
        ((PdfNewPage) ((page instanceof PdfNewPage) ? page : null)).getAnnotations().add(annotation1);

        // Calculate the y-coordinate position for the bottom of the table
        float tableBottom = (float) tableLayoutResult.getBounds().getY() + (float) tableLayoutResult.getBounds().getHeight() + 5;

        // Update button bounds for the "To Top" button at the bottom of the table
        buttonBounds = new Rectangle2D.Float(x, tableBottom, buttonWidth, buttonHeight);
        // Draw the "To Top" button on the page
        tableLayoutResult.getPage().getCanvas().drawRectangle(PdfBrushes.getDarkGray(), buttonBounds);
        tableLayoutResult.getPage().getCanvas().drawString("To Top", buttonFont, PdfBrushes.getCadetBlue(), buttonBounds, format2);

        // Create and add a GoTo action annotation to navigate to the top of the table
        PdfGoToAction action2 = new PdfGoToAction(tableTopDest);
        PdfActionAnnotation annotation2 = new PdfActionAnnotation(buttonBounds, action2);
        annotation2.setBorder(new PdfAnnotationBorder(0.75f));
        annotation2.setColor(new PdfRGBColor(Color.lightGray));
        com.spire.pdf.PdfPageBase tempVar = tableLayoutResult.getPage();
        ((PdfNewPage) ((tempVar instanceof PdfNewPage) ? tempVar : null)).getAnnotations().add(annotation2);

        // Set an action to be executed when the PDF document is opened (navigates to the last page)
        PdfNamedAction action3 = new PdfNamedAction(PdfActionDestination.LastPage);
        doc.setAfterOpenAction(action3);

        // Define a JavaScript action to be executed before the PDF document is closed
        String script = "app.alert({"
                + "    cMsg: \"Oh no, you want to leave me.\","
                + "    nIcon: 3,"
                + "    cTitle: \"JavaScript Action\""
                + "});";
        PdfJavaScriptAction action4 = new PdfJavaScriptAction(script);
        doc.setBeforeCloseAction(action4);

        // Save the PDF document to the specified output file in PDF format
        doc.saveToFile(output, FileFormat.PDF);

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }

    static PdfLayoutResult drawPartsTable1(PdfPageBase page, float y) {
        // Specify the input file for database connection
        String inputFile = "data/demo.mdb";
        
        // Define the brush for table elements
        PdfBrush brush1 = PdfBrushes.getBlack();

        // Create a new PdfTable object
        PdfTable table = new PdfTable();

        // Set cell padding and border style for the table
        table.getStyle().setCellPadding(2);
        table.getStyle().setBorderPen(new PdfPen(brush1, 0.75f));

        // Set default style for table cells
        table.getStyle().getDefaultStyle().setBackgroundBrush(PdfBrushes.getSkyBlue());
        table.getStyle().getDefaultStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 10)));

        // Set alternate style for table cells
        table.getStyle().setAlternateStyle(new PdfCellStyle());
        table.getStyle().getAlternateStyle().setBackgroundBrush(PdfBrushes.getLightYellow());
        table.getStyle().getAlternateStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 10)));

        // Set header source and style for the table
        table.getStyle().setHeaderSource(PdfHeaderSource.Column_Captions);
        table.getStyle().getHeaderStyle().setBackgroundBrush(PdfBrushes.getCadetBlue());
        table.getStyle().getHeaderStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 11)));
        table.getStyle().getHeaderStyle().setStringFormat(new PdfStringFormat(PdfTextAlignment.Center));

        // Enable table header to be displayed
        table.getStyle().setShowHeader(true);

        // Set up the database connection and query
        String url = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=" + inputFile;
        DataTable dataTable = new DataTable();
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            try {
                Connection conn = DriverManager.getConnection(url);
                Statement sta = conn.createStatement();
                ResultSet resultSet = sta.executeQuery("SELECT Description, OnHand, OnOrder, Cost, ListPrice FROM parts");
                JdbcAdapter jdbcAdapter = new JdbcAdapter();
                jdbcAdapter.fillDataTable(dataTable, resultSet);

                // Set the table's data source
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

        // Calculate the table width based on the page canvas size and column count
        float width = (float) (page.getCanvas().getClientSize().getWidth() - (table.getColumns().getCount() + 1) * table.getStyle().getBorderPen().getWidth());

        // Set the widths and string formats of the table columns
        for (int i = 0; i < table.getColumns().getCount(); i++) {
            if (i == 0) {
                table.getColumns().get(i).setWidth(width * 0.40f * width);
                table.getColumns().get(i).setStringFormat(new PdfStringFormat(PdfTextAlignment.Left, PdfVerticalAlignment.Middle));
            } else {
                table.getColumns().get(i).setWidth(width * 0.15f * width);
                table.getColumns().get(i).setStringFormat(new PdfStringFormat(PdfTextAlignment.Right, PdfVerticalAlignment.Middle));
            }
        }

        // Set up the table layout format
        PdfTableLayoutFormat tableLayout = new PdfTableLayoutFormat();
        tableLayout.setBreak(PdfLayoutBreakType.Fit_Element);
        tableLayout.setLayout(PdfLayoutType.Paginate);

        // Draw the table on the page and get the layout result
        PdfLayoutResult result = table.draw(page, new Point2D.Float(0, y), tableLayout);

        // Update the y-coordinate for the next element placement
        y = (float) result.getBounds().getY() + (float) result.getBounds().getHeight() + 5;

        // Add a custom text below the table
        PdfBrush brush2 = PdfBrushes.getGray();
        PdfTrueTypeFont font2 = new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 9));
        result.getPage().getCanvas().drawString(String.format("* %1$s parts in the list.", table.getRows().getCount()), font2, brush2, 5, y);

        // Return the layout result of the table drawing operation
        return result;
    }
}