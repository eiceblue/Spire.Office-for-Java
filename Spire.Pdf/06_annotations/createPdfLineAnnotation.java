import com.spire.pdf.*;
import com.spire.pdf.annotations.*;
import com.spire.pdf.fields.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.util.EnumSet;

public class createPdfLineAnnotation {
    public static void main(String[] args) {
 // Create a new PDF document
        PdfDocument document = new PdfDocument();

        // Add a new page to the document
        PdfPageBase page = document.getPages().add();

        // Create the first line annotation
        int[] linePoints = new int[] { 100, 650, 180, 650 };
        PdfLineAnnotation lineAnnotation = new PdfLineAnnotation(linePoints, "This is the first line annotation");

        // Set the line border style and width
        lineAnnotation.getlineBorder().setBorderStyle(PdfBorderStyle.Solid);
        lineAnnotation.getlineBorder().setBorderWidth(1);

        // Set the line intent
        lineAnnotation.setLineIntent(PdfLineIntent.Line_Dimension);

        // Set the line styles for the beginning and end points
        lineAnnotation.setBeginLineStyle(PdfLineEndingStyle.Butt);
        lineAnnotation.setEndLineStyle(PdfLineEndingStyle.Diamond);

        // Set the line flag
        lineAnnotation.setFlags(EnumSet.of(PdfAnnotationFlags.Default));

        // Set the line color and background color
        lineAnnotation.setInnerLineColor(new PdfRGBColor(Color.green));
        lineAnnotation.setBackColor(new PdfRGBColor(Color.green));

        // Set the leader line properties
        lineAnnotation.setLeaderLineExt(0);
        lineAnnotation.setLeaderLine(0);

        // Add the first line annotation to the page
        ((PdfNewPage) page).getAnnotations().add(lineAnnotation);


        // Create the second line annotation
        linePoints = new int[] { 100, 550, 280, 550 };
        lineAnnotation = new PdfLineAnnotation(linePoints, "This is the second line annotation");
        lineAnnotation.getlineBorder().setBorderStyle(PdfBorderStyle.Underline);
        lineAnnotation.getlineBorder().setBorderWidth(2);
        lineAnnotation.setLineIntent(PdfLineIntent.Line_Arrow);
        lineAnnotation.setBeginLineStyle(PdfLineEndingStyle.Circle);
        lineAnnotation.setEndLineStyle(PdfLineEndingStyle.Diamond);
        lineAnnotation.setFlags(EnumSet.of(PdfAnnotationFlags.Default));
        lineAnnotation.setInnerLineColor(new PdfRGBColor(Color.pink));
        lineAnnotation.setBackColor(new PdfRGBColor(Color.pink));
        lineAnnotation.setLeaderLineExt(0);
        lineAnnotation.setLeaderLine(0);

        // Add the second line annotation to the page
        ((PdfNewPage) page).getAnnotations().add(lineAnnotation);

        // Create the third line annotation
        linePoints = new int[] { 100, 450, 280, 450 };
        lineAnnotation = new PdfLineAnnotation(linePoints, "This is the third line annotation");
        lineAnnotation.getlineBorder().setBorderStyle(PdfBorderStyle.Beveled);
        lineAnnotation.getlineBorder().setBorderWidth(2);
        lineAnnotation.setLineIntent(PdfLineIntent.Line_Dimension);
        lineAnnotation.setBeginLineStyle(PdfLineEndingStyle.None);
        lineAnnotation.setEndLineStyle(PdfLineEndingStyle.None);
        lineAnnotation.setFlags(EnumSet.of(PdfAnnotationFlags.Default));
        lineAnnotation.setInnerLineColor(new PdfRGBColor(Color.blue));
        lineAnnotation.setBackColor(new PdfRGBColor(Color.blue));
        lineAnnotation.setLeaderLineExt(1);
        lineAnnotation.setLeaderLine(1);

        // Add the third line annotation to the page
        ((PdfNewPage) page).getAnnotations().add(lineAnnotation);

        // Set the file path for saving the document
        String result = "output/createPdfLineAnnotation_out.pdf";

        // Save the document
        document.saveToFile(result);

        // Close the PDF document
        document.close();

        // Dispose of the PDF document (frees up system resources)
        document.dispose();
    }
}
