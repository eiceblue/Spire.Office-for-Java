
import com.spire.pdf.PdfDocument;
import com.spire.pdf.widget.*;
import com.spire.pdf.widget.PdfTextBoxFieldWidget;

public class getFieldValue {
    public static void main(String[] args) throws Exception{
        // Load the PDF document
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile("data/TextBoxSample.pdf");

        //Get pdf forms
        PdfFormWidget formWidget = (PdfFormWidget)doc.getForm();
        
        //Get textbox
        PdfTextBoxFieldWidget textbox = (PdfTextBoxFieldWidget)formWidget.getFieldsWidget().get("Text1");
        
        //Get the text of the textbox
        String text = textbox.getText();

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }
}
