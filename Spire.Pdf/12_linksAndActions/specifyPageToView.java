import com.spire.pdf.*;
import com.spire.pdf.actions.PdfGoToAction;
import com.spire.pdf.general.PdfDestination;
import java.awt.geom.Point2D;

public class specifyPageToView {
    public static void main(String[] args) {
        // Specify the file paths for the input and output PDF files.
        String input = "data/specifyPageToView.pdf";
        String output = "output/specifyPageToView_out.pdf";

        // Create a new instance of the PdfDocument class.
        PdfDocument doc = new PdfDocument();

        // Load the PDF document from the input file path.
        doc.loadFromFile(input);

        // Specify the destination page and its view settings for the "AfterOpenAction".
        PdfDestination dest = new PdfDestination(2, new Point2D.Float(0, 100), 0.5f);

        // Create a PdfGoToAction based on the destination.
        PdfGoToAction action = new PdfGoToAction(dest);

        // Set the "AfterOpenAction" property of the document object to the created action.
        doc.setAfterOpenAction(action);

        // Save the modified PDF document to the specified output file path.
        doc.saveToFile(output, FileFormat.PDF);

        // Close the PDF document to release resources.
        doc.close();

        // Dispose of the PDF document to free up system resources.
        doc.dispose();
    }
}
