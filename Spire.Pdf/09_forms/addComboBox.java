
import com.spire.pdf.PdfDocument;
import com.spire.pdf.fields.*;
import com.spire.pdf.graphics.*;
import java.awt.geom.Rectangle2D;
import java.util.EnumSet;


public class addComboBox {
    public static void main(String[] args) throws Exception{
		// Create a new PdfDocument object
        PdfDocument doc = new PdfDocument();

        // Load an existing PDF document
        doc.loadFromFile("data/addLayer.pdf");

        // Enable form creation on the document
        doc.setAllowCreateForm(true);

        // Create a font for the combobox field
        PdfFont font = new PdfFont(PdfFontFamily.Times_Roman, 12f, EnumSet.of(PdfFontStyle.Regular));

        // Create a combobox field on the first page of the document
        PdfComboBoxField comboBoxField = new PdfComboBoxField(doc.getPages().get(0), "Combox1");

        // Set the position and dimensions of the combobox field
        comboBoxField.setBounds(new Rectangle2D.Float(80, 350, 70, 30));

        // Customize the appearance and behavior of the combobox field
        comboBoxField.setBorderWidth(0.75f);
        comboBoxField.setFont(font);
        comboBoxField.setRequired(true);

        // Add items to the combobox field
        comboBoxField.getItems().add(new PdfListFieldItem("Apple", "item1"));
        comboBoxField.getItems().add(new PdfListFieldItem("Banana", "item2"));
        comboBoxField.getItems().add(new PdfListFieldItem("Pear", "item3"));
        comboBoxField.getItems().add(new PdfListFieldItem("Peach", "item4"));
        comboBoxField.getItems().add(new PdfListFieldItem("Grape", "item5"));

        // Add the combobox field to the PDF form
        doc.getForm().getFields().add(comboBoxField);

        // Save the modified document to a new file
        String output = "output/AddComboBox-result.pdf";
        doc.saveToFile(output);

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();

    }

}
