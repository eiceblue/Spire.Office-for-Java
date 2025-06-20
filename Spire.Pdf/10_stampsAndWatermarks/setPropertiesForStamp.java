import com.spire.pdf.*;
import com.spire.pdf.annotations.*;

import java.util.Date;

public class setPropertiesForStamp {
    public static void main(String[] args) {
        // Create a new PdfDocument object
        PdfDocument pdf = new PdfDocument();

        // Load an existing PDF document from the specified file path
        pdf.loadFromFile("data/stampSample.pdf");

        // Get the first page of the loaded PDF document
        PdfPageBase page = pdf.getPages().get(0);

        // Iterate through each annotation in the page's annotations widget collection
        for (PdfAnnotation annotation : (Iterable<PdfAnnotation>) page.getAnnotationsWidget().getList()) {
            // Check if the annotation is a PdfRubberStampAnnotationWidget
            if (annotation instanceof PdfRubberStampAnnotationWidget) {
                // Cast the annotation to PdfRubberStampAnnotationWidget
                PdfRubberStampAnnotationWidget stamp = (PdfRubberStampAnnotationWidget) annotation;

                // Set the author, subject, creation date, and modified date properties of the rubber stamp annotation
                stamp.setAuthor("Support");
                stamp.setSubject("E-iceblue");
                stamp.setCreationDate(new Date());
                stamp.setModifiedDate(new Date());
            }
        }

        // Specify the output file path for the modified PDF document
        String result = "output/setPropertiesForStamp_out.pdf";

        // Save the modified PDF document to the specified file path in PDF format
        pdf.saveToFile(result, FileFormat.PDF);

        // Close the PDF document to release resources
        pdf.close();

        // Dispose of the PDF document to free up system resources
        pdf.dispose();
    }
}
