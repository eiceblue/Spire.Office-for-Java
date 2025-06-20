import com.spire.pdf.*;
import com.spire.pdf.annotations.*;

public class modifyLineAnnotation {
    public static void main(String[] args) {
        // Create a new PdfDocument object
        PdfDocument document = new PdfDocument();

        // Load the existing PDF document from the specified file path
        document.loadFromFile("data/PdfLineAnnotation.pdf");

        // Get the first annotation from the first page of the PDF document
        PdfAnnotation pdfAnnotation = document.getPages().get(0).getAnnotationsWidget().get(0);

        // Check if the annotation is an instance of PdfLineAnnotationWidget
        if (pdfAnnotation instanceof PdfLineAnnotationWidget) {
            // Cast the annotation to PdfLineAnnotationWidget
            PdfLineAnnotationWidget lineAnn = (PdfLineAnnotationWidget) pdfAnnotation;

            // Modify the author of the line annotation
            lineAnn.setAuthor("Author_test");

            // Modify the subject of the line annotation
            lineAnn.setSubject("Subject_test");
        }

        // Specify the file path to save the modified document
        String result = "output/ModifyLineAnnotation.pdf";

        // Save the modified PDF document to the specified file path
        document.saveToFile(result);

        // Close the PDF document
        document.close();

        // Dispose of the PDF document to free up system resources
        document.dispose();
    }
}
