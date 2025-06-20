import com.spire.pdf.*;

public class properties {
    public static void main(String[] args) {
        // Create a PdfDocument object to load the original document
        PdfDocument doc = new PdfDocument();

        // Load the PDF document from the file "data/properties.pdf"
        doc.loadFromFile("data/properties.pdf");

        // Modify the document properties
        doc.getDocumentInformation().setAuthor("E-iceblue");
        doc.getDocumentInformation().setCreator("E-iceblue");
        doc.getDocumentInformation().setKeywords("pdf, demo, document information");
        doc.getDocumentInformation().setProducer("Spire.PDF");
        doc.getDocumentInformation().setSubject("Demo of Spire.PDF");
        doc.getDocumentInformation().setTitle("Document Information");

        // Set specific options for the PDF file information
        doc.getFileInfo().setCrossReferenceType(PdfCrossReferenceType.Cross_Reference_Stream);
        doc.getFileInfo().setIncrementalUpdate(false);
        doc.getFileInfo().setVersion(PdfVersion.Version_1_5);

        // Specify the output file path for the modified PDF document
        String output = "output/properties.pdf";

        // Save the modified document to a new PDF file
        doc.saveToFile(output);

        // Close and dispose of system resources associated with the original document
        doc.close();
        doc.dispose();
    }
}
