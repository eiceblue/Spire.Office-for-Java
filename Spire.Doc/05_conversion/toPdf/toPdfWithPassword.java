import com.spire.doc.Document;
import com.spire.doc.ToPdfParameterList;
import com.spire.pdf.security.*;

public class toPdfWithPassword {
    public static void main(String[] args) {

        String inputFile="data/convertedTemplate.docx";
        String outputFile="output/toPdfWithPassword.pdf";

        //create word document
        Document document = new Document();
        document.loadFromFile(inputFile);

        //create a parameter
        ToPdfParameterList toPdf = new ToPdfParameterList();

        //set the password
        String password = "E-iceblue";
        toPdf.getPdfSecurity().encrypt(password, password, PdfPermissionsFlags.None, PdfEncryptionKeySize.Key_128_Bit);

        //save doc file.
        document.saveToFile(outputFile, toPdf);
    }
}
