import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import com.spire.pdf.tables.*;
import java.awt.*;
import java.awt.geom.Point2D;

public class simpleTable {
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
        PdfPageBase page =   doc.getPages().add(PdfPageSize.A4, margin);

        float y = 10;

        //Draw title
        PdfBrush brush1 = PdfBrushes.getBlack();
        PdfTrueTypeFont font1 = new PdfTrueTypeFont(new Font("Arial",Font.BOLD ,16));
        PdfStringFormat format1 = new PdfStringFormat(PdfTextAlignment.Center);
        page.getCanvas().drawString("Country List", font1, brush1, page.getCanvas().getClientSize().getWidth() / 2, y, format1);
        y = y + (float) font1.measureString("Country List", format1).getHeight();
        y = y + 5;

        String[] data = {"Name;Capital;Continent;Area;Population", "Argentina;Buenos Aires;South America;2777815;32300003", "Bolivia;La Paz;South America;1098575;7300000", "Brazil;Brasilia;South America;8511196;150400000", "Canada;Ottawa;North America;9976147;26500000", "Chile;Santiago;South America;756943;13200000", "Colombia;Bagota;South America;1138907;33000000", "Cuba;Havana;North America;114524;10600000", "Ecuador;Quito;South America;455502;10600000", "El Salvador;San Salvador;North America;20865;5300000", "Guyana;Georgetown;South America;214969;800000", "Jamaica;Kingston;North America;11424;2500000", "Mexico;Mexico City;North America;1967180;88600000", "Nicaragua;Managua;North America;139000;3900000", "Paraguay;Asuncion;South America;406576;4660000", "Peru;Lima;South America;1285215;21600000", "United States of America;Washington;North America;9363130;249200000", "Uruguay;Montevideo;South America;176140;3002000", "Venezuela;Caracas;South America;912047;19700000"};

        String[][] dataSource = new String[data.length][];
        for (int i = 0; i < data.length; i++) {
            dataSource[i] = data[i].split("[;]", -1);
        }

        PdfTable table = new PdfTable();
        table.getStyle().setCellPadding(2);
        table.getStyle().setHeaderSource(PdfHeaderSource.Rows);
        table.getStyle().setHeaderRowCount(1);
        table.getStyle().setShowHeader(true);
        table.setDataSource(dataSource);

        PdfLayoutResult result = table.draw(page, new Point2D.Float(0, y));
        y = y + (float) result.getBounds().getHeight() + 5;

        PdfBrush brush2 = PdfBrushes.getGray();
        PdfTrueTypeFont font2 = new PdfTrueTypeFont(new Font("Arial", 0,9));
        page.getCanvas().drawString(String.format("* %1$s countries in the list.", data.length - 1), font2, brush2, 5, y);

        //Save pdf file.
        doc.saveToFile("output/simpleTable.pdf");
    }
}
