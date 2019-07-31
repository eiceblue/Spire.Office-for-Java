import com.spire.pdf.*;
import com.spire.pdf.automaticfields.*;
import com.spire.pdf.graphics.*;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class automaticField {
    public static void main(String[] args) {
        PdfDocument doc = new PdfDocument();
        doc.getDocumentInformation().setAuthor("Spire.Pdf");

        //Set the margin
        PdfUnitConvertor unitCvtr = new PdfUnitConvertor();
        PdfMargins margin = new PdfMargins();
        margin.setTop(unitCvtr.convertUnits(2.54f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
        margin.setBottom(margin.getTop());
        margin.setLeft(unitCvtr.convertUnits(3.17f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
        margin.setRight(margin.getLeft());

        //Create section
        PdfSection section = doc.getSections().add();
        section.getPageSettings().setSize(PdfPageSize.A4);
        section.getPageSettings().setMargins(margin);

        //Create one page
        PdfPageBase page = section.getPages().add();

        //Draw automatic fields
        drawAutomaticField(page);

        doc.saveToFile("output/automaticField.pdf");
        doc.close();
    }

    static void drawAutomaticField(PdfPageBase page) {
        float y = 20;

        //Title
        PdfBrush brush1 = PdfBrushes.getCadetBlue();
        PdfTrueTypeFont font1 = new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 16));
        PdfStringFormat format1 = new PdfStringFormat(PdfTextAlignment.Center);
        page.getCanvas().drawString("Automatic Field List", font1, brush1, page.getCanvas().getClientSize().getWidth() / 2, y, format1);
        y = y + (float) font1.measureString("Automatic Field List", format1).getHeight();
        y = y + 15;

        String[] fieldList = new String[]{"DateTimeField", "CreationDateField", "DocumentAuthorField", "SectionNumberField", "SectionPageNumberField", "SectionPageCountField", "PageNumberField", "PageCountField", "DestinationPageNumberField", "CompositeField"};
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial", 0, 12));
        PdfStringFormat fieldNameFormat = new PdfStringFormat();
        fieldNameFormat.setMeasureTrailingSpaces(true);
        for (String fieldName : fieldList) {
            //Draw field name
            String text = String.format("%1$s: ", fieldName);
            page.getCanvas().drawString(text, font, PdfBrushes.getDodgerBlue(), 0, y);
            float x = (float) font.measureString(text, fieldNameFormat).getWidth();
            Rectangle2D bounds = new Rectangle2D.Float(x, y, 200, font.getHeight());
            drawAutomaticField(fieldName, page, bounds);
            y = y + font.getHeight() + 8;
        }
    }

    static void drawAutomaticField(String fieldName, PdfPageBase page, Rectangle2D bounds) {
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial", Font.ITALIC, 12));
        PdfBrush brush = PdfBrushes.getOrangeRed();
        PdfStringFormat format = new PdfStringFormat(PdfTextAlignment.Left, PdfVerticalAlignment.Middle);

        if (fieldName.equals("DateTimeField")) {
            PdfDateTimeField field = new PdfDateTimeField();
            field.setFont(font);
            field.setBrush(brush);
            field.setStringFormat(format);
            field.setBounds(bounds);
            field.setDateFormatString("yyyy-MM-dd HH:mm:ss");
            field.draw(page.getCanvas());
        }

        if (fieldName.equals("CreationDateField")) {
            PdfCreationDateField field = new PdfCreationDateField();
            field.setFont(font);
            field.setBrush(brush);
            field.setStringFormat(format);
            field.setBounds(bounds);
            field.setDateFormatString("yyyy-MM-dd HH:mm:ss");
            field.draw(page.getCanvas());
        }

        if (fieldName.equals("DocumentAuthorField")) {
            PdfDocumentAuthorField field = new PdfDocumentAuthorField();
            field.setFont(font);
            field.setBrush(brush);
            field.setStringFormat(format);
            field.setBounds(bounds);
            field.draw(page.getCanvas());
        }

        if (fieldName.equals("SectionNumberField")) {
            PdfSectionNumberField field = new PdfSectionNumberField();
            field.setFont(font);
            field.setBrush(brush);
            field.setStringFormat(format);
            field.setBounds(bounds);
            field.draw(page.getCanvas());
        }

        if (fieldName.equals("SectionPageNumberField")) {
            PdfSectionPageNumberField field = new PdfSectionPageNumberField();
            field.setFont(font);
            field.setBrush(brush);
            field.setStringFormat(format);
            field.setBounds(bounds);
            field.draw(page.getCanvas());
        }

        if (fieldName.equals("SectionPageCountField")) {
            PdfSectionPageCountField field = new PdfSectionPageCountField();
            field.setFont(font);
            field.setBrush(brush);
            field.setStringFormat(format);
            field.setBounds(bounds);
            field.draw(page.getCanvas());
        }

        if (fieldName.equals("PageNumberField")) {
            PdfPageNumberField field = new PdfPageNumberField();
            field.setFont(font);
            field.setBrush(brush);
            field.setStringFormat(format);
            field.setBounds(bounds);
            field.draw(page.getCanvas());
        }

        if (fieldName.equals("PageCountField")) {
            PdfPageCountField field = new PdfPageCountField();
            field.setFont(font);
            field.setBrush(brush);
            field.setStringFormat(format);
            field.setBounds(bounds);
            field.draw(page.getCanvas());
        }

        if (fieldName.equals("DestinationPageNumberField")) {
            PdfDestinationPageNumberField field = new PdfDestinationPageNumberField();
            field.setFont(font);
            field.setBrush(brush);
            field.setStringFormat(format);
            field.setBounds(bounds);
            field.setPage((PdfNewPage) ((page instanceof PdfNewPage) ? page : null));
            field.draw(page.getCanvas());
        }

        if (fieldName.equals("CompositeField")) {
            PdfSectionPageNumberField field1 = new PdfSectionPageNumberField();
            field1.setNumberStyle(PdfNumberStyle.Lower_Roman);
            PdfSectionPageCountField field2 = new PdfSectionPageCountField();
            PdfCompositeField fields = new PdfCompositeField();
            fields.setFont(font);
            fields.setBrush(brush);
            fields.setStringFormat(format);
            fields.setBounds(bounds);
            fields.setAutomaticFields(new PdfAutomaticField[]{field1, field2});
            fields.setText("section page {0} of {1}");
            fields.draw(page.getCanvas());
        }
    }
}
