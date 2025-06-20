import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.Point2D;

public class headerAndFooter {
    public static void main(String[] args) {
        // Specify the input PDF file paths
        String input1 = "data/headerAndFooter.pdf";
        String input2 = "Data/header.png";
        String input3 = "Data/footer.png";

        // Specify the output PDF file path
        String output = "output/addheaderAndFooter.pdf";

        // Create a new PDF document
        PdfDocument doc = new PdfDocument();

        // Load the existing PDF document from the input file
        doc.loadFromFile(input1);

        // Set the brush color for drawing
        PdfBrush brush = PdfBrushes.getBlack();

        // Set the pen for drawing lines
        PdfPen pen = new PdfPen(brush, 0.75f);

        // Set the font for text
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial", Font.ITALIC, 10), true);

        // Set the string format for right-aligned text
        PdfStringFormat rightAlign = new PdfStringFormat(PdfTextAlignment.Right);
        rightAlign.setMeasureTrailingSpaces(true);

        // Set the string format for left-aligned text
        PdfStringFormat leftAlign = new PdfStringFormat(PdfTextAlignment.Left);

        // Get the page margins of the document
        PdfMargins margin = doc.getPageSettings().getMargins();

        // Calculate the space between lines based on the font height
        float space = font.getHeight() * 0.75f;

        // Initialize variables for position and width
        float x = 0;
        float y = 0;
        float width = 0;

        // Create a new PDF document for adding headers and footers
        PdfDocument newPdf = new PdfDocument();
        PdfPageBase newPage;

        // Iterate through each page of the original document
        for (int i = 0; i < doc.getPages().getCount(); i++) {
            // Get the current page
            PdfPageBase page = doc.getPages().get(i);

            // Create a new page in the new PDF document with the same size and no margins
            newPage = newPdf.getPages().add(page.getSize(), new PdfMargins(0));

            // Set transparency for the new page's canvas
            newPage.getCanvas().setTransparency(0.5f);

            // Set the starting position and width for drawing headers and footers
            x = margin.getLeft();
            width = (float) page.getCanvas().getClientSize().getWidth() - margin.getLeft() - margin.getRight();

            // Draw a line as a separator between header and content
            y = margin.getTop() - space;
            newPage.getCanvas().drawLine(pen, x, y + 15, x + width, y + 15);

            // Adjust the vertical position for drawing the header text
            y = y + 10 - font.getHeight();

            // Set transparency for the new page's canvas
            newPage.getCanvas().setTransparency(0.5f);

            // Draw the header image
            PdfImage headerImage = PdfImage.fromFile(input2);
            newPage.getCanvas().drawImage(headerImage, new Point2D.Float(0, 0));

            // Draw the right-aligned header text
            newPage.getCanvas().drawString("Demo of Spire.Pdf", font, brush, x + width, y, rightAlign);

            // Draw the footer image
            PdfImage footerImage = PdfImage.fromImage(input3);
            newPage.getCanvas().drawImage(footerImage, new Point2D.Float(0, (float) (newPage.getCanvas().getClientSize().getHeight() - footerImage.getPhysicalDimension().getHeight())));

            // Change the font and brush for drawing the footer text
            brush = PdfBrushes.getDarkBlue();
            font = new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 12), true);

            // Calculate the vertical position for drawing the footer text
            y = (float) newPage.getCanvas().getClientSize().getHeight() - margin.getBottom() - font.getHeight();

            // Draw the left-aligned footer text
            newPage.getCanvas().drawString("Created by E-iceblue Co,.Ltd", font, brush, x, y, leftAlign);

            // Set transparency back to 1 for the new page's canvas
            newPage.getCanvas().setTransparency(1);

            // Draw the contents of the original page on the new page's canvas
            page.createTemplate().draw(newPage.getCanvas(), new Point2D.Float(0, 0));
        }

        // Save the modified document to the output file in PDF format
        newPdf.saveToFile(output, FileFormat.PDF);

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }
}
