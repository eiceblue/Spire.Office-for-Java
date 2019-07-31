import com.spire.pdf.*;

public class properties {
    public static void main(String[] args) {
        String inputFile = "data/properties.pdf";
        String outputFile = "output/properties_result.pdf";

        //Load pdf document
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(inputFile);

        //Set document info
        doc.getDocumentInformation().setAuthor("E-iceblue");
        doc.getDocumentInformation().setCreator("E-iceblue");
        doc.getDocumentInformation().setKeywords("pdf, demo, document information");
        doc.getDocumentInformation().setProducer("Spire.PDF");
        doc.getDocumentInformation().setSubject("Demo of Spire.PDF");
        doc.getDocumentInformation().setTitle("Document Information");

        //File info
        doc.getFileInfo().setCrossReferenceType(PdfCrossReferenceType.Cross_Reference_Stream);
        doc.getFileInfo().setIncrementalUpdate(false);
        doc.getFileInfo().setVersion(PdfVersion.Version_1_5);

        //Save pdf file.
        doc.saveToFile(outputFile);
        doc.close();


    }
}
