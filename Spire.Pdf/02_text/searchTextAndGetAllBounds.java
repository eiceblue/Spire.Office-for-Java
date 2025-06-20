import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import com.spire.pdf.texts.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.EnumSet;
import java.util.List;

public class searchTextAndGetAllBounds {

    public static void main(String args[]) {
        // Input and output files
        String inputFile = "data/FindTextAndGetAllBounds.pdf";
        String outputFile = "output/CoverAllFindingBounds.pdf";

        // Create a PDF document
        PdfDocument pdf = new PdfDocument();

        // Load the document from disk
        pdf.loadFromFile(inputFile);

        // Initialize a variable to store search results
        List<PdfTextFragment> results = null;

        // Create text find options for searching
        PdfTextFindOptions findOptions = new PdfTextFindOptions();

        // Ignore case when finding text
        findOptions.setTextFindParameter(EnumSet.of(TextFindParameter.IgnoreCase));

        PdfTextFinder textFinder = null;

        for (Object pageObj : pdf.getPages()) {
            // Get the current page
            PdfPageBase page = (PdfPageBase) pageObj;

            // Save the current graphics state
            PdfGraphicsState state = page.getCanvas().save();

            // Define pen and brush for drawing rectangles
            PdfPen pen = new PdfPen(new PdfRGBColor(Color.BLACK), 1f);
            PdfBrush brush = new PdfSolidBrush(new PdfRGBColor(Color.RED));

            // Create a PdfTextFinder object with the current page
            textFinder = new PdfTextFinder(page);

            // Find the specified text using the given find options
            results = textFinder.find("Customized Demo", findOptions);

            // Traverse all finding results
            for (PdfTextFragment find : results) {
                // Get all bounds of a found text
                Rectangle2D[] bounds = find.getBounds();

                // Draw a rectangle around each found text
                for (Rectangle2D rect : bounds) {
                    page.getCanvas().drawRectangle(pen, brush, rect);
                }
            }

            // Restore the graphics state
            page.getCanvas().restore(state);
        }

        // Save the modified document
        pdf.saveToFile(outputFile, FileFormat.PDF);

        // Close the PDF document
        pdf.close();

        // Dispose of the PDF document (frees up system resources)
        pdf.dispose();
    }
}
