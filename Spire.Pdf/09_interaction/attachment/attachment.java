import com.spire.pdf.*;
import com.spire.pdf.attachments.*;
import com.spire.pdf.graphics.*;
import com.spire.pdf.annotations.*;
import java.awt.*;
import java.awt.geom.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class attachment {
    public static void main(String[] args) {
        PdfDocument doc = new PdfDocument();
        PdfPageBase page = doc.getPages().add();
        float y =100;
        //Title
        PdfBrush brush1 = PdfBrushes.getCornflowerBlue();
        PdfTrueTypeFont font1 = new PdfTrueTypeFont(new Font("Arial", Font.BOLD ,18));
        PdfStringFormat format1 = new PdfStringFormat(PdfTextAlignment.Center);
        page.getCanvas().drawString("Attachment", font1, brush1, page.getCanvas().getClientSize().getWidth() / 2, y, format1);
        y = y + (float) font1.measureString("Attachment", format1).getHeight();
        y = y + 10;

        //Add an attachment
        PdfAttachment attachment = new PdfAttachment("Header.png");
        attachment.setData(fileConvertToByteArray("data/Header.png"));
        attachment.setDescription("Page header picture of demo.");
        attachment.setMimeType("image/png");
        doc.getAttachments().add(attachment);

        //Add an attachment
        attachment = new PdfAttachment("Footer.png");
        attachment.setData(fileConvertToByteArray("data/Footer.png"));
        attachment.setDescription("Page footer picture of demo.");
        attachment.setMimeType("image/png");
        doc.getAttachments().add(attachment);
        float x = 50;
        PdfTrueTypeFont font2 = new PdfTrueTypeFont(new Font("Arial",  Font.BOLD,14));
        Point2D location = new Point2D.Float(x, y);
        String label = "Sales Report Chart";

        byte[] data = fileConvertToByteArray("data/SalesReportChart.png");
        Dimension2D size = font2.measureString(label);
        Rectangle2D bounds = new Rectangle2D.Float();
        bounds.setFrame(location, size);
        page.getCanvas().drawString(label, font2, PdfBrushes.getDarkOrange(), bounds);
        bounds = new Rectangle2D.Float((float) bounds.getX() + (float) bounds.getWidth() + 3, (float) bounds.getY(), font2.getHeight() / 2, font2.getHeight());

        //Create a PdfAttachmentAnnotation
        PdfAttachmentAnnotation annotation1 = new PdfAttachmentAnnotation(bounds, "SalesReportChart.png", data);
        annotation1.setColor(new PdfRGBColor(new Color(0,128,128)));
        annotation1.setFlags(PdfAnnotationFlags.Read_Only);
        annotation1.setIcon(PdfAttachmentIcon.Graph);
        annotation1.setText("Sales Report Chart");
        //Add the annotation1
        page.getAnnotationsWidget().add(annotation1);
        y = y + (float) size.getHeight() + 3;

        location = new Point2D.Float(x, y);
        label = "Science Personification Boston";
        data = fileConvertToByteArray("data/SciencePersonificationBoston.jpg");
        size = font2.measureString(label);
        bounds = new Rectangle2D.Float( );
        bounds.setFrame(location,size);
        page.getCanvas().drawString(label, font2, PdfBrushes.getDarkOrange(), bounds);

        bounds = new Rectangle2D.Float((float) bounds.getX() + (float) bounds.getWidth() + 3, (float) bounds.getY(), font2.getHeight() / 2, font2.getHeight());


        PdfAttachmentAnnotation annotation2 = new PdfAttachmentAnnotation(bounds, "SciencePersonificationBoston.jpg", data);
        annotation2.setColor(new PdfRGBColor(new Color(255,165,0)));
        annotation2.setFlags(PdfAnnotationFlags.No_Zoom);
        annotation2.setIcon(PdfAttachmentIcon.Push_Pin);
        annotation2.setText("SciencePersonificationBoston.jpg, from Wikipedia, the free encyclopedia");
        page.getAnnotationsWidget().add(annotation2);
        y = y + (float) size.getHeight() + 2;

        location = new Point2D.Float(x, y);
        label = "Picture of Science";
        data = fileConvertToByteArray("data/Wikipedia_Science.png");
        size = font2.measureString(label);
        bounds = new Rectangle2D.Float();
        bounds.setFrame(location,size);
        page.getCanvas().drawString(label, font2, PdfBrushes.getDarkOrange(), bounds);
        bounds = new Rectangle2D.Float((float) bounds.getX() + (float) bounds.getWidth() + 3, (float) bounds.getY(), font2.getHeight() / 2, font2.getHeight());
        PdfAttachmentAnnotation annotation3 = new PdfAttachmentAnnotation(bounds, "Wikipedia_Science.png", data);
        annotation3.setColor(new PdfRGBColor(new Color(139,69,19)));
        annotation3.setFlags(PdfAnnotationFlags.Locked);
        annotation3.setIcon(PdfAttachmentIcon.Tag);
        annotation3.setText("Wikipedia_Science.png, from Wikipedia, the free encyclopedia");
        page.getAnnotationsWidget().add(annotation3);
        y = y + (float) size.getHeight() + 2;

        location = new Point2D.Float(x, y);
        label = "Hawaii Killer Font";
        data = fileConvertToByteArray("data/Hawaii_Killer.ttf");
        size = font2.measureString(label);
        bounds = new Rectangle2D.Float();
        bounds.setFrame(location,size);
        page.getCanvas().drawString(label, font2, PdfBrushes.getDarkOrange(), bounds);
        bounds = new Rectangle2D.Float((float) bounds.getX() + (float) bounds.getWidth() + 3, (float) bounds.getY(), font2.getHeight() / 2, font2.getHeight());
        PdfAttachmentAnnotation annotation4 = new PdfAttachmentAnnotation(bounds, "Hawaii_Killer.ttf", data);
        annotation4.setColor(new PdfRGBColor(new Color(95,158,160)));
        annotation4.setFlags(PdfAnnotationFlags.No_Rotate);
        annotation4.setIcon(PdfAttachmentIcon.Paperclip);
        annotation4.setText("Hawaii Killer Font, from http://www.1001freefonts.com");
        page.getAnnotationsWidget().add(annotation4);
        y = y + (float) size.getHeight() + 2;

        doc.saveToFile("output/attachment.pdf");
        doc.close();
    }
    private static byte[] fileConvertToByteArray(String file) {
        byte[] data = null;

        try {
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            int len;
            byte[] buffer = new byte[1024];
            while ((len = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }

            data = baos.toByteArray();

            fis.close();
            baos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }
}
