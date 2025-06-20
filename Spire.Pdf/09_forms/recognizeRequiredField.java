
import com.spire.pdf.PdfDocument;
import com.spire.pdf.fields.PdfField;
import com.spire.pdf.widget.PdfFormWidget;
import java.io.*;

public class recognizeRequiredField {
    public static void main(String[] args) throws Exception{
		// Load the PDF document
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile("data/RadioButtonSample.pdf");

        // Create a StringBuilder to store the recognized required fields
        StringBuilder sb = new StringBuilder();

        // Get the form widget from the document
        PdfFormWidget formWidget = (PdfFormWidget) doc.getForm();

        // Iterate through each field in the form widget
        for (int i = 0; i < formWidget.getFieldsWidget().getList().size(); i++) {
            PdfField field = (PdfField) formWidget.getFieldsWidget().getList().get(i);

            // Check if the field is required
            if (field.getRequired()) {
                sb.append("The field named: " + field.getName() + " is required\r\n");
            }
        }

        String output = "output/recognizeRequiredField-result.txt";

        // Write the recognized required fields to a text file
        writeStringToTxt(sb.toString(), output);

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();

    }
	
    // Writes a string to a text file.
    public static void writeStringToTxt(String content, String txtFileName) throws IOException {
        FileWriter fWriter = new FileWriter(txtFileName, true);
        try {
            // Write the content to the file
            fWriter.write(content);
        } catch (IOException ex) {
            // An error occurred while writing to the file
            ex.printStackTrace();
        } finally {
            try {
                // Flush and close the FileWriter
                fWriter.flush();
                fWriter.close();
            } catch (IOException ex) {
                // An error occurred while flushing or closing the FileWriter
                ex.printStackTrace();
            }
        }
    }

}
