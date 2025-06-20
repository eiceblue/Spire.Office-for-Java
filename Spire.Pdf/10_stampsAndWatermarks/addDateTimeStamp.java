
import com.spire.pdf.*;
import com.spire.pdf.annotations.*;
import com.spire.pdf.annotations.appearance.PdfAppearance;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.text.SimpleDateFormat;
import java.util.Date;


public class addDateTimeStamp {
    public static void main(String[] args) {

        // Load a PDF document from disk
        PdfDocument document = new PdfDocument();
        document.loadFromFile("data/addLayer.pdf");

        // Get the first page of the document
        PdfPageBase page = document.getPages().get(0);

        // Create a font using Arial with bold style and size 12
        Font createFont = new Font("Arial", Font.BOLD, 12);

        // Create a PDF TrueType font using the created font
        PdfTrueTypeFont font = new PdfTrueTypeFont(createFont, true);

        // Create a solid brush with red color for drawing
        PdfSolidBrush brush = new PdfSolidBrush(new PdfRGBColor(Color.red));

        // Get the current date and time
        Date timeString = new Date(System.currentTimeMillis());

        // Specify the desired format for the date and time string
        SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");

        // Format the current date and time as a string
        String retStrFormatNowDate = sdFormatter.format(timeString);

        // Create a PDF template with dimensions 140x30
        PdfTemplate template = new PdfTemplate(140, 30);

        // Set the position and dimensions of the template on the page
        Rectangle2D rect = new Rectangle2D.Float((float) page.getActualSize().getWidth() - (float) template.getWidth() - 10,
                (float) page.getActualSize().getHeight() - (float) template.getHeight() - 10,
                template.getWidth(), template.getHeight());

        // Draw the date and time string onto the template
        template.getGraphics().drawString(retStrFormatNowDate, font, brush, 10, 10);
        
        // Create a rubber stamp annotation with the specified rectangle position and dimensions
        PdfRubberStampAnnotation stamp = new PdfRubberStampAnnotation(rect);

        // Create a PDF appearance for the rubber stamp annotation
        PdfAppearance appearance = new PdfAppearance(stamp);

        // Set the normal appearance of the annotation as the created PDF template
        appearance.setNormal(template);

        // Set the appearance of the rubber stamp annotation to the created PDF appearance
        stamp.setAppearance(appearance);

        // Add the rubber stamp annotation to the page's annotations widget
        page.getAnnotationsWidget().add(stamp);

        // Save the modified document to the specified output file
        String output = "output/AddDateTimeStamp_result.pdf";
        document.saveToFile(output, FileFormat.PDF);

        // Close the PDF document to release resources
        document.close();

        // Dispose of the PDF document to free up system resources
        document.dispose();
    }
}
