import com.spire.pdf.PdfDocument;
import com.spire.pdf.fields.PdfField;
import com.spire.pdf.widget.*;

public class determineRequiredField {
    public static void main(String[] args) {
        String inputFile = "data/determineRequiredField.pdf";
        String outputFile = "output/determineRequiredField.pdf";
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(inputFile);

        com.spire.pdf.fields.PdfForm tempVar = doc.getForm();
        PdfFormWidget formWidget = (PdfFormWidget) ((tempVar instanceof PdfFormWidget) ? tempVar : null);

        //Find the particular form field and determine if it marks as required or not
        for (int i = 0; i < formWidget.getFieldsWidget().getList().size(); i++) {
            PdfField field = (PdfField) ((formWidget.getFieldsWidget().getList().get(i) instanceof PdfField) ? formWidget.getFieldsWidget().getList().get(i) : null);

            if (field instanceof PdfTextBoxFieldWidget) {
                PdfTextBoxFieldWidget textbox = (PdfTextBoxFieldWidget) ((field instanceof PdfTextBoxFieldWidget) ? field : null);
                if (textbox.getName().equals("username")) {
                    textbox.setRequired(true);
                }
                if (textbox.getName().equals("password2")) {
                    textbox.setRequired(false);
                }
            }
        }

        doc.saveToFile(outputFile);
        doc.close();
    }
}
