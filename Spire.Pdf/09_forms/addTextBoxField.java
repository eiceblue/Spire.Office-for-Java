import com.spire.pdf.*;
import com.spire.pdf.fields.*;
import com.spire.pdf.graphics.*;
import java.awt.geom.Rectangle2D;
import java.util.EnumSet;


public class addTextBoxField {
    public static void main(String[] args) throws Exception{
        // Create a new PDF document
        PdfDocument doc = new PdfDocument();

        // Load an existing PDF document from file
        doc.loadFromFile("data/addLayer.pdf");

        // Enable form creation in the document
        doc.setAllowCreateForm(true);

        // Get the first page of the document
        PdfPageBase page = doc.getPages().get(0);

        // Define the font for the text box field
        PdfFont font = new PdfFont(PdfFontFamily.Times_Roman, 12f, EnumSet.of(PdfFontStyle.Regular));

        // Define the brush color for the text
        PdfBrush brush = PdfBrushes.getBlack();

        // Set the initial position of the text box
        float x = 80;
        float y = 350;

        // Temporary variable to store the updated x-coordinate
        float tempX = 0;

        // Text to be displayed as a label for the text box
        String text = "TextBox: ";

        // Draw the label text on the page canvas
        page.getCanvas().drawString(text, font, brush, x, y);

        // Calculate the x-coordinate for the text box based on the label width
        tempX = (float) font.measureString(text).getWidth() + x + 15;

        // Create a new text box field
        PdfTextBoxField textbox = new PdfTextBoxField(page, "TextBox");

        // Set the bounds (position and size) of the text box
        textbox.setBounds(new Rectangle2D.Float(tempX, y, 100, 15));

        // Set the required property of the text box field to true
        textbox.setRequired(true);

        // Set the border style for the text box field
        textbox.setBorderStyle(PdfBorderStyle.Solid);

        // Add the text box field to the document's form fields collection
        doc.getForm().getFields().add(textbox);

        // Specify the output file path
        String result = "output/addTextBoxField-result.pdf";

        // Save the modified PDF document to file
        doc.saveToFile(result);

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();


    }

}
