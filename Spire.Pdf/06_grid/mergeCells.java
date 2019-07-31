import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import com.spire.pdf.grid.*;
import java.awt.*;
import java.awt.geom.Point2D;


public class mergeCells {
    public static void main(String[] args) {
        PdfDocument document = new PdfDocument();
        PdfPageBase page = document.getPages().add();
        PdfGrid grid = new PdfGrid();
        grid.getColumns().add(5);
        //Set the width
        for (int j = 0; j < grid.getColumns().getCount(); j++) {
            grid.getColumns().get(j).setWidth(100);
        }
        //Add rows
        PdfGridRow row0 = grid.getRows().add();
        PdfGridRow row1 =   grid.getRows().add();
        float height = 20.0f;
        //Set the height
        for (int i = 0; i < grid.getRows().size(); i++) {
            grid.getRows().get(i).setHeight(height);
        }
        row0.getStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.BOLD,16), true));
        row1.getStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.ITALIC,16), true));
        row0.getCells().get(0).setValue( "Corporation");
        //Merge two rows
        row0.getCells().get(0).setRowSpan(2);
        row0.getCells().get(1).setValue("B&K Undersea Photo");
        row0.getCells().get(1).setStringFormat(new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle));
        //Merge two columns
        row0.getCells().get(1).setColumnSpan(3);
        row0.getCells().get(4).setValue( "World");
        row0.getCells().get(4).getStyle().setFont(new PdfTrueTypeFont(new Font("Arial",Font.BOLD+Font.ITALIC ,10), true));
        row0.getCells().get(4).setStringFormat(new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle));
        row0.getCells().get(4).getStyle().setBackgroundBrush( PdfBrushes.getLightGreen());
        row1.getCells().get(1).setValue( "Diving International Unlimited");
        row1.getCells().get(1).setStringFormat(new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle));
        //Merge four columns
        row1.getCells().get(1).setColumnSpan(4);
        grid.draw(page, new Point2D.Float(10, 150));

        document.saveToFile("output/mergeCells.pdf");
    }
}
