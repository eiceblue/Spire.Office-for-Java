import com.spire.pdf.*;
import com.spire.pdf.actions.*;

public class getZoomFactor {
    public static void main(String[] args) {
        // Create a new PdfDocument object
        PdfDocument doc = new PdfDocument();

        // Load the PDF document from a file
        doc.loadFromFile("data/getZoomFactor.pdf");

        // Get the 'After Open' action of the document
        PdfGoToAction action = (PdfGoToAction) doc.getAfterOpenAction();

        // Get the zoom value from the destination of the action
        float zoomValue = action.getDestination().getZoom();

        // Print the zoom factor of the document
        System.out.println("The zoom factor of the document is " + zoomValue * 100 + "%.");

        // Close the document
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();

    }
}
