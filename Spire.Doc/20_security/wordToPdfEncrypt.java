import com.spire.doc.*;

public class wordToPdfEncrypt {
    public static void main(String[] args) {
        // Create a new document object
        Document document = new Document();

        // Load the document from the specified input file "data/JAVATemplate_N.docx"
        document.loadFromFile("data/JAVATemplate_N.docx");

        // Create a ToPdfParameterList object for converting to PDF
        ToPdfParameterList toPdf = new ToPdfParameterList();

        // Encrypt the PDF with the specified owner password "e-iceblue", user password "test", default permissions, and 128-bit encryption key size
        toPdf.getPdfSecurity().encrypt("e-iceblue", "test", PdfPermissionsFlags.Default, PdfEncryptionKeySize.Key_128_Bit);

        // Specify the output file path
        String result = "output/WordToPdfEncrypt.pdf";

        // Save the converted PDF with encryption to the specified output file using the ToPdfParameterList settings
        document.saveToFile(result, toPdf);

        // Dispose the document resources
        document.dispose();
    }
}
