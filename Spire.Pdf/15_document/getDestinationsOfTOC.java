import com.spire.pdf.*;
import com.spire.pdf.annotations.*;
import com.spire.pdf.general.*;

public class getDestinationsOfTOC {
    public static void main(String[] args) {
        // Load the PDF document
        PdfDocument pdf = new PdfDocument("data/template_TOC.pdf");

        // Get the first page of the document
        PdfPageBase page = pdf.getPages().get(0);

        // Get the collection of annotations on the page
        PdfAnnotationCollection annotations = page.getAnnotationsWidget();

        // Iterate through the annotations and extract information about document link annotations
        for (int i = 0; i < annotations.getCount(); i++) {
            if (annotations.get(i) instanceof PdfDocumentLinkAnnotationWidget) {
                PdfDocumentLinkAnnotationWidget link = (PdfDocumentLinkAnnotationWidget) annotations.get(i);
                PdfDestination destination = link.getDestination();
                System.out.println("Page Index: " + destination.getPageNumber());
                System.out.println("Location: (" + destination.getLocation().getX() + ", " + destination.getLocation().getY() + ")");
            }
        }

        // Close the document
        pdf.close();

        // Dispose of the PDF document to free up system resources
        pdf.dispose();
    }
}
