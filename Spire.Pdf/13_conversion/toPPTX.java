import com.spire.pdf.*;


public class toPPTX {
    public static void main(String[] args) {
        String input = "data/JavaPDFSample_1.pdf";
        String output = "output/toPPTX.pptx";

        //Load a pdf document
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(input);

        //Convert pdf to pptx file.
        doc.saveToFile(output, FileFormat.PPTX);

        // Close the original document
        doc.close();

        // Dispose of the resources used by the document
        doc.dispose();
    }
}
