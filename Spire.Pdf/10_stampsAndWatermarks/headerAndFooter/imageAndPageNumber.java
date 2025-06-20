import com.spire.pdf.*;
import com.spire.pdf.automaticfields.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.*;

public class imageAndPageNumber {
    public static void main(String[] args) {
        String output = "output/imageAndPageNumber.pdf";

        //create a PDF document
        PdfDocument doc = new PdfDocument();
        doc.getPageSettings().setSize( PdfPageSize.A4);

        //reset the default margins to 0
        doc.getPageSettings().setMargins(new PdfMargins(0));

        //create a PdfMargins object, the parameters indicate the page margins you want to set
        PdfMargins margins = new PdfMargins(50, 50, 50, 50);

        //get page size
        Dimension2D pageSize = doc.getPageSettings().getSize();

        //create a header template with content and apply it to page template
        doc.getTemplate().setTop(CreateHeaderTemplate(doc, margins, pageSize));

        //create a footer template with content and apply it to page template
        doc.getTemplate().setBottom(CreateFooterTemplate(doc, margins, pageSize));

        // Set the left template of the document using the left margin and page height
        doc.getTemplate().setLeft(new PdfPageTemplateElement(margins.getLeft(), doc.getPageSettings().getSize().getHeight()));

        // Set the right template of the document using the right margin and page height
        doc.getTemplate().setRight(new PdfPageTemplateElement(margins.getRight(), doc.getPageSettings().getSize().getHeight()));

        // Create a new page in the document
        PdfPageBase page = doc.getPages().add();

        // Draw the text "Hello, World!" on the page at coordinates (10, 10)
        page.getCanvas().drawString(
                "Hello, World!",
                new PdfFont(PdfFontFamily.Helvetica, 30f), // Specify the font family and size for the text
                new PdfSolidBrush(new PdfRGBColor(Color.BLACK)), // Specify the brush (color) for the text
                10, 10); // Specify the position coordinates for the text

        //save the file
        doc.saveToFile(output, FileFormat.PDF);

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }

      // Creates a header template for a PDF document.
    private static PdfPageTemplateElement CreateHeaderTemplate(PdfDocument doc, PdfMargins margins, Dimension2D pageSize) {
        // Specify the path to the input image
        String input = "data/E-iceblueLogo.png";

        // Create a PdfPageTemplateElement for the header space with the specified width and top margin
        PdfPageTemplateElement headerSpace = new PdfPageTemplateElement(pageSize.getWidth(), margins.getTop());
        headerSpace.setForeground(false);

        float x = margins.getLeft();
        float y = 0;

        // Load the header image from the file
        PdfImage headerImage = PdfImage.fromFile(input);

        // Calculate the scaled width and height of the header image
        float width = headerImage.getWidth() / 2;
        float height = headerImage.getHeight() / 2;

        // Draw the header image on the header space's graphics at the specified position and size
        headerSpace.getGraphics().drawImage(headerImage, x, margins.getTop() - height - 5, width, height);

        // Create a pen to draw a line below the header
        PdfPen pen = new PdfPen(PdfBrushes.getLightGray(), 1);

        // Draw a horizontal line at the bottom of the header space
        headerSpace.getGraphics().drawLine(pen, x, y + margins.getTop() - 2, pageSize.getWidth() - x, y + margins.getTop() - 2);

        return headerSpace;
    }

    // Creates a footer template for a PDF document.
    private static PdfPageTemplateElement CreateFooterTemplate(PdfDocument doc, PdfMargins margins, Dimension2D pageSize) {
        // Create a PdfPageTemplateElement for the footer space with the specified width and bottom margin
        PdfPageTemplateElement footerSpace = new PdfPageTemplateElement(pageSize.getWidth(), margins.getBottom());
        footerSpace.setForeground(false);

        float x = margins.getLeft();
        float y = 0;

        // Create a pen to draw a line at the top of the footer space
        PdfPen pen = new PdfPen(PdfBrushes.getGray(), 1);
        footerSpace.getGraphics().drawLine(pen, x, y, pageSize.getWidth() - x, y);

        // Increase the y-coordinate to create a small space between the line and the text
        y = y + 5;

        // Create a TrueType font with Arial, plain style, and size 10
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 10), true);

        // Create a PdfPageNumberField to display the current page number
        PdfPageNumberField number = new PdfPageNumberField();

        // Create a PdfPageCountField to display the total number of pages
        PdfPageCountField count = new PdfPageCountField();

        // Create a composite field with the font, black color, and format string "Page {0} of {1}"
        PdfCompositeField compositeField = new PdfCompositeField(font, PdfBrushes.getBlack(), "Page {0} of {1}", number, count);

        // Set the string format for the composite field to align the text to the left and top
        compositeField.setStringFormat(new PdfStringFormat(PdfTextAlignment.Left, PdfVerticalAlignment.Top));

        // Measure the size of the composite field to determine its width and height
        Dimension2D size = font.measureString(compositeField.getText());

        // Set the bounds of the composite field using a rectangle with the calculated size
        compositeField.setBounds(new Rectangle2D.Float(x, y, (float)size.getWidth(), (float)size.getHeight()));

        // Draw the composite field on the footer space's graphics
        compositeField.draw(footerSpace.getGraphics());

        return footerSpace;
    }
}
