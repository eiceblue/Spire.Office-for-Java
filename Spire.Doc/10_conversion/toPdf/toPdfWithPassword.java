import com.spire.doc.*;


public class toPdfWithPassword {
    public static void main(String[] args) {
        // Specify the input file path for the Word document to be processed
        String inputFile = "data/convertedTemplate.docx";

        // Specify the output file path for the resulting PDF document
        String outputFile = "output/toPdfWithPassword.pdf";

        // Create a new instance of the Document class
        Document document = new Document();

        // Load the Word document from the specified input file
        document.loadFromFile(inputFile);

        // Create an instance of the ToPdfParameterList class to specify parameters for conversion to PDF
        ToPdfParameterList toPdf = new ToPdfParameterList();

        // Set the passwords for encrypting the PDF document
        String password1 = "E-iceblue";
		String password2 = "123";
        toPdf.getPdfSecurity().encrypt(password1, password2, PdfPermissionsFlags.None, PdfEncryptionKeySize.Key_128_Bit);

        // Save the document to the specified output file in PDF format, using the specified conversion parameters
        document.saveToFile(outputFile, toPdf);

        // Dispose of system resources associated with the document
        document.dispose();
    }
}
