import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import com.spire.pdf.tables.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class insertPageBreak {
    public static void main(String[] args) {
		// Create a new Pdf document
        PdfDocument doc = new PdfDocument();
        PdfPageBase page = doc.getPages().add();

        // Set the initial y-coordinate for drawing content on the page
        float y = 10;

        // Define brush, font, and format for the title
        PdfBrush brush1 = PdfBrushes.getBlack();
        PdfTrueTypeFont font1 = new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 16));
        PdfStringFormat format1 = new PdfStringFormat(PdfTextAlignment.Center);

        // Draw the title "Country List" at the center of the page
        page.getCanvas().drawString("Country List", font1, brush1, page.getCanvas().getClientSize().getWidth() / 2, y, format1);
        y = y + (float)font1.measureString("Country List", format1).getHeight(); // Increase y by the height of the title
        y = y + 5; // Add some extra space below the title

        // Create a new PdfTable instance
        PdfTable table = new PdfTable();

        // Set the border pen for the table
        table.getStyle().setBorderPen(new PdfPen(brush1, 0.5f));

        // Use rows as the header source
        table.getStyle().setHeaderSource(PdfHeaderSource.Rows);

        // Specify that only one row will be used as the header
        table.getStyle().setHeaderRowCount(1);

        // Set to true to display the header
        table.getStyle().setShowHeader(true);

        // Set the background brush of the header cells to Cadet Blue
        table.getStyle().getHeaderStyle().setBackgroundBrush(PdfBrushes.getCadetBlue());

        // Set the font of the header cells to Arial, bold, with a size of 14
        table.getStyle().getHeaderStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 14)));

        // Set the string format of the header cells to center alignment horizontally and middle alignment vertically
        table.getStyle().getHeaderStyle().setStringFormat(new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle));

        // Enable repeating of the header on each page
        table.getStyle().setRepeatHeader(true);

        // Set the default background brush of the cells to Sky Blue
        table.getStyle().getDefaultStyle().setBackgroundBrush(PdfBrushes.getSkyBlue());

        // Set the default font of the cells to Arial, plain, with a size of 10
        table.getStyle().getDefaultStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 10)));

        // Set the default string format of the cells to center alignment horizontally and middle alignment vertically
        table.getStyle().getDefaultStyle().setStringFormat(new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle));

        // Create a new alternate style instance
        table.getStyle().setAlternateStyle(new PdfCellStyle());

        // Set the background brush of the alternate cells to Light Yellow
        table.getStyle().getAlternateStyle().setBackgroundBrush(PdfBrushes.getLightYellow());

        // Set the font of the alternate cells to Arial, plain, with a size of 10
        table.getStyle().getAlternateStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 10)));

        // Set the string format of the alternate cells to center alignment horizontally and middle alignment vertically
        table.getStyle().getAlternateStyle().setStringFormat(new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle));

        // Set the data source for the table
        table.setDataSource(GetData());

        // Create an instance of PdfTableLayoutFormat to specify the table layout settings
        PdfTableLayoutFormat tableLayout = new PdfTableLayoutFormat();

        // Set the layout break type to fit the element on the page
        tableLayout.setBreak(PdfLayoutBreakType.Fit_Element);

        // Set the layout type to paginate
        tableLayout.setLayout(PdfLayoutType.Paginate);

        // Set the paginate bounds, specifying the rectangle area where the table will be paginated
        tableLayout.setPaginateBounds(new Rectangle2D.Double(0, y, page.getActualSize().getWidth() - 100, page.getActualSize().getHeight() / 3));

        // Set the row height using a BeginRowLayoutEventHandler
        table.beginRowLayout.add(new BeginRowLayoutEventHandler() {
            @Override
            public void invoke(Object sender, BeginRowLayoutEventArgs args) {
                table_BeginRowLayout(sender, args);
            }
        });

        // Draw the table on the page at the specified location with the given table layout format
        table.draw(page, new Point2D.Float(0, y), tableLayout);

        // Save the document to the specified output file path
        String output = "output/insertPageBreak_out.pdf";
        doc.saveToFile(output);

        // Close the PDF document
        doc.close();

        // Dispose of the PDF document (frees up system resources)
        doc.dispose();
    }
	
	
     // Define the data and return it
    private static String[][] GetData() {
        // Define the data array with country information
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

        String[][] dataSource = new String[data.length][];
        for (int i = 0; i < data.length; i++) {
            dataSource[i] = data[i].split(";");
        }
        return dataSource;
    }

    // This method is called when the layout of a table row begins.
    static void table_BeginRowLayout(Object sender, BeginRowLayoutEventArgs args) {
        // Set a minimal height for each row during layout
        args.setMinimalHeight(50f);
    }
}
