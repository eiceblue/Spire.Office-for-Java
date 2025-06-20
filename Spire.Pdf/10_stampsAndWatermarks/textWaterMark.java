import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.*;

public class textWaterMark {
    public static void main(String[] args)  {
        // Specify the input and output file paths for the PDF files
        String input = "data/headerAndFooter.pdf";
        String output = "output/textWaterMark.pdf";

        // Create a new PdfDocument object called 'original' and load the PDF document from the input file
        PdfDocument original = new PdfDocument();
        original.loadFromFile(input);

        // Get the first page of the loaded PDF document
        PdfPageBase page = original.getPages().get(0);

        // Insert the watermark on the PDF page, with the text "E-ICEBLUE"
        insertWatermark(page, "E-ICEBLUE");

        // Save the modified PDF document to the specified output file
        original.saveToFile(output);

        // Close the PDF document to release resources
        original.close();

        // Dispose of the PDF document to free up system resources
        original.dispose();
    }

    static void insertWatermark(PdfPageBase page, String watermark) {
        // Create a Dimension object to store the size of the watermark
        Dimension2D dimension2D = new Dimension();

        // Set the size of the watermark to half of the page's client size width and one third of its height
        dimension2D.setSize(page.getCanvas().getClientSize().getWidth() / 2, page.getCanvas().getClientSize().getHeight() / 3);

        // Create a PdfTilingBrush with the specified dimensions
        PdfTilingBrush brush = new PdfTilingBrush(dimension2D);

        // Set the transparency of the brush's graphics to 0.3 (30% transparency)
        brush.getGraphics().setTransparency(0.3f);

        // Save the current state of the brush's graphics
        brush.getGraphics().save();

        // Translate the origin of the brush's graphics to the center of the brush's size
        brush.getGraphics().translateTransform((float) brush.getSize().getWidth() / 2, (float) brush.getSize().getHeight() / 2);

        // Rotate the brush's graphics counterclockwise by 45 degrees
        brush.getGraphics().rotateTransform(-45);

        // Draw the watermark text on the brush's graphics using a specified font, color, position, and format
        brush.getGraphics().drawString(watermark, new PdfFont(PdfFontFamily.Helvetica, 24), PdfBrushes.getViolet(), 0, 0, new PdfStringFormat(PdfTextAlignment.Center));

        // Restore the previously saved state of the brush's graphics
        brush.getGraphics().restore();

        // Reset the transparency of the brush's graphics to 1 (100% opacity)
        brush.getGraphics().setTransparency(1);

        // Create a Rectangle2D object that represents the entire page's client size
        Rectangle2D loRect = new Rectangle2D.Float();
        loRect.setFrame(new Point2D.Float(0, 0), page.getCanvas().getClientSize());

        // Draw a rectangle on the page's canvas using the brush as the fill color and the specified rectangle bounds
        page.getCanvas().drawRectangle(brush, loRect);
    }
}
