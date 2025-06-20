import com.spire.pdf.PdfDocument;
import com.spire.pdf.fields.*;
import java.awt.geom.Rectangle2D;


public class addCheckBox {
    public static void main(String[] args) throws Exception{
        // Create a new PdfDocument object
        PdfDocument doc = new PdfDocument();

        // Load an existing PDF document
        doc.loadFromFile("data/addLayer.pdf");

        // Enable form creation on the document
        doc.setAllowCreateForm(true);

        // Create a checkbox field on the first page of the document
        PdfCheckBoxField checkboxField = new PdfCheckBoxField(doc.getPages().get(0), "fieldID");

        // Set the position and dimensions of the checkbox field
        float checkboxWidth = 40;
        float checkboxHeight = 40;
        checkboxField.setBounds(new Rectangle2D.Float(80, 350, checkboxWidth, checkboxHeight));

        // Customize the appearance and behavior of the checkbox field
        checkboxField.setBorderWidth(0.75f);
        checkboxField.setChecked(true);
        checkboxField.setStyle(PdfCheckBoxStyle.Check);
        checkboxField.setRequired(true);

        // Add the checkbox field to the PDF form
        doc.getForm().getFields().add(checkboxField);

        // Save the modified document to a new file
        String result = "output/AddCheckBox-result.pdf";
        doc.saveToFile(result);

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }

}
