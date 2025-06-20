import com.spire.pdf.*;
import com.spire.pdf.annotations.*;

public class extractAndUpdateLink {
    public static void main(String[] args) throws Exception {
        // Set the input file path for the PDF document
        String input = "data/linkAnnotation.pdf";

        // Set the output file path for the modified PDF document
        String output = "output/extractAndUpdateLink.pdf";

        // Create a new PdfDocument object
        PdfDocument doc = new PdfDocument();

        // Load the PDF document from the input file
        doc.loadFromFile(input);

        // Get the first page of the document
        PdfPageBase page = doc.getPages().get(0);

        // Get the collection of annotations on the page
        PdfAnnotationCollection annotations = page.getAnnotationsWidget();

        // Verify if the annotation collection is not null and contains annotations
        if (annotations.getCount() > 0) {
            // Traverse through the PdfAnnotationCollection
            for (int i = 0; i < annotations.getCount(); i++) {
                // Get each annotation in the collection
                PdfAnnotation pdfAnnotation = annotations.get(i);

                // Check if it is a PdfTextWebLinkAnnotationWidget
                if (pdfAnnotation instanceof PdfTextWebLinkAnnotationWidget) {
                    // Cast the annotation to PdfTextWebLinkAnnotationWidget
                    PdfTextWebLinkAnnotationWidget annotation = (PdfTextWebLinkAnnotationWidget) pdfAnnotation;

                    // Change the URL of the link annotation
                    annotation.setUrl("https://www.e-iceblue.com/Introduce/pdf-for-java.html");
                }
            }
        }

        // Save the modified document to the specified output file path
        doc.saveToFile(output, FileFormat.PDF);

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }
}
