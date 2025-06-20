import com.spire.pdf.*;
import com.spire.pdf.actions.*;
import com.spire.pdf.annotations.PdfActionAnnotation;
import com.spire.pdf.texts.*;
import java.awt.geom.Rectangle2D;
import java.util.EnumSet;
import java.util.List;

public class launchFileInNewWindow {
    public static void main(String[] args) {
        String inputFile1 = "data/documentsLinks.pdf";
        String inputFile2 = "data/sample.pdf";
        String outputFile = "output/launchFileInNewWindow.pdf";

        // Create a new instance of PdfDocument
        PdfDocument pdf = new PdfDocument();

        // Load the first input PDF file
        pdf.loadFromFile(inputFile1);

        // Create instances for PdfTextFinder and PdfTextFragment
        PdfTextFinder finder = null;
        List<PdfTextFragment> finds = null;

        // Define the target text to search
        String test = "Spire.PDF";

        // Set the find options for text search
        PdfTextFindOptions findOptions = new PdfTextFindOptions();
        findOptions.setTextFindParameter(EnumSet.of(TextFindParameter.None));

        // Iterate through each page of the PDF document
        for (PdfPageBase page : (Iterable<PdfPageBase>) pdf.getPages()) {
            // Instantiate PdfTextFinder with the current page
            finder = new PdfTextFinder(page);

            // Find the occurrences of the target text on the page using the specified find options
            finds = finder.find(test, findOptions);

            // Iterate through each found text fragment
            for (PdfTextFragment find : finds) {
                // Create a launch action to open the second input PDF file in a new window
                PdfLaunchAction launchAction = new PdfLaunchAction(inputFile2, PdfFilePathType.Absolute);
                launchAction.isNewWindow(true);

                // Create a rectangle based on the position and size of the found text fragment
                Rectangle2D rect = new Rectangle2D.Double(
                        find.getPositions()[0].getX(),
                        find.getPositions()[0].getY(),
                        find.getSizes()[0].getWidth(),
                        find.getSizes()[0].getHeight()
                );

                // Create a PdfActionAnnotation with the launch action and the rectangle
                PdfActionAnnotation annotation = new PdfActionAnnotation(rect, launchAction);

                // Add the annotation to the page's annotation widget collection
                page.getAnnotationsWidget().add(annotation);
            }
        }

        // Save the modified PDF document to the specified output file in PDF format
        pdf.saveToFile(outputFile, FileFormat.PDF);

        // Close the PDF document to release resources
        pdf.close();

        // Dispose of the PDF document to free up system resources
        pdf.dispose();
    }
}
