import com.spire.pdf.*;
import com.spire.pdf.fields.*;
import com.spire.pdf.graphics.*;

import java.awt.geom.Rectangle2D;

public class addTooltipForFormField {
    public static void main(String[] args) throws Exception{
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile("data/addTooltipForFormField.pdf");
        PdfPageBase page = doc.getPages().get(0);

        //As for existing pdf, the property needs to be set as true
        doc.setAllowCreateForm(true);
        //Create a new pdf font
        PdfFont font = new PdfFont(PdfFontFamily.Helvetica, 12f, PdfFontStyle.Bold);
        //Create a pdf brush
        PdfBrush brush = PdfBrushes.getBlack();

        float x = 50;
        float y = 590;
        float tempX = 0;
        String text = "E-mail: ";

        //Draw a text into page
        page.getCanvas().drawString(text, font, brush, x, y);
        tempX = (float) (font.measureString(text).getWidth() + x + 15);
        //Create a pdf textbox field
        PdfTextBoxField textbox = new PdfTextBoxField(page, "TextBox");
        //Set the bounds of textbox field
        textbox.setBounds(new Rectangle2D.Float(tempX, y, 100, 15));
        //Set the border width of textbox field
        textbox.setBorderWidth(0.75f);
        //Set the border style of textbox field
        textbox.setBorderStyle(PdfBorderStyle.Solid);
        //Add the textbox field into pdf document
        doc.getForm().getFields().add(textbox);
        //Add a tooltip for the textbox field
        doc.getForm().getFields().get("TextBox").setToolTip("Please insert a valid email address");

        doc.saveToFile("output/addTooltipForFormField.pdf");
        doc.close();
    }
}
