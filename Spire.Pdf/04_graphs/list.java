import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import com.spire.pdf.lists.*;
import java.awt.*;
import java.awt.geom.*;

public class list {
    public static void main(String[] args) {
        // Create a new PdfDocument
        PdfDocument doc = new PdfDocument();

        // Create a PdfUnitConvertor to convert units of measurement
        PdfUnitConvertor unitCvtr = new PdfUnitConvertor();

        // Create a new PdfMargins object
        PdfMargins margin = new PdfMargins();

        // Set the top margin by converting 2.54 centimeters to points using the PdfUnitConvertor
        margin.setTop(unitCvtr.convertUnits(2.54f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));

        // Set the bottom margin equal to the top margin
        margin.setBottom(margin.getTop());

        // Set the left margin by converting 3.17 centimeters to points using the PdfUnitConvertor
        margin.setLeft(unitCvtr.convertUnits(3.17f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));

        // Set the right margin equal to the left margin
        margin.setRight(margin.getLeft());

        // Add a new page to the document with specified page size and margins
        PdfPageBase page = doc.getPages().add(PdfPageSize.A4, margin);

        // Set the initial y-coordinate for drawing content on the page
        float y = 10;

        // Define the brush and font for drawing text
        PdfBrush brush1 = PdfBrushes.getBlack();
        PdfTrueTypeFont font1 = new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 16), true);

        // Create a PdfStringFormat for text alignment
        PdfStringFormat format1 = new PdfStringFormat(PdfTextAlignment.Center);

        // Draw the text "Categories List" at the center of the page
        page.getCanvas().drawString("Categories List", font1, brush1, page.getCanvas().getClientSize().getWidth() / 2, y, format1);


        // Update the y-coordinate for the next drawing operation by adding the height of the "Categories List" text and a 5-point spacing
        y = y + (float) font1.measureString("Categories List", format1).getHeight();
        y = y + 5;

        // Create a Rectangle2D object representing the entire canvas area
        Rectangle2D rctg = new Rectangle2D.Float();
        rctg.setFrame(new Point(0, 0), page.getCanvas().getClientSize());

        // Create a linear gradient brush with specified colors and gradient mode
        PdfLinearGradientBrush brush = new PdfLinearGradientBrush(rctg,
                new PdfRGBColor(new PdfRGBColor(new Color(0,0,128))),
                new PdfRGBColor(new Color(255,69,0)),
                PdfLinearGradientMode.Vertical);

        // Create a PdfFont object for the list items
        PdfFont font = new PdfFont(PdfFontFamily.Helvetica, 12f, PdfFontStyle.Bold);

        // Define the formatted string with line breaks for each item
        String formatted = "Beverages\nCondiments\nConfections\nDairy Products\nGrains/Cereals\nMeat/Poultry\nProduce\nSeafood";

        // Create a unordered list object with the specified formatting.
        PdfListBase list = new PdfUnorderedList(formatted);

        // Set the font for the list items.
        list.setFont(font);

        // Set the left indent for the list.
        list.setIndent(8);

        // Set the indentation for the text within each list item.
        list.setTextIndent(5);

        // Set the brush (color) for the list items.
        list.setBrush(brush);

        // Draw the unordered list on the page and get the layout result
        PdfLayoutResult result = list.draw(page, 0, y);

        // Update the y-coordinate for the next drawing operation based on the layout result
        y = (float) (result.getBounds().getHeight() + result.getBounds().getY());

        // Create a sorted list object with the same formatted string
        PdfSortedList sortedList = new PdfSortedList(formatted);

        // Set the font for the list items.
        sortedList.setFont(font);

        // Set the left indent for the list.
        sortedList.setIndent(8);

        // Set the indentation for the text within each list item.
        sortedList.setTextIndent(5);

        // Set the brush (color) for the list items.
        sortedList.setBrush(brush);

        // Draw the sorted list on the page and get the layout result
        PdfLayoutResult result2 = sortedList.draw(page, 0, y);

        // Update the y-coordinate again based on the layout result of the sorted list
        y = (float) (result2.getBounds().getHeight() + result2.getBounds().getY());

        // Create an ordered marker for the list items using lower Roman numerals
        PdfOrderedMarker marker1 = new PdfOrderedMarker(PdfNumberStyle.Lower_Roman, new PdfFont(PdfFontFamily.Helvetica, 12f));

        // Create another sorted list object with the same formatted string and the ordered marker
        PdfSortedList list2 = new PdfSortedList(formatted);

        // Set the font for the list items.
        list2.setFont(font);

        // Set the marker for the list items.
        list2.setMarker(marker1);

        // Set the left indent for the list.
        list2.setIndent(8);

        // Set the indentation for the text within each list item.
        list2.setTextIndent(5);

        // Set the brush (color) for the list items.
        list2.setBrush(brush);

        // Draw the list with ordered markers on the page and get the layout result
        PdfLayoutResult result3 = list2.draw(page, 0, y);

        // Update the y-coordinate once again based on the layout result of the list with ordered markers
        y = (float) (result3.getBounds().getHeight() + result3.getBounds().getY());

        // Create an ordered marker for the list items using lower Latin letters
        PdfOrderedMarker marker2 = new PdfOrderedMarker(PdfNumberStyle.Lower_Latin, new PdfFont(PdfFontFamily.Helvetica, 12f));

        // Create a new sorted list object with the same formatted string and the new ordered marker
        PdfSortedList list3 = new PdfSortedList(formatted);

        // Set the font for the list items.
        list3.setFont(font);

        // Set the marker for the list items.
        list3.setMarker(marker2);

        // Set the left indent for the list.
        list3.setIndent(8);

        // Set the indentation for the text within each list item.
        list3.setTextIndent(5);

        // Set the brush (color) for the list items.
        list3.setBrush(brush);
        
        // Draw the final list with ordered markers on the page
        list3.draw(page, 0, y);

        // Save the file 
        doc.saveToFile("output/list.pdf");
        
        // Close the PDF document
        doc.close();
        
        // Dispose of the PDF document (frees up system resources)
        doc.dispose();
    }
}
