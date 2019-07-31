import com.spire.pdf.*;

public class viewerPreference {
    public static void main(String[] args) {
        String inputFile = "data/viewerPreference.pdf";
        String outputFile = "output/viewerPreference_result.pdf";

        //Load pdf document.
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(inputFile);

        //set view reference
        doc.getViewerPreferences().setCenterWindow(true);
        doc.getViewerPreferences().setDisplayTitle(false);
        doc.getViewerPreferences().setFitWindow(false);
        doc.getViewerPreferences().setHideMenubar(true);
        doc.getViewerPreferences().setHideToolbar(true);
        doc.getViewerPreferences().setPageLayout(PdfPageLayout.Single_Page);

        //Save pdf file.
        doc.saveToFile(outputFile);
        doc.close();

    }
}
