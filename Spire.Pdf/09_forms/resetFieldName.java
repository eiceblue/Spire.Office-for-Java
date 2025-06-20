import com.spire.pdf.*;
import com.spire.pdf.fields.PdfField;
import com.spire.pdf.widget.PdfFieldWidget;
import com.spire.pdf.widget.PdfFormWidget;

public class resetFieldName {
    public static void main(String[] args) {
        // Create a new PdfDocument object to work with PDF files
        PdfDocument document = new PdfDocument();

        // Load the PDF file from the specified path
        document.loadFromFile("data\\resetFieldName.pdf");

        // Get the form widget from the loaded document
        PdfFormWidget formWidget = (PdfFormWidget)document.getForm();

        // Iterate over each field widget in the form
        for (PdfFieldWidget widget : (Iterable<? extends PdfFieldWidget>) formWidget.getFieldsWidget())
        {
            // Check if the field name is "TextBox"
            if (widget.getName().equals("TextBox"))
            {
                // Change the field name to "NewTextBox"
                widget.setName("NewTextBox");
            }
        }

        // Save the modified document to a new file named "result-2.pdf" in PDF format
        document.saveToFile("result-2.pdf", FileFormat.PDF);

        // Dispose of system resources associated with the PdfDocument object
        document.dispose();
    }
}
