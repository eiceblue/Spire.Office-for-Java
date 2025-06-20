import com.spire.pdf.*;
import com.spire.pdf.actions.*;
import com.spire.pdf.annotations.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class addPdfLaunchAction {
    public static void main(String[] args) {
        // Set the input file path
        String input = "data/text.txt";

        // Set the output file path for the generated PDF document
        String output = "output/addPdfLaunchAction.pdf";

        // Create a new PdfDocument object
        PdfDocument doc = new PdfDocument();

        // Add a new page to the document
        PdfPageBase page = doc.getPages().add();

        // Create a launch action with the specified input file path
        PdfLaunchAction launchAction = new PdfLaunchAction(input);

        // Set the text and font for the clickable area
        String text = "Click here to open file";
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 13));

        // Define the rectangle for the clickable area
        Rectangle2D rect = new Rectangle2D.Float(50, 50, 230, 15);

        // Draw the text on the page
        page.getCanvas().drawString(text, font, PdfBrushes.getOrange(), rect);

        // Create a PdfActionAnnotation with the specified rectangle and launch action
        PdfActionAnnotation annotation = new PdfActionAnnotation(rect, launchAction);

        // Add the annotation to the page's annotations widget
        page.getAnnotationsWidget().add(annotation);

        // Save the document to the specified output file path
        doc.saveToFile(output, FileFormat.PDF);

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }
}
