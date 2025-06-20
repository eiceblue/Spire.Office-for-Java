import com.spire.pdf.*;
import com.spire.pdf.barcode.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.util.EnumSet;

public class drawBarcode {
    public static void main(String[] args) {
        // Create a PDF document
        PdfDocument doc = new PdfDocument();

        // Set the compression level of the PDF document to None
        doc.setCompressionLevel(PdfCompressionLevel.None);

        // Create a unit converter for converting measurement units
        PdfUnitConvertor unitCvtr = new PdfUnitConvertor();

        // Set the margins of the page
        PdfMargins margin = new PdfMargins();
        margin.setTop(unitCvtr.convertUnits(2.54f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
        margin.setBottom(margin.getTop());
        margin.setLeft(unitCvtr.convertUnits(3.17f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
        margin.setRight(margin.getLeft());

        // Add a section to the document
        PdfSection section = doc.getSections().add();

        // Set the margins of the section's pages
        section.getPageSettings().setMargins(margin);

        // Set the size of the section's pages to A4
        section.getPageSettings().setSize(PdfPageSize.A4);

        // Add a page to the section
        PdfPageBase page = section.getPages().add();
        double y = 15;

        // Set the font for the barcode text
        PdfFont font1 = new PdfFont(PdfFontFamily.Helvetica, 12, EnumSet.of(PdfFontStyle.Bold));

        // Create a Dimension object for the rectangle
        Dimension rctg = new Dimension();

        // Set the size of the rectangle to match the page's canvas size
        rctg.setSize(page.getCanvas().getClientSize());

        // Create a PdfTextWidget for the "Codebar:" text
        PdfTextWidget text = new PdfTextWidget();
        text.setFont(font1);
        text.setText("Codebar:");

        // Draw the text on the page at coordinates (0, y) and obtain the layout result
        PdfLayoutResult result = text.draw(page, 0, y);

        // Update the current page and y-coordinate position for further elements
        page = result.getPage();
        y = (float)(result.getBounds().getY() + result.getBounds().getHeight() + 2);

        // Create a Codabar barcode with the given value ("00:12-3456/7890")
        PdfCodabarBarcode barcode1 = new PdfCodabarBarcode("00:12-3456/7890");

        // Set the height of the gap between the barcode and the text
        barcode1.setBarcodeToTextGapHeight(1f);

        // Enable the check digit for the barcode
        barcode1.setEnableCheckDigit(true);

        // Show the check digit in the barcode
        barcode1.setShowCheckDigit(true);

        // Set the location of the displayed text in the barcode to the bottom
        barcode1.setTextDisplayLocation(TextLocation.Bottom);

        // Set the text color of the barcode to blue
        PdfRGBColor blue = new PdfRGBColor(Color.blue);
        barcode1.setTextColor(blue);

        // Set the location of the barcode on the page
        Point2D.Float point = new Point2D.Float();
        point.setLocation(0, y);

        // Draw the barcode on the page
        barcode1.draw(page, point);
        y = barcode1.getBounds().getY() + barcode1.getBounds().getHeight() + 5;


        // Update the text content to "Code11:"
        text.setText("Code11:");

        // Draw the updated text on the page at coordinates (0, y) and obtain the layout result
        result = text.draw(page, 0, y);

        // Update the current page and y-coordinate position for further elements
        page = result.getPage();
        y = (float)(result.getBounds().getY() + result.getBounds().getHeight() + 2);

        // Create a Code11 barcode with the given value ("123-4567890")
        PdfCode11Barcode barcode2 = new PdfCode11Barcode("123-4567890");

        // Set the height of the gap between the barcode and the text
        barcode2.setBarcodeToTextGapHeight(1f);

        // Set the location of the displayed text in the barcode to the bottom
        barcode2.setTextDisplayLocation(TextLocation.Bottom);

        // Set the text color of the barcode to blue
        barcode2.setTextColor(blue);

        // Update the location of the barcode on the page
        point.setLocation(point.x, y);

        // Draw the barcode on the page using the updated location
        barcode2.draw(page, point);

        // Update the y-coordinate position for further element placement
        y = (float)(barcode2.getBounds().getY() + barcode2.getBounds().getHeight() + 5);


        // Update the text content to "Code128-A:"
        text.setText("Code128-A:");

        // Draw the updated text on the page at coordinates (0, y) and obtain the layout result
        result = text.draw(page, 0, y);

        // Update the current page and y-coordinate position for further elements
        page = result.getPage();
        y = (float)(result.getBounds().getY() + result.getBounds().getHeight() + 2);

        // Create a Code128-A barcode with the given value ("HELLO 00-123")
        PdfCode128ABarcode barcode3 = new PdfCode128ABarcode("HELLO 00-123");

        // Set the height of the gap between the barcode and the text
        barcode3.setBarcodeToTextGapHeight(1f);

        // Set the location of the displayed text in the barcode to the bottom
        barcode3.setTextDisplayLocation(TextLocation.Bottom);

        // Set the text color of the barcode to blue
        barcode3.setTextColor(blue);

        // Update the location of the barcode on the page
        point.setLocation(point.x, y);

        // Draw the barcode on the page using the updated location
        barcode3.draw(page, point);

        // Update the y-coordinate position for further element placement
        y = (float)(barcode3.getBounds().getY() + barcode3.getBounds().getHeight() + 5);

        // Update the text content to "Code128-B:"
        text.setText("Code128-B:");

        // Draw the updated text on the page at coordinates (0, y) and obtain the layout result
        result = text.draw(page, 0, y);

        // Update the current page and y-coordinate position for further elements
        page = result.getPage();
        y = (float)(result.getBounds().getY() + result.getBounds().getHeight() + 2);

        // Create a Code128-B barcode with the given value ("Hello 00-123")
        PdfCode128BBarcode barcode4 = new PdfCode128BBarcode("Hello 00-123");

        // Set the height of the gap between the barcode and the text
        barcode4.setBarcodeToTextGapHeight(1f);

        // Set the location of the displayed text in the barcode to the bottom
        barcode4.setTextDisplayLocation(TextLocation.Bottom);

        // Set the text color of the barcode to blue
        barcode4.setTextColor(blue);

        // Update the location of the barcode on the page
        point.setLocation(point.x, y);

        // Draw the barcode on the page using the updated location
        barcode4.draw(page, point);

        // Update the y-coordinate position for further element placement
        y = (float)(barcode4.getBounds().getY() + barcode4.getBounds().getHeight() + 5);

        // Update the text content to "Code32:"
        text.setText("Code32:");

        // Draw the updated text on the page at coordinates (0, y) and obtain the layout result
        result = text.draw(page, 0, y);

        // Update the current page and y-coordinate position for further elements
        page = result.getPage();
        y = (float)(result.getBounds().getY() + result.getBounds().getHeight() + 2);

        // Create a Code32 barcode with the given value ("16273849")
        PdfCode32Barcode barcode5 = new PdfCode32Barcode("16273849");

        // Set the height of the gap between the barcode and the text
        barcode5.setBarcodeToTextGapHeight(1f);

        // Set the location of the displayed text in the barcode to the bottom
        barcode5.setTextDisplayLocation(TextLocation.Bottom);

        // Set the text color of the barcode to blue
        barcode5.setTextColor(blue);

        // Update the location of the barcode on the page
        point.setLocation(point.x, y);

        // Draw the barcode on the page using the updated location
        barcode5.draw(page, point);

        // Update the y-coordinate position for further element placement
        y = (float)(barcode5.getBounds().getY() + barcode5.getBounds().getHeight() + 5);

        // Create a new page for further elements and reset y-coordinate position
        page = section.getPages().add();
        y = 10;


        // Update the text content to "Code39:"
        text.setText("Code39:");

        // Draw the updated text on the page at coordinates (0, y) and obtain the layout result
        result = text.draw(page, 0, y);

        // Update the current page and y-coordinate position for further elements
        page = result.getPage();
        y = (float)(result.getBounds().getY() + result.getBounds().getHeight() + 2);

        // Create a Code39 barcode with the given value ("16-273849")
        PdfCode39Barcode barcode6 = new PdfCode39Barcode("16-273849");

        // Set the height of the gap between the barcode and the text
        barcode6.setBarcodeToTextGapHeight(1f);

        // Set the location of the displayed text in the barcode to the bottom
        barcode6.setTextDisplayLocation(TextLocation.Bottom);

        // Set the text color of the barcode to blue
        barcode6.setTextColor(blue);

        // Update the location of the barcode on the page
        point.setLocation(point.x, y);

        // Draw the barcode on the page using the updated location
        barcode6.draw(page, point);

        // Update the y-coordinate position for further element placement
        y = (float)(barcode6.getBounds().getY() + barcode6.getBounds().getHeight() + 5);

        // Update the text content to "Code39-E:"
        text.setText("Code39-E:");

        // Draw the updated text on the page at coordinates (0, y) and obtain the layout result
        result = text.draw(page, 0, y);

        // Update the current page and y-coordinate position for further elements
        page = result.getPage();
        y = (float)(result.getBounds().getY() + result.getBounds().getHeight() + 2);

        // Create a Code39 Extended barcode with the given value ("16-273849")
        PdfCode39ExtendedBarcode barcode7 = new PdfCode39ExtendedBarcode("16-273849");

        // Set the height of the gap between the barcode and the text
        barcode7.setBarcodeToTextGapHeight(1f);

        // Set the location of the displayed text in the barcode to the bottom
        barcode7.setTextDisplayLocation(TextLocation.Bottom);

        // Set the text color of the barcode to blue
        barcode7.setTextColor(blue);

        // Update the location of the barcode on the page
        point.setLocation(point.x, y);

        // Draw the barcode on the page using the updated location
        barcode7.draw(page, point);

        // Update the y-coordinate position for further element placement
        y = (float)(barcode7.getBounds().getY() + barcode7.getBounds().getHeight() + 5);

        // Update the text content to "Code93:"
        text.setText("Code93:");

        // Draw the updated text on the page at coordinates (0, y) and obtain the layout result
        result = text.draw(page, 0, y);

        // Update the current page and y-coordinate position for further elements
        page = result.getPage();
        y = (float)(result.getBounds().getY() + result.getBounds().getHeight() + 2);

        // Create a Code93 barcode with the given value ("16-273849")
        PdfCode93Barcode barcode8 = new PdfCode93Barcode("16-273849");

        // Set the height of the gap between the barcode and the text
        barcode8.setBarcodeToTextGapHeight(1f);

        // Set the location of the displayed text in the barcode to the bottom
        barcode8.setTextDisplayLocation(TextLocation.Bottom);

        // Set the text color of the barcode to blue
        barcode8.setTextColor(blue);

        // Set the bottom quiet zone height of the barcode to 5 units
        barcode8.getQuietZone().setBottom(5);

        // Update the location of the barcode on the page
        point.setLocation(point.x, y);

        // Draw the barcode on the page using the updated location
        barcode8.draw(page, point);

        // Update the y-coordinate position for further element placement
        y = (float)(barcode8.getBounds().getY() + barcode8.getBounds().getHeight() + 5);

        // Update the text content to "Code93-E:"
        text.setText("Code93-E:");

        // Draw the updated text on the page at coordinates (0, y) and obtain the layout result
        result = text.draw(page, 0, y);

        // Update the current page and y-coordinate position for further elements
        page = result.getPage();
        y = (float)(result.getBounds().getY() + result.getBounds().getHeight() + 2);

        // Create a Code93 Extended barcode with the given value ("16-273849")
        PdfCode93ExtendedBarcode barcode9 = new PdfCode93ExtendedBarcode("16-273849");

        // Set the height of the gap between the barcode and the text
        barcode9.setBarcodeToTextGapHeight(1f);

        // Set the location of the displayed text in the barcode to the bottom
        barcode9.setTextDisplayLocation(TextLocation.Bottom);

        // Set the text color of the barcode to blue
        barcode9.setTextColor(blue);

        // Update the location of the barcode on the page
        point.setLocation(point.x, y);

        // Draw the barcode on the page using the updated location
        barcode9.draw(page, point);

        // Save pdf file.
        doc.saveToFile("output/drawBarcode.pdf");

        // Close the PDF document
        doc.close();

        // Dispose of the PDF document (frees up system resources)
        doc.dispose();
    }
}
