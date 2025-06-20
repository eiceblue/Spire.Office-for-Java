import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import com.spire.pdf.graphics.layer.*;

import java.awt.geom.*;

public class addLayers {
    public static void main(String[] args) {
        // Create a new PdfDocument object
        PdfDocument doc = new PdfDocument();

        // Load the PDF document from the specified file
        doc.loadFromFile("data/addLayer.pdf");

        // Get the first page of the document
        PdfPageBase page = doc.getPages().get(0);

        // Create a new layer with the name "red line1"
        PdfLayer layer = doc.getLayers().addLayer("red line1");

        // Create a graphics context for drawing on the layer's canvas
        PdfCanvas pcA = layer.createGraphics(doc.getPages().get(0).getCanvas());

        // Draw a red line on the layer's canvas
        pcA.drawLine(new PdfPen(PdfBrushes.getRed(), 1), new Point2D.Float(50, 350), new Point2D.Float(200, 350));

        // Create a new layer with the name "blue line1"
        layer = doc.getLayers().addLayer("blue line1");

        // Create a graphics context for drawing on the layer's canvas
        PdfCanvas pcB = layer.createGraphics(doc.getPages().get(0).getCanvas());

        // Draw a blue line on the layer's canvas
        pcB.drawLine(new PdfPen(PdfBrushes.getBlue(), 1), new Point2D.Float(50, 450), new Point2D.Float(200, 450));

        // Create a new layer with the name "green line1"
        layer = doc.getLayers().addLayer("green line1");

        // Create a graphics context for drawing on the layer's canvas
        PdfCanvas pcC = layer.createGraphics(doc.getPages().get(0).getCanvas());

        // Draw a green line on the layer's canvas
        pcC.drawLine(new PdfPen(PdfBrushes.getGreen(), 1), new Point2D.Float(50, 550), new Point2D.Float(200, 550));

        // Specify the output file path for the modified document
        String output = "output/addLayers.pdf";

        // Save the modified document to the specified output file in PDF format
        doc.saveToFile(output, FileFormat.PDF);

        // Close the input document
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }
}
