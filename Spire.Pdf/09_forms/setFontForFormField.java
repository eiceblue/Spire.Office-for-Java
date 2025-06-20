
import com.spire.pdf.PdfDocument;
import com.spire.pdf.graphics.PdfTrueTypeFont;
import com.spire.pdf.widget.*;
import java.awt.*;

public class setFontForFormField {
    public static void main(String[] args) throws Exception{
        // Load the PDF document
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile("data/TextBoxSample.pdf");

        // Get the form widget from the document
        PdfFormWidget formWidget = (PdfFormWidget)doc.getForm();

        // Get the text box field by its name (e.g., "Text1")
        PdfTextBoxFieldWidget textbox = (PdfTextBoxFieldWidget)formWidget.getFieldsWidget().get("Text1");

        // Specify the font properties for the text box field
        Font font = new Font("Tahoma", java.awt.Font.BOLD, 14);
        PdfTrueTypeFont trueTypeFont = new PdfTrueTypeFont(font);

        // Set the font for the text box field
        textbox.setFont(trueTypeFont);

        // Set the text value for the text box field (optional)
        textbox.setText("Test");

        String result = "output/SetFontForFormField-result.pdf";

        // Save the document with the modified font to a file
        doc.saveToFile(result);

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }

}
