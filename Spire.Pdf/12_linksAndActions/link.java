import com.spire.pdf.*;
import com.spire.pdf.actions.*;
import com.spire.pdf.annotations.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.*;

public class link {
    public static void main(String[] args) throws Exception {
        // Define the output file path for the PDF document
        String output = "output/link.pdf";

        // Create a new instance of PdfDocument
        PdfDocument doc = new PdfDocument();

        // Set up page margins
        PdfUnitConvertor unitCvtr = new PdfUnitConvertor();
        PdfMargins margin = new PdfMargins();

        // Convert and set the top margin to 2.54 centimeters in points
        margin.setTop(unitCvtr.convertUnits(2.54f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));

        // Set the bottom margin equal to the top margin
        margin.setBottom(margin.getTop());

        // Convert and set the left margin to 3.17 centimeters in points
        margin.setLeft(unitCvtr.convertUnits(3.17f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));

        // Set the right margin equal to the left margin
        margin.setRight(margin.getLeft());

        // Add a new page to the document with A4 size and specified margins
        PdfPageBase page = doc.getPages().add(PdfPageSize.A4, margin);

        // Initialize the vertical position of the text
        float y = 100;

        // Initialize the horizontal position of the text
        float x = 10;

        // Set up fonts for text rendering
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Lucida Sans Unicode", 0, 14));
        PdfTrueTypeFont font1 = new PdfTrueTypeFont(new Font("Lucida Sans Unicode", 0, 14));

        // Define the label for the text link
        String label = "Simple Text Link: ";

        // Create a string format object
        PdfStringFormat format = new PdfStringFormat();

        // Specify that trailing spaces should be measured
        format.setMeasureTrailingSpaces(true);

        // Draw the label on the page canvas at position (0, y) using the specified font and format
        page.getCanvas().drawString(label, font, PdfBrushes.getOrange(), 0, y, format);

        // Update the horizontal position based on the width of the drawn label
        x = (float) font.measureString(label, format).getWidth();

        // Define the URL for the text link
        String url1 = "http://www.e-iceblue.com";

        // Draw the URL on the page canvas at position (x, y) using the specified font and color
        page.getCanvas().drawString(url1, font1, PdfBrushes.getCadetBlue(), x, y);

        // Update the vertical position to leave space for the next element
        y = y + (float) font1.measureString(url1).getHeight() + 25;

        // Add a web link
        label = "Web Link: ";

        // Draw the label on the page canvas at position (0, y) using the specified font and format
        page.getCanvas().drawString(label, font, PdfBrushes.getOrange(), 0, y, format);

        // Update the horizontal position based on the width of the drawn label
        x = (float) font.measureString(label, format).getWidth();

        // Define the text for the web link
        String text = "E-iceblue home";

        // Create a PDF text web link object
        PdfTextWebLink link2 = new PdfTextWebLink();

        // Set the text for the web link
        link2.setText(text);

        // Set the URL for the web link
        link2.setUrl(url1);

        // Set the font for the web link
        link2.setFont(font1);

        // Set the color for the web link
        link2.setBrush(PdfBrushes.getCadetBlue());

        // Draw the web link on the page canvas at position (x, y)
        link2.drawTextWebLink(page.getCanvas(), new Point2D.Float(x, y));

        // Update the vertical position to leave space for the next element
        y = y + (float) font1.measureString(text).getHeight() + 30;

        // Add a URI annotation
        label = "URI Annotation: ";

        // Draw the label on the page canvas at position (0, y) using the specified font and format
        page.getCanvas().drawString(label, font, PdfBrushes.getOrange(), 0, y, format);

        // Update the horizontal position based on the width of the drawn label
        x = (float) font.measureString(label, format).getWidth();

        // Define the text for the URI annotation
        text = "Google";

        // Define the location of the URI annotation
        Point2D location = new Point2D.Float(x, y);

        // Measure the size of the text
        Dimension2D size = font1.measureString(text);

        // Create a rectangle to define the bounds of the URI annotation
        Rectangle2D linkBounds = new Rectangle2D.Float();

        // Set the frame of the link bounds
        linkBounds.setFrame(location, size);

        // Create a PDF URI annotation with the specified bounds
        PdfUriAnnotation link3 = new PdfUriAnnotation(linkBounds);

        // Set the border of the URI annotation
        link3.setBorder(new PdfAnnotationBorder(0));

        // Set the URI for the annotation
        link3.setUri("http://www.google.com");

        // Add the URI annotation to the page's annotations collection
        ((PdfNewPage) ((page instanceof PdfNewPage) ? page : null)).getAnnotations().add(link3);

        // Draw the text on the page canvas at position (x, y) using the specified font and color
        page.getCanvas().drawString(text, font1, PdfBrushes.getCadetBlue(), x, y);

        // Update the vertical position to leave space for the next element
        y = y + (float) size.getHeight() + 30;

        // Add a URI annotation with JavaScript action
        label = "URI Annotation Action: ";

        // Draw the label on the page canvas at position (0, y) using the specified font and format
        page.getCanvas().drawString(label, font, PdfBrushes.getOrange(), 0, y, format);

        // Update the horizontal position based on the width of the drawn label
        x = (float) font.measureString(label, format).getWidth();

        // Define the text for the URI annotation with JavaScript action
        text = "JavaScript Action (Click Me)";

        // Define the location of the URI annotation with JavaScript action
        location = new Point2D.Float(x - 2, y - 2);

        // Measure the size of the text
        size = font1.measureString(text);

        // Adjust the size to provide padding
        size.setSize(size.getWidth() + 5, size.getHeight() + 5);

        // Create a rectangle to define the bounds of the URI annotation with JavaScript action
        linkBounds = new Rectangle2D.Float();

        // Set the frame of the link bounds
        linkBounds.setFrame(location, size);

        // Create a PDF URI annotation with the specified bounds
        PdfUriAnnotation link4 = new PdfUriAnnotation(linkBounds);

        // Set the border of the URI annotation with JavaScript action
        link4.setBorder(new PdfAnnotationBorder(0.75f));

        // Set the color of the URI annotation with JavaScript action
        link4.setColor(new PdfRGBColor(new Color(95, 158, 160)));

        // Define the JavaScript code for the action
        String script = "app.alert({"
                + "    cMsg: \"Hello.\","
                + "    nIcon: 3,"
                + "    cTitle: \"JavaScript Action\""
                + "});";

        // Create a PDF JavaScript action with the specified code
        PdfJavaScriptAction action = new PdfJavaScriptAction(script);

        // Set the action for the URI annotation with JavaScript action
        link4.setAction(action);

        // Add the URI annotation with JavaScript action to the page's annotations collection
        ((PdfNewPage) ((page instanceof PdfNewPage) ? page : null)).getAnnotations().add(link4);

        // Draw the text on the page canvas at position (x, y) using the specified font and color
        page.getCanvas().drawString(text, font1, PdfBrushes.getCadetBlue(), x, y);

        // Update the vertical position to leave space for the next element
        y = y + (float) size.getHeight() + 30;

        // Update the label for the "Need Help" section
        label = "Need Help:  ";

        // Draw the label on the page canvas at position (0, y) using the specified font and format
        page.getCanvas().drawString(label, font, PdfBrushes.getOrange(), 0, y, format);

        // Update the horizontal position based on the width of the drawn label
        x = (float) font.measureString(label, format).getWidth();

        // Define the text for the forum link
        text = "Go to forum to ask questions";

        // Create a PDF text web link object
        link2 = new PdfTextWebLink();

        // Set the text for the forum link
        link2.setText(text);

        // Set the URL for the forum link
        link2.setUrl("https://www.e-iceblue.com/forum/components-f5.html");

        // Set the font for the forum link
        link2.setFont(font1);

        // Set the color for the forum link
        link2.setBrush(PdfBrushes.getCadetBlue());

        // Draw the forum link on the page canvas at position (x, y)
        link2.drawTextWebLink(page.getCanvas(), new Point2D.Float(x, y));

        // Update the vertical position to leave space for the next element
        y = y + (float) font1.measureString(text).getHeight() + 30;

        // Update the label for the "Contact us" section
        label = "Contact us:  ";

        // Draw the label on the page canvas at position (0, y) using the specified font and format
        page.getCanvas().drawString(label, font, PdfBrushes.getOrange(), 0, y, format);

        // Update the horizontal position based on the width of the drawn label
        x = (float) font.measureString(label, format).getWidth();

        // Define the text for the email link
        text = "Send an email";

        // Create a new PDF text web link object
        link2 = new PdfTextWebLink();

        // Set the text for the email link
        link2.setText(text);

        // Set the URL for the email link
        link2.setUrl("mailto:support@e-iceblue.com");

        // Set the font for the email link
        link2.setFont(font1);

        // Set the color for the email link
        link2.setBrush(PdfBrushes.getCadetBlue());

        // Draw the email link on the page canvas at position (x, y)
        link2.drawTextWebLink(page.getCanvas(), new Point2D.Float(x, y));

        // Update the vertical position to leave space for the next element
        y = y + (float) font1.measureString(text).getHeight() + 30;

        // Save the file
        doc.saveToFile(output, FileFormat.PDF);

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }
}

