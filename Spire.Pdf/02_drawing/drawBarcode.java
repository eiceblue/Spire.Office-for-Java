import com.spire.pdf.*;
import com.spire.pdf.barcode.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.util.*;

public class drawBarcode {
    public static void main(String[] args) {
        // Create a pdf document
        PdfDocument doc = new PdfDocument();
        // Compression level
        doc.setCompressionLevel(PdfCompressionLevel.None);
        // Set margin
        PdfUnitConvertor unitCvtr = new PdfUnitConvertor();
        PdfMargins margin = new PdfMargins();
        margin.setTop(unitCvtr.convertUnits(2.54f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
        margin.setBottom(margin.getTop());
        margin.setLeft(unitCvtr.convertUnits(3.17f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
        margin.setRight(margin.getLeft());
        // Create section
        PdfSection section = doc.getSections().add();
        section.getPageSettings().setMargins(margin);
        section.getPageSettings().setSize(PdfPageSize.A4);
        // Create one page
        PdfPageBase page = section.getPages().add();
        double y = 15;
        PdfFont font1 = new PdfFont(PdfFontFamily.Helvetica, 12, EnumSet.of(PdfFontStyle.Bold));
        Dimension rctg = new Dimension();
        rctg.setSize(page.getCanvas().getClientSize());
        // Draw CodabarBarcode
        PdfTextWidget text = new PdfTextWidget();
        text.setFont(font1);
        text.setText("Codebar:");
        PdfLayoutResult result = text.draw(page, 0, y);
        page = result.getPage();
        y =(float)(result.getBounds().getY()+ result.getBounds().getHeight() + 2);
        PdfCodabarBarcode barcode1 = new PdfCodabarBarcode("00:12-3456/7890");
        barcode1.setBarcodeToTextGapHeight(1f);
        barcode1.setEnableCheckDigit(true);
        barcode1.setShowCheckDigit(true);
        barcode1.setTextDisplayLocation(TextLocation.Bottom);
        PdfRGBColor blue = new PdfRGBColor(Color.blue);
        barcode1.setTextColor(blue);
        Point2D.Float point = new Point2D.Float();
        point.setLocation(0,y);
        barcode1.draw(page, point);
        y = barcode1.getBounds().getY()+ barcode1.getBounds().getHeight() + 5;
        // Draw Code11 drawBarcode
        text.setText("Code11:");
        result = text.draw(page, 0, y);
        page = result.getPage();
        y =result.getBounds().getY()+ result.getBounds().getHeight() + 2;
        PdfCode11Barcode barcode2 = new PdfCode11Barcode("123-4567890");
        barcode2.setBarcodeToTextGapHeight(1f);
        barcode2.setTextDisplayLocation(TextLocation.Bottom);
        barcode2.setTextColor(blue);
        point.setLocation(point.x,y);
        barcode2.draw(page, point);
        y =barcode2.getBounds().getY()+ barcode2.getBounds().getHeight() + 5;
        // Draw Code128-A drawBarcode
        text.setText("Code128-A:");
        result = text.draw(page, 0, y);
        page = result.getPage();
        y =result.getBounds().getY()+ result.getBounds().getHeight() + 2;
        PdfCode128ABarcode barcode3 = new PdfCode128ABarcode("HELLO 00-123");
        barcode3.setBarcodeToTextGapHeight(1f);
        barcode3.setTextDisplayLocation(TextLocation.Bottom);
        barcode3.setTextColor(blue);
        point.setLocation(point.x,y);
        barcode3.draw(page, point);
        y =barcode3.getBounds().getY()+ barcode3.getBounds().getHeight() + 5;
        // Draw Code128-B drawBarcode
        text.setText("Code128-B:");
        result = text.draw(page, 0, y);
        page = result.getPage();
        y =result.getBounds().getY()+ result.getBounds().getHeight() + 2;
        PdfCode128BBarcode barcode4 = new PdfCode128BBarcode("Hello 00-123");
        barcode4.setBarcodeToTextGapHeight(1f);
        barcode4.setTextDisplayLocation(TextLocation.Bottom);
        barcode4.setTextColor(blue);
        point.setLocation(point.x,y);
        barcode4.draw(page, point);
        y =barcode4.getBounds().getY()+ barcode4.getBounds().getHeight() + 5;
        // Draw Code32 drawBarcode
        text.setText("Code32:");
        result = text.draw(page, 0, y);
        page = result.getPage();
        y =result.getBounds().getY()+ result.getBounds().getHeight() + 2;
        PdfCode32Barcode barcode5 = new PdfCode32Barcode("16273849");
        barcode5.setBarcodeToTextGapHeight(1f);
        barcode5.setTextDisplayLocation(TextLocation.Bottom);
        barcode5.setTextColor(blue);
        point.setLocation(point.x,y);
        barcode5.draw(page, point);
        y =barcode5.getBounds().getY()+ barcode5.getBounds().getHeight() + 5;
        page = section.getPages().add();
        y = 10;
        // Draw Code39 drawBarcode
        text.setText("Code39:");
        result = text.draw(page, 0, y);
        page = result.getPage();
        y =result.getBounds().getY()+ result.getBounds().getHeight() + 2;
        PdfCode39Barcode barcode6 = new PdfCode39Barcode("16-273849");
        barcode6.setBarcodeToTextGapHeight(1f);
        barcode6.setTextDisplayLocation(TextLocation.Bottom);
        barcode6.setTextColor(blue);
        point.setLocation(point.x,y);
        barcode6.draw(page, point);
        y =barcode6.getBounds().getY()+ barcode6.getBounds().getHeight() + 5;
        // Draw Code39-E drawBarcode
        text.setText("Code39-E:");
        result = text.draw(page, 0, y);
        page = result.getPage();
        y =result.getBounds().getY()+ result.getBounds().getHeight() + 2;
        PdfCode39ExtendedBarcode barcode7 = new PdfCode39ExtendedBarcode("16-273849");
        barcode7.setBarcodeToTextGapHeight(1f);
        barcode7.setTextDisplayLocation(TextLocation.Bottom);
        barcode7.setTextColor(blue);
        point.setLocation(point.x,y);
        barcode7.draw(page, point);
        y =barcode7.getBounds().getY()+ barcode7.getBounds().getHeight() + 5;
        // Draw Code93 drawBarcode
        text.setText("Code93:");
        result = text.draw(page, 0, y);
        page = result.getPage();
        y =result.getBounds().getY()+ result.getBounds().getHeight() + 2;
        PdfCode93Barcode barcode8 = new PdfCode93Barcode("16-273849");
        barcode8.setBarcodeToTextGapHeight(1f);
        barcode8.setTextDisplayLocation(TextLocation.Bottom);
        barcode8.setTextColor(blue);
        barcode8.getQuietZone().setBottom(5);
        point.setLocation(point.x,y);
        barcode8.draw(page, point);
        y =barcode8.getBounds().getY()+ barcode8.getBounds().getHeight() + 5;
        // Draw Code93-E drawBarcode
        text.setText("Code93-E:");
        result = text.draw(page, 0, y);
        page = result.getPage();
        y =result.getBounds().getY()+ result.getBounds().getHeight() + 2;
        PdfCode93ExtendedBarcode barcode9 = new PdfCode93ExtendedBarcode("16-273849");
        barcode9.setBarcodeToTextGapHeight(1f);
        barcode9.setTextDisplayLocation(TextLocation.Bottom);
        barcode9.setTextColor(blue);
        point.setLocation(point.x,y);
        barcode9.draw(page, point);
        y =barcode9.getBounds().getY()+ barcode9.getBounds().getHeight() + 5;
        // Save pdf file.
        doc.saveToFile("output/drawBarcode.pdf");
    }

}
