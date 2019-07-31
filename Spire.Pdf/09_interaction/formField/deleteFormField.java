import com.spire.pdf.PdfDocument;
import com.spire.pdf.fields.PdfField;
import com.spire.pdf.widget.*;


public class deleteFormField {
    public static void main(String[] args) {
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile("data/deleteFormField.pdf");

        com.spire.pdf.fields.PdfForm tempVar = doc.getForm();
        PdfFormWidget formWidget = (PdfFormWidget) ((tempVar instanceof PdfFormWidget) ? tempVar : null);

        //Find the particular form field and delete it
        for (int i = 0; i < formWidget.getFieldsWidget().getList().size(); i++) {
            PdfField field = (PdfField) ((formWidget.getFieldsWidget().getList().get(i) instanceof PdfField) ? formWidget.getFieldsWidget().getList().get(i) : null);

            if (field instanceof PdfTextBoxFieldWidget) {
                PdfTextBoxFieldWidget textbox = (PdfTextBoxFieldWidget) ((field instanceof PdfTextBoxFieldWidget) ? field : null);
                if (textbox.getName().equals("password2")) {
                    formWidget.getFieldsWidget().remove(textbox);
                }
            }
        }

        doc.saveToFile("output/deleteFormField.pdf");
        doc.close();
    }
}
