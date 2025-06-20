import com.spire.pdf.*;
import com.spire.pdf.fields.*;
import com.spire.pdf.graphics.*;

import java.awt.geom.Rectangle2D;

public class addTooltipForFormField {
    public static void main(String[] args) throws Exception{
        // Create a new PDF document
        PdfDocument doc = new PdfDocument();

        // Load an existing PDF document from file
        doc.loadFromFile("data/addTooltipForFormField.pdf");

        // Get the first page of the document
        PdfPageBase page = doc.getPages().get(0);

        // Enable form creation in the document
        doc.setAllowCreateForm(true);

        // Define the font and brush color for the text
        PdfFont font = new PdfFont(PdfFontFamily.Helvetica, 12f, PdfFontStyle.Bold);
        PdfBrush brush = PdfBrushes.getBlack();

        // Set the initial position of the text
        float x = 50;
        float y = 590;

        // Temporary variable to store the updated x-coordinate
        float tempX = 0;

        // Text to be displayed as a label
        String text = "E-mail: ";

        // Draw the label text on the page canvas
        page.getCanvas().drawString(text, font, brush, x, y);

        // Calculate the x-coordinate for the form field based on the label width
        tempX = (float) (font.measureString(text).getWidth() + x + 15);

        // Create a new text box form field
        PdfTextBoxField textbox = new PdfTextBoxField(page, "TextBox");

        // Set the bounds (position and size) of the text box form field
        textbox.setBounds(new Rectangle2D.Float(tempX, y, 100, 15));

        // Set the border width and style for the text box form field
        textbox.setBorderWidth(0.75f);
        textbox.setBorderStyle(PdfBorderStyle.Solid);

        // Add the text box form field to the document's form fields collection
        doc.getForm().getFields().add(textbox);

        // Set the tooltip for the text box form field
        doc.getForm().getFields().get("TextBox").setToolTip("Please insert a valid email address");

        // Save the modified PDF document to file
        doc.saveToFile("output/addTooltipForFormField.pdf");

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }
}
