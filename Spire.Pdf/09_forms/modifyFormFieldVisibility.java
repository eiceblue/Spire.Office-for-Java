
import com.spire.pdf.PdfDocument;
import com.spire.pdf.annotations.PdfAnnotationFlags;
import com.spire.pdf.fields.*;
import com.spire.pdf.widget.*;

public class modifyFormFieldVisibility {
    public static void main(String[] args) throws Exception{
		// Load the PDF document
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile("data/TextBoxSample.pdf");

        // Get the form widget from the document
        PdfFormWidget formWidget = (PdfFormWidget) doc.getForm();

        // Get the first field from the fields widget
        PdfField field = formWidget.getFieldsWidget().get(0);

        // Set the visibility of the field
        // Uncomment one of the following lines based on the desired visibility option

        // Setting visibility to default
        field.setAnnotationFlags(PdfAnnotationFlags.Default);

        // Setting visibility to hidden
        // field.setAnnotationFlags(PdfAnnotationFlags.Hidden);

        String output = "output/modifyFormFieldVisibility-result.pdf";

        // Save the modified document to a file
        doc.saveToFile(output);

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }
}
