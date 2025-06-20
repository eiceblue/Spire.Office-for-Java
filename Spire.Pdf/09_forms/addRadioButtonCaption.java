
import com.spire.pdf.*;
import com.spire.pdf.fields.PdfField;
import com.spire.pdf.graphics.*;
import com.spire.pdf.widget.*;
import java.awt.*;

public class addRadioButtonCaption {
    public static void main(String[] args) throws Exception{
        // Create a new PdfDocument object
        PdfDocument doc = new PdfDocument();

        // Load an existing PDF document from file
        doc.loadFromFile("data/RadioButtonSample.pdf");

        // Get the document's form widget
        PdfFormWidget formWidget = (PdfFormWidget) doc.getForm();

        // Iterate through the list of form fields
        for (int i = 0; i < formWidget.getFieldsWidget().getList().size(); i++) {
            // Get the i-th form field
            PdfField field = (PdfField) formWidget.getFieldsWidget().getList().get(i);

            // Check if the form field is a radio button list field
            if (field instanceof PdfRadioButtonListFieldWidget) {
                PdfRadioButtonListFieldWidget radioButton = (PdfRadioButtonListFieldWidget) field;

                // Check if the radio button field has the name "RadioButton"
                if (radioButton.getName().equals("RadioButton")) {
                    // Get the page associated with the radio button field
                    PdfPageBase page = radioButton.getPage();

                    // Define the caption text for the radio button
                    String text = "Radio button caption";

                    // Specify the font for the caption text
                    PdfFont font = new PdfFont(PdfFontFamily.Helvetica, 12f);

                    // Set the pen color and width for drawing the caption
                    PdfPen pen = new PdfPen(new PdfRGBColor(Color.red), 0.02f);

                    // Set the brush color for filling the caption background
                    PdfSolidBrush brush = new PdfSolidBrush(new PdfRGBColor(Color.red));

                    // Calculate the coordinates for drawing the caption above the radio button
                    float x = (float) radioButton.getLocation().getX();
                    float y = (float) radioButton.getLocation().getY() - (float) font.measureString(text).getHeight() - 10;

                    // Draw the caption text on the page's canvas
                    page.getCanvas().drawString(text, font, pen, brush, x, y);
                }
            }
        }

        // Specify the output file path
        String output = "output/addRadioButtonCaption-result.pdf";

        // Save the modified document to the output file
        doc.saveToFile(output);

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }

}
