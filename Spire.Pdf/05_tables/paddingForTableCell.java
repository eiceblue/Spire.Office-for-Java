import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import com.spire.pdf.grid.*;
import java.awt.geom.Point2D;

public class paddingForTableCell {
    public static void main(String[] args) {
        // Create a new PDF document
        PdfDocument doc = new PdfDocument();

        // Add a page to the document with A4 size and 5mm margins
        PdfPageBase page = doc.getPages().add(PdfPageSize.A4, new PdfMargins(5));

        // Create a new grid
        PdfGrid grid = new PdfGrid();

        // Set the cell padding for the grid
        grid.getStyle().setCellPadding(new PdfPaddings(10, 10, 10, 10));

        // Fill data into the grid by setting its data source
        grid.setDataSource(GetData());

        // Set alignment for each cell in the grid
        for (int i = 0; i < grid.getRows().size(); i++) {
            PdfGridRow row = grid.getRows().get(i);
            for (int j = 0; j < row.getCells().getCount(); j++) {
                row.getCells().get(j).setStringFormat(new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle));
            }
        }

        // Draw the grid on the page at the specified location (0, 0)
        grid.draw(page, new Point2D.Float(0, 0));

        // Save the PDF document to the specified output file path
        String result = "output/paddingForTableCell_out.pdf";
        doc.saveToFile(result);

        // Close the PDF document
        doc.close();

        // Dispose of the PDF document (frees up system resources)
        doc.dispose();
    }
   
   
   private static String[][] GetData() {
        // Define the data array containing information about countries
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

        // Create a 2D array to hold the parsed data
        String[][] dataSource = new String[data.length][];

        // Split each string in the data array and store it in the dataSource array
        for (int i = 0; i < data.length; i++) {
            dataSource[i] = data[i].split(";");
        }

        // Return the parsed data
        return dataSource;
    }
}
