

import com.spire.pdf.*;
import com.spire.pdf.actions.*;
import com.spire.pdf.fields.*;
import com.spire.pdf.graphics.*;
import java.awt.geom.Rectangle2D;
import java.util.EnumSet;


public class addJavaScriptAction {
    public static void main(String[] args) throws Exception{
      // Create a new PdfDocument object
        PdfDocument doc = new PdfDocument();

        // Load an existing PDF document
        doc.loadFromFile("data/addLayer.pdf");

        // Enable creating form fields
        doc.setAllowCreateForm(true);

        // Create a PdfFont for text styling
        PdfFont font = new PdfFont(PdfFontFamily.Times_Roman, 12f, EnumSet.of(PdfFontStyle.Regular));

        // Create a PdfBrush for text color
        PdfBrush brush = PdfBrushes.getBlack();

        // Set the initial coordinates for drawing elements
        float x = 80;
        float y = 350;
        float tempX = 0;

        // Get the first page of the document
        PdfPageBase page = doc.getPages().get(0);

        // Draw the text "Enter a number, such as 12345:"
        String text1 = "Enter a number, such as 12345: ";
        page.getCanvas().drawString(text1, font, brush, x, y);

        // Calculate the x-coordinate for the text box based on the width of the previous text
        tempX = (float) font.measureString(text1).getWidth() + x + 15;

        // Create a new PdfTextBoxField with the specified name and associate it with the given page
        PdfTextBoxField textbox = new PdfTextBoxField(page, "Number-TextBox");

        // Set the bounds of the text box field using a rectangle with the specified coordinates and dimensions
        textbox.setBounds(new Rectangle2D.Float(tempX, y, 100, 15));

        // Set the border width of the text box field to 0.75f (floating-point value)
        textbox.setBorderWidth(0.75f);

        // Set the border style of the text box field to a solid line
        textbox.setBorderStyle(PdfBorderStyle.Solid);
        
        // Generate JavaScript code for keystroke action with desired input format
        String js = PdfJavaScript.getNumberKeystrokeString(2, 0, 0, 0, "$", true);

        // Create a PdfJavaScriptAction with the generated JavaScript code for keystroke action
        PdfJavaScriptAction jsAction = new PdfJavaScriptAction(js);

        // Set the keyPressed action of the text box field to the generated JavaScript action
        textbox.getActions().setKeyPressed(jsAction);

        // Generate JavaScript code for format action with desired formatting options
        js = PdfJavaScript.getNumberFormatString(2, 0, 0, 0, "$", true);

        // Create a PdfJavaScriptAction with the generated JavaScript code for format action
        jsAction = new PdfJavaScriptAction(js);

        // Set the format action of the text box field to the generated JavaScript action
        textbox.getActions().setFormat(jsAction);

        // Add the text box field to the document's form fields collection
        doc.getForm().getFields().add(textbox);

        // Save the modified document to the output file
        String output = "output/AddJavaScriptAction_out.pdf";
        doc.saveToFile(output);

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }

}
