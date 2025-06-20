import com.spire.pdf.*;
import com.spire.pdf.attachments.*;
import com.spire.pdf.graphics.*;
import com.spire.pdf.annotations.*;
import java.awt.*;
import java.awt.geom.*;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.util.EnumSet;

public class attachment {
    public static void main(String[] args) {
        // Create a PdfDocument object.
        PdfDocument doc = new PdfDocument();

        // Add a page to the PdfDocument object.
        PdfPageBase page = doc.getPages().add();

        // Initialize a variable to store the y-coordinate.
        float y = 100;

        // Create a PdfBrush object with a cornflower blue color.
        PdfBrush brush1 = PdfBrushes.getCornflowerBlue();

        // Create a PdfTrueTypeFont object with the Arial font, bold style, and size 18.
        PdfTrueTypeFont font1 = new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 18));

        // Create a PdfStringFormat object with center alignment.
        PdfStringFormat format1 = new PdfStringFormat(PdfTextAlignment.Center);

        // Draw the string "Attachment" at the center of the page, with the specified font, brush, and y-coordinate.
        page.getCanvas().drawString("Attachment", font1, brush1, page.getCanvas().getClientSize().getWidth() / 2, y, format1);

        // Increment the y-coordinate by the height of the string, plus 10 points.
        y = y + (float) font1.measureString("Attachment", format1).getHeight();
        y = y + 10;

        // Create a new PdfAttachment object and set its name to "Header.png".
        PdfAttachment attachment = new PdfAttachment("Header.png");

        // Set the data of the attachment to the byte array returned by fileConvertToByteArray.
        attachment.setData(fileConvertToByteArray("data/Header.png"));

        // Set the description of the attachment to "Page header picture of demo."
        attachment.setDescription("Page header picture of demo.");

        // Set the MIME type of the attachment to "image/png".
        attachment.setMimeType("image/png");

        // Add the attachment to the document.
        doc.getAttachments().add(attachment);

        // Create a new PdfAttachment object and set its name to "Footer.png".
        attachment = new PdfAttachment("Footer.png");

        // Set the data of the attachment to the byte array returned by fileConvertToByteArray.
        attachment.setData(fileConvertToByteArray("data/Footer.png"));

        // Set the description of the attachment to "Page footer picture of demo."
        attachment.setDescription("Page footer picture of demo.");

        // Set the MIME type of the attachment to "image/png".
        attachment.setMimeType("image/png");

        // Add the attachment to the document.
        doc.getAttachments().add(attachment);


        // Set the x-coordinate of the label to 50.
        float x = 50;

        // Create a new PdfTrueTypeFont object with Arial font, bold style, and size 14.
        PdfTrueTypeFont font2 = new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 14));

        // Create a new Point2D object with the x-coordinate set to 50 and the y-coordinate set to the current y-coordinate.
        Point2D location = new Point2D.Float(x, y);

        // Set the label string to "Sales Report Chart".
        String label = "Sales Report Chart";

        // Set the data of the label to the byte array returned by fileConvertToByteArray.
        byte[] data = fileConvertToByteArray("data/SalesReportChart.png");

        // Use the font2 object to measure the size of the label string.
        Dimension2D size = font2.measureString(label);

        // Create a new Rectangle2D object
        Rectangle2D bounds = new Rectangle2D.Float();

        // Set location  and size of bounds
        bounds.setFrame(location, size);

        // Draw label
        page.getCanvas().drawString(label, font2, PdfBrushes.getDarkOrange(), bounds);

        // Update the bounds
        bounds = new Rectangle2D.Float((float) bounds.getX() + (float) bounds.getWidth() + 3, (float) bounds.getY(), font2.getHeight() / 2, font2.getHeight());

        // Create a new PdfAttachmentAnnotation object with the specified bounds, file name, and data.
        PdfAttachmentAnnotation annotation1 = new PdfAttachmentAnnotation(bounds, "SalesReportChart.png", data);

        // Set the color of the annotation to green.
        annotation1.setColor(new PdfRGBColor(new Color(0, 128, 128)));

        // Set the flags of the annotation to read-only.
        annotation1.setFlags(EnumSet.of(PdfAnnotationFlags.Read_Only));

        // Set the icon of the annotation to graph.
        annotation1.setIcon(PdfAttachmentIcon.Graph);

        // Set the text of the annotation to "Sales Report Chart".
        annotation1.setText("Sales Report Chart");

        // Add the annotation to the annotations widget of the page.
        page.getAnnotationsWidget().add(annotation1);

        // Increment the y-coordinate by the height of the label, plus 3 points.
        y = y + (float) size.getHeight() + 3;

        // Create a new Point2D object with the x-coordinate set to 50 and the y-coordinate set to the current y-coordinate.
        location = new Point2D.Float(x, y);

        // Set the label string to "Science Personification Boston".
       label = "Science Personification Boston";

        // Set the data of the label to the byte array returned by fileConvertToByteArray.
        data = fileConvertToByteArray("data/SciencePersonificationBoston.jpg");

        // Use the font2 object to measure the size of the label string.
        size = font2.measureString(label);

        // Create a new Rectangle2D object with the specified location, size, and frame.
        bounds = new Rectangle2D.Float();
        bounds.setFrame(location, size);

        // Draw the label on the page using the specified font, brush, and bounds.
        page.getCanvas().drawString(label, font2, PdfBrushes.getDarkOrange(), bounds);

        // Update the bounds
        bounds = new Rectangle2D.Float((float) bounds.getX() + (float) bounds.getWidth() + 3, (float) bounds.getY(), font2.getHeight() / 2, font2.getHeight());

        // Create an attachment annotation for "SciencePersonificationBoston.jpg" with provided bounds and data
        PdfAttachmentAnnotation annotation2 = new PdfAttachmentAnnotation(bounds, "SciencePersonificationBoston.jpg", data);

        // Set the color of the annotation to orange
        annotation2.setColor(new PdfRGBColor(new Color(255, 165, 0)));

        // Set the flags of the annotation to disable zooming
        annotation2.setFlags(EnumSet.of(PdfAnnotationFlags.No_Zoom));

        // Set the icon of the annotation to a push pin
        annotation2.setIcon(PdfAttachmentIcon.Push_Pin);

        // Set the text description of the annotation
        annotation2.setText("SciencePersonificationBoston.jpg, from Wikipedia, the free encyclopedia");

        // Add the annotation to the page's annotations widget
        page.getAnnotationsWidget().add(annotation2);

        // Update the vertical position (y coordinate) based on the height of the annotation and spacing
        y = y + (float) size.getHeight() + 2;

        // Set the location for the next annotation as a Point2D.Float object with the updated coordinates
        location = new Point2D.Float(x, y);

        // Set the label for the next annotation as "Picture of Science"
        label = "Picture of Science";

        // Load the data of the attachment from "data/Wikipedia_Science.png"
        data = fileConvertToByteArray("data/Wikipedia_Science.png");

        // Measure the size of the label using font2
        size = font2.measureString(label);

        // Create a rectangle bounds object for the next annotation
        bounds = new Rectangle2D.Float();

        // Set the frame of the bounds object using the calculated location and size
        bounds.setFrame(location, size);

        // Draw the label text on the page's canvas using font2 and dark orange color within the specified bounds
        page.getCanvas().drawString(label, font2, PdfBrushes.getDarkOrange(), bounds);

        // Update the bounds for the next annotation to position it beside the label text
        bounds = new Rectangle2D.Float((float) bounds.getX() + (float) bounds.getWidth() + 3, (float) bounds.getY(), font2.getHeight() / 2, font2.getHeight());

        // Create an attachment annotation for "Wikipedia_Science.png" with provided bounds and data
        PdfAttachmentAnnotation annotation3 = new PdfAttachmentAnnotation(bounds, "Wikipedia_Science.png", data);

        // Set the color of the annotation to a specific shade of brown
        annotation3.setColor(new PdfRGBColor(new Color(139, 69, 19)));

        // Set the flags of the annotation to be locked
        annotation3.setFlags(EnumSet.of(PdfAnnotationFlags.Locked));

        // Set the icon of the annotation to a tag
        annotation3.setIcon(PdfAttachmentIcon.Tag);

        // Set the text description of the annotation
        annotation3.setText("Wikipedia_Science.png, from Wikipedia, the free encyclopedia");

        // Add the annotation to the page's annotations widget
        page.getAnnotationsWidget().add(annotation3);

        // Update the vertical position (y coordinate) for the next annotation
        y = y + (float) size.getHeight() + 2;

        // Set the location for the next annotation as a Point2D.Float object with the updated coordinates
        location = new Point2D.Float(x, y);

        // Set the label for the next annotation as "PT_Serif-Caption-Web-Regular Font"
        label = "PT_Serif-Caption-Web-Regular Font";

        // Load the data of the attachment from "data/PT_Serif-Caption-Web-Regular.ttf"
        data = fileConvertToByteArray("data/PT_Serif-Caption-Web-Regular.ttf");

        // Measure the size of the label using font2
        size = font2.measureString(label);

        // Create a rectangle bounds object for the next annotation
        bounds = new Rectangle2D.Float();

        // Set the frame of the bounds object using the calculated location and size
        bounds.setFrame(location, size);

        // Draw the label text on the page's canvas using font2 and dark orange color within the specified bounds
        page.getCanvas().drawString(label, font2, PdfBrushes.getDarkOrange(), bounds);

        // Update the bounds for the next annotation to position it beside the label text
        bounds = new Rectangle2D.Float((float) bounds.getX() + (float) bounds.getWidth() + 3, (float) bounds.getY(), font2.getHeight() / 2, font2.getHeight());

        // Create an attachment annotation for "PT_Serif-Caption-Web-Regular.ttf" with provided bounds and data
        PdfAttachmentAnnotation annotation4 = new PdfAttachmentAnnotation(bounds, "PT_Serif-Caption-Web-Regular.ttf", data);

        // Set the color of the annotation to a specific shade of teal
        annotation4.setColor(new PdfRGBColor(new Color(95, 158, 160)));
        // Set the flags of annotation4 to disable rotation
        annotation4.setFlags(EnumSet.of(PdfAnnotationFlags.No_Rotate));

        // Set the icon of annotation4 to a paperclip
        annotation4.setIcon(PdfAttachmentIcon.Paperclip);

        // Set the text description of annotation4
        annotation4.setText("PT_Serif-Caption-Web-Regular Font, from https://company.paratype.com");

        // Add annotation4 to the page's annotations widget
        page.getAnnotationsWidget().add(annotation4);

        // Update the vertical position (y coordinate) for the next annotation
        y = y + (float) size.getHeight() + 2;

        // Save the modified PDF document to a file named "attachment.pdf" in the "output" folder
        doc.saveToFile("output/attachment.pdf");

        // Close the PDF document.
        doc.close();

        // Dispose of the PDF document to free up system resources.
        doc.dispose();
    }
   
   // Convert a file to a byte array.
    private static byte[] fileConvertToByteArray(String file) {
        byte[] data = null;

        try {
            // Create a FileInputStream object to read the file.
            FileInputStream fis = new FileInputStream(file);
            // Create a ByteArrayOutputStream object to write the read data.
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            // Read the file data in 1024-byte chunks.
            int len;
            byte[] buffer = new byte[1024];
            while ((len = fis.read(buffer)) != -1) {
                // Write the read data to the ByteArrayOutputStream object.
                baos.write(buffer, 0, len);
            }

            // Convert the ByteArrayOutputStream object's data to a byte array.
            data = baos.toByteArray();

            // Close the FileInputStream and ByteArrayOutputStream objects.
            fis.close();
            baos.close();
        } catch (Exception e) {
            // Print the stack trace.
            e.printStackTrace();
        }

        return data;
    }
}
