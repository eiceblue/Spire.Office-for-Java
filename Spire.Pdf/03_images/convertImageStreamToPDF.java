import com.spire.pdf.*;
import com.spire.pdf.graphics.PdfImage;
import java.io.*;

public class convertImageStreamToPDF {
    public static void main(String[] args) throws Exception{
        // Create a new PDF document
        PdfDocument pdf = new PdfDocument();

        // Add a section to the document
        PdfSection section = pdf.getSections().add();

        // Add a page to the section
        PdfPageBase page = section.getPages().add();

        // Create a FileStream object to read the image file
        File file=new File("data/bg.png");
        FileInputStream fs=new FileInputStream(file);

        // Specify the image source
        PdfImage image = PdfImage.fromStream(fs);

        // Calculate the fit rate for the image based on its width and height relative to the canvas size
        double widthFitRate = image.getPhysicalDimension().getWidth() / page.getCanvas().getClientSize().getWidth();
        double heightFitRate = image.getPhysicalDimension().getHeight() / page.getCanvas().getClientSize().getHeight();

        // Determine the maximum fit rate between width and height
        float fitRate = Math.max((float)widthFitRate, (float)heightFitRate);

        // Calculate the size of the image
        double fitWidth = image.getPhysicalDimension().getWidth() / fitRate;
        double fitHeight = image.getPhysicalDimension().getHeight() / fitRate;

        // Draw the image on the page's canvas
        page.getCanvas().drawImage(image, 0, 30, fitWidth, fitHeight);

        // Specify the output path
        String output = "output/convertImageStreamToPDF.pdf";

        // Save the PDF document to a file
        pdf.saveToFile(output,FileFormat.PDF);

        // Close the PDF document
        pdf.close();

        // Dispose of the PDF document (frees up system resources)
        pdf.dispose();
    }
}
