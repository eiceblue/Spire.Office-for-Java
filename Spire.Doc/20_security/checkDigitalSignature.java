import com.spire.doc.*;

public class checkDigitalSignature {
    public static void main(String[] args) {

        //Determine if a document has a digital signature
       boolean value = Document.hasDigitalSignature("data/Sample.docx");
       if(value) {
           System.out.println("This Word document has a digital signature");
       }else {
           System.out.println("This Word document has not a digital signature");
       }
    }
}
