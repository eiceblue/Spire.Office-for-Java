import com.spire.pdf.conversion.compression.*;

public class compressDocumentSecondApproach {
    public static void main(String[] args) {
        // Create a new PdfCompressor object and specify the input file path
        PdfCompressor compressor = new PdfCompressor("data/compressDocument.pdf");

        // Enable resizing of images
        compressor.getOptions().getImageCompressionOptions().setResizeImages(true);

        // Set the image quality to low
        compressor.getOptions().getImageCompressionOptions().setImageQuality(ImageQuality.Low);

        // Compress the PDF document and save it to the specified output file
        compressor.compressToFile("output/compressDocument.pdf");

        // Alternatively, you can compress the PDF document and write it to a stream
        // OutputStream newStream = new FileOutputStream(outFile);
        // compressor.compressToStream(newStream);
    }
}
