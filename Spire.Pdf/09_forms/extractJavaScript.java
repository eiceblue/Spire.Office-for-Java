import com.spire.pdf.PdfDocument;
import com.spire.pdf.actions.PdfJavaScriptAction;
import com.spire.pdf.fields.PdfField;
import com.spire.pdf.widget.*;
import java.io.FileWriter;

public class extractJavaScript {
    public static void main(String[] args) throws Exception{
    // Specify the input PDF file path and output text file path
        String inputFile = "data/extractJavaScript.pdf";
        String outputFile = "output/extractJavaScript.txt";

        // Load the PDF document
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(inputFile);

        // Variable to store the extracted JavaScript code
        String js = null;

        // Get the form widget from the document
        PdfFormWidget form = (PdfFormWidget) ((doc.getForm() instanceof PdfFormWidget) ? doc.getForm() : null);

        // Iterate through each field in the form
        for (int i = 0; i < form.getFieldsWidget().getList().size(); i++) {
            // Get the current field
            PdfField field = (PdfField) ((form.getFieldsWidget().getList().get(i) instanceof PdfField) ? form.getFieldsWidget().getList().get(i) : null);

            // Check if the field is a text box field
            if (field instanceof PdfTextBoxFieldWidget) {
                // Cast the field to a text box field
                PdfTextBoxFieldWidget textbox = (PdfTextBoxFieldWidget) ((field instanceof PdfTextBoxFieldWidget) ? field : null);

                // Find the text box named "total"
                if (textbox.getName().equals("total")) {
                    // Get the calculate action of the text box field
                    PdfJavaScriptAction jsa = textbox.getActions().getCalculate();

                    if (jsa != null) {
                        // Get the JavaScript code
                        js = jsa.getScript();
                    }
                }
            }
        }

        // Write the extracted JavaScript code to the output file
        FileWriter writer = new FileWriter(outputFile);
        writer.write(js);
        writer.flush();
        writer.close();

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }
}
