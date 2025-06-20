import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.*;
import java.io.*;
import java.util.ArrayList;

public class pagination {
    public static void main(String[] args) throws Exception {
        // Create a new instance of PdfDocument
        PdfDocument doc = new PdfDocument();

        // Create a PdfUnitConvertor to convert measurement units
        PdfUnitConvertor unitCvtr = new PdfUnitConvertor();

        // Create an instance of PdfMargins to set the margins of the document
        PdfMargins margin = new PdfMargins();

        // Set the top margin using the converted value from centimeters to points
        margin.setTop(unitCvtr.convertUnits(2.54f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));

        // Set the bottom margin equal to the top margin
        margin.setBottom(margin.getTop());

        // Set the left margin using the converted value from centimeters to points
        margin.setLeft(unitCvtr.convertUnits(3.17f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));

        // Set the right margin equal to the left margin
        margin.setRight(margin.getLeft());

        // Draw the cover section of the document
        drawCover(doc.getSections().add(), margin);

        // Draw the content section of the document
        drawContent(doc.getSections().add(), margin);

        // Draw the page number in the second section of the document
        drawPageNumber(doc.getSections().get(1), margin, 1, doc.getSections().get(1).getCount());

        // Save the PDF document to the specified file location
        doc.saveToFile("output/pagination.pdf");

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }


    static void drawCover(PdfSection section, PdfMargins margin) {
        // Set the page size to A4 and reset all margins to 0
        section.getPageSettings().setSize(PdfPageSize.A4);
        section.getPageSettings().getMargins().setAll(0);

        // Add a new page to the section and draw the page header and footer
        PdfPageBase page = section.getPages().add();
        drawPageHeaderAndFooter(page, margin, true);

        // Define brushes, fonts, and formatting for text rendering
        PdfBrush brush1 = PdfBrushes.getLightGray();
        PdfBrush brush2 = PdfBrushes.getBlue();
        PdfTrueTypeFont font1 = new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 8));
        PdfStringFormat format = new PdfStringFormat();
        format.setMeasureTrailingSpaces(true);

        // Define the three parts of the introductory text
        String text1 = "(All text and picture from ";
        String text2 = "Wikipedia";
        String text3 = ", the free encyclopedia)";

        float x = 0, y = 10;

        // Calculate the starting position for drawing the text
        x = x + margin.getLeft();
        y = y + margin.getTop();

        // Draw the first part of the text
        page.getCanvas().drawString(text1, font1, brush1, x, y, format);
        x = x + (float) font1.measureString(text1, format).getWidth();

        // Draw the second part of the text
        page.getCanvas().drawString(text2, font1, brush2, x, y, format);
        x = x + (float) font1.measureString(text2, format).getWidth();

        // Draw the third part of the text
        page.getCanvas().drawString(text3, font1, brush1, x, y, format);

        // Define brushes and other variables for image rendering
        PdfBrush brush3 = PdfBrushes.getBlack();
        PdfBrush brush4 = new PdfSolidBrush(new PdfRGBColor(new Color(0xf9, 0xf9, 0xf9)));
        String inputFile = "data/SciencePersonificationBoston.jpg";
        PdfImage image = PdfImage.fromFile(inputFile);
        String text = "Personification of \"Science\" in front of the Boston Public Library";

        // Calculate the scaling factor for the image
        float r = (float) image.getPhysicalDimension().getHeight() / image.getHeight();

        // Create a pen, size measurement, and template for drawing the image
        PdfPen pen = new PdfPen(brush1, r);
        Dimension2D size = font1.measureString(text, image.getPhysicalDimension().getWidth() - 2);
        PdfTemplate template = new PdfTemplate(image.getPhysicalDimension().getWidth() + 4 * r + 4, image.getPhysicalDimension().getHeight() + 4 * r + 7 + size.getHeight());

        // Draw a rectangle around the template using a pen and fill it with a color
        template.getGraphics().drawRectangle(pen, brush4, 0, 0, template.getWidth(), template.getHeight());

        x = y = r + 2;

        // Draw a rectangle within the template to contain the image
        template.getGraphics().drawRectangle(brush1, x, y, image.getPhysicalDimension().getWidth() + 2 * r, image.getPhysicalDimension().getHeight() + 2 * r);
        x = y = x + r;

        // Draw the image within the rectangle of the template
        template.getGraphics().drawImage(image, x, y);

        x = x - 1;
        y = y + (float) image.getPhysicalDimension().getHeight() + r + 2;

        // Create a rectangle for drawing the text below the image in the template
        Rectangle2D loRec = new Rectangle2D.Float();
        loRec.setFrame(new Point2D.Float(x, y), size);

        // Draw the text within the rectangle in the template
        template.getGraphics().drawString(text, font1, brush3, loRec);

        // Calculate the position to draw the template on the page canvas
        float x1 = (float) (page.getCanvas().getClientSize().getWidth() - template.getWidth()) / 2;
        float y1 = (float) (page.getCanvas().getClientSize().getHeight() - margin.getTop() - margin.getBottom()) * (1 - 0.618f) - template.getHeight() / 2 + margin.getTop();

        // Draw the template on the page canvas
        template.draw(page.getCanvas(), x1, y1);

        // Set alignment and font for the title
        format.setAlignment(PdfTextAlignment.Center);
        PdfTrueTypeFont font2 = new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 24));

        // Calculate the position to draw the title on the page canvas
        x = (float) page.getCanvas().getClientSize().getWidth() / 2;
        y = y1 + template.getHeight() + 10;
        String title = "Science History and Etymology";

        // Draw the title on the page canvas
        page.getCanvas().drawString(title, font2, brush3, x, y, format);
    }

    static void drawContent(PdfSection section, PdfMargins margin) throws IOException{
        // Set page size to A4 and reset all margins to 0
        section.getPageSettings().setSize(PdfPageSize.A4);
        section.getPageSettings().getMargins().setAll(0);

        // Add a new page to the section
        PdfPageBase page = section.getPages().add();

        // Draw page header and footer
        drawPageHeaderAndFooter(page, margin, false);

        float x = margin.getLeft();
        float y = margin.getTop() + 8;
        float width = (float)page.getCanvas().getClientSize().getWidth() - margin.getLeft() - margin.getRight();

        // Set up font, brush, and pen for drawing title
        PdfTrueTypeFont font1 = new PdfTrueTypeFont(new Font("Arial", 0, 16), true);
        PdfBrush brush1 = PdfBrushes.getBlack();
        PdfPen pen1 = new PdfPen(brush1, 0.75f);

        // Draw the title
        String title = "Science History and Etymology";
        page.getCanvas().drawString(title, font1, brush1, x, y);
        y = y + (float)font1.measureString(title).getHeight() + 6;

        // Draw a horizontal line below the title
        page.getCanvas().drawLine(pen1, x, y, page.getCanvas().getClientSize().getWidth() - margin.getRight(), y);
        y = y + 1.75f;

        // Specify the input file containing the content
        String inputFile = "data/Science_History_and_Etymology.txt";

        // Read the lines from the input file
        java.util.List<String> lines = new ArrayList<String>();
        FileInputStream fis = new FileInputStream(inputFile);
        InputStreamReader inputStreamReader = new InputStreamReader(fis, "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String tempLine="";
        while ((tempLine = bufferedReader.readLine()) != null) {
            lines.add(tempLine);
        }
        bufferedReader.close();
        inputStreamReader.close();
        fis.close();

        // Construct the content as a string
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        String content = null;
        while ((content = br.readLine()) != null) {
            sb.append(content).append("\r\n");
        }
        content = sb.toString();

        // Set up font and format for drawing the content
        PdfTrueTypeFont font2 = new PdfTrueTypeFont(new Font("Arial", Font.ITALIC ,10), true);
        PdfStringFormat format1 = new PdfStringFormat();
        format1.setMeasureTrailingSpaces(true);
        format1.setLineSpacing(font2.getHeight() * 1.5f);
        format1.setParagraphIndent(font2.measureString("\t", format1).getWidth());
        y = y + font2.getHeight() * 0.5f;

        // Draw the first line of content
        Dimension2D size = font2.measureString(lines.get(0), width, format1);
        Rectangle2D loRec = new Rectangle2D.Float();
        loRec.setFrame(new Point2D.Float(x, y), size);
        page.getCanvas().drawString(lines.get(0), font2, brush1, loRec, format1);
        y = y + (float)size.getHeight();

        // Set up font and format for drawing subsequent lines of content
        PdfTrueTypeFont font3 = new PdfTrueTypeFont(new Font("Arial", 0, 10), true);
        PdfStringFormat format2 = new PdfStringFormat();
        format2.setLineSpacing(font3.getHeight() * 1.4f);
        format2.setMeasureTrailingSpaces(true);

        // Draw the second line of content
        size = font3.measureString(lines.get(1), width, format2);
        loRec.setFrame(new Point2D.Float(x, y), size);
        page.getCanvas().drawString(lines.get(1), font3, brush1, loRec, format2);
        y = y + (float)size.getHeight();

        y = y + font3.getHeight() * 0.75f;
        float indent = (float)font3.measureString("\t\t", format2).getWidth();
        float x1 = x + indent;

        // Draw the third line of content with indentation
        size = font3.measureString(lines.get(2), width - indent, format2);

        loRec.setFrame(new Point2D.Float(x1, y), size);
        page.getCanvas().drawString(lines.get(2), font3, brush1, loRec, format2);
        y = y + (float)size.getHeight() + font3.getHeight() * 0.75f;

        // Construct the remaining content
        StringBuilder buff = new StringBuilder();
        for (int i = 3; i < lines.size(); i++) {
            buff.append(lines.get(i) + "\r\n");
        }
        content = buff.toString();

        // Layout and draw the remaining content
        PdfStringLayouter textLayouter = new PdfStringLayouter();
        Dimension2D sizeF = new Dimension();
        size.setSize(width, Float.MAX_VALUE);
        PdfStringLayoutResult result = textLayouter.layout(content, font3, format2, size);
        for (LineInfo line : result.getLines()) {
            // Adjust y position if it exceeds the page height
            if ((LineType.getLineTypeValue(line.getLineType()) & LineType.First_Paragraph_Line.getValue()) == LineType.First_Paragraph_Line.getValue()) {
                y = y + font3.getHeight() * 0.75f;
            }
            if (y > (page.getCanvas().getClientSize().getHeight() - margin.getBottom() - result.getLineHeight())) {
                // Add a new page if y position exceeds the available space on current page
                page = section.getPages().add();
                drawPageHeaderAndFooter(page, margin, false);
                y = margin.getTop();
            }
            // Draw the line of content
            page.getCanvas().drawString(line.getText(), font3, brush1, x, y, format2);
            y = y + result.getLineHeight();
        }
    }

    static void drawPageHeaderAndFooter(PdfPageBase page, PdfMargins margin, boolean isCover) {
        // Define the file paths for the header and footer images
        String inputFile1 = "data/header.png";
        String inputFile2 = "data/footer.png";

        // Set transparency of the canvas to 0.5f
        page.getCanvas().setTransparency(0.5f);

        // Load the header and footer images
        PdfImage headerImage = PdfImage.fromFile(inputFile1);
        PdfImage footerImage = PdfImage.fromFile(inputFile2);

        // Draw the header image at the top-left corner of the page
        page.getCanvas().drawImage(headerImage, new Point2D.Float(0, 0));

        // Calculate the y position for drawing the footer image at the bottom of the page
        float footerY = (float) page.getCanvas().getClientSize().getHeight() - (float) footerImage.getPhysicalDimension().getHeight();

        // Draw the footer image at the bottom-left corner of the page
        page.getCanvas().drawImage(footerImage, new Point2D.Float(0, footerY));

        // If the page is a cover page, set transparency of the canvas back to 1 and return
        if (isCover) {
            page.getCanvas().setTransparency(1);
            return;
        }

        // Set up brush, pen, font, and format for drawing the footer text
        PdfBrush brush = PdfBrushes.getBlack();
        PdfPen pen = new PdfPen(brush, 0.75f);
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial", Font.ITALIC, 9), true);
        PdfStringFormat format = new PdfStringFormat(PdfTextAlignment.Right);
        format.setMeasureTrailingSpaces(true);

        // Calculate the space between lines and position for drawing the footer text
        float space = font.getHeight() * 0.75f;
        float x = margin.getLeft();
        float width = (float) page.getCanvas().getClientSize().getWidth() - margin.getLeft() - margin.getRight();
        float y = margin.getTop() - space;

        // Draw a line above the footer text
        page.getCanvas().drawLine(pen, x, y, x + width, y);

        // Move the y position to draw the footer text below the line
        y = y - 1 - font.getHeight();

        // Draw the footer text on the canvas
        page.getCanvas().drawString("Demo of Spire.Pdf", font, brush, x + width, y, format);

        // Set transparency of the canvas back to 1
        page.getCanvas().setTransparency(1);
    }


    static void drawPageNumber(PdfSection section, PdfMargins margin, int startNumber, int pageCount) {
        // Iterate through each page in the section
        for (PdfPageBase page : (Iterable<PdfPageBase>) section.getPages()) {
            // Set transparency of the canvas to 0.5f
            page.getCanvas().setTransparency(0.5f);

            // Set up brush, pen, font, and format for drawing page numbers
            PdfBrush brush = PdfBrushes.getBlack();
            PdfPen pen = new PdfPen(brush, 0.75f);
            PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial", Font.ITALIC, 9), true);
            PdfStringFormat format = new PdfStringFormat(PdfTextAlignment.Right);
            format.setMeasureTrailingSpaces(true);

            // Calculate the space between lines and position for drawing the page number
            float space = font.getHeight() * 0.75f;
            float x = margin.getLeft();
            float width = (float) page.getCanvas().getClientSize().getWidth() - margin.getLeft() - margin.getRight();
            float y = (float) page.getCanvas().getClientSize().getHeight() - margin.getBottom() + space;

            // Draw a line above the page number
            page.getCanvas().drawLine(pen, x, y, x + width, y);

            // Increase the y position to draw the page number below the line
            y = y + 1;

            // Create the page number label string with the current page number and total page count
            String numberLabel = String.format("%1$s of %2$s", startNumber++, pageCount);

            // Draw the page number label on the canvas
            page.getCanvas().drawString(numberLabel, font, brush, x + width, y, format);

            // Set transparency of the canvas back to 1
            page.getCanvas().setTransparency(1);
        }
    }
}
