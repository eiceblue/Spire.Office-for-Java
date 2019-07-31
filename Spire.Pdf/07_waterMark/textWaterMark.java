import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.*;

public class textWaterMark {
    public static void main(String[] args) {
        PdfDocument original = new PdfDocument();
        original.loadFromFile("data/waterMark.pdf");
        PdfPageBase page =  original.getPages().get(0);
        insertWatermark(page,"E-ICEBLUE");
        original.saveToFile("output/textWaterMark.pdf");
    }

    static void insertWatermark(PdfPageBase page, String watermark) {
        Dimension2D dimension2D = new Dimension();
        dimension2D.setSize(page.getCanvas().getClientSize().getWidth() / 2, page.getCanvas().getClientSize().getHeight() / 3);
        PdfTilingBrush brush = new PdfTilingBrush(dimension2D);
        brush.getGraphics().setTransparency(0.3F);
        brush.getGraphics().save();
        brush.getGraphics().translateTransform((float) brush.getSize().getWidth() / 2, (float) brush.getSize().getHeight() / 2);
        brush.getGraphics().rotateTransform(-45);
        brush.getGraphics().drawString(watermark, new PdfFont(PdfFontFamily.Helvetica, 24), PdfBrushes.getViolet(), 0, 0, new PdfStringFormat(PdfTextAlignment.Center));
        brush.getGraphics().restore();
        brush.getGraphics().setTransparency(1);
        Rectangle2D loRect = new Rectangle2D.Float();
        loRect.setFrame(new Point2D.Float(0, 0), page.getCanvas().getClientSize());
        page.getCanvas().drawRectangle(brush, loRect);
    }
}