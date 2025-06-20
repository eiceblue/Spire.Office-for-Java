import com.spire.doc.Document;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class checkPasswordProtectionByStream {
    public static void main(String[] args) throws FileNotFoundException {

        //Determine if the stream is protected or not
        FileInputStream inStream = new FileInputStream("data/decrypt.docx");
        boolean isPwd = Document.isEncrypted(inStream);
        System.out.println(isPwd);
    }
}
