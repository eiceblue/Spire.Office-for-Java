import com.spire.pdf.*;
import com.spire.pdf.annotations.*;
import com.spire.pdf.general.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.*;


public class annotation {
    public static void main(String[] args) {
        PdfDocument doc = new PdfDocument();
        //Margin
        PdfUnitConvertor unitCvtr = new PdfUnitConvertor();
        PdfMargins margin = new PdfMargins();
        margin.setTop(unitCvtr.convertUnits(2.54f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
        margin.setBottom(margin.getTop());
        margin.setLeft(unitCvtr.convertUnits(3f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
        margin.setRight(margin.getLeft());
        //Create one page
        PdfPageBase page = doc.getPages().add(PdfPageSize.A4, margin);
        //Title
        PdfBrush brush1 = PdfBrushes.getBlack();
        PdfTrueTypeFont font1 = new PdfTrueTypeFont(new Font("Arial", Font.BOLD + Font.ITALIC,13), true);
        PdfStringFormat format1 = new PdfStringFormat(PdfTextAlignment.Left);
        float y = 50;
        String s = "The sample demonstrates how to add annotations in PDF document.";
        page.getCanvas().drawString(s, font1, brush1, 0, y - 5, format1);
        y = y + (float)font1.measureString(s, format1).getHeight();
        y = y + 15;
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
        doc.saveToFile("output/annotation.pdf");
        doc.close();
    }

    static float addDocumentLinkAnnotation(PdfPageBase page, float y) {
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial",0, 12));
        PdfStringFormat format = new PdfStringFormat();
        format.setMeasureTrailingSpaces(true);
        String prompt = "Document Link: ";
        Dimension2D size=font.measureString(prompt);

        page.getCanvas().drawString(prompt, font, PdfBrushes.getDodgerBlue(), 0, y);
        float x = (float)font.measureString(prompt, format).getWidth();

        PdfDestination dest = new PdfDestination(page);
        dest.setMode(PdfDestinationMode.Location);
        dest.setLocation(new Point2D.Float(0, y));
        dest.setZoom(2f);

        String label = "Click me, Zoom 200%";
        size = font.measureString(label);
        Rectangle2D.Float bounds = new Rectangle2D.Float(x, y, (float)size.getWidth(), (float)size.getHeight());
        page.getCanvas().drawString(label, font, PdfBrushes.getOrangeRed(), x, y);
        PdfDocumentLinkAnnotation annotation = new PdfDocumentLinkAnnotation(bounds, dest);
        annotation.setColor(new PdfRGBColor(Color.BLUE));
        ((PdfNewPage) page).getAnnotations().add(annotation);
        y = (float) bounds.getY()+(float) bounds.getHeight();

        return y;
    }

    static float addFileLinkAnnotation(PdfPageBase page, float y) {
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial",0,12));
        PdfStringFormat format = new PdfStringFormat();
        format.setMeasureTrailingSpaces(true);
        String prompt = "Launch File: ";
        Dimension2D size = font.measureString(prompt);

        page.getCanvas().drawString(prompt, font, PdfBrushes.getDodgerBlue(), 0, y);
        float x = (float)font.measureString(prompt, format).getWidth();

        String label = "Launch Notepad.exe";
        size = font.measureString(label);
        Rectangle2D.Float bounds = new  Rectangle2D.Float(x, y, (float)size.getWidth(), (float)size.getHeight());
        page.getCanvas().drawString(label, font, PdfBrushes.getOrangeRed(), x, y);
        PdfFileLinkAnnotation annotation = new PdfFileLinkAnnotation(bounds, "C://Windows//Notepad.exe");
        annotation.setColor(new PdfRGBColor(Color.BLUE));
        ((PdfNewPage) page).getAnnotations().add(annotation);
        y = (float) bounds.getY()+(float) bounds.getHeight();

        return y;
    }

    static float addFreeTextAnnotation(PdfPageBase page, float y) {
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial",0, 12));
        PdfStringFormat format = new PdfStringFormat();
        format.setMeasureTrailingSpaces(true);
        String prompt = "Text Markup: ";
        Dimension2D size = font.measureString(prompt);

        page.getCanvas().drawString(prompt, font, PdfBrushes.getDodgerBlue(), 0, y);
        float x = (float)font.measureString(prompt, format).getWidth();

        String label = "I'm a text box, not a TV";
        size = font.measureString(label);
        Rectangle2D bounds = new Rectangle2D.Float(x, y, (float)size.getWidth(), (float)size.getHeight());
        page.getCanvas().drawRectangle(new PdfPen(new PdfRGBColor(Color.BLUE), 0.1f), bounds);
        page.getCanvas().drawString(label, font, PdfBrushes.getOrangeRed(), x, y);
        Point2D.Float location = new Point2D.Float((float)bounds.getX()+(float) bounds.getWidth() + 16, (float)bounds.getY() - 16);
        Dimension2D dimension2D = new Dimension();
        dimension2D.setSize(80,32);
        Rectangle2D.Float annotationBounds = new Rectangle2D.Float();
        annotationBounds.setFrame(location,dimension2D);
        PdfFreeTextAnnotation annotation = new PdfFreeTextAnnotation(annotationBounds);
        annotation.setAnnotationIntent(PdfAnnotationIntent.FreeTextCallout);
        annotation.setBorder(new PdfAnnotationBorder(0.5f));
        annotation.setBorderColor(new PdfRGBColor(Color.red));
        annotation.setCalloutLines(new Point2D[]
                {
                        new Point2D.Float((float)( bounds.getX()+bounds.getWidth()), (float) bounds.getY()),
                        new Point2D.Float((float) (bounds.getX()+bounds.getWidth() + 8),(float) bounds.getY() - 8),
                        location
                });
        annotation.setColor(new PdfRGBColor(Color.YELLOW));
        annotation.setFlags(PdfAnnotationFlags.Locked);
        annotation.setFont(font);
        annotation.setLineEndingStyle(PdfLineEndingStyle.OpenArrow);
        annotation.setMarkupText("Just a joke.");
        annotation.setOpacity(0.75f);
        annotation.setTextMarkupColor(new PdfRGBColor(Color.GREEN));
        ((PdfNewPage) page).getAnnotations().add(annotation);
        y = (float) bounds.getY()+(float) bounds.getHeight();

        return y;
    }

    static float addLineAnnotation(PdfPageBase page, float y) {
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial",0,12));
        PdfStringFormat format = new PdfStringFormat();
        format.setMeasureTrailingSpaces(true);
        String prompt = "Line Annotation: ";
        Dimension2D size = font.measureString(prompt);

        page.getCanvas().drawString(prompt, font, PdfBrushes.getDodgerBlue(), 0, y);
        float x = (float)font.measureString(prompt, format).getWidth();

        String label = "Line Annotation";
        size = font.measureString(label);
        page.getCanvas().drawString(label, font, PdfBrushes.getOrangeRed(), x, y);
        Rectangle2D.Float bounds = new Rectangle2D.Float(x, y, (float)size.getWidth(), (float)size.getHeight());
        int[] linePoints = new int[]{(int) bounds.getX(), (int) bounds.getY(), (int)bounds.getX()+(int) bounds.getWidth(), (int)bounds.getY ()+(int) bounds.getHeight()};
        PdfLineAnnotation annotation = new PdfLineAnnotation(linePoints, "Annotation");
        annotation.setBeginLineStyle(PdfLineEndingStyle.ClosedArrow);
        annotation.setEndLineStyle(PdfLineEndingStyle.ClosedArrow);
        annotation.setLineCaption(true);
        annotation.setBackColor(new PdfRGBColor(Color.BLACK));
        annotation.setCaptionType(PdfLineCaptionType.Inline);
        ((PdfNewPage) page).getAnnotations().add(annotation);
        y = (float) bounds.getY()+(float) bounds.getHeight();
        return y;
    }

    static float addTextMarkupAnnotation(PdfPageBase page, float y) {
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial",0,12));
        PdfStringFormat format = new PdfStringFormat();
        format.setMeasureTrailingSpaces(true);
        String prompt = "Highlight incorrect spelling: ";
        Dimension2D size = font.measureString(prompt, format);
        page.getCanvas().drawString(prompt, font, PdfBrushes.getDodgerBlue(), 0, y);
        float x = (float)size.getWidth();

        String label = "demo of annotation";
        page.getCanvas().drawString(label, font, PdfBrushes.getOrangeRed(), x, y);
        size = font.measureString("demo of ", format);
        x = x + (float)size.getWidth();
        Point2D.Float incorrectWordLocation = new Point2D.Float(x, y);
        String markupText = "Should be 'annotation'";
        Rectangle2D aFloat = new Rectangle2D.Float(x, y, 100f, 100f);

        PdfTextMarkupAnnotation annotation = new PdfTextMarkupAnnotation(markupText, "anotation", aFloat, font);
        annotation.setTextMarkupAnnotationType(PdfTextMarkupAnnotationType.Highlight);
        annotation.setTextMarkupColor(new PdfRGBColor(new Color(	135,206,250)));
        ((PdfNewPage)page).getAnnotations().add(annotation);
        y = y + (float)size.getHeight();
        return y;
    }

    static float addPopupAnnotation(PdfPageBase page, float y) {
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial",0, 12));
        PdfStringFormat format = new PdfStringFormat();
        format.setMeasureTrailingSpaces(true);
        String prompt = "Markup incorrect spelling: ";
        Dimension2D size = font.measureString(prompt, format);
        page.getCanvas().drawString(prompt, font, PdfBrushes.getDodgerBlue(), 0, y);
        float x = (float)size.getWidth();

        String label = "demo of annotation";
        page.getCanvas().drawString(label, font, PdfBrushes.getOrangeRed(), x, y);
        x = x + (float)font.measureString(label, format).getWidth();
        String markupText = "All words were spelled correctly";
        size = font.measureString(markupText);
        Rectangle2D rectangle2D = new Rectangle.Float();
        rectangle2D.setFrame(new Point2D.Double(x,y),new Dimension());
        PdfPopupAnnotation annotation = new PdfPopupAnnotation(rectangle2D, markupText);
        annotation.setIcon(PdfPopupIcon.Paragraph);
        annotation.setOpen(true);
        annotation.setColor(new PdfRGBColor(Color.YELLOW));
        ((PdfNewPage) page).getAnnotations().add(annotation);
        y = y + (float)size.getHeight();
        return y;
    }

    static float addRubberStampAnnotation(PdfPageBase page, float y) {
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial", 0,12));
        PdfStringFormat format = new PdfStringFormat();
        format.setMeasureTrailingSpaces(true);
        String prompt = "Markup incorrect spelling: ";
        Dimension2D size = font.measureString(prompt, format);
        page.getCanvas().drawString(prompt, font, PdfBrushes.getDodgerBlue(), 0, y);
        float x = (float)size.getWidth();

        String label = "demo of annotation";
        page.getCanvas().drawString(label, font, PdfBrushes.getOrangeRed(), x, y);
        x = x + (float)font.measureString(label, format).getWidth();
        String markupText = "Just a draft, not checked.";
        size = font.measureString(markupText);
        PdfRubberStampAnnotation annotation = new PdfRubberStampAnnotation(new Rectangle2D.Float(x, y, font.getHeight(), font.getHeight()), markupText);
        annotation.setIcon(PdfRubberStampAnnotationIcon.Draft);
        annotation.setColor(new PdfRGBColor(new Color(221,160,221)));
        ((PdfNewPage)page ).getAnnotations().add(annotation);
        y = y + (float)size.getHeight();
        return y;
    }
}
