import com.spire.pdf.*;
import com.spire.pdf.exporting.PdfImageInfo;

public class compressDocument {
    public static void main(String[] args) {
        // Create a new PdfDocument object
        PdfDocument document = new PdfDocument();

        // Load an existing PDF document from the specified file
        document.loadFromFile("data/compressDocument.pdf");

        // Compress the content of the document
        compressContent(document);

        // Compress the images in the document
        compressImage(document);

        // Specify the output file path and name
        String output = "output/compressDocument.pdf";

        // Save the compressed PDF document to the specified output file
        document.saveToFile(output, FileFormat.PDF);

        // Close the input document
        document.close();

        // Dispose of the PDF document to free up system resources
        document.dispose();
    }

    private static void compressContent(PdfDocument doc) {
        // Disable the incremental update
        doc.getFileInfo().setIncrementalUpdate(false);

        // Set the compression level to best
        doc.setCompressionLevel(PdfCompressionLevel.Best);
    }

    private static void compressImage(PdfDocument doc) {
        // Disable the incremental update
        doc.getFileInfo().setIncrementalUpdate(false);

        // Traverse all pages
        for (int i = 0; i < doc.getPages().getCount(); i++) {
            PdfPageBase page = doc.getPages().get(i);
            if (page != null) {
                if (page.getImagesInfo() != null) {
                    // Iterate through each image on the page and compress it
                    for (int j = 0; j < page.getImagesInfo().length; j++) {
                        PdfImageInfo info = page.getImagesInfo()[j];
                        page.tryCompressImage(info.getIndex());
                    }
                }
            }
        }
    }
}
