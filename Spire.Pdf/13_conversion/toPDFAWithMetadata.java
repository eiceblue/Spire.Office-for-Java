import com.spire.pdf.conversion.PdfStandardsConverter;

public class toPDFAWithMetadata {
    public static void main(String[] args) {
        // Path to the input PDF document
        String input = "data/ToPDFAWithMetadata.pdf";

        // Path to the output PDFA document
        String output = "output/toPDFAWithMetadata_out.pdf";

        // Create an instance of PdfStandardsConverter with the input PDF file
        PdfStandardsConverter convert= new PdfStandardsConverter(input);

        // Set the option to preserve allowed metadata during conversion
        convert.getOptions().setPreserveAllowedMetadata(true);

        // Convert the input PDF to PDF/A-1a format
        convert.toPdfA1A(output);
    }
}
