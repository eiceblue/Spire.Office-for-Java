import com.spire.pdf.*;
import com.spire.pdf.annotations.*;
import com.spire.pdf.graphics.*;
import com.spire.pdf.texts.*;
import java.awt.*;
import java.io.*;
import java.util.EnumSet;
import java.util.List;

public class searchTextAndAddHyperlink {
    public static void main(String[] args) {
        // Input file path
        String input = "data/SearchReplaceTemplate.pdf";

        // Create a new PDF document
        PdfDocument doc = new PdfDocument();

        // Read a PDF file
        doc.loadFromFile(input);

        // Get the first page of the PDF file
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
        results = textFinder.find("e-iceblue", findOptions);

        // Hyperlink URL
        String url = "http://www.e-iceblue.com";

        // Iterate over each found text fragment
        for (PdfTextFragment fragment : results) {
            // Create a URI annotation with the bounds of the text fragment
            PdfUriAnnotation uri = new PdfUriAnnotation(fragment.getBounds()[0]);

            // Set the URI of the hyperlink
            uri.setUri(url);

            // Set the border style of the annotation
            uri.setBorder(new PdfAnnotationBorder(1f));

            // Set the color of the annotation
            uri.setColor(new PdfRGBColor(Color.blue));

            // Add the annotation to the page
            page.getAnnotationsWidget().add(uri);
        }

        // Output file path to save the modified document
        String result = "output/searchTextAndAddHyperlink.pdf";

        // Save the modified document
        doc.saveToFile(result);
        // Close the PDF document
        doc.close();

        // Dispose of the PDF document (frees up system resources)
        doc.dispose();
    }
}
