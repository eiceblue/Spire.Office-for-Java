import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import com.spire.pdf.graphics.layer.*;
import java.awt.geom.*;

public class addLayers {
    public static void main(String[] args) throws Exception {
        String input="data/addLayer.pdf";
        PdfDocument loDoc = new PdfDocument();
        loDoc.loadFromFile(input);
        PdfPageBase page = loDoc.getPages().get(0);
        PdfLayer layer = loDoc.getLayers().addLayer("red line1");
        PdfCanvas pcA = layer.createGraphics(loDoc.getPages().get(0).getCanvas());
        pcA.drawLine(new PdfPen(PdfBrushes.getRed(), 1), new Point2D.Float(50, 350), new Point2D.Float(200, 350));
        layer = loDoc.getLayers().addLayer("blue line1");
        PdfCanvas pcB = layer.createGraphics(loDoc.getPages().get(0).getCanvas());
        pcB.drawLine(new PdfPen(PdfBrushes.getBlue(), 1), new Point2D.Float(50, 450), new Point2D.Float(200, 450));
        layer = loDoc.getLayers().addLayer("green line1");
        PdfCanvas pcC = layer.createGraphics(loDoc.getPages().get(0).getCanvas());
        pcC.drawLine(new PdfPen(PdfBrushes.getGreen(), 1), new Point2D.Float(50,550), new Point2D.Float(200, 550));
        loDoc.saveToFile("output/addLayers.pdf");
    }
}
