import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.*;
import java.io.*;
import java.util.ArrayList;

public class pagination {
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

        drawCover(doc.getSections().add(), margin);
        drawContent(doc.getSections().add(), margin);
        drawPageNumber(doc.getSections().get(1), margin, 1, doc.getSections().get(1).getCount());

        //Save pdf file.
        doc.saveToFile("output/pagination.pdf");
        doc.close();
    }
    static void drawCover(PdfSection section, PdfMargins margin) {
        section.setPageNumber(new PdfPageNumber());
        section.getPageNumber().setNumberStyle(PdfNumberStyle.Lower_Roman);
        section.getPageNumber().setPrefix("cover ");
        section.getPageSettings().setSize(PdfPageSize.A4);
        section.getPageSettings().getMargins().setAll(0);
        PdfPageBase page = section.getPages().add();
        drawPageHeaderAndFooter(page, margin, true);

        PdfBrush brush1 = PdfBrushes.getLightGray();
        PdfBrush brush2 = PdfBrushes.getBlue();
        PdfTrueTypeFont font1 = new PdfTrueTypeFont(new Font("Arial",Font.PLAIN,8));
        PdfStringFormat format = new PdfStringFormat();
        format.setMeasureTrailingSpaces(true);
        String text1 = "(All text and picture from ";
        String text2 = "Wikipedia";
        String text3 = ", the free encyclopedia)";
        float x = 0, y = 10;
        x = x + margin.getLeft();
        y = y + margin.getTop();
        page.getCanvas().drawString(text1, font1, brush1, x, y, format);
        x = x + (float)font1.measureString(text1, format).getWidth();
        page.getCanvas().drawString(text2, font1, brush2, x, y, format);
        x = x + (float)font1.measureString(text2, format).getWidth();
        page.getCanvas().drawString(text3, font1, brush1, x, y, format);

        PdfBrush brush3 = PdfBrushes.getBlack();
        PdfBrush brush4 = new PdfSolidBrush(new PdfRGBColor(new Color(0xf9, 0xf9, 0xf9)));
        String inputFile = "data/SciencePersonificationBoston.jpg";
        PdfImage image = PdfImage.fromFile(inputFile);
        String text = "Personification of \"Science\" in front of the Boston Public Library";
        float r = (float)image.getPhysicalDimension().getHeight() / image.getHeight();
        PdfPen pen = new PdfPen(brush1, r);
        Dimension2D size = font1.measureString(text, image.getPhysicalDimension().getWidth() - 2);
        PdfTemplate template = new PdfTemplate(image.getPhysicalDimension().getWidth() + 4 * r + 4, image.getPhysicalDimension().getHeight() + 4 * r + 7 + size.getHeight());
        template.getGraphics().drawRectangle(pen, brush4, 0, 0, template.getWidth(), template.getHeight());
        x = y = r + 2;
        template.getGraphics().drawRectangle(brush1, x, y, image.getPhysicalDimension().getWidth() + 2 * r, image.getPhysicalDimension().getHeight() + 2 * r);
        x = y = x + r;
        template.getGraphics().drawImage(image, x, y);

        x = x - 1;
        y = y + (float)image.getPhysicalDimension().getHeight() + r + 2;
        Rectangle2D loRec= new Rectangle2D.Float();
        loRec.setFrame(new Point2D.Float(x, y), size);
        template.getGraphics().drawString(text, font1, brush3, loRec);

        float x1 = (float)(page.getCanvas().getClientSize().getWidth() - template.getWidth()) / 2;
        float y1 = (float)(page.getCanvas().getClientSize().getHeight() - margin.getTop() - margin.getBottom()) * (1 - 0.618f) - template.getHeight() / 2 + margin.getTop();
        template.draw(page.getCanvas(), x1, y1);

        //Draw title
        format.setAlignment(PdfTextAlignment.Center);
        PdfTrueTypeFont font2 = new PdfTrueTypeFont(new Font("Arial", Font.BOLD,24 ));
        x = (float)page.getCanvas().getClientSize().getWidth() / 2;
        y = y1 + template.getHeight() + 10;
        String title = "Science History and Etymology";
        page.getCanvas().drawString(title, font2, brush3, x, y, format);
    }

    static void drawContent(PdfSection section, PdfMargins margin) throws IOException{
        section.setPageNumber(new PdfPageNumber());
        section.getPageNumber().setNumberStyle(PdfNumberStyle.Numeric);
        section.getPageNumber().setPrefix("page ");
        section.getPageSettings().setSize(PdfPageSize.A4);
        section.getPageSettings().getMargins().setAll(0);
        PdfPageBase page = section.getPages().add();
        drawPageHeaderAndFooter(page, margin, false);

        float x = margin.getLeft();
        float y = margin.getTop() + 8;
        float width = (float)page.getCanvas().getClientSize().getWidth() - margin.getLeft() - margin.getRight();
        PdfTrueTypeFont font1 = new PdfTrueTypeFont(new Font("Arial",0, 16), true);
        PdfBrush brush1 = PdfBrushes.getBlack();
        PdfPen pen1 = new PdfPen(brush1, 0.75f);
        String title = "Science History and Etymology";
        page.getCanvas().drawString(title, font1, brush1, x, y);
        y = y + (float)font1.measureString(title).getHeight() + 6;
        page.getCanvas().drawLine(pen1, x, y, page.getCanvas().getClientSize().getWidth() - margin.getRight(), y);
        y = y + 1.75f;

        String inputFile = "data/Science_History_and_Etymology.txt";

        java.util.List<String> lines = new ArrayList<String>();
        FileInputStream fis = new FileInputStream(inputFile);
        InputStreamReader inputStreamReader = new InputStreamReader(fis,"UTF-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String tempLine="";
        while ((tempLine=bufferedReader.readLine())!=null){
            lines.add(tempLine);
        }
        bufferedReader.close();
        inputStreamReader.close();
        fis.close();
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        String content=null;
        while ((content=br.readLine())!=null){
            sb.append(content).append("\r\n");
        }
        content= sb.toString();
        PdfTrueTypeFont font2 = new PdfTrueTypeFont(new Font("Arial",Font.ITALIC ,10), true);
        PdfStringFormat format1 = new PdfStringFormat();
        format1.setMeasureTrailingSpaces(true);
        format1.setLineSpacing(font2.getHeight() * 1.5f);
        format1.setParagraphIndent(font2.measureString("\t", format1).getWidth());
        y = y + font2.getHeight() * 0.5f;
        Dimension2D size = font2.measureString(lines.get(0), width, format1);
        Rectangle2D loRec = new Rectangle2D.Float();
        loRec.setFrame(new Point2D.Float(x, y), size);
        page.getCanvas().drawString(lines.get(0), font2, brush1,loRec, format1);
        y = y + (float)size.getHeight();

        PdfTrueTypeFont font3 = new PdfTrueTypeFont( new Font("Arial",0, 10), true);
        PdfStringFormat format2 = new PdfStringFormat();
        format2.setLineSpacing(font3.getHeight() * 1.4f);
        format2.setMeasureTrailingSpaces(true);
        size = font3.measureString(lines.get(1), width, format2);
        loRec.setFrame(new Point2D.Float(x, y), size);
        page.getCanvas().drawString(lines.get(1), font3, brush1, loRec, format2);
        y = y + (float)size.getHeight();

        y = y + font3.getHeight() * 0.75f;
        float indent = (float)font3.measureString("\t\t", format2).getWidth();
        float x1 = x + indent;
        size = font3.measureString(lines.get(2), width - indent, format2);
        loRec.setFrame(new Point2D.Float(x1, y), size);
        page.getCanvas().drawString(lines.get(2), font3, brush1, loRec, format2);
        y = y + (float)size.getHeight() + font3.getHeight() * 0.75f;

        StringBuilder buff = new StringBuilder();
        for (int i = 3; i < lines.size(); i++) {
            buff.append(lines.get(i) + "\r\n");
        }
        content = buff.toString();

        PdfStringLayouter textLayouter = new PdfStringLayouter();
        Dimension2D sizeF = new Dimension();
        size.setSize(width, Float.MAX_VALUE);
        PdfStringLayoutResult result = textLayouter.layout(content, font3, format2, size);
        for (LineInfo line : result.getLines()) {
            if ((LineType.getLineTypeValue( line.getLineType()) & LineType.First_Paragraph_Line.getValue()) == LineType.First_Paragraph_Line.getValue()) {
                y = y + font3.getHeight() * 0.75f;
            }
            if (y > (page.getCanvas().getClientSize().getHeight() - margin.getBottom() - result.getLineHeight())) {
                page = section.getPages().add();
               drawPageHeaderAndFooter(page, margin, false);
                y = margin.getTop();
            }
            page.getCanvas().drawString(line.getText(), font3, brush1, x, y, format2);
            y = y + result.getLineHeight();
        }
    }

    static void drawPageHeaderAndFooter(PdfPageBase page, PdfMargins margin, boolean isCover) {
        String inputFile1 = "data/header.png";
        String inputFile2 = "data/footer.png";
        page.getCanvas().setTransparency(0.5f);
        PdfImage headerImage = PdfImage.fromFile(inputFile1);
        PdfImage footerImage = PdfImage.fromFile(inputFile2);
        page.getCanvas().drawImage(headerImage, new Point2D.Float(0, 0));
        page.getCanvas().drawImage(footerImage, new Point2D.Float(0, (float)page.getCanvas().getClientSize().getHeight() -(float) footerImage.getPhysicalDimension().getHeight()));
        if (isCover) {
            page.getCanvas().setTransparency(1);
            return;
        }

        PdfBrush brush = PdfBrushes.getBlack();
        PdfPen pen = new PdfPen(brush, 0.75f);
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial", Font.ITALIC,9 ), true);
        PdfStringFormat format = new PdfStringFormat(PdfTextAlignment.Right);
        format.setMeasureTrailingSpaces(true);
        float space = font.getHeight() * 0.75f;
        float x = margin.getLeft();
        float width = (float)page.getCanvas().getClientSize().getWidth() - margin.getLeft() - margin.getRight();
        float y = margin.getTop() - space;
        page.getCanvas().drawLine(pen, x, y, x + width, y);
        y = y - 1 - font.getHeight();
        page.getCanvas().drawString("Demo of Spire.Pdf", font, brush, x + width, y, format);
        page.getCanvas().setTransparency(1);
    }

    static void drawPageNumber(PdfSection section, PdfMargins margin, int startNumber, int pageCount) {
        for (PdfPageBase page : (Iterable<PdfPageBase>) section.getPages()) {
            page.getCanvas().setTransparency(0.5f);
            PdfBrush brush = PdfBrushes.getBlack();
            PdfPen pen = new PdfPen(brush, 0.75f);
            PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial", Font.ITALIC,9 ), true);
            PdfStringFormat format = new PdfStringFormat(PdfTextAlignment.Right);
            format.setMeasureTrailingSpaces(true);
            float space = font.getHeight() * 0.75f;
            float x = margin.getLeft();
            float width = (float)page.getCanvas().getClientSize().getWidth() - margin.getLeft() - margin.getRight();
            float y = (float)page.getCanvas().getClientSize().getHeight() - margin.getBottom() + space;
            page.getCanvas().drawLine(pen, x, y, x + width, y);
            y = y + 1;
            String numberLabel = String.format("%1$s of %2$s", startNumber++, pageCount);
            page.getCanvas().drawString(numberLabel, font, brush, x + width, y, format);
            page.getCanvas().setTransparency(1);
        }
    }
}
