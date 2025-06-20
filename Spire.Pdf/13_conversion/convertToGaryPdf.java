import com.spire.pdf.conversion.PdfGrayConverter;

public class convertToGaryPdf {
    public static void main(String[] args) {
        // Input file path
        String input = "data/convertToGaryPdf.pdf";

        // Output file path
        String output = "output/convertToGaryPdf_result.pdf";

        // Create a PdfGrayConverter with an pdf file
        PdfGrayConverter converter = new PdfGrayConverter(input);

        // Convert the file to gray pdf
        converter.toGrayPdf(output);
    }
}
