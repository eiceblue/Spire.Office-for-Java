import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import com.spire.pdf.texts.*;
import java.util.EnumSet;
import java.util.List;

public class searchTextAndDrawRectangle {
    public static void main(String[] args) {
        // Input file path
        String input = "data/SearchReplaceTemplate.pdf";

        // Create a new PDF document
        PdfDocument doc = new PdfDocument();

        // Read a pdf file
        doc.loadFromFile(input);

        // Get the first page of pdf file
        PdfPageBase page = doc.getPages().get(0);

        // Initialize a variable to store search results
        List<PdfTextFragment> results = null;

        // Create text find options for searching
        PdfTextFindOptions findOptions = new PdfTextFindOptions();

        // Set search parameters
        findOptions.setTextFindParameter(EnumSet.of(TextFindParameter.None));

        // Create a PdfTextFinder object with the specified page
        PdfTextFinder textFinder = new PdfTextFinder(page);

        // Find the specified text using the given find options
        results = textFinder.find("Spire.PDF for Java", findOptions);


        for(PdfTextFragment find : results)
        {
            // Draw a rectangle with red pen
            page.getCanvas().drawRectangle(new PdfPen(PdfBrushes.getRed(),0.9f), find.getBounds()[0]);
        }

        // Output file path to save the modified document
        String result = "output/searchTextAndDrawRectangle.pdf";

        //Save the document
        doc.saveToFile(result, FileFormat.PDF);

        // Close the PDF document
        doc.close();

        // Dispose of the PDF document (frees up system resources)
        doc.dispose();
    }
}
