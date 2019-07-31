import com.spire.pdf.*;
import com.spire.pdf.exporting.PdfImageInfo;

public class compressDocument {
    public static void main(String[] args) {
        String inputFile = "data/compressDocument.pdf";
        String outputFile = "output/compressDocument_result.pdf";

        PdfDocument document = new PdfDocument();
        document.loadFromFile(inputFile);

        //Compress the content in document
        CompressContent(document);

        //Save the document
        document.saveToFile(outputFile, FileFormat.PDF);
        document.close();
    }

    private static void CompressContent(PdfDocument doc) {
        //Disable the incremental update
        doc.getFileInfo().setIncrementalUpdate(false);

        //Set the compression level to best
        doc.setCompressionLevel(PdfCompressionLevel.Best);
    }
}
