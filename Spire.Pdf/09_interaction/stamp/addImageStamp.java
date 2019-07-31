import com.spire.pdf.*;
import com.spire.pdf.annotations.PdfRubberStampAnnotation;
import com.spire.pdf.annotations.appearance.PdfAppearance;
import com.spire.pdf.graphics.*;

import java.awt.*;
import java.awt.geom.*;

public class addImageStamp {
    public static void main(String[] args) {
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile("data/stamp.pdf");

        PdfPageBase page = doc.getPages().get(0);
        Dimension2D lodimension2D = new Dimension();
        lodimension2D.setSize(60,60);
        //Create a rubber stamp annotation
        Rectangle2D loRect= new Rectangle2D.Float();
        loRect.setFrame(new Point2D.Float(10, 10),lodimension2D );
        PdfRubberStampAnnotation loStamp = new PdfRubberStampAnnotation(loRect);
        //Create an instance of PdfAppearance
        PdfAppearance loApprearance = new PdfAppearance(loStamp);
        PdfImage image = PdfImage.fromFile("data/image stamp.jpg");
        PdfTemplate template = new PdfTemplate(210, 210);
        //Draw a pdf image into pdf template
        template.getGraphics().drawImage(image, 10, 10);
        loApprearance.setNormal(template);
        loStamp.setAppearance(loApprearance);
        //Add the rubber stamp annotation into pdf
        page.getAnnotationsWidget().add(loStamp);

        doc.saveToFile("output/addImageStamp.pdf");
        doc.close();
    }
}
