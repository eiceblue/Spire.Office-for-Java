
import com.spire.pdf.*;
import com.spire.pdf.fields.*;
import com.spire.pdf.graphics.*;
import java.awt.geom.Rectangle2D;

public class assignIconToButtonField {
    public static void main(String[] args) throws Exception{
        // Create a new PDF document
        PdfDocument doc = new PdfDocument();

        // Add a new page to the document
        PdfPageBase page = doc.getPages().add();

        // Create a new button field with the name "button1"
        PdfButtonField btn = new PdfButtonField(page, "button1");

        // Set the bounds (position and size) of the button field
        btn.setBounds(new Rectangle2D.Float(80, 50, 120, 100));

        // Set the highlight mode of the button field to Push
        btn.setHighlightMode(PdfHighlightMode.Push);

        // Set the layout mode of the button field to Caption Overlay Icon
        btn.setLayoutMode(PdfButtonLayoutMode.Caption_Overlay_Icon);

        // Set the text and icon for the normal appearance of the button field
        btn.setText("Normal Text");
        btn.setIcon(PdfImage.fromFile("data/E-iceblueLogo.png"));

        // Set the text and icon for the click appearance of the button field
        // Note: This can only be set when the highlight mode is Push
        btn.setAlternateText("Alternate Text");
        btn.setAlternateIcon(PdfImage.fromFile("data/footer.png"));

        // Set the text and icon for the rollover appearance of the button field
        // Note: This can only be set when the highlight mode is Push
        btn.setRolloverText("Rollover Text");
        btn.setRolloverIcon(PdfImage.fromFile("data/pdfjava.png"));

        // Configure the icon layout of the button field
        btn.getIconLayout().setSpaces(new float[]{0.5f, 0.5f});
        btn.getIconLayout().setScaleMode(PdfButtonIconScaleMode.Proportional);
        btn.getIconLayout().setScaleReason(PdfButtonIconScaleReason.Always);
        btn.getIconLayout().isFitBounds(false);

        // Add the button field to the document's form fields collection
        doc.getForm().getFields().add(btn);

        // Specify the output file path where the modified PDF will be saved
        String result = "output/AssignIconToButtonField-result.pdf";

        // Save the modified PDF document to the specified output file
        doc.saveToFile(result);

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }

}
