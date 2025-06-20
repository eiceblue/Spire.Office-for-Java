package addDemo;

import com.spire.pdf.*;
import com.spire.pdf.annotations.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class setAuthorAndSubjectForPdfPopupAnnotation {

	public static void main(String[] args) {
		// Create a new PdfDocument object
        PdfDocument pdf = new PdfDocument();

        // Add a new page to the PDF document
        PdfPageBase page = pdf.getPages().add();

        // Create a Rectangle2D object to define the position and size of the popup annotation
        Rectangle2D rectangle2D = new Rectangle.Float();
        rectangle2D.setFrame(new Point2D.Double(10, 10), new Dimension(100, 100));

        // Create a PdfPopupAnnotation with the specified rectangle and text content
        PdfPopupAnnotation annotation = new PdfPopupAnnotation(rectangle2D, "test");

        // Set the icon for the popup annotation to a help icon
        annotation.setIcon(PdfPopupIcon.Help);

        // Set the open state of the popup annotation to true (visible by default)
        annotation.setOpen(true);

        // Set the author property of the popup annotation
        annotation.setAuthor("e-iceblue");

        // Set the subject property of the popup annotation
        annotation.setSubject("subject_popup");

        // Set the color of the popup annotation to a custom RGB color (255, 0, 150)
        annotation.setColor(new PdfRGBColor(255, 0, 150));

        // Add the popup annotation to the page's annotation collection
        page.getAnnotationsWidget().add(annotation);

        // Specify the file path to save the modified document
        String result = "output/setAuthorAndSubjectForPdfPopupAnnotation.pdf";

        // Save the modified PDF document to the specified file path
        pdf.saveToFile(result);

        // Close the PDF document
        pdf.close();

        // Dispose of the PDF document to free up system resources
        pdf.dispose();
	}

}
