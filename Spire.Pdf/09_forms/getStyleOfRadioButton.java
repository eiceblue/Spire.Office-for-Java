import com.spire.pdf.*;
import com.spire.pdf.fields.*;
import com.spire.pdf.widget.*;
import java.io.*;

public class getStyleOfRadioButton {
    public static void main(String[] args) throws IOException {
		// Specify the input PDF file path and the result file path
        String input = "data/radioButtonField.pdf";
        String result = "output/getStyleOfRadioButton_out.txt";

        // Load the PDF document
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile(input);

        // Get the first page of the document
        PdfPageBase page = pdf.getPages().get(0);

        // Get the form widget from the document
        PdfFormWidget formWidget = (PdfFormWidget) pdf.getForm();

        // Create a FileWriter and BufferedWriter for the result file
        FileWriter fw = new FileWriter(result, true);
        BufferedWriter bw = new BufferedWriter(fw);

        int num = 0;

        // Iterate through each field in the form widget
        for (int i = 0; i < formWidget.getFieldsWidget().getList().size(); i++) {
            PdfField field = (PdfField) formWidget.getFieldsWidget().getList().get(i);

            // Check if the field is a radio button list field
            if (field instanceof PdfRadioButtonListFieldWidget) {
                num++;
                PdfRadioButtonListFieldWidget radio = (PdfRadioButtonListFieldWidget) field;
                PdfCheckBoxStyle buttonStyle = radio.getButtonStyle();
                bw.write(String.format("The button style of Radio button %d is: %s", num, buttonStyle.toString()));
                bw.newLine();
            }
        }

        // Flush and close the BufferedWriter and FileWriter
        bw.flush();
        bw.close();
        fw.close();

        // Close the PDF document to release resources
        pdf.close();

        // Dispose of the PDF document to free up system resources
        pdf.dispose();
    }
}
