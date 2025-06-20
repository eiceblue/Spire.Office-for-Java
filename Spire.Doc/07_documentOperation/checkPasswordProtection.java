import com.spire.doc.*;

public class checkPasswordProtection {
    public static void main(String[] args) {

        //Determine if the document is protected or not
       boolean value = Document.isEncrypted("data/decrypt.docx");
       if(value) {
           System.out.println("This Word document is password protected.");
       }else {
           System.out.println("This Word document is not password protected.");
       }
    }
}
