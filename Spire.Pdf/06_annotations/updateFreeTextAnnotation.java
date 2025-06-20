import com.spire.pdf.*;
import com.spire.pdf.annotations.*;
import com.spire.pdf.graphics.*;
import java.awt.*;

public class updateFreeTextAnnotation {

	public static void main(String[] args) {
		// Create a new PDF document and load an existing document.
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile("data/UpdateFreeTextAnnotation.pdf");

        // Get the collection of annotations from the first page.
        PdfAnnotationCollection annotations = pdf.getPages().get(0).getAnnotationsWidget();

        // Iterate through the annotations.
        for (int i = 0; i < annotations.getCount(); i++) {
            // Check if the current annotation is a free text annotation.
            if (annotations.get(i) instanceof PdfFreeTextAnnotationWidget) {
                // Cast the annotation to a free text annotation widget.
                PdfFreeTextAnnotationWidget annotation = (PdfFreeTextAnnotationWidget) annotations.get(i);

                // Update the color property of the free text annotation to orange.
                annotation.setColor(new PdfRGBColor(Color.orange));
            }
        }

        // Specify the output file path.
        String result = "output/updateFreeTextAnnotation_out.pdf";

        // Save the modified document to the output file.
        pdf.saveToFile(result);

        // Close the PDF document.
        pdf.close();

        // Dispose of the PDF document to free up system resources.
        pdf.dispose();
	}

}
