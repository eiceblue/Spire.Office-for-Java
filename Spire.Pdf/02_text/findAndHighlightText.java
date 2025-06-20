import com.spire.ms.System.Collections.Generic.List;
import com.spire.pdf.*;
import com.spire.pdf.texts.*;
import java.io.*;
import java.util.EnumSet;

public class findAndHighlightText {
    public static void main(String[] args) throws Exception{
        // Create a new PDF document
        PdfDocument pdf = new PdfDocument();

        // Load an existing PDF file
        pdf.loadFromFile("data/findAndHighlightText.pdf");

        // Initialize a variable to store search results
        List<PdfTextFragment> results = null;

        // Create text find options for searching
        PdfTextFindOptions findOptions = new PdfTextFindOptions();

        // Set search parameters to find whole words only
        findOptions.setTextFindParameter(EnumSet.of(TextFindParameter.WholeWord));

        // Loop through the pages in the PDF file
        for (Object pageObj : pdf.getPages()) {

            // Get each page in the PDF document
            PdfPageBase page = (PdfPageBase) pageObj;

            // Create a text finder object for the page
            PdfTextFinder textFinder = new PdfTextFinder(page);

            // Search for the text "science" on the page
            results = textFinder.find("science", findOptions);

            // Find text
            for (PdfTextFragment fragment : results) {
                // Highlight searched text
                fragment.highLight();
            }
        }

        // Specify the output file path
        String output = "output/findAndHighlightText_out.pdf";

        // Save the modified document
        pdf.saveToFile(output, FileFormat.PDF);

        // Close the PDF document
        pdf.close();

        // Dispose of the PDF document (frees up system resources)
        pdf.dispose();
    }
}
