import com.spire.pdf.*;
import com.spire.pdf.actions.*;
import com.spire.pdf.general.*;
import java.awt.geom.*;

public class setZoomFactor {
    public static void main(String[] args) {
        // Create a PdfDocument object and load the PDF document from the file "data/setZoomFactor.pdf"
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile("data/setZoomFactor.pdf");

        // Retrieve the first page of the document
        PdfPageBase page = doc.getPages().get(0);

        // Create a destination that specifies a location at (-40, -40) with a zoom factor of 0.6
        PdfDestination dest = new PdfDestination(page);
        dest.setMode(PdfDestinationMode.Location);
        dest.setLocation(new Point2D.Float(-40f, -40f));
        dest.setZoom(0.6f);

        // Create a PdfGoToAction with the destination
        PdfGoToAction gotoAction = new PdfGoToAction(dest);

        // Set the PdfGoToAction as the action to be performed after the document is opened
        doc.setAfterOpenAction(gotoAction);

        // Specify the output file path for the modified PDF document
        String output = "output/setZoomFactor.pdf";

        // Save the modified document to a new PDF file
        doc.saveToFile(output);

        // Close and dispose of system resources associated with the document
        doc.close();
        doc.dispose();
    }
}
