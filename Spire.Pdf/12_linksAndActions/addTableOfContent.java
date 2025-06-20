import com.spire.pdf.*;
import com.spire.pdf.actions.*;
import com.spire.pdf.annotations.*;
import com.spire.pdf.general.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.*;

public class addTableOfContent {
    public static void main(String[] args) {
        // Set the input file path
        String input = "data/addTableOfContent.pdf";

        // Set the output file path for the modified PDF document
        String output = "output/addTableOfContent_output.pdf";

        // Create a new PdfDocument object with the specified input file
        PdfDocument doc = new PdfDocument(input);

        // Get the total number of pages in the document
        int pageCount = doc.getPages().getCount();

        // Insert a new page at the beginning of the document for the table of contents
        PdfPageBase tocPage = doc.getPages().insert(0);

        // Set the title and formatting for the table of contents
        String title = "Table Of Contents";
        PdfTrueTypeFont titleFont = new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 20));
        PdfStringFormat centerAlignment = new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle);
        Point2D location = new Point2D.Float((float)tocPage.getCanvas().getClientSize().getWidth() / 2, (float)titleFont.measureString(title).getHeight());
        tocPage.getCanvas().drawString(title, titleFont, PdfBrushes.getCornflowerBlue(), location, centerAlignment);

        // Set the font for the titles in the table of contents
        PdfTrueTypeFont titlesFont = new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 14));

        // Generate the titles for each page in the document
        String[] titles = new String[pageCount];
        for (int i = 0; i < titles.length; i++) {
            titles[i] = String.format("This is page %1$s", i + 1);
        }

        // Set the initial y-coordinate for drawing the titles
        float y = (float)titleFont.measureString(title).getHeight() + 10;
        float x = 0;

        // Iterate through each page and add the title, page number, and action to the table of contents
        for (int i = 1; i <= pageCount; i++) {
            // Get the title for the current page
            String text = titles[i - 1];

             // Measure the dimensions (width and height) of the title text using the titlesFont font
            Dimension2D titleSize = titlesFont.measureString(text);

            // Retrieve the corresponding page in the document that corresponds to the current title
            PdfPageBase navigatedPage = doc.getPages().get(i);

            // Generate the page number as a string by adding 1 to the current index
            String pageNumText = (String.valueOf(i + 1));

            // Measure the dimensions of the page number text using the titlesFont font
            Dimension2D pageNumTextSize = titlesFont.measureString(pageNumText);

            // Draw the title text
            tocPage.getCanvas().drawString(text, titlesFont, PdfBrushes.getCadetBlue(), 0, y);

            // Calculate the location for the dots between the title and page number
            float dotLocation = (float)titleSize.getWidth() + 2 + x;
            float pageNumlocation = (float)(tocPage.getCanvas().getClientSize().getWidth() - pageNumTextSize.getWidth());

            // Draw the dots
            for (float j = dotLocation; j < pageNumlocation; j++) {
                if (dotLocation >= pageNumlocation) {
                    break;
                }
                tocPage.getCanvas().drawString(".", titlesFont, PdfBrushes.getGray(), dotLocation, y);
                dotLocation += 3;
            }

            // Draw the page number
            tocPage.getCanvas().drawString(pageNumText, titlesFont, PdfBrushes.getCadetBlue(), pageNumlocation, y);

            // Define the title bounds and destination for the action
            Rectangle2D titleBounds = new Rectangle2D.Float(0, y, (float)tocPage.getCanvas().getClientSize().getWidth(), (float)titleSize.getHeight());
            PdfDestination dest = new PdfDestination(navigatedPage, new Point2D.Float(-doc.getPageSettings().getMargins().getTop(), -doc.getPageSettings().getMargins().getLeft()));
            PdfActionAnnotation action = new PdfActionAnnotation(titleBounds, new PdfGoToAction(dest));
            action.setBorder(new PdfAnnotationBorder(0));

            // Add the action to the table of contents page
            ((PdfNewPage)((tocPage instanceof PdfNewPage) ? tocPage : null)).getAnnotations().add(action);
            y += titleSize.getHeight() + 10;
        }

        // Save the modified document to the specified output file path
        doc.saveToFile(output, FileFormat.PDF);

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
      }
}
