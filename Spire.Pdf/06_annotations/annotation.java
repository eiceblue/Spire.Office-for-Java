import com.spire.pdf.*;
import com.spire.pdf.annotations.*;
import com.spire.pdf.general.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.EnumSet;


public class annotation {
    public static void main(String[] args) {
// Create a new PDF document
        PdfDocument doc = new PdfDocument();

        // Create a unit converter for converting measurement units
        PdfUnitConvertor unitCvtr = new PdfUnitConvertor();

        // Set the margins for the page
        PdfMargins margin = new PdfMargins();
        margin.setTop(unitCvtr.convertUnits(2.54f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
        margin.setBottom(margin.getTop());
        margin.setLeft(unitCvtr.convertUnits(3f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
        margin.setRight(margin.getLeft());

        // Add a new page to the document with specified size and margins
        PdfPageBase page = doc.getPages().add(PdfPageSize.A4, margin);

        // Set up brush, font, and string format for drawing text on the page
        PdfBrush brush1 = PdfBrushes.getBlack();
        PdfTrueTypeFont font1 = new PdfTrueTypeFont(new Font("Arial", Font.BOLD + Font.ITALIC, 13), true);
        PdfStringFormat format1 = new PdfStringFormat(PdfTextAlignment.Left);

        float y = 50; // Initial y-coordinate for positioning annotations

        // Draw a sample string on the page
        String s = "The sample demonstrates how to add annotations in PDF document.";
        page.getCanvas().drawString(s, font1, brush1, 0, y - 5, format1);

        // Update the y-coordinate based on the drawn string's height
        y = y + (float) font1.measureString(s, format1).getHeight();
        y = y + 15;

        // Add different types of annotations at specified y-coordinates
        y = addDocumentLinkAnnotation(page, y);
        y = y + 6;
        y = addFileLinkAnnotation(page, y);
        y = y + 6;
        y = addFreeTextAnnotation(page, y);
        y = y + 6;
        y = addLineAnnotation(page, y);
        y = y + 6;
        y = addTextMarkupAnnotation(page, y);
        y = y + 6;
        y = addPopupAnnotation(page, y);
        y = y + 6;
        y = addRubberStampAnnotation(page, y);

        // Save the PDF document to a file
        doc.saveToFile("output/annotation.pdf");

        // Close the PDF document
        doc.close();

        // Dispose of the PDF document (frees up system resources)
        doc.dispose();
    }

    static float addDocumentLinkAnnotation(PdfPageBase page, float y) {
        // Create a PdfTrueTypeFont with Arial font, size 12
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial", 0, 12));

        // Create a PdfStringFormat with trailing spaces measurement enabled
        PdfStringFormat format = new PdfStringFormat();
        format.setMeasureTrailingSpaces(true);

        // Set the prompt text and measure its size using the font
        String prompt = "Document Link: ";
        Dimension2D size = font.measureString(prompt);

        // Draw the prompt text on the page's canvas at position (0, y)
        page.getCanvas().drawString(prompt, font, PdfBrushes.getDodgerBlue(), 0, y);

        // Update the x-coordinate for subsequent drawings based on the prompt text's width
        float x = (float) font.measureString(prompt, format).getWidth();

        // Create a PdfDestination object for the document link annotation
        PdfDestination dest = new PdfDestination(page);
        dest.setMode(PdfDestinationMode.Location);
        dest.setLocation(new Point2D.Float(0, y));
        dest.setZoom(2f);

        // Set up a label text and measure its size using the font
        String label = "Click me, Zoom 200%";
        size = font.measureString(label);

        // Create a rectangle representing the bounds of the document link annotation
        Rectangle2D.Float bounds = new Rectangle2D.Float(x, y, (float) size.getWidth(), (float) size.getHeight());

        // Draw the label text on the page's canvas with the font and color at position (x, y)
        page.getCanvas().drawString(label, font, PdfBrushes.getOrangeRed(), x, y);

        // Create a PdfDocumentLinkAnnotation object with the bounds and destination
        PdfDocumentLinkAnnotation annotation = new PdfDocumentLinkAnnotation(bounds, dest);

        // Set the color for the document link annotation
        annotation.setColor(new PdfRGBColor(Color.BLUE));

        // Add the document link annotation to the page's annotations collection
        ((PdfNewPage) page).getAnnotations().add(annotation);

        // Update the y-coordinate for the next annotation or drawing
        y = (float) bounds.getY() + (float) bounds.getHeight();

        // Return the updated y-coordinate
        return y;
    }

    static float addFileLinkAnnotation(PdfPageBase page, float y) {
        // Create a PdfTrueTypeFont with Arial font, size 12
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial", 0, 12));

        // Create a PdfStringFormat with trailing spaces measurement enabled
        PdfStringFormat format = new PdfStringFormat();
        format.setMeasureTrailingSpaces(true);

        // Set the prompt text and measure its size using the font
        String prompt = "Launch File: ";
        Dimension2D size = font.measureString(prompt);

        // Draw the prompt text on the page's canvas at position (0, y)
        page.getCanvas().drawString(prompt, font, PdfBrushes.getDodgerBlue(), 0, y);

        // Update the x-coordinate for subsequent drawings based on the prompt text's width
        float x = (float) font.measureString(prompt, format).getWidth();

        // Set up a label text and measure its size using the font
        String label = "Launch Notepad.exe";
        size = font.measureString(label);

        // Create a rectangle representing the bounds of the file link annotation
        Rectangle2D.Float bounds = new Rectangle2D.Float(x, y, (float) size.getWidth(), (float) size.getHeight());

        // Draw the label text on the page's canvas with the font and color at position (x, y)
        page.getCanvas().drawString(label, font, PdfBrushes.getOrangeRed(), x, y);

        // Create a PdfFileLinkAnnotation object with the bounds and file path
        PdfFileLinkAnnotation annotation = new PdfFileLinkAnnotation(bounds, "C://Windows//Notepad.exe");

        // Set the color for the file link annotation
        annotation.setColor(new PdfRGBColor(Color.BLUE));

        // Add the file link annotation to the page's annotations collection
        ((PdfNewPage) page).getAnnotations().add(annotation);

        // Update the y-coordinate for the next annotation or drawing
        y = (float) bounds.getY() + (float) bounds.getHeight();

        // Return the updated y-coordinate
        return y;
    }

    static float addFreeTextAnnotation(PdfPageBase page, float y) {
        // Create a PdfTrueTypeFont with Arial font, size 12
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial", 0, 12));

        // Create a PdfStringFormat with trailing spaces measurement enabled
        PdfStringFormat format = new PdfStringFormat();
        format.setMeasureTrailingSpaces(true);

        // Set the prompt text and measure its size using the font
        String prompt = "Text Markup: ";
        Dimension2D size = font.measureString(prompt);

        // Draw the prompt text on the page's canvas at position (0, y)
        page.getCanvas().drawString(prompt, font, PdfBrushes.getDodgerBlue(), 0, y);

        // Update the x-coordinate for subsequent drawings based on the prompt text's width
        float x = (float) font.measureString(prompt, format).getWidth();

        // Set up a label text and measure its size using the font
        String label = "I'm a text box, not a TV";
        size = font.measureString(label);

        // Create a rectangle representing the bounds of the text box
        Rectangle2D bounds = new Rectangle2D.Float(x, y, (float) size.getWidth(), (float) size.getHeight());

        // Draw a rectangle outline for the text box
        page.getCanvas().drawRectangle(new PdfPen(new PdfRGBColor(Color.BLUE), 0.1f), bounds);

        // Draw the label text on the page's canvas with the font and color at position (x, y)
        page.getCanvas().drawString(label, font, PdfBrushes.getOrangeRed(), x, y);

        // Set up the location and dimensions for the free text annotation
        Point2D.Float location = new Point2D.Float((float) bounds.getX() + (float) bounds.getWidth() + 16, (float) bounds.getY() - 16);
        Dimension2D dimension2D = new Dimension();
        dimension2D.setSize(80, 32);
        Rectangle2D.Float annotationBounds = new Rectangle2D.Float();
        annotationBounds.setFrame(location, dimension2D);

        // Create a PdfFreeTextAnnotation object with the annotation bounds
        PdfFreeTextAnnotation annotation = new PdfFreeTextAnnotation(annotationBounds);

        // Set the annotation intent to FreeTextCallout
        annotation.setAnnotationIntent(PdfAnnotationIntent.FreeTextCallout);

        // Set the border style and color for the annotation
        annotation.setBorder(new PdfAnnotationBorder(0.5f));
        annotation.setBorderColor(new PdfRGBColor(Color.red));

        // Set up the callout lines for the annotation
        location = new Point2D.Float((float) (bounds.getX() + bounds.getWidth() + 105), (float) (page.getActualSize().getHeight() - bounds.getY() - 80));
        annotation.setCalloutLines(new Point2D[]{
                new Point2D.Float((float) (bounds.getX() + bounds.getWidth() + 85), (float) (page.getActualSize().getHeight() - bounds.getY() - 85)),
                new Point2D.Float((float) (bounds.getX() + bounds.getWidth() + 105), (float) (page.getActualSize().getHeight() - bounds.getY() - 80)),
                location
        });

        // Set the color for the annotation
        annotation.setColor(new PdfRGBColor(Color.YELLOW));

        // Set the flags for the annotation to Locked
        annotation.setFlags(EnumSet.of(PdfAnnotationFlags.Locked));

        // Set the font for the annotation
        annotation.setFont(font);

        // Set the line ending style to OpenArrow for the annotation
        annotation.setLineEndingStyle(PdfLineEndingStyle.OpenArrow);

        // Set the markup text for the annotation
        annotation.setMarkupText("Just a joke.");

        // Set the opacity for the annotation
        annotation.setOpacity(0.75f);

        // Set the text markup color for the annotation
        annotation.setTextMarkupColor(new PdfRGBColor(Color.GREEN));

        // Add the free text annotation to the page's annotations collection
        ((PdfNewPage) page).getAnnotations().add(annotation);

        // Update the y-coordinate for the next annotation or drawing
        y = (float) bounds.getY() + (float) bounds.getHeight();

        // Return the updated y-coordinate
        return y;
    }

    static float addLineAnnotation(PdfPageBase page, float y) {
        // Create a PdfTrueTypeFont with Arial font, size 12
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial", 0, 12));

        // Create a PdfStringFormat with trailing spaces measurement enabled
        PdfStringFormat format = new PdfStringFormat();
        format.setMeasureTrailingSpaces(true);

        // Set the prompt text and measure its size using the font
        String prompt = "Line Annotation: ";
        Dimension2D size = font.measureString(prompt);

        // Draw the prompt text on the page's canvas at position (0, y)
        page.getCanvas().drawString(prompt, font, PdfBrushes.getDodgerBlue(), 0, y);

        // Update the x-coordinate for subsequent drawings based on the prompt text's width
        float x = (float) font.measureString(prompt, format).getWidth();

        // Set up a label text and measure its size
        String label = "Line Annotation";
        size = font.measureString(label);

        // Draw the label text on the page's canvas with the font and color at position (x, y)
        page.getCanvas().drawString(label, font, PdfBrushes.getOrangeRed(), x, y);

        // Create a rectangle representing the bounds of the line annotation
        Rectangle2D.Float bounds = new Rectangle2D.Float(x, y, (float) size.getWidth(), (float) size.getHeight());

        // Define the line points as an array of integers [x1, y1, x2, y2]
        int[] linePoints = new int[]{(int) bounds.getX(), (int) bounds.getY(), (int) bounds.getX() + (int) bounds.getWidth(), (int) bounds.getY() + (int) bounds.getHeight()};

        // Create a PdfLineAnnotation object with the line points and annotation text
        PdfLineAnnotation annotation = new PdfLineAnnotation(linePoints, "Annotation");

        // Set the line ending styles to closed arrows
        annotation.setBeginLineStyle(PdfLineEndingStyle.ClosedArrow);
        annotation.setEndLineStyle(PdfLineEndingStyle.ClosedArrow);

        // Enable line caption
        annotation.setLineCaption(true);

        // Set the background color of the line annotation
        annotation.setBackColor(new PdfRGBColor(Color.BLACK));

        // Set the caption type to inline for the line annotation
        annotation.setCaptionType(PdfLineCaptionType.Inline);

        // Add the line annotation to the page's annotations collection
        ((PdfNewPage) page).getAnnotations().add(annotation);

        // Update the y-coordinate for the next annotation or drawing
        y = (float) bounds.getY() + (float) bounds.getHeight();

        // Return the updated y-coordinate
        return y;
    }

    static float addTextMarkupAnnotation(PdfPageBase page, float y) {
        // Create a PdfTrueTypeFont with Arial font, size 12
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial", 0, 12));

        // Create a PdfStringFormat with trailing spaces measurement enabled
        PdfStringFormat format = new PdfStringFormat();
        format.setMeasureTrailingSpaces(true);

        // Set the prompt text and measure its size using the font and format
        String prompt = "Highlight incorrect spelling: ";
        Dimension2D size = font.measureString(prompt, format);

        // Draw the prompt text on the page's canvas at position (0, y)
        page.getCanvas().drawString(prompt, font, PdfBrushes.getDodgerBlue(), 0, y);

        // Update the x-coordinate for subsequent drawings
        float x = (float) size.getWidth();

        // Draw a label text on the page's canvas with the font and color at position (x, y)
        String label = "demo of annotation";
        page.getCanvas().drawString(label, font, PdfBrushes.getOrangeRed(), x, y);

        // Measure the size of "demo of " and update the x-coordinate
        size = font.measureString("demo of ", format);
        x = x + (float) size.getWidth();

        // Set up a rectangle with dimensions 100x100 at position (x, y)
        String markupText = "Should be 'annotation'";
        Rectangle2D aFloat = new Rectangle2D.Float(x, y, 100f, 100f);

        // Create a PdfTextMarkupAnnotation object with the markup text, correction text, rectangle, and font
        PdfTextMarkupAnnotation annotation = new PdfTextMarkupAnnotation(markupText, "anotation", aFloat, font);

        // Set the text markup type to "Highlight"
        annotation.setTextMarkupAnnotationType(PdfTextMarkupAnnotationType.Highlight);

        // Set the color for the text markup annotation
        annotation.setTextMarkupColor(new PdfRGBColor(new Color(135, 206, 250)));

        // Add the text markup annotation to the page's annotations collection
        ((PdfNewPage) page).getAnnotations().add(annotation);

        // Update the y-coordinate for the next annotation or drawing
        y = y + (float) size.getHeight();

        // Return the updated y-coordinate
        return y;
    }

    static float addPopupAnnotation(PdfPageBase page, float y) {
        // Create a PdfTrueTypeFont with Arial font, size 12
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial", 0, 12));

        // Create a PdfStringFormat with trailing spaces measurement enabled
        PdfStringFormat format = new PdfStringFormat();
        format.setMeasureTrailingSpaces(true);

        // Set the prompt text and measure its size using the font and format
        String prompt = "Markup incorrect spelling: ";
        Dimension2D size = font.measureString(prompt, format);

        // Draw the prompt text on the page's canvas at position (0, y)
        page.getCanvas().drawString(prompt, font, PdfBrushes.getDodgerBlue(), 0, y);

        // Update the x-coordinate for subsequent drawings
        float x = (float) size.getWidth();

        // Draw a label text on the page's canvas with the font and color at position (x, y)
        String label = "demo of annotation";
        page.getCanvas().drawString(label, font, PdfBrushes.getOrangeRed(), x, y);

        // Update the x-coordinate again based on the label's width
        x = x + (float)font.measureString(label, format).getWidth();

        // Set up a popup annotation with a rectangle at position (x, y) and an empty dimension
        String markupText = "All words were spelled correctly";
        size = font.measureString(markupText);
        Rectangle2D rectangle2D = new Rectangle.Float();
        rectangle2D.setFrame(new Point2D.Double(x, y), new Dimension());

        // Create a PdfPopupAnnotation object with the rectangle and markup text
        PdfPopupAnnotation annotation = new PdfPopupAnnotation(rectangle2D, markupText);

        // Set the icon type for the popup annotation to "Paragraph"
        annotation.setIcon(PdfPopupIcon.Paragraph);

        // Set the open state of the popup annotation to "true"
        annotation.setOpen(true);

        // Set the color for the popup annotation
        annotation.setColor(new PdfRGBColor(Color.YELLOW));

        // Add the popup annotation to the page's annotations collection
        ((PdfNewPage) page).getAnnotations().add(annotation);

        // Update the y-coordinate for the next annotation or drawing
        y = y + (float)size.getHeight();

        // Return the updated y-coordinate
        return y;
    }

    static float addRubberStampAnnotation(PdfPageBase page, float y) {
        // Create a PdfTrueTypeFont with Arial font, size 12
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial", 0, 12));

        // Create a PdfStringFormat with trailing spaces measurement enabled
        PdfStringFormat format = new PdfStringFormat();
        format.setMeasureTrailingSpaces(true);

        // Set the prompt text and measure its size using the font and format
        String prompt = "Markup incorrect spelling: ";
        Dimension2D size = font.measureString(prompt, format);

        // Draw the prompt text on the page's canvas at position (0, y)
        page.getCanvas().drawString(prompt, font, PdfBrushes.getDodgerBlue(), 0, y);

        // Update the x-coordinate for subsequent drawings
        float x = (float) size.getWidth();

        // Draw a label text on the page's canvas with the font and color at position (x, y)
        String label = "demo of annotation";
        page.getCanvas().drawString(label, font, PdfBrushes.getOrangeRed(), x, y);

        // Update the x-coordinate again based on the label's width
        x = x + (float) font.measureString(label, format).getWidth();

        // Set up a rubber stamp annotation with a rectangle at position (x, y) with dimensions equal to font height
        String markupText = "Just a draft, not checked.";
        size = font.measureString(markupText);
        PdfRubberStampAnnotation annotation = new PdfRubberStampAnnotation(new Rectangle2D.Float(x, y, font.getHeight(), font.getHeight()), markupText);

        // Set the icon type for the rubber stamp annotation to "Draft"
        annotation.setIcon(PdfRubberStampAnnotationIcon.Draft);

        // Set the color for the rubber stamp annotation
        annotation.setColor(new PdfRGBColor(new Color(221, 160, 221)));

        // Add the rubber stamp annotation to the page's annotations collection
        ((PdfNewPage) page).getAnnotations().add(annotation);

        // Update the y-coordinate for the next annotation or drawing
        y = y + (float) size.getHeight();

        // Return the updated y-coordinate
        return y;
    }
}
