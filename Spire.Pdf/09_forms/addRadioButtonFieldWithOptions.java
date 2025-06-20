

import com.spire.pdf.*;
import com.spire.pdf.fields.*;
import com.spire.pdf.graphics.*;
import java.awt.geom.Rectangle2D;
import java.util.EnumSet;


public class addRadioButtonFieldWithOptions {
    public static void main(String[] args) throws Exception{
        // Create a new PDF document
        PdfDocument doc = new PdfDocument();

        // Load an existing PDF document from file
        doc.loadFromFile("data/addLayer.pdf");

        // Enable form creation in the document
        doc.setAllowCreateForm(true);

        // Get the first page of the document
        PdfPageBase page = doc.getPages().get(0);

        // Define the font for the radio button options
        PdfFont font = new PdfFont(PdfFontFamily.Times_Roman, 12f, EnumSet.of(PdfFontStyle.Regular));

        // Define the brush color for the text
        PdfBrush brush = PdfBrushes.getBlack();

        // Set the initial position of the radio buttons
        float x = 80;
        float y = 350;

        // Temporary variable to store the updated x-coordinate
        float tempX = 0;

        // Create a new radio button field
        PdfRadioButtonListField radioButton = new PdfRadioButtonListField(page, "RadioButton");
        radioButton.setRequired(true);

        // Add three radio button options to the field
        for (int i = 0; i < 3; i++) {
            // Create a new radio button option
            PdfRadioButtonListItem fieldItem = new PdfRadioButtonListItem();

            // Set the border width for the option
            fieldItem.setBorderWidth(0.75f);

            // Set the bounds (position and size) of the option
            fieldItem.setBounds(new Rectangle2D.Float(x, y, 15, 15));

            // Add the option to the radio button field
            radioButton.getItems().add(fieldItem);

            // Update the x-coordinate for the text position
            tempX = x + 20;

            // Draw the option label text on the page
            page.getCanvas().drawString("Item" + i, font, brush, tempX, y);

            // Update the x-coordinate for the next radio button position
            x = tempX + 100;
        }

        // Add the radio button field to the document's form fields collection
        doc.getForm().getFields().add(radioButton);

        // Specify the output file path
        String output = "output/addRadioButtonFieldWithOptions-result.pdf";

        // Save the modified PDF document to file
        doc.saveToFile(output);

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }

}
