import com.spire.pdf.*;
import com.spire.pdf.actions.*;
import com.spire.pdf.annotations.*;
import com.spire.pdf.attachments.*;
import com.spire.pdf.general.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.*;

public class goToAction {
    public static void main(String[] args) {
        String output = "output/goToAction.pdf";

        // Create a new instance of PdfDocument
        PdfDocument pdf = new PdfDocument();

        // Add a new page to the document
        PdfPageBase page = pdf.getPages().add();

        // Call the embeddedGoToAction method to embed a GoTo action in the PDF
        embeddedGoToAction(pdf, page);

        // Call the jumpToSpecificLocationAction method to add an action that jumps to a specific location in the PDF
        jumpToSpecificLocationAction(pdf, page);

        // Save the PDF document to the specified output file in PDF format
        pdf.saveToFile(output, FileFormat.PDF);

        // Close the PDF document to release resources
        pdf.close();

        // Dispose of the PDF document to free up system resources
        pdf.dispose();
    }
	
        static void embeddedGoToAction(PdfDocument pdf, PdfPageBase page) {
        // Create a PdfAttachment object with the file path "data/goToAction.pdf"
        PdfAttachment attachment = new PdfAttachment("data/goToAction.pdf");
        // Add the attachment to the attachments collection of the PDF document
        pdf.getAttachments().add(attachment);

        // Define the text to be displayed as the embedded go-to action
        String text = "Test embedded go-to action! Click this will open the attached PDF in a new window.";

        // Create a PdfTrueTypeFont object using the Arial font with a plain style and a font size of 13
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 13));

        // Set the width and height for the rectangle that will be used for drawing the text
        float width = 490f;
        float height = font.getHeight() * 2.2f;

        // Create a Rectangle2D.Float object and set its position and size
        Rectangle2D rectangle = new Rectangle2D.Float();
        rectangle.setFrame(0, 100, width, height);

        // Draw the specified text using the defined font, black color, and the previously created rectangle on the canvas of the page
        page.getCanvas().drawString(text, font, PdfBrushes.getBlack(), rectangle);

        // Create a PdfDestination object representing a target location in the PDF document
        // This destination specifies the first page (page number 1) and a specific position (0, 842) with a zoom factor of 2
        PdfDestination dest = new PdfDestination(1, new Point2D.Float(0, 842), 2f);

        // Create a PdfEmbeddedGoToAction object with the attachment's filename, the previously created destination, and the parameter indicating opening in a new window
        PdfEmbeddedGoToAction action = new PdfEmbeddedGoToAction(attachment.getFileName(), dest, true);

        // Create a PdfActionAnnotation object with the previously defined rectangle and the embedded go-to action
        PdfActionAnnotation annotation = new PdfActionAnnotation(rectangle, action);

        // Add the annotation to the annotations collection of the current page
        ((PdfNewPage) ((page instanceof PdfNewPage) ? page : null)).getAnnotations().add(annotation);
    }

    static void jumpToSpecificLocationAction(PdfDocument pdf, PdfPageBase page) {
        // Create a new page in the PDF document
        PdfPageBase pagetwo = pdf.getPages().add();

        // Draw text on the new page
        pagetwo.getCanvas().drawString("This is Page Two.", new PdfFont(PdfFontFamily.Helvetica, 20f),
                new PdfSolidBrush(new PdfRGBColor(Color.black)), 10, 10);

        // Create a destination for jumping to the bottom of the new page
        PdfDestination pageBottomDest = new PdfDestination(pagetwo);
        pageBottomDest.setLocation(new Point2D.Float(0, 5));
        pageBottomDest.setMode(PdfDestinationMode.Location);
        pageBottomDest.setZoom(1f);

        // Create a GoTo action based on the destination
        PdfGoToAction action = new PdfGoToAction(pageBottomDest);

        // Define the font and dimensions of a button
        PdfTrueTypeFont buttonFont = new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 10));
        float buttonWidth = 70;
        float buttonHeight = buttonFont.getHeight() * 1.5f;

        // Set the format for the button text
        PdfStringFormat format2 = new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle);

        // Define the bounds of the button
        Rectangle2D buttonBounds = new Rectangle2D.Float(0, 200, buttonWidth, buttonHeight);

        // Draw a rectangle as the button background
        page.getCanvas().drawRectangle(PdfBrushes.getDarkGray(), buttonBounds);

        // Draw the button text
        page.getCanvas().drawString("To Last Page", buttonFont, PdfBrushes.getCadetBlue(), buttonBounds, format2);

        // Create an action annotation for the button with the GoTo action
        PdfActionAnnotation annotation = new PdfActionAnnotation(buttonBounds, action);

        // Set the border and color of the annotation
        annotation.setBorder(new PdfAnnotationBorder(0.75f));
        annotation.setColor(new PdfRGBColor(Color.lightGray));

        // Add the annotation to the current page's annotations collection
        ((PdfNewPage) ((page instanceof PdfNewPage) ? page : null)).getAnnotations().add(annotation);
    }
}
