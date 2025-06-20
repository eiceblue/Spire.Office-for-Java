import com.spire.pdf.*;
import com.spire.pdf.graphics.PdfImage;

public class replaceImageSecondApproach {
    public static void main(String[] args) {
        //Create a pdf document
        PdfDocument doc = new PdfDocument();

        //Load file from disk.
        doc.loadFromFile("data/ReplaceImage.pdf");

        //Get the first page.
        PdfPageBase page = doc.getPages().get(0);

        //Load a image
        PdfImage image = PdfImage.fromFile("data/E-iceblueLogo.png");

        //Replace the first image on the page.
        page.replaceImage(0, image);

        String result = "output/replaceImageSecondApproach.pdf";

        //Save the document
        doc.saveToFile(result, FileFormat.PDF);

        // Close the PDF document
        doc.close();

        // Dispose of the PDF document (frees up system resources)
        doc.dispose();
    }
}
