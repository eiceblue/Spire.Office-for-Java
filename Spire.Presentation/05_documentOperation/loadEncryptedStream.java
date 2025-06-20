import com.spire.presentation.*;
import java.io.FileInputStream;

public class loadEncryptedStream {

    public static void main(String[] args) {
        try(FileInputStream fis = new FileInputStream("data/OpenEncryptedPPT.pptx")){
            // Create a Presentation instance
            Presentation ppt = new Presentation();

            // Specify the password for decryption
            String password = "123456";

            // Load the encrypted stream with the provided password
            ppt.loadFromStream(fis, FileFormat.AUTO, password);

            // Save the decrypted document to disk
            ppt.saveToFile("output/result.pptx", FileFormat.PPTX_2013);

            ppt.dispose();

        } catch (Exception e) {
            // Throw a runtime exception if any error occurs
            throw new RuntimeException(e);
        }
    }
}

