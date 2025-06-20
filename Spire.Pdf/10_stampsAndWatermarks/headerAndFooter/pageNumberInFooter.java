import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.*;

public class pageNumberInFooter {
    public static void main(String[] args) {
        String input = "data/deletePage.pdf";
        String output = "output/pageNumberInFooter.pdf";

        // Create a PDF document
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(input);

        // Get the margin settings of the document
        PdfMargins margin = doc.getPageSettings().getMargins();

        // Add page numbers to the document
        DrawPageNumber(doc, margin, 1, doc.getPages().getCount());

        // Save the modified PDF document to the output file
        doc.saveToFile(output, FileFormat.PDF);

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }
	
	
     private static void DrawPageNumber(PdfDocument doc, PdfMargins margin, int startNumber, int pageCount) {
        for (int i = 0; i < doc.getPages().getCount(); i++) {
            // Get the current page
            PdfPageBase page = doc.getPages().get(i);

            // Set transparency for the canvas
            page.getCanvas().setTransparency(0.5f);

            // Set the brush and pen for drawing
            PdfBrush brush = PdfBrushes.getBlack();
            PdfPen pen = new PdfPen(brush, 0.75f);

            // Set the font for the page number text
            PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial", Font.ITALIC, 12), true);

            // Set the string format for aligning the page number text
            PdfStringFormat format = new PdfStringFormat(PdfTextAlignment.Right);
            format.setMeasureTrailingSpaces(true);

            // Calculate the space between lines
            float space = font.getHeight() * 0.75f;

            // Set the initial position for drawing
            float x = margin.getLeft();
            float width = (float) page.getCanvas().getClientSize().getWidth() - margin.getLeft() - margin.getRight();
            float y = (float) page.getCanvas().getClientSize().getHeight() - margin.getBottom() + space;

            // Draw a line under the page number
            page.getCanvas().drawLine(pen, x, y, x + width, y);

            // Update the position for drawing the page number label
            y = y + 1;

            // Generate the page number label
            String numberLabel = String.format("%d of %d", startNumber++, pageCount);

            // Draw the page number label onto the page
            page.getCanvas().drawString(numberLabel, font, brush, x + width, y, format);

            // Reset the transparency for the canvas
            page.getCanvas().setTransparency(1);
        }
    }
}
