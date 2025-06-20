import com.spire.ms.imagecodecs.tiff.spi.TiffImageReaderSpi;
import com.spire.pdf.*;
import com.spire.pdf.graphics.PdfImage;
import javax.imageio.ImageReader;
import javax.imageio.stream.FileImageInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class tiffToPDF {
    public static void main(String[] args) throws Exception {
        String input = "data/TiffToPdf.tiff";

        String output = "output/TiffToPdf-result.pdf";

        // Create a new PDF document
        PdfDocument pdfDocument = new PdfDocument();

        // Split the TIFF image into an array of images
        Image[] images = SplitTIFFImage(new File(input));

        // Iterate through the images and add them to separate pages in the PDF document
        for (int i = 0; i < images.length; i++) {
            // Convert the BufferedImage to a PdfImage
            PdfImage pdfImage = PdfImage.fromImage((BufferedImage) images[i]);

            // Add a new page to the PDF document
            PdfPageBase page = pdfDocument.getPages().add();

            // Calculate the scaled width and height of the image
            float width = pdfImage.getWidth() * 0.7f;
            float height = pdfImage.getHeight() * 0.7f;

            // Calculate the x-coordinate to center the image horizontally on the page
            float x = (float) ((page.getCanvas().getClientSize().getWidth() - width) / 2);

            // Draw the image on the page's canvas
            page.getCanvas().drawImage(pdfImage, x, 0, width, height);
        }

        // Save the PDF document to the specified output file
        pdfDocument.saveToFile(output, FileFormat.PDF);

        // Close the document
        pdfDocument.close();

        // Dispose of the resources used by the document
        pdfDocument.dispose();
    }
	
    public static Image[] SplitTIFFImage(File tiffFile) throws Exception {
        // Input stream for reading the TIFF file.
        FileImageInputStream fis = null;

        // Service provider for TIFF image reader.
        TiffImageReaderSpi tiffImageReaderSpi = new TiffImageReaderSpi();

        // Create an instance of the TIFF image reader.
        ImageReader imageReader = tiffImageReaderSpi.createReaderInstance();

        // Open the TIFF file for reading.
        fis = new FileImageInputStream(tiffFile);

        // Set the input source for the image reader.
        imageReader.setInput(fis);

        // Get the number of pages in the TIFF.
        int pageCount = imageReader.getNumImages(true);

        // Array to store the individual page images.
        Image[] images = new Image[pageCount];
        for (int i = 0; i < pageCount; i++) {
            // Read the current page as a BufferedImage.
            BufferedImage bi = imageReader.read(i);

            // Store the BufferedImage in the array of images.
            images[i] = bi;
        }

        // Return the array of images representing each page of the TIFF.
        return images;
    }
}
