import com.spire.pdf.*;
import com.spire.pdf.annotations.*;

public class getWatermarkInfo {
    public static void main(String[] args) {
        // Define the input file path
        String inputFile = "data/WatermarkSample.pdf";

        // Load the PDF document from the input file
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile(inputFile);

        // Get the annotation collection of the first page
        PdfAnnotationCollection annotationWidget = pdf.getPages().get(0).getAnnotationsWidget();

        // Iterate through each annotation in the collection
        for (int i = 0; i < annotationWidget.getCount(); i++) {
            // Check if the annotation is a watermark annotation
            if (annotationWidget.get(i) instanceof PdfWatermarkAnnotationWidget) {
                // Retrieve and print the text content of the watermark annotation
                System.out.println(annotationWidget.get(i).getText());

                // Retrieve and print the horizontal translation of the watermark annotation's fixed print
                System.out.println(((PdfWatermarkAnnotationWidget) annotationWidget.get(i)).getFixedPrint().getHorizontalTranslation());

                // Retrieve and print the vertical translation of the watermark annotation's fixed print
                System.out.println(((PdfWatermarkAnnotationWidget) annotationWidget.get(i)).getFixedPrint().getVerticalTranslation());
            }
        }

        // Close the PDF document to release resources
        pdf.close();

        // Dispose of the PDF document to free up system resources
        pdf.dispose();
    }
}
