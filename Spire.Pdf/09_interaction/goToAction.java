import com.spire.pdf.*;
import com.spire.pdf.actions.*;
import com.spire.pdf.annotations.*;
import com.spire.pdf.attachments.*;
import com.spire.pdf.general.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class goToAction {
    public static void main(String[] args) {
        PdfDocument pdf = new PdfDocument();
        PdfPageBase page = pdf.getPages().add();
        //Add a GoToE in pdf
        EmbeddedGoToAction(pdf, page);
        //Create a action that could jump to specific location
        JumpToSpecificLocationAction(pdf, page);

        pdf.saveToFile("output/goToActionOutput.pdf");
        pdf.close();
    }
    static void EmbeddedGoToAction(PdfDocument pdf, PdfPageBase page) {
        //add a attachment
        PdfAttachment attachment = new PdfAttachment("data/goToAction.pdf");
        pdf.getAttachments().add(attachment);
        String text = "Test embedded go-to action! Click this will open the attached PDF in a new window.";
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial", Font.PLAIN ,13));
        float width = 490f;
        float height = font.getHeight() * 2.2f;
        Rectangle2D rectangle = new Rectangle2D.Float();
        rectangle.setFrame(0, 100, width, height);
        page.getCanvas().drawString(text, font, PdfBrushes.getBlack(), rectangle);
        //Create a PdfDestination with specific page, location and 200% zoom factor
        PdfDestination dest = new PdfDestination(1, new Point2D.Float(0, 842), 2f);
        //Create GoToE action with dest
        PdfEmbeddedGoToAction action = new PdfEmbeddedGoToAction(attachment.getFileName(), dest, true);
        PdfActionAnnotation annotation = new PdfActionAnnotation(rectangle, action);
        //Add the annotation
        ((PdfNewPage) ((page instanceof PdfNewPage) ? page : null)).getAnnotations().add(annotation);
    }

    static void JumpToSpecificLocationAction(PdfDocument pdf, PdfPageBase page) {
        //add a new page
        PdfPageBase pagetwo = pdf.getPages().add();

        //draw text on the page
        pagetwo.getCanvas().drawString("This is Page Two.", new PdfFont(PdfFontFamily.Helvetica, 20f), new PdfSolidBrush(new PdfRGBColor(Color.black)), 10, 10);

        //create PdfDestination instance and link to PdfGoToAction
        PdfDestination pageBottomDest = new PdfDestination(pagetwo);
        pageBottomDest.setLocation(new Point2D.Float(0, 5));
        pageBottomDest.setMode(PdfDestinationMode.Location);
        pageBottomDest.setZoom(1f);
        PdfGoToAction action = new PdfGoToAction(pageBottomDest);

        PdfTrueTypeFont buttonFont = new PdfTrueTypeFont(new Font("Arial", Font.BOLD,10));
        float buttonWidth = 70;
        float buttonHeight = buttonFont.getHeight() * 1.5f;
        PdfStringFormat format2 = new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle);
        Rectangle2D buttonBounds = new Rectangle2D.Float(0, 200, buttonWidth, buttonHeight);

        //create a rectangle and draw text
        page.getCanvas().drawRectangle(PdfBrushes.getDarkGray(), buttonBounds);
        page.getCanvas().drawString("To Last Page", buttonFont, PdfBrushes.getCadetBlue(), buttonBounds, format2);

        //add the annotation
        PdfActionAnnotation annotation = new PdfActionAnnotation(buttonBounds, action);
        annotation.setBorder(new PdfAnnotationBorder(0.75f));
        annotation.setColor(new PdfRGBColor(Color.lightGray));
        ((PdfNewPage) ((page instanceof PdfNewPage) ? page : null)).getAnnotations().add(annotation);
    }
}
