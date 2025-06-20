import com.spire.pdf.*;
import com.spire.pdf.fields.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.*;

public class addTooltipToText {
    public static void main(String[] args) throws Exception{
        // Create a pdf document
        PdfDocument doc = new PdfDocument();

        // Create one page
        PdfPageBase page = doc.getPages().add();

        // Draw the text
        page.getCanvas().drawString("Move the mouse cursor over the following text to display a tooltip",
                new PdfFont(PdfFontFamily.Times_Roman, 15), PdfBrushes.getBlack(), new Point(10, 20));

        // Define the text
        String text1 = "Your Office Development Master";

        // Define the font style
        PdfTrueTypeFont font1 = new PdfTrueTypeFont(new Font("Arial", Font.ITALIC, 18), true);

        // Measure the text1
        Dimension2D sizeF1 = font1.measureString(text1);

        // Define the Rectangle to contain the text1
        Rectangle2D.Double rec1 = new Rectangle2D.Double(100, 100, sizeF1.getWidth(), sizeF1.getHeight());

        // Draw text
        page.getCanvas().drawString(text1, font1, new PdfSolidBrush(new PdfRGBColor(Color.blue)), rec1);

        // Create invisible button on text position
        PdfButtonField field1 = new PdfButtonField(page, "field1");

        // Set the bounds and size of field
        field1.setBounds(rec1);

        // Set tooltip content
        field1.setToolTip("E-iceblue Co. Ltd., a vendor of .NET, Java and WPF development components");

        // Set no border for field
        field1.setBorderWidth(0);

        // Define the color
        Color loColor = new Color(0, 0, 0, 0);

        // Set backColor for field1
        field1.setBackColor(new PdfRGBColor(loColor));

        // Set foreColor for field1
        field1.setForeColor(new PdfRGBColor(loColor));

        // Set the layout mode for field1
        field1.setLayoutMode(PdfButtonLayoutMode.Icon_Only);

        // Set whether the icon layout fits the bounds
        field1.getIconLayout().isFitBounds(true);

        // Define the text and its style
        String text2 = "Spire.PDF";

        // Define the font style
        PdfFont font2 = new PdfFont(PdfFontFamily.Times_Roman, 20);

        // Measure the text2
        Dimension2D sizeF2 = font2.measureString(text2);

        // Define the Rectangle to contain the text2
        Rectangle2D.Double rec2 = new Rectangle2D.Double(100, 160, sizeF2.getWidth(), sizeF2.getHeight());

        // Draw text
        page.getCanvas().drawString(text2, font2, PdfBrushes.getDarkOrange(), rec2);

        // Create invisible button on text position
        PdfButtonField field2 = new PdfButtonField(page, "field2");

        // Set the bounds of rec2
        field2.setBounds(rec2);

        // Set tool tip content
        field2.setToolTip("A professional PDF library applied to creating," +
                "writing, editing, handling and reading PDF files" +
                "without any external dependencies within .NET" +
                "( C#, VB.NET, ASP.NET, .NET Core) application.");

        // Set border width
        field2.setBorderWidth(0);

        // Set backColor for field2
        field2.setBackColor(new PdfRGBColor(loColor));

        // Set foreColor for field2
        field2.setForeColor(new PdfRGBColor(loColor));


        // Set the layout mode for field2
        field2.setLayoutMode(PdfButtonLayoutMode.Icon_Only);

        // Set whether the icon layout fits the bounds
        field2.getIconLayout().isFitBounds(true);

        // Allow create form on pdf
        doc.setAllowCreateForm(true);

        // Add the field1 to pdf form
        doc.getForm().getFields().add(field1);

        // Add the field2 to pdf form
        doc.getForm().getFields().add(field2);

        String result = "output/addTooltipToText.pdf";

        // Save the document
        doc.saveToFile(result);

        // Close the document
        doc.close();

        // Dispose of the document (frees up system resources)
        doc.dispose();
    }
}
