import com.spire.pdf.*;
import java.awt.*;
import java.awt.geom.Point2D;

public class insertSVGToPDF {
    public static void main(String[] args) {
        //Create SVG document
        PdfDocument svg = new PdfDocument();

        //Load the SVG document from disk.
        svg.loadFromSvg("data/charthtml.svg");

        //Create PDF document
        PdfDocument pdf = new PdfDocument();
        
        //Load the PDF document from disk
        pdf.loadFromFile("data/Source.pdf");

        // Draw svg image on pdf document
        pdf.getPages().get(0).getCanvas().drawTemplate(svg.getPages().get(0).createTemplate(), new Point2D.Float(10, 10), new Dimension(300, 300));

        //Save the document
        pdf.saveToFile("output/insertSVG2PDF.pdf", FileFormat.PDF);
        svg.close();

        // Close the PDF document
        pdf.close();

        // Dispose of the PDF document (frees up system resources)
        pdf.dispose();
    }
}
