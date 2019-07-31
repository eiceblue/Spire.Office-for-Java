import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import com.spire.pdf.tables.*;
import java.awt.*;
import java.awt.geom.Point2D;

public class tableBorder {
    public static void main(String[] args) {
        String[] data = {"Name;Capital;Continent;Area;Population", "Argentina;Buenos Aires;South America;2777815;32300003", "Bolivia;La Paz;South America;1098575;7300000", "Brazil;Brasilia;South America;8511196;150400000", "Canada;Ottawa;North America;9976147;26500000", "Chile;Santiago;South America;756943;13200000", "Colombia;Bagota;South America;1138907;33000000", "Cuba;Havana;North America;114524;10600000", "Ecuador;Quito;South America;455502;10600000", "El Salvador;San Salvador;North America;20865;5300000", "Guyana;Georgetown;South America;214969;800000", "Jamaica;Kingston;North America;11424;2500000", "Mexico;Mexico City;North America;1967180;88600000", "Nicaragua;Managua;North America;139000;3900000", "Paraguay;Asuncion;South America;406576;4660000", "Peru;Lima;South America;1285215;21600000", "United States of America;Washington;North America;9363130;249200000", "Uruguay;Montevideo;South America;176140;3002000", "Venezuela;Caracas;South America;912047;19700000"};
        String[][] dataSource = new String[data.length][];
        for (int i = 0; i < data.length; i++) {
            dataSource[i] = data[i].split("[;]", -1);
        }
        PdfDocument doc = new PdfDocument();
        PdfPageBase page = doc.getPages().add();
        //Create a pdf table
        PdfTable table = new PdfTable();
        //Set data source of the pdf table
        table.setDataSource(dataSource);
        //Set the color of table border
        PdfTableStyle style = new PdfTableStyle();
        style.setCellPadding(2);
        style.setBorderPen(new PdfPen(new PdfRGBColor(new Color(128,128,128)), 1f));
        table.setStyle(style);
        //Add custom method to beginRowLayout event
        table.beginRowLayout.add((new BeginRowLayoutEventHandler() {
            @Override
            public void invoke(Object sender, BeginRowLayoutEventArgs args) {
                table_BeginRowLayout(sender, args);
            }
        }));
        //Draw the pdf table into pdf document
        table.draw(page, new Point2D.Float(50, 100));

        doc.saveToFile("output/tableBorder.pdf");
        doc.close();
    }

    static void table_BeginRowLayout(Object sender, BeginRowLayoutEventArgs args) {
        //Set the color of table cell border
        PdfCellStyle cellStyle = new PdfCellStyle();
        cellStyle.setBorderPen(new PdfPen(new PdfRGBColor(new Color(173, 216, 230)), 0.9));
        args.setCellStyle(cellStyle);
    }
}
