import com.spire.pdf.PdfDocument;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class pageToPNG {
    public static void main(String[] args) throws Exception{
        // Specify the input PDF file path
        String input = "data/PDFTemplate-Az.pdf";

        // Create a new PdfDocument instance and load the PDF from file
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile(input);

        // Specify the page index to convert to image
        int pageIndex = 1;

        // Specify the output file name for the PNG image
        String fileName = "pageToPNG.png";

        // Convert the specified page of the PDF to a BufferedImage
        BufferedImage image = pdf.saveAsImage(pageIndex);

        // Create a new File object for the output PNG file
        File file = new File("output/" + fileName);

        // Write the BufferedImage as a PNG image file
        ImageIO.write(image, "PNG", file);

        // Close the PDF document
        pdf.close();

        // Dispose of the PDF document (frees up system resources)
        pdf.dispose();
    }
}
