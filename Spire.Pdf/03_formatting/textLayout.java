import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.io.File;
import java.awt.*;
import java.util.EnumSet;
import java.awt.geom.*;

public class textLayout {
    public static void main(String[] args) {
        PdfDocument doc = new PdfDocument();
        // Create one page
        PdfPageBase page = doc.getPages().add();
        double pageWidth = page.getCanvas().getClientSize().getWidth();
        double y = 0;
        // Page header
        PdfRGBColor lightGray = new PdfRGBColor(new Color(211,211,211));
        PdfPen pen1 = new PdfPen(lightGray, 1f);
        PdfBrush brush1 = new PdfSolidBrush(lightGray);
        PdfFont font1 = new PdfFont(PdfFontFamily.Helvetica, 8, EnumSet.of(PdfFontStyle.Bold));
        PdfStringFormat format1 = new PdfStringFormat(PdfTextAlignment.Right);
        String text = "Demo of Spire.pdf";
        page.getCanvas().drawString(text, font1, brush1, pageWidth, y, format1);
        Dimension2D size = font1.measureString(text, format1);
        y = y + size.getHeight() + 1;
        page.getCanvas().drawLine(pen1, 0, y, pageWidth, y);
        // Title
        y = y + 5;
        PdfBrush brush2 = PdfBrushes.getBlack();
        PdfFont font2 = new PdfFont(PdfFontFamily.Helvetica, 16, EnumSet.of(PdfFontStyle.Bold));
        PdfStringFormat format2 = new PdfStringFormat(PdfTextAlignment.Center);
        format2.setCharacterSpacing(1f);
        text = "Summary of Science";
        page.getCanvas().drawString(text, font2, brush2, pageWidth / 2, y,
                format2);
        size = font2.measureString(text, format2);
        y = y + size.getHeight() + 6;
        // Icon
        PdfImage image = PdfImage.fromFile("data/Wikipedia_Science.png");
        Point2D.Float point1 = new Point2D.Float();
        point1.setLocation(pageWidth - image.getPhysicalDimension().getWidth(),y);

        page.getCanvas().drawImage(image, point1);
        double imageLeftSpace = pageWidth - image.getPhysicalDimension().getWidth() - 2;
        double imageBottom = image.getPhysicalDimension().getHeight() + y;

        PdfFont font3 = new PdfFont(PdfFontFamily.Helvetica, 9);
        PdfStringFormat format3 = new PdfStringFormat();
        format3.setParagraphIndent(font3.getSize() * 2);
        format3.setMeasureTrailingSpaces(true);
        format3.setLineSpacing(font3.getSize() * 1.5f);
        String text1 = "(All text and picture from ";
        String text2 = "Wikipedia";
        String text3 = ", the free encyclopedia)";
        page.getCanvas().drawString(text1, font3, brush2, 0, y, format3);
        size = font3.measureString(text1, format3);
        double x1 = size.getWidth();
        format3.setParagraphIndent(0);
        PdfFont font4 = new PdfFont(PdfFontFamily.Helvetica, 9,
                EnumSet.of(PdfFontStyle.Underline));
        PdfBrush brush3 = PdfBrushes.getBlue();
        page.getCanvas().drawString(text2, font4, brush3, x1, y, format3);
        size = font4.measureString(text2, format3);
        x1 = x1 + size.getWidth();
        page.getCanvas().drawString(text3, font3, brush2, x1, y, format3);
        y = y + size.getHeight();
        // Content
        PdfStringFormat format4 = new PdfStringFormat();
        File file= new File("data/Summary_of_Science.txt");
        text =textUtil.readText(file);
        PdfFont font5 = new PdfFont(PdfFontFamily.Helvetica, 10);
        format4.setLineSpacing(font5.getSize() * 1.5f);
        PdfStringLayouter textLayouter = new PdfStringLayouter();
        double imageLeftBlockHeight = imageBottom - y;
        Dimension2D size1 = new Dimension();
        size1.setSize(imageLeftSpace,imageLeftBlockHeight);

        PdfStringLayoutResult result = textLayouter.layout(text, font5, format4, size1);
        if (result.getActualSize().getHeight() < imageBottom - y) {
            imageLeftBlockHeight = imageLeftBlockHeight + result.getLineHeight();
            size1.setSize(size1.getWidth(),imageLeftBlockHeight);
            result = textLayouter.layout(text, font5, format4, size1);
        }
        for (LineInfo line : result.getLines()) {
            page.getCanvas().drawString(line.getText(), font5, brush2, 0, y, format4);
            y = y + result.getLineHeight();
        }
        PdfTextWidget textWidget = new PdfTextWidget(result.getRemainder(), font5, brush2);
        PdfTextLayout textLayout = new PdfTextLayout();
        textLayout.setBreak(PdfLayoutBreakType.Fit_Page);
        textLayout.setLayout(PdfLayoutType.Paginate);
        Point2D.Float point = new Point2D.Float();
        point.setLocation(0,y);

        Dimension2D size2 = page.getCanvas().getClientSize();
        Rectangle2D.Float bounds = new Rectangle2D.Float();
        bounds.setRect(point.x,point.y,size2.getWidth(),size2.getHeight());

        textWidget.setStringFormat(format4);
        textWidget.draw(page, bounds, textLayout);
        // Save pdf file.
        doc.saveToFile("output/textLayout.pdf");
        // Close pdf file
        doc.close();
    }
}
