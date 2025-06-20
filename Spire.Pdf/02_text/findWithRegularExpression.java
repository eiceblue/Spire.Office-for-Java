import com.spire.ms.System.Collections.Generic.List;
import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import com.spire.pdf.texts.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.io.*;
import java.util.EnumSet;


public class findWithRegularExpression {
    public static void main(String[] args) {
        // Specify the file path
        String input = "data/findWithRegularExpression.pdf";

        // Create a pdf file
        PdfDocument doc = new PdfDocument();

        // Load the PDF document
        doc.loadFromFile(input);

        // Get the first page of the PDF file
        PdfPageBase page = doc.getPages().get(0);

        // Match the regex
        String regex = "(?<=\\{)[^}]*(?=\\})";

        // Create text find options
        PdfTextFindOptions findOptions = new PdfTextFindOptions();

        // Set search parameter to use regular expression
        findOptions.setTextFindParameter(EnumSet.of(TextFindParameter.Regex));

        // Create a text finder object for the page
        PdfTextFinder textFinder = new PdfTextFinder(page);

        // Find text fragments that match the regex
        List<PdfTextFragment> finds = textFinder.find(regex, findOptions);

        // Define a color
        PdfRGBColor color = new PdfRGBColor(Color.blue);

        // Create a brush with the defined color
        PdfBrush brush = new PdfSolidBrush(color);

        // Define a font
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 10));

        // Set text alignment
        PdfStringFormat centerAlign = new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle);

        // Define a rec
        Rectangle2D rec;

        // Iterate the find results
        for (PdfTextFragment find : finds) {

            // Get the bounds of the found text
            rec = find.getBounds()[0];

            // Draw a rectangle around the found text
            page.getCanvas().drawRectangle(PdfBrushes.getWhite(), rec);

            // Set new text
            String newText = "New Text";

            //  Replace the found text with new text
            page.getCanvas().drawString(newText, font, brush, rec, centerAlign);
        }

        // Define output path
        String result = "output/findWithRegularExpression_out.pdf";

        // Save the modified document
        doc.saveToFile(result);

        // Close the PDF document
        doc.close();

        // Dispose of the PDF document (frees up system resources)
        doc.dispose();
    }
}
