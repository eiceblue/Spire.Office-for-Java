import com.spire.pdf.*;
import com.spire.pdf.annotations.PdfRubberStampAnnotation;
import com.spire.pdf.annotations.appearance.PdfAppearance;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.*;
import java.text.SimpleDateFormat;

public class addTextStamp {
    public static void main(String[] args) {
        // Define the output file path
        String output = "output/addTextStamp.pdf";

        // Load a PDF document from disk
        PdfDocument document = new PdfDocument();
        document.loadFromFile("data/stamp.pdf");

        // Get the first page of the document
        PdfPageBase page = document.getPages().get(0);

        // Create a PDF template with dimensions 125x55 to hold the stamp content
        PdfTemplate template = new PdfTemplate(125, 55);

        // Create a TrueType font for the stamp text
        PdfTrueTypeFont font1 = new PdfTrueTypeFont(new Font("Elephant", Font.ITALIC, 10), true);

        // Create a solid brush with RGB color (139, 0, 0)
        PdfSolidBrush brush = new PdfSolidBrush(new PdfRGBColor(139, 0, 0));

        // Create a pen using the solid brush for drawing the border
        PdfPen pen = new PdfPen(brush);

        // Create a rectangle for the stamp annotation
        Rectangle2D rectangle = new Rectangle2D.Float();
        rectangle.setFrame(new Point2D.Float(5, 5), template.getSize());

        // Define the corner radius for rounded corners
        int cornerRadius = 20;

        // Create a path for the stamp shape with rounded corners
        PdfPath path = new PdfPath();
        path.addArc(template.getBounds().getX(), template.getBounds().getY(), cornerRadius, cornerRadius, 180, 90);
        path.addArc(template.getBounds().getX() + template.getWidth() - cornerRadius, template.getBounds().getY(), cornerRadius, cornerRadius, 270, 90);
        path.addArc(template.getBounds().getX() + template.getWidth() - cornerRadius, template.getBounds().getY() + template.getHeight() - cornerRadius, cornerRadius, cornerRadius, 0, 90);
        path.addArc(template.getBounds().getX(), template.getBounds().getY() + template.getHeight() - cornerRadius, cornerRadius, cornerRadius, 90, 90);
        path.addLine(template.getBounds().getX(), template.getBounds().getY() + template.getHeight() - cornerRadius, template.getBounds().getX(), template.getBounds().getY() + cornerRadius / 2);

        // Draw the stamp shape with the pen and path
        template.getGraphics().drawPath(pen, path);

        // Define the stamp text lines
        String s1 = "REVISED\n";
        String s2 = "by E-iceblue at " + dateToString(new java.util.Date(), "MM dd, yyyy");

        // Create a TrueType font for the stamp text line 2
        PdfTrueTypeFont font2 = new PdfTrueTypeFont(new Font("Lucida Sans Unicode", Font.BOLD, 9), true);

        // Draw the stamp text lines onto the template using the fonts and brush
        template.getGraphics().drawString(s1, font1, brush, new Point2D.Float(5, 10));
        template.getGraphics().drawString(s2, font2, brush, new Point2D.Float(2, 30));

        // Create a rubber stamp annotation with the defined rectangle
        PdfRubberStampAnnotation stamp = new PdfRubberStampAnnotation(rectangle);

        // Create a PDF appearance for the rubber stamp annotation
        PdfAppearance appearance = new PdfAppearance(stamp);

        // Set the normal appearance of the annotation as the created PDF template
        appearance.setNormal(template);

        // Set the appearance of the rubber stamp annotation to the created PDF appearance
        stamp.setAppearance(appearance);

        // Add the rubber stamp annotation to the page's annotations widget
        page.getAnnotationsWidget().add(stamp);

        // Save the modified document to the specified output file
        document.saveToFile(output, FileFormat.PDF);

        // Close the PDF document to release resources
        document.close();

        // Dispose of the PDF document to free up system resources
        document.dispose();

    }
	
    public static String dateToString(java.util.Date poDate, String pcFormat) {
        // Create a SimpleDateFormat object with the specified format
        SimpleDateFormat loFormat = new SimpleDateFormat(pcFormat);

        // Format the Date object as a string using the created SimpleDateFormat
        return loFormat.format(poDate);
    }
}
