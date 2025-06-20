import com.spire.pdf.*;

public class viewerPreference {
    public static void main(String[] args) {
        //Load pdf document
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile("data/viewerPreference.pdf");

        //Set view reference
        doc.getViewerPreferences().setCenterWindow(true);
        doc.getViewerPreferences().setDisplayTitle(false);
        doc.getViewerPreferences().setFitWindow(false);
        doc.getViewerPreferences().setHideMenubar(true);
        doc.getViewerPreferences().setHideToolbar(true);
        doc.getViewerPreferences().setPageLayout(PdfPageLayout.Single_Page);

        //Save pdf file
        String output = "output/viewerPreference.pdf";
        doc.saveToFile(output, FileFormat.PDF);
        doc.close();
    }
}
