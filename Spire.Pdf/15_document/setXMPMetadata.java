import com.spire.pdf.*;

public class setXMPMetadata {
    public static void main(String[] args) {
        // Create a PdfDocument object and load the PDF document from the file "data/setXMPMetadata.pdf"
        PdfDocument document = new PdfDocument();
        document.loadFromFile("data/setXMPMetadata.pdf");

        // Set XMP metadata properties
        document.getDocumentInformation().setAuthor("E-iceblue");
        document.getDocumentInformation().setCreator("Spire.PDF");
        document.getDocumentInformation().setKeywords("XMP");
        document.getDocumentInformation().setProducer("E-icenlue Co,.Ltd");
        document.getDocumentInformation().setSubject("XMP Metadata");
        document.getDocumentInformation().setTitle("Set XMP Metadata in PDF");

        // Specify the output file path for the modified PDF document
        String output = "output/setXMPMetadata.pdf";

        // Save the modified document to a new PDF file
        document.saveToFile(output, FileFormat.PDF);

        // Close and dispose of system resources associated with the document
        document.close();
        document.dispose();
    }
}
