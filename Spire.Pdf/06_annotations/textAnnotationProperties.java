import com.spire.pdf.*;
import com.spire.pdf.annotations.*;
import java.awt.geom.Rectangle2D;

public class textAnnotationProperties {
    public static void main(String[] args)throws Exception {
 // Specify the input and output file paths.
        String input = "data/FreeTextAnnotation.pdf";
        String output = "output/textAnnotationProperties.pdf";

        // Load the input PDF document.
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile(input);

        // Get the first page of the input document.
        PdfPageBase firstPage = pdf.getPages().get(0);

        // Create a new PDF document to store the copied text annotations.
        PdfDocument newPdf = new PdfDocument();

        // Iterate through the annotations on the first page.
        for (int i = 0; i < firstPage.getAnnotationsWidget().getList().size(); i++) {
            // Get the current annotation.
            PdfAnnotation annotation = firstPage.getAnnotationsWidget().get(i);

            // Check if the annotation is a free text annotation.
            if (annotation instanceof PdfFreeTextAnnotationWidget) {
                // Cast the annotation to a free text annotation widget.
                PdfFreeTextAnnotationWidget textAnnotation = (PdfFreeTextAnnotationWidget) annotation;

                // Retrieve the bounds (rectangle) and text content of the annotation.
                Rectangle2D rect = textAnnotation.getBounds();
                String text = textAnnotation.getText();

                // Create a new page in the new PDF document with the same size as the first page.
                PdfPageBase newPage = newPdf.getPages().add(firstPage.getSize());

                // Create a new free text annotation in the new document and set its properties.
                PdfFreeTextAnnotation newAnnotation = new PdfFreeTextAnnotation(rect);
                newAnnotation.setText(text);
                newAnnotation.setCalloutLines(textAnnotation.getCalloutLines());
                newAnnotation.setLineEndingStyle(textAnnotation.getLineEndingStyle());
                newAnnotation.setRectangleDifferences(textAnnotation.getRectangularDifferenceArray());
                newAnnotation.setColor(textAnnotation.getColor());

                // Add the new annotation to the page's widget annotations in the new document.
                newPage.getAnnotationsWidget().add(newAnnotation);
            }
        }

        // Save the new PDF document with the copied text annotations to the output file.
        newPdf.saveToFile(output, FileFormat.PDF);

        // Close and dispose of the input and new PDF documents.
        pdf.close();
        pdf.dispose();
        newPdf.close();
        newPdf.dispose();
    }
}
