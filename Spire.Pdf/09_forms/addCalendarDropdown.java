import com.spire.pdf.*;
import com.spire.pdf.actions.*;
import com.spire.pdf.fields.PdfTextBoxField;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class addCalendarDropdown {
    public static void main(String[] args) throws Exception {
        // Create a new PdfDocument object
        PdfDocument pdf = new PdfDocument();

        // Add a page to the document
        PdfPageBase page = pdf.getPages().add(PdfPageSize.A4, new PdfMargins());

        // Set up the font for the textbox field
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial Unicode MS", Font.PLAIN, 10), true);

        // Create a textbox field
        PdfTextBoxField textbox = new PdfTextBoxField(page, "date");
        textbox.setBounds(new Rectangle2D.Float(40, 50, 60, 20));
        textbox.setFont(font);

        // Get the JavaScript code for the keystroke action with the specified date format
        String kjs = PdfJavaScript.getDateKeystrokeString("mm/dd/yyyy");

        // Get the JavaScript code for the format action with the specified date format
        String fjs = PdfJavaScript.getDateFormatString("mm/dd/yyyy");

        // Create a PdfJavaScriptAction object for the keystroke action using the JavaScript code
        PdfJavaScriptAction kjsAction = new PdfJavaScriptAction(kjs);

        // Create a PdfJavaScriptAction object for the format action using the JavaScript code
        PdfJavaScriptAction fjsAction = new PdfJavaScriptAction(fjs);

        // Set the keystroke action of the textbox field to the kjsAction
        textbox.getActions().setKeyPressed(kjsAction);

        // Set the format action of the textbox field to the fjsAction
        textbox.getActions().setFormat(fjsAction);

        // Add the textbox field to the PDF form
        pdf.getForm().getFields().add(textbox);

        // Save the modified document to a new file
        String result = "output/addCalendarDropdown_result.pdf";
        pdf.saveToFile(result);

        // Close the PDF document to release resources
        pdf.close();

        // Dispose of the PDF document to free up system resources
        pdf.dispose();
    }
}
