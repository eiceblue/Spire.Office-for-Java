import com.spire.pdf.*;
import com.spire.pdf.annotations.*;
import com.spire.pdf.general.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.*;

public class documentLinkAnnotation {
    public static void main(String[] args) {
        String output = "output/documentLinkAnnotation.pdf";

        // Create a pdf document
        PdfDocument doc = new PdfDocument();

        // Create PdfUnitConvertor to convert the unit
        PdfUnitConvertor unitCvtr = new PdfUnitConvertor();

        //setting for page margin
        PdfMargins margin = new PdfMargins();
        margin.setTop(unitCvtr.convertUnits(2.54f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
        margin.setBottom(margin.getTop());
        margin.setLeft(unitCvtr.convertUnits(2.0f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
        margin.setRight(margin.getLeft());

        // Add the first page
        PdfPageBase page1 = doc.getPages().add(PdfPageSize.A4, margin);

        // Define a PdfBrush
        PdfBrush brush1 = PdfBrushes.getBlack();

        // Define a font
        PdfTrueTypeFont font1 = new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 12), true);

        // Set the string format
        PdfStringFormat format1 = new PdfStringFormat(PdfTextAlignment.Left);

        // Set the position for drawing
        float x = 0;
        float y = 50;

        // Text string
        String specification = "The sample demonstrates how to create a local document link in PDF document.";

        // Draw text string on first page
        page1.getCanvas().drawString(specification, font1, brush1, x, y, format1);

        // Use MeasureString to get the height of string
        y = y + (float) font1.measureString(specification, format1).getHeight() + 10f;

        // Add the second page
        PdfPageBase page2 = doc.getPages().add(PdfPageSize.A4, margin);

        // String text
        String PageContent = "This is the second page!";

        // Draw text string on second page
        page2.getCanvas().drawString(PageContent, font1, brush1, x, y, format1);

        // Add DocumentLinkAnnotation on the first page and link to the second page
        addDocumentLinkAnnotation(doc, 0, 1, y);

        // Save the document
        doc.saveToFile(output, FileFormat.PDF);

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }

    private static void addDocumentLinkAnnotation(PdfDocument pdf, int AddPage, int DestinationPage, float y) {
        // Define a font
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 12));

        // Set the string format
        PdfStringFormat format = new PdfStringFormat(PdfTextAlignment.Left);

        // Text string
        String prompt = "Local document Link: ";

        // Draw text string on page that
        pdf.getPages().get(AddPage).getCanvas().drawString(prompt, font, PdfBrushes.getDodgerBlue(), 0, y);

        // Use MeasureString to get the width of string
        float x = (float) font.measureString(prompt, format).getWidth();

        // Create a PdfDestination with specific page
        PdfDestination dest = new PdfDestination(pdf.getPages().get(DestinationPage));

        // Set the location of destination
        dest.setLocation(new Point2D.Float(0, y));

        // Set 50% zoom factor
        dest.setZoom(0.5f);

        // Label string
        String label = "Click here to link the second page.";

        // Use MeasureString to get the SizeF of string
        Dimension2D dimension2D = new Dimension();
        dimension2D.setSize(font.measureString(label));

        // Create a rectangle
        Rectangle2D bounds = new Rectangle2D.Float();
        bounds.setFrame(x, y, dimension2D.getWidth(),dimension2D.getHeight());

        // Draw label string
        pdf.getPages().get( AddPage).getCanvas().drawString(label, font, PdfBrushes.getOrangeRed(), x, y);

        // Create PdfDocumentLinkAnnotation on the rectangle and link to the destination
        PdfDocumentLinkAnnotation annotation = new PdfDocumentLinkAnnotation(bounds, dest);

        // Set color for annotation
        annotation.setColor(new PdfRGBColor(Color.BLUE));

        // Add annotation to the page
        pdf.getPages().get( AddPage ).getAnnotationsWidget().add(annotation);
    }
}
