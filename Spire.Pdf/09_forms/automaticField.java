import com.spire.pdf.*;
import com.spire.pdf.automaticfields.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class automaticField {
    public static void main(String[] args) {
        // Create a new PDF document
        PdfDocument doc = new PdfDocument();

        // Set the author information for the document
        doc.getDocumentInformation().setAuthor("Spire.Pdf");

        // Initialize a unit converter for converting measurement units
        PdfUnitConvertor unitCvtr = new PdfUnitConvertor();

        // Define the page margins in centimeters and convert them to points
        PdfMargins margin = new PdfMargins();
        margin.setTop(unitCvtr.convertUnits(2.54f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
        margin.setBottom(margin.getTop());
        margin.setLeft(unitCvtr.convertUnits(3.17f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
        margin.setRight(margin.getLeft());

        // Add a section to the document
        PdfSection section = doc.getSections().add();

        // Set the page size and margins for the section
        section.getPageSettings().setSize(PdfPageSize.A4);
        section.getPageSettings().setMargins(margin);

        // Add a new page to the section
        PdfPageBase page = section.getPages().add();

        // Draw automatic fields on the page
        drawAutomaticField(page);

        // Save the document to a file named "output/automaticField.pdf"
        doc.saveToFile("output/automaticField.pdf");

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }

    static void drawAutomaticField(PdfPageBase page) {
        float y = 20;

        // Define the brush, font, and format for the title
        PdfBrush brush1 = PdfBrushes.getCadetBlue();
        PdfTrueTypeFont font1 = new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 16));
        PdfStringFormat format1 = new PdfStringFormat(PdfTextAlignment.Center);

        // Draw the title "Automatic Field List"
        page.getCanvas().drawString("Automatic Field List", font1, brush1, page.getCanvas().getClientSize().getWidth() / 2, y, format1);
        y = y + (float) font1.measureString("Automatic Field List", format1).getHeight();
        y = y + 15;

        // Define the list of field names
        String[] fieldList = new String[]{"DateTimeField", "CreationDateField", "DocumentAuthorField", "SectionNumberField", "SectionPageNumberField", "SectionPageCountField", "PageNumberField", "PageCountField", "DestinationPageNumberField", "CompositeField"};

        // Define the font and format for the field names
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial", 0, 12));
        PdfStringFormat fieldNameFormat = new PdfStringFormat();
        fieldNameFormat.setMeasureTrailingSpaces(true);

        // Iterate over each field name in the list
        for (String fieldName : fieldList) {
            // Prepare the text and draw the field name
            String text = String.format("%1$s: ", fieldName);
            page.getCanvas().drawString(text, font, PdfBrushes.getDodgerBlue(), 0, y);

            // Calculate the x position for the field bounds
            float x = (float) font.measureString(text, fieldNameFormat).getWidth();

            // Define the bounds for the field
            Rectangle2D bounds = new Rectangle2D.Float(x, y, 200, font.getHeight());

            // Draw the automatic field with the specified field name and bounds
            drawAutomaticField(fieldName, page, bounds);

            // Update the y position for the next field
            y = y + font.getHeight() + 8;
        }
    }


    static void drawAutomaticField(String fieldName, PdfPageBase page, Rectangle2D bounds) {
        // Create a TrueType font with Arial Italic style and font size 12
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial", Font.ITALIC, 12));

        // Define an orange-red brush color
        PdfBrush brush = PdfBrushes.getOrangeRed();

        // Set the string format for the field's text alignment and vertical alignment
        PdfStringFormat format = new PdfStringFormat(PdfTextAlignment.Left, PdfVerticalAlignment.Middle);

        // Check the field name and draw the corresponding automatic field
        if (fieldName.equals("DateTimeField")) {
            // Create a DateTime field
            PdfDateTimeField field = new PdfDateTimeField();
            field.setFont(font);
            field.setBrush(brush);
            field.setStringFormat(format);
            field.setBounds(bounds);
            field.setDateFormatString("yyyy-MM-dd HH:mm:ss");
            field.draw(page.getCanvas());
        }

        if (fieldName.equals("CreationDateField")) {
            // Create a Creation Date field
            PdfCreationDateField field = new PdfCreationDateField();
            field.setFont(font);
            field.setBrush(brush);
            field.setStringFormat(format);
            field.setBounds(bounds);
            field.setDateFormatString("yyyy-MM-dd HH:mm:ss");
            field.draw(page.getCanvas());
        }

        if (fieldName.equals("DocumentAuthorField")) {
            // Create a Document Author field
            PdfDocumentAuthorField field = new PdfDocumentAuthorField();
            field.setFont(font);
            field.setBrush(brush);
            field.setStringFormat(format);
            field.setBounds(bounds);
            field.draw(page.getCanvas());
        }

        if (fieldName.equals("SectionNumberField")) {
            // Create a Section Number field
            PdfSectionNumberField field = new PdfSectionNumberField();
            field.setFont(font);
            field.setBrush(brush);
            field.setStringFormat(format);
            field.setBounds(bounds);
            field.draw(page.getCanvas());
        }

        if (fieldName.equals("SectionPageNumberField")) {
            // Create a Section Page Number field
            PdfSectionPageNumberField field = new PdfSectionPageNumberField();
            field.setFont(font);
            field.setBrush(brush);
            field.setStringFormat(format);
            field.setBounds(bounds);
            field.draw(page.getCanvas());
        }

        if (fieldName.equals("SectionPageCountField")) {
            // Create a Section Page Count field
            PdfSectionPageCountField field = new PdfSectionPageCountField();
            field.setFont(font);
            field.setBrush(brush);
            field.setStringFormat(format);
            field.setBounds(bounds);
            field.draw(page.getCanvas());
        }

        if (fieldName.equals("PageNumberField")) {
            // Create a Page Number field
            PdfPageNumberField field = new PdfPageNumberField();
            field.setFont(font);
            field.setBrush(brush);
            field.setStringFormat(format);
            field.setBounds(bounds);
            field.draw(page.getCanvas());
        }

        if (fieldName.equals("PageCountField")) {
            // Create a Page Count field
            PdfPageCountField field = new PdfPageCountField();
            field.setFont(font);
            field.setBrush(brush);
            field.setStringFormat(format);
            field.setBounds(bounds);
            field.draw(page.getCanvas());
        }

        if (fieldName.equals("DestinationPageNumberField")) {
            // Create a Destination Page Number field
            PdfDestinationPageNumberField field = new PdfDestinationPageNumberField();
            field.setFont(font);
            field.setBrush(brush);
            field.setStringFormat(format);
            field.setBounds(bounds);
            // Set the page for the field (if it's a PdfNewPage)
            field.setPage((PdfNewPage) ((page instanceof PdfNewPage) ? page : null));
            field.draw(page.getCanvas());
        }

        if (fieldName.equals("CompositeField")) {
            // Create a Composite Field by combining multiple automatic fields
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
