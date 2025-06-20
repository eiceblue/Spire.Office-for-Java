import com.spire.pdf.conversion.PdfToWordConverter;

public class NewMethodToDocx {
    public static void main(String[] args) {    
        // Specify the input PDF file path
        String inputFile = "data/JavaPDFSample_2.pdf";

        // Specify the output Word document path
        String outputFile = "output/JavaPDFSample_2.docx";

        // Create an instance of the PdfToWordConverter class with the input file path
        PdfToWordConverter converter = new PdfToWordConverter(inputFile);

        // Convert the PDF to DOCX and save it to the specified output path
        converter.saveToDocx(outputFile);

        // Release any resources or clean up after the conversion process
        converter.dispose();
    }
}
