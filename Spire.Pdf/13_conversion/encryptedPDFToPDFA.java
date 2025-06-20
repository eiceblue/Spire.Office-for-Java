import com.spire.pdf.conversion.PdfStandardsConverter;

public class encryptedPDFToPDFA {
    public static void main(String[] args) {	
        // Input file path of the encrypted PDF document
        String inputFile = "data/Decryption.pdf";

        // Password to decrypt the input PDF document
        String password = "test";

        // Create an instance of PdfStandardsConverter with the input file and password
        PdfStandardsConverter converter = new PdfStandardsConverter(inputFile, password);

        // Convert the input PDF document to PDF/A-2a format
        converter.toPdfA2A("EncryptedPDFToPDFA.pdf");
    }
}
