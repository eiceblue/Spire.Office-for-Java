
import com.spire.pdf.*;
import com.spire.pdf.widget.*;
import java.util.List;

public class fillXFAFields {
    public static void main(String[] args) throws Exception {
		// Load the PDF document with XFA content
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile("data/DynamicXFA.pdf");

        // Get the form widget from the document
        PdfFormWidget form = (PdfFormWidget) doc.getForm();

        // Get a list of XFA fields in the form
        List<XfaField> xfafields = form.getXFAForm().getXfaFields();

        // Iterate through each XFA field
        for (int i = 0; i < xfafields.size(); i++) {
            XfaField xf = xfafields.get(i);
            // Check if the XFA field is a text field
            if (xf instanceof XfaTextField) {
                XfaTextField xtf = (XfaTextField) xf;
                // Check the name of the text field and set its value accordingly
                if (xtf.getName().equals("EmployeeName")) {
                    xtf.setValue("Gary");
                }
                if (xtf.getName().equals("Address")) {
                    xtf.setValue("Chengdu, China");
                }
                if (xtf.getName().equals("StateProv")) {
                    xtf.setValue("Sichuan Province");
                }
            }
        }

        // Save the modified PDF document with filled XFA fields
        doc.saveToFile("output/fillXFAFields.pdf");

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }
}