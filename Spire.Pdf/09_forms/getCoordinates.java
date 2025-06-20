
import com.spire.pdf.PdfDocument;
import com.spire.pdf.widget.*;

import java.awt.geom.Point2D;


public class getCoordinates {
    public static void main(String[] args) throws Exception{
        // Load the PDF document
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile("data/TextBoxSample.pdf");

        // Get the form widget from the document
        PdfFormWidget formWidget = (PdfFormWidget) doc.getForm();

        // Get the text box field widget by its name
        PdfTextBoxFieldWidget textbox = (PdfTextBoxFieldWidget) formWidget.getFieldsWidget().get("Text1");

        // Get the location of the text box field on the page
        Point2D location = textbox.getLocation();

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();

    }

}
