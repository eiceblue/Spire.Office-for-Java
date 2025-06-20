import com.spire.pdf.*;
import com.spire.pdf.utilities.*;

public class compressImages {
    public static void main(String[] args) {
        // Create a PDF document
        PdfDocument doc = new PdfDocument();

        // Load a file from disk
        doc.loadFromFile("data/CompressImages.pdf");

	// Set IncrementalUpdate to false
	doc.getFileInfo().setIncrementalUpdate(false);

        // Create an instance of PdfImageHelper to work with images
        PdfImageHelper imageHelper = new PdfImageHelper();

        // Iterate through each page in the document
        for (PdfPageBase page : (Iterable<PdfPageBase>) doc.getPages()) {
            // Retrieve information about the images on the page
            for (PdfImageInfo info : imageHelper.getImagesInfo(page)) {
                // Attempt to compress the image
                info.tryCompressImage();
            }
        }

        // Specify the output file name for the modified PDF
        String result = "output/CompressImages_out.pdf";

        // Save the modified document to a file
        doc.saveToFile(result, FileFormat.PDF);

        // Dispose the PDF document to release resources
        doc.dispose();
    }
}
