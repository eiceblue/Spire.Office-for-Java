import com.spire.pdf.*;
import com.spire.pdf.annotations.*;
import com.spire.pdf.annotations.appearance.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.EnumSet;

public class textWaterMarkSecond {
    public static void main(String[] args) {
        // Create a new PdfDocument object
        PdfDocument pdf = new PdfDocument();

        // Load an existing PDF document from the file path "data/template_az.pdf"
        pdf.loadFromFile("data/template_az.pdf");

        // Get the first page of the loaded PDF document
        PdfPageBase page = pdf.getPages().get(0);

        // Create a Dimension object to store the size of the page
        Dimension2D lodimension2D = new Dimension();
        lodimension2D.setSize(page.getClientSize().getWidth(), page.getClientSize().getHeight());

        // Create a Rectangle2D object that represents the entire page's client size
        Rectangle2D loRect = new Rectangle2D.Float();
        loRect.setFrame(new Point2D.Float(0, 0), lodimension2D);

        // Create a PdfTemplate with the same dimensions as the page
        PdfTemplate template = new PdfTemplate(page.getClientSize().getWidth(), page.getClientSize().getHeight());

        // Call the 'insertWatermark' method to insert the watermark on the template, with the text "e-iceblue"
        insertWatermark(template, "e-iceblue");

        // Create a PdfWatermarkAnnotation with the specified rectangle coordinates
        PdfWatermarkAnnotation watermarkAnnotation = new PdfWatermarkAnnotation(loRect);

        // Create a PdfAppearance object for the watermark annotation
        PdfAppearance appearance = new PdfAppearance(watermarkAnnotation);

        // Set the appearance to use the template as its normal state
        appearance.setNormal(template);

        // Set the appearance of the watermark annotation
        watermarkAnnotation.setAppearance(appearance);

        // Set the text of the watermark annotation to "watermark"
        watermarkAnnotation.setText("watermark");

        // Set the transformation matrix for printing the annotation
        watermarkAnnotation.getFixedPrint().setMatrix(new float[]{1, 0, 0, 1, 0, 0});

        // Set the horizontal translation for printing the annotation
        watermarkAnnotation.getFixedPrint().setHorizontalTranslation(0.5f);

        // Set the vertical translation for printing the annotation
        watermarkAnnotation.getFixedPrint().setVerticalTranslation(0.5f);

        // Add the watermark annotation to the page's annotations widget
        page.getAnnotationsWidget().add(watermarkAnnotation);

        // Save the modified PDF document to the file path "output/textWaterMarkSecond.pdf"
        pdf.saveToFile("output/textWaterMarkSecond.pdf");

        // Close the PDF document to release resources
        pdf.close();

        // Dispose of the PDF document to free up system resources
        pdf.dispose();
    }

    static void insertWatermark(PdfTemplate template, String watermark) {
        // Create a Dimension object to store the size of the watermark
        Dimension2D dimension2D = new Dimension();

        // Set the size of the watermark to half of the template's width and one third of its height
        dimension2D.setSize(template.getWidth() / 2, template.getHeight() / 3);

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

        // Create a Rectangle2D object that represents the template's client size
        Rectangle2D loRect = new Rectangle2D.Float();
        loRect.setFrame(new Point2D.Float(0, 0), template.getGraphics().getSize());

        // Draw a rectangle on the template's graphics using the brush as the fill color and the specified rectangle bounds
        template.getGraphics().drawRectangle(brush, loRect);
    }
}
