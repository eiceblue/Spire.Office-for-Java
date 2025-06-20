import com.spire.pdf.*;
import com.spire.pdf.actions.*;
import com.spire.pdf.general.*;
import java.awt.geom.Point2D;

public class SetMagnificationToFitHeight {
    public static void main(String[] args) {
        // Specify the input and output file paths for the PDF document
        String inputFile = "data/template_Pdf_2.pdf";
        String outputFile = "output/FitHeight.pdf";

        // Create a PdfDocument object and load the PDF document from the input file
        PdfDocument myPdf = new PdfDocument();
        myPdf.loadFromFile(inputFile);

        // Retrieve the first page of the document
        PdfPageBase page = myPdf.getPages().get(0);

        // Create a destination that fits the height of the page at coordinates (40, 40)
        PdfDestination dest = new PdfDestination(page, new Point2D.Float(40f, 40f));
        dest.setMode(PdfDestinationMode.Fit_V);

        // Create a PdfGoToAction with the destination
        PdfGoToAction goToAction = new PdfGoToAction(dest);

        // Set the PdfGoToAction as the action to be performed after the document is opened
        myPdf.setAfterOpenAction(goToAction);

        // Set the viewer preferences to use outlines as the default page mode
        myPdf.getViewerPreferences().setPageMode(PdfPageMode.Use_Outlines);

        // Save the modified document to the output file
        myPdf.saveToFile(outputFile);

        // Close and dispose of system resources associated with the document
        myPdf.close();
        myPdf.dispose();
    }
}
