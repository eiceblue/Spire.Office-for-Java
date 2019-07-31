import com.spire.pdf.*;
import com.spire.pdf.automaticfields.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.*;
import java.io.*;

public class template {
    public static void main(String[] args) throws Exception {
        PdfDocument doc = new PdfDocument();
        doc.getViewerPreferences().setPageLayout(PdfPageLayout.Two_Column_Left);

        //Set margin
        PdfUnitConvertor unitCvtr = new PdfUnitConvertor();
        PdfMargins margin = new PdfMargins();
        margin.setTop(unitCvtr.convertUnits(2.54f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
        margin.setBottom(margin.getTop());
        margin.setLeft(unitCvtr.convertUnits(3.17f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
        margin.setRight(margin.getLeft());

        setDocumentTemplate(doc, PdfPageSize.A4, margin);

        //Create section
        PdfSection section = doc.getSections().add();
        section.getPageSettings().setSize(PdfPageSize.A4);
        section.getPageSettings().setMargins(new PdfMargins(0));
        setSectionTemplate(section, PdfPageSize.A4, margin, "Section 1");

        // Create one page
        PdfNewPage page =  section.getPages().add();
        //Draw page
        drawPage(page);
        page =  section.getPages().add();
        drawPage(page);

        page =  section.getPages().add();
        drawPage(page);

        page =  section.getPages().add();
        drawPage(page);

        doc.saveToFile("output/template.pdf");
        doc.close();
    }

    static void setSectionTemplate(PdfSection section, java.awt.geom.Dimension2D pageSize, PdfMargins margin, String label) {
        PdfPageTemplateElement leftSpace = new PdfPageTemplateElement(margin.getLeft(), pageSize.getHeight());
        leftSpace.setForeground(true);
        section.getTemplate().setOddLeft(leftSpace);
        Font loFont= new Font("Arial",Font.ITALIC,9 );
        PdfTrueTypeFont font = new PdfTrueTypeFont(loFont);
        PdfStringFormat format = new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle);
        float y = (float) (pageSize.getHeight() - margin.getTop() - margin.getBottom()) * (1 - 0.618f);
        Rectangle2D bounds = new Rectangle2D.Double(10, y, margin.getLeft() - 20, font.getHeight() + 6);
        leftSpace.getGraphics().drawRectangle(PdfBrushes.getOrangeRed(), bounds);
        leftSpace.getGraphics().drawString(label, font, PdfBrushes.getWhite(), bounds, format);

        PdfPageTemplateElement rightSpace = new PdfPageTemplateElement(margin.getRight(), pageSize.getHeight());
        rightSpace.setForeground(true);
        section.getTemplate().setEvenRight(rightSpace);
        bounds = new Rectangle2D.Double(10, y, margin.getRight() - 20, font.getHeight() + 6);
        rightSpace.getGraphics().drawRectangle(PdfBrushes.getSaddleBrown(), bounds);
        rightSpace.getGraphics().drawString(label, font, PdfBrushes.getWhite(), bounds, format);
    }

    static void setDocumentTemplate(PdfDocument doc, java.awt.geom.Dimension2D pageSize, PdfMargins margin) {
        PdfPageTemplateElement leftSpace = new PdfPageTemplateElement(margin.getLeft(), pageSize.getHeight());
        doc.getTemplate().setLeft(leftSpace);

        PdfPageTemplateElement topSpace = new PdfPageTemplateElement(pageSize.getWidth(), margin.getTop());
        topSpace.setForeground(true);
        doc.getTemplate().setTop(topSpace);

        //Draw header label
        Font loFont = new Font("Arial", Font.ITALIC, 9);
        PdfTrueTypeFont font = new PdfTrueTypeFont(loFont);
        PdfStringFormat format = new PdfStringFormat(PdfTextAlignment.Right);
        String label = "Demo of Spire.Pdf";
        java.awt.geom.Dimension2D dimension2D = new Dimension();
        dimension2D.setSize(font.measureString(label, format));
        float y = topSpace.getHeight() - font.getHeight() - 1;
        PdfPen pen = new PdfPen(new PdfRGBColor(Color.black), 0.75f);
        topSpace.getGraphics().setTransparency(0.5f);
        topSpace.getGraphics().drawLine(pen, margin.getLeft(), y, pageSize.getWidth() - margin.getRight(), y);
        y = y - 1 - (float) dimension2D.getHeight();
        topSpace.getGraphics().drawString(label, font, PdfBrushes.getBlack(), pageSize.getWidth() - margin.getRight(), y, format);

        PdfPageTemplateElement rightSpace = new PdfPageTemplateElement(margin.getRight(), pageSize.getHeight());
        doc.getTemplate().setRight(rightSpace);

        PdfPageTemplateElement bottomSpace = new PdfPageTemplateElement(pageSize.getWidth(), margin.getBottom());
        bottomSpace.setForeground(true);
        doc.getTemplate().setBottom(bottomSpace);

        //Draw footer label
        y = font.getHeight() + 1;
        bottomSpace.getGraphics().setTransparency(0.5f);
        bottomSpace.getGraphics().drawLine(pen, margin.getLeft(), y, pageSize.getWidth() - margin.getRight(), y);
        y = y + 1;
        PdfPageNumberField pageNumber = new PdfPageNumberField();
        PdfPageCountField pageCount = new PdfPageCountField();
        PdfCompositeField pageNumberLabel = new PdfCompositeField();
        pageNumberLabel.setAutomaticFields(new PdfAutomaticField[]{pageNumber, pageCount});
        pageNumberLabel.setBrush(PdfBrushes.getBlack());
        pageNumberLabel.setFont(font);
        pageNumberLabel.setStringFormat(format);
        pageNumberLabel.setText("page {0} of {1}");
        pageNumberLabel.draw(bottomSpace.getGraphics(), pageSize.getWidth() - margin.getRight()-50, y);

        String inputFile1 = "data/Header.png";
        PdfImage headerImage = PdfImage.fromFile(inputFile1);
        Point2D pageLeftTop = new Point2D.Double(-margin.getLeft(), -margin.getTop());
        PdfPageTemplateElement header = new PdfPageTemplateElement(pageLeftTop, headerImage.getPhysicalDimension());
        header.setForeground(false);
        header.getGraphics().setTransparency(0.5f);
        header.getGraphics().drawImage(headerImage, 0, 0);
        doc.getTemplate().getStamps().add(header);

        String inputFile2 = "data/Footer.png";
        PdfImage footerImage = PdfImage.fromFile(inputFile2);
        y = (float) (pageSize.getHeight() - footerImage.getPhysicalDimension().getHeight());
        Point2D footerLocation = new Point2D.Double(-margin.getLeft(), y);
        PdfPageTemplateElement footer = new PdfPageTemplateElement(footerLocation, footerImage.getPhysicalDimension());
        footer.setForeground(false);
        footer.getGraphics().setTransparency(0.5f);
        footer.getGraphics().drawImage(footerImage, 0, 0);
        doc.getTemplate().getStamps().add(footer);
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
