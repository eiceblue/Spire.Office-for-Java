import com.spire.pdf.conversion.PdfToLinearizedPdfConverter;

public class toLinearizedPdf {
    public static void main(String[] args) {
        // Specify the path of the input PDF file
        String input = "data/pdfTemplate_N.pdf";

        // Specify the path of the output linearized PDF file
        String output = "output/toLinearizedPdf.pdf";

        // Create an instance of the PdfToLinearizedPdfConverter class, passing the input file path as a parameter
        PdfToLinearizedPdfConverter converter = new PdfToLinearizedPdfConverter(input);

        // Call the toLinearizedPdf method of the converter object, passing the output file path as a parameter
        converter.toLinearizedPdf(output);

        // Dispose of the resources used by the converter
        converter.dispose();
    }
}
