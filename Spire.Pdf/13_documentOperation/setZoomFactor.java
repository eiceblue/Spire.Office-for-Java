import com.spire.pdf.PdfDocument;
import com.spire.pdf.PdfPageBase;
import com.spire.pdf.actions.PdfGoToAction;
import com.spire.pdf.general.PdfDestination;
import com.spire.pdf.general.PdfDestinationMode;
import java.awt.geom.*;

public class setZoomFactor {
    public static void main(String[] args) {
        String inputFile = "data/setZoomFactor.pdf";
        String outputFile = "output/setZoomFactor_result.pdf";

        //Open a pdf document
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(inputFile);
        //Get the first page
        PdfPageBase page = doc.getPages().get(0);

        //Set pdf destination
        PdfDestination dest = new PdfDestination(page);
        dest.setMode(PdfDestinationMode.Location);
        dest.setLocation(new Point2D.Float(-40f, -40f));
        dest.setZoom(0.6f);

        //Set action
        PdfGoToAction gotoAction = new PdfGoToAction(dest);
        doc.setAfterOpenAction(gotoAction);

        //Save pdf document
        doc.saveToFile(outputFile);

    }
}
