import com.spire.pdf.*;
public class deleteAllAnnotations {
    public static void main(String[] args) {
		//Create a new PDF document.
        PdfDocument document = new PdfDocument();

        //Load the file from disk
        document.loadFromFile("data/annotations.pdf");

        //Remove all annotations
        document.getPages().get(0).getAnnotationsWidget().clear();

        String result = "output/deleteAllAnnotations_out.pdf";

        //Save the document
        document.saveToFile(result);

        // Close the PDF document
        document.close();

        // Dispose of the PDF document (frees up system resources)
        document.dispose();
    }
}
