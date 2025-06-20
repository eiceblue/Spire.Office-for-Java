
import com.spire.pdf.*;
import com.spire.pdf.fields.*;
import com.spire.pdf.graphics.*;

import java.awt.geom.Rectangle2D;
import java.util.EnumSet;


public class addRadioButtonField {
    public static void main(String[] args) throws Exception{
         // Create a new PdfDocument object
        PdfDocument doc = new PdfDocument();

        // Load an existing PDF document from file
        doc.loadFromFile("data/addLayer.pdf");

        // Enable creating form fields
        doc.setAllowCreateForm(true);

        // Get the first page of the document
        PdfPageBase page = doc.getPages().get(0);

        // Set the font for text styling
        PdfFont font = new PdfFont(PdfFontFamily.Times_Roman, 12f, EnumSet.of(PdfFontStyle.Regular));

        // Set the brush color for text drawing
        PdfBrush brush = PdfBrushes.getBlack();

        // Set the initial coordinates for drawing elements
        float x = 80;
        float y = 350;
        float tempX = 0;

        // Specify the caption text for the radio button field
        String text = "RadioButton: ";

        // Draw the caption text on the page's canvas
        page.getCanvas().drawString(text, font, brush, x, y);

        // Calculate the x-coordinate for the radio button based on the width of the caption text
        tempX = (float) font.measureString(text).getWidth() + x + 15;

        // Create a PdfRadioButtonListField object with the specified name
        PdfRadioButtonListField radioButton = new PdfRadioButtonListField(page, "RadioButton");

        // Set the required property of the radio button field to true
        radioButton.setRequired(true);

        // Create a PdfRadioButtonListItem object for the radio button item
        PdfRadioButtonListItem fieldItem = new PdfRadioButtonListItem();

        // Set the border width and bounds of the radio button item
        fieldItem.setBorderWidth(0.75f);
        fieldItem.setBounds(new Rectangle2D.Float(tempX, y, 15, 15));

        // Add the radio button item to the radio button field
        radioButton.getItems().add(fieldItem);

        // Add the radio button field to the document's form fields collection
        doc.getForm().getFields().add(radioButton);

        // Specify the output file path
        String output = "output/addRadioButtonField-result.pdf";

        // Save the modified document to the output file
        doc.saveToFile(output);

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();

    }

}
