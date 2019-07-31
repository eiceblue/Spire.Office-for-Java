import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.*;
import java.io.*;

public class pageSetup {
    public static void main(String[] args) throws Exception {
        //Create a pdf document.
        PdfDocument doc = new PdfDocument();
        //Set margin
        PdfUnitConvertor unitCvtr = new PdfUnitConvertor();
        PdfMargins margin = new PdfMargins();
        margin.setTop(unitCvtr.convertUnits(2.54f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
        margin.setBottom(margin.getTop());
        margin.setLeft(unitCvtr.convertUnits(3.17f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
        margin.setRight(margin.getLeft());
        //page 1
        PdfPageBase page = doc.getPages().add(PdfPageSize.A4, margin);
        page.setBackgroundColor(new Color(210, 105, 30));
        drawPage(page);

        //page 2
        page = doc.getPages().add(PdfPageSize.A4, margin);
        page.setBackgroundColor(new Color(255, 127, 80));
        drawPage(page);

        //Page 3
        page = doc.getPages().add(PdfPageSize.A3, margin, PdfPageRotateAngle.Rotate_Angle_180, PdfPageOrientation.Landscape);
        page.setBackgroundColor(new Color(255, 182, 193));
        drawPage(page);

        //Create section
        PdfSection section = doc.getSections().add();
        page = section.getPages().add();
        section.getPageSettings().setSize(PdfPageSize.A4);
        section.getPageSettings().setMargins(margin);
        //Draw page 4
        drawPage(page);
        //set background color
        page = section.getPages().add();
        page.setBackgroundColor(new Color(135, 206, 250));
        //Draw page 5
        drawPage(page);
        //Landscape
        section = doc.getSections().add();
        section.getPageSettings().setOrientation(PdfPageOrientation.Landscape);
        page = section.getPages().add();
        section.getPageSettings().setSize(PdfPageSize.A4);
        section.getPageSettings().setMargins(margin);

        //Draw page 6
        drawPage(page);
        //Rotate 90
        section = doc.getSections().add();
        page = section.getPages().add();
        section.getPageSettings().setSize(PdfPageSize.A4);
        section.getPageSettings().setMargins(margin);
        section.getPageSettings().setRotate(PdfPageRotateAngle.Rotate_Angle_90);

        //Draw page 7
        drawPage(page);
        //Rotate 180
        section = doc.getSections().add();
        page = section.getPages().add();
        section.getPageSettings().setSize(PdfPageSize.A4);
        section.getPageSettings().setMargins(margin);
        section.getPageSettings().setRotate(PdfPageRotateAngle.Rotate_Angle_180);

        //Draw page 8
        drawPage(page);
        //Save pdf file.
        doc.saveToFile("output/pageSetup.pdf");
        doc.close();
    }

    static void drawPage(PdfPageBase page) throws IOException {
        String inputFile_1 = "data/Wikipedia_Science.png";
        String inputFile_2 = "data/Summary_of_Science.txt";
        float pageWidth = (float) page.getCanvas().getClientSize().getWidth();
        float y = 0;
        //title
        y = y + 5;
        PdfBrush brush2 = new PdfSolidBrush(new PdfRGBColor(Color.black));
        PdfTrueTypeFont font2 = new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 16));
        PdfStringFormat format2 = new PdfStringFormat(PdfTextAlignment.Center);
        format2.setCharacterSpacing(1f);
        String text = "Summary of Science";
        page.getCanvas().drawString(text, font2, brush2, pageWidth / 2, y, format2);
        Dimension2D size = font2.measureString(text, format2);
        y = y + (float) size.getHeight() + 6;
        //icon
        PdfImage image = PdfImage.fromFile(inputFile_1);
        page.getCanvas().drawImage(image, new Point2D.Float(pageWidth - (float) image.getPhysicalDimension().getWidth(), y));
        float imageLeftSpace = pageWidth - (float) image.getPhysicalDimension().getWidth() - 2;
        float imageBottom = (float) image.getPhysicalDimension().getHeight() + y;

        PdfTrueTypeFont font3 = new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 9));
        PdfStringFormat format3 = new PdfStringFormat();
        format3.setParagraphIndent(font3.getSize() * 2);
        format3.setMeasureTrailingSpaces(true);
        format3.setLineSpacing(font3.getSize() * 1.5f);
        String text1 = "(All text and picture from ";
        String text2 = "Wikipedia";
        String text3 = ", the free encyclopedia)";
        page.getCanvas().drawString(text1, font3, brush2, 0, y, format3);
        size = font3.measureString(text1, format3);
        float x1 = (float) size.getWidth();
        format3.setParagraphIndent(0);
        PdfTrueTypeFont font4 = new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 9));
        PdfBrush brush3 = PdfBrushes.getBlue();
        page.getCanvas().drawString(text2, font4, brush3, x1, y, format3);
        size = font4.measureString(text2, format3);
        x1 = x1 + (float) size.getWidth();
        page.getCanvas().drawString(text3, font3, brush2, x1, y, format3);
        y = y + (float) size.getHeight();
        //Content
        PdfStringFormat format4 = new PdfStringFormat();
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new FileReader(inputFile_2));
        String content = null;
        while ((content = br.readLine()) != null) {
            sb.append(content).append("\r\n");
        }
        text = sb.toString();
        PdfTrueTypeFont font5 = new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 10));
        format4.setLineSpacing(font5.getSize() * 1.5f);
        PdfStringLayouter textLayouter = new PdfStringLayouter();
        float imageLeftBlockHeight = imageBottom - y;
        Dimension2D dimension2D = new Dimension();
        dimension2D.setSize(imageLeftSpace, imageLeftBlockHeight);
        PdfStringLayoutResult result = textLayouter.layout(text, font5, format4, dimension2D);
        if (result.getActualSize().getHeight() < imageBottom - y) {
            imageLeftBlockHeight = imageLeftBlockHeight + result.getLineHeight();
            Dimension2D dimension = new Dimension();
            dimension.setSize(imageLeftSpace, imageLeftBlockHeight);
            result = textLayouter.layout(text, font5, format4, dimension);
        }
        for (LineInfo line : result.getLines()) {
            page.getCanvas().drawString(line.getText(), font5, brush2, 0, y, format4);
            y = y + result.getLineHeight();
        }
        PdfTextWidget textWidget = new PdfTextWidget(result.getRemainder(), font5, brush2);
        PdfTextLayout textLayout = new PdfTextLayout();
        textLayout.setBreak(PdfLayoutBreakType.Fit_Page);
        textLayout.setLayout(PdfLayoutType.Paginate);
        Rectangle2D bounds = new Rectangle2D.Float();
        bounds.setFrame(new Point2D.Float(0, y), page.getCanvas().getClientSize());
        textWidget.setStringFormat(format4);
        textWidget.draw(page, bounds, textLayout);
    }
}
