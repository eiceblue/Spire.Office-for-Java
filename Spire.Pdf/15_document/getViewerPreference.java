import com.spire.pdf.*;
import java.io.*;

public class getViewerPreference {
    public static void main(String[] args) throws IOException {
        // Create a new PdfDocument object
        PdfDocument doc = new PdfDocument();

        // Load the PDF document from a file
        doc.loadFromFile("data/pdfTemplate-Az.pdf");

        // Get the viewer preferences of the loaded PDF document
        PdfViewerPreferences viewer = doc.getViewerPreferences();

        // Create a StringBuilder to store the viewer preference information
        StringBuilder builder = new StringBuilder();

        // Append whether the document's window position is in the center to the StringBuilder
        builder.append("Whether the document's window position is in the center: " + "\r\n");
        builder.append("CenterWindow: " + viewer.getCenterWindow() + "\r\n");

        // Append the document displaying mode (thumbnails, full-screen, attachment panel) to the StringBuilder
        builder.append("Document displaying mode, e.g., show thumbnails, full-screen, show attachment panel: " + "\r\n");
        builder.append("PageMode: " + viewer.getPageMode().toString() + "\r\n");

        // Append the page layout (e.g., single page, one column) to the StringBuilder
        builder.append("The page layout, e.g., single page, one column: " + "\r\n");
        builder.append("PageLayout: " + viewer.getPageLayout().toString() + "\r\n");

        // Append whether the window's title bar should display the document title to the StringBuilder
        builder.append("Whether the window's title bar should display the document title: " + "\r\n");
        builder.append("DisplayTitle: " + viewer.getDisplayTitle() + "\r\n");

        // Append whether to resize the document's window to fit the size of the first displayed page to the StringBuilder
        builder.append("Whether to resize the document's window to fit the size of the first displayed page: " + "\r\n");
        builder.append("FitWindow: " + viewer.getFitWindow() + "\r\n");

        // Append whether to hide the menu bar of the viewer application to the StringBuilder
        builder.append("Whether to hide the menu bar of the viewer application: " + "\r\n");
        builder.append("HideMenubar: " + viewer.getHideMenubar() + "\r\n");

        // Append whether to hide the tool bar of the viewer application to the StringBuilder
        builder.append("Whether to hide the tool bar of the viewer application: " + "\r\n");
        builder.append("HideToolbar: " + viewer.getHideToolbar() + "\r\n");

        // Append whether to hide UI elements like scroll bars and leave only the page contents displayed to the StringBuilder
        builder.append("Whether to hide UI elements like scroll bars and leave only the page contents displayed: " + "\r\n");
        builder.append("HideWindowUI: " + viewer.getHideWindowUI());

        // Save the viewer preference information to a text file
        String output = "output/getViewerPreference.txt";
        File file = new File(output);

        // Delete the file if it already exists
        if (!file.exists()) {
            file.delete();
        }

        // Create a new file
        file.createNewFile();

        // Create FileWriter, BufferedWriter, and FileReader objects for writing to the file
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);

        // Write the content of the StringBuilder to the file
        bw.write(builder.toString());

        // Flush and close the BufferedWriter and FileWriter
        bw.flush();
        bw.close();
        fw.close();

        // Close the document
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }
}
