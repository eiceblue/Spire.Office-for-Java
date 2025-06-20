import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import com.spire.pdf.tables.*;

import java.awt.*;
import java.awt.geom.Point2D;

public class addRepeatingHeader {
    public static void main(String[] args) {
  // Create a PDF document
        PdfDocument doc = new PdfDocument();

        // Create an instance of the PdfUnitConvertor class to convert measurements
        PdfUnitConvertor unitCvtr = new PdfUnitConvertor();

        // Create margin settings for the document
        PdfMargins margin = new PdfMargins();

        // Set the top margin by converting 2.54 centimeters to points
        margin.setTop(unitCvtr.convertUnits(2.54f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));

        // Set the bottom margin equal to the top margin
        margin.setBottom(margin.getTop());

        // Set the left margin by converting 3.17 centimeters to points
        margin.setLeft(unitCvtr.convertUnits(3.17f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));

        // Set the right margin equal to the left margin
        margin.setRight(margin.getLeft());

        // Add a page to the document
        PdfPageBase page = doc.getPages().add(PdfPageSize.A4, margin);

        float y = 10;

        // Set the font and format for the title
        PdfBrush brush = PdfBrushes.getBlack();
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial",  Font.BOLD,16));
        PdfStringFormat format = new PdfStringFormat(PdfTextAlignment.Center);

        // Draw the title on the page
        page.getCanvas().drawString("Country List", font, brush, page.getCanvas().getClientSize().getWidth() / 2, y, format);
        y = y + (float) font.measureString("Country List", format).getHeight();
        y = y + 5;

        // Create a data table
        PdfTable table = new PdfTable();

        // Set the border of the table
        table.getStyle().setBorderPen(new PdfPen(brush, 0.5f));

        // Set the source of the table header to be based on rows
        table.getStyle().setHeaderSource(PdfHeaderSource.Rows);

        // Specify that there is only one row in the table header
        table.getStyle().setHeaderRowCount(1);

        // Set the visibility of the table header to true
        table.getStyle().setShowHeader(true);

        // Set the background color of the table header to Cadet Blue
        table.getStyle().getHeaderStyle().setBackgroundBrush(PdfBrushes.getCadetBlue());

        // Set the font style for the table header as Arial, bold, with a size of 14
        table.getStyle().getHeaderStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 14)));

        // Set the text alignment and vertical alignment of the table header to center
        table.getStyle().getHeaderStyle().setStringFormat(new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle));

        // Enable repeating headers on each page
        table.getStyle().setRepeatHeader(true);
        
        // Set the background color of the default style for table cells to Sky Blue
        table.getStyle().getDefaultStyle().setBackgroundBrush(PdfBrushes.getSkyBlue());

        // Set the font style for the default style of table cells as Arial, plain, with a size of 10
        table.getStyle().getDefaultStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 10)));

        // Create a new PdfCellStyle instance for the alternate style
        table.getStyle().setAlternateStyle(new PdfCellStyle());

        // Set the background color of the alternate style for table cells to Light Yellow
        table.getStyle().getAlternateStyle().setBackgroundBrush(PdfBrushes.getLightYellow());

        // Set the font style for the alternate style of table cells as Arial, plain, with a size of 10
        table.getStyle().getAlternateStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 10)));

        // Set the data source for the table
        table.setDataSource(GetData());

        // Set the string format for each column in the table
        for(int i=0; i<table.getColumns().getCount();i++) {
            PdfColumn column= table.getColumns().get(i);
            column.setStringFormat(new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle));
        }

        // Add an event handler for the row layout
        table.beginRowLayout.add(new BeginRowLayoutEventHandler() {
            @Override
            public void invoke(Object sender, BeginRowLayoutEventArgs args) {
                table_BeginRowLayout(sender,args);
            }
        });

        // Draw the table on the page
        PdfLayoutResult result = table.draw(page, new Point2D.Float(0, y));
        y = y + (float) result.getBounds().getHeight() + 5;

        // Set the font and format for the footer
        PdfBrush brush2 = PdfBrushes.getGray();
        PdfTrueTypeFont font2 = new PdfTrueTypeFont(new Font("Arial",Font.PLAIN, 9));

        // Draw the footer text on the page
        page.getCanvas().drawString("* "+ table.getRows().getCount()+" countries in the list.", font2, brush2, 5, y);

        // Save the document
        doc.saveToFile("output/addRepeatingColumn_out.pdf");

        // Close the PDF document
        doc.close();

        // Dispose of the PDF document (frees up system resources)
        doc.dispose();
    }

  // Event handler for the beginning layout of a table row.
    static void table_BeginRowLayout(Object sender, BeginRowLayoutEventArgs args) {
        // Set the minimal height of the row to 50 units
        args.setMinimalHeight(50f);
    }


    // Retrieves the data for the table.
    private static String[][] GetData() {
        // Define the data for the table
        String[] data = {
                "Name;Capital;Continent;Area;Population",
                "Argentina;Buenos Aires;South America;2777815;32300003",
                "Bolivia;La Paz;South America;1098575;7300000",
                "Brazil;Brasilia;South America;8511196;150400000",
                "Canada;Ottawa;North America;9976147;26500000",
                "Chile;Santiago;South America;756943;13200000",
                "Colombia;Bagota;South America;1138907;33000000",
                "Cuba;Havana;North America;114524;10600000",
                "Ecuador;Quito;South America;455502;10600000",
                "El Salvador;San Salvador;North America;20865;5300000",
                "Guyana;Georgetown;South America;214969;800000",
                "Jamaica;Kingston;North America;11424;2500000",
                "Mexico;Mexico City;North America;1967180;88600000",
                "Nicaragua;Managua;North America;139000;3900000",
                "Paraguay;Asuncion;South America;406576;4660000",
                "Peru;Lima;South America;1285215;21600000",
                "United States of America;Washington;North America;9363130;249200000",
                "Uruguay;Montevideo;South America;176140;3002000",
                "Venezuela;Caracas;South America;912047;19700000"
        };

        // Convert the data into a two-dimensional array
        String[][] dataSource = new String[data.length][];
        for (int i = 0; i < data.length; i++) {
            // Split each row of data by the semicolon delimiter and assign it to the corresponding row in the array
            dataSource[i] = data[i].split(";");
        }
        return dataSource;
    }
}
