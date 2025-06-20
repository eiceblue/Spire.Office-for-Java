import com.spire.pdf.*;
import com.spire.pdf.annotations.*;

public class removeHyperlinks {
    public static void main(String[] args) {
        // Input file path
        String input = "data/removeHyperlinks.pdf";

        // Output file path
        String output = "output/removeHyperlinks_out.pdf";

        // Create a new PdfDocument object
        PdfDocument document = new PdfDocument();

        // Load the PDF document from the input file
        document.loadFromFile(input);

        // Get the first page of the document
        PdfPageBase page = document.getPages().get(0);

        // Get the collection of annotations (widgets) on the page
        PdfAnnotationCollection widgetCollection = page.getAnnotationsWidget();

        // Check if there are any annotations on the page
        if (widgetCollection.getCount() > 0) {
            // Iterate through the annotations in reverse order
            for (int i = widgetCollection.getCount() - 1; i >= 0; i--) {
                // Get the current annotation
                PdfAnnotation annotation = widgetCollection.get(i);

                // Check if the annotation is a text web link
                if (annotation instanceof PdfTextWebLinkAnnotationWidget) {
                    // Cast the annotation to a text web link annotation
                    PdfTextWebLinkAnnotationWidget link = (PdfTextWebLinkAnnotationWidget) annotation;

                    // Remove the text web link annotation from the collection
                    widgetCollection.remove(link);
                }
            }
        }

        // Save the modified document to the output file
        document.saveToFile(output, FileFormat.PDF);

        // Close the PDF document to release resources
        document.close();

        // Dispose of the PDF document to free up system resources
        document.dispose();
    }
}
