import com.spire.presentation.Presentation;

public class checkDigitalSignature {
    public static void main(String[] args) throws Exception {
        //Load a PowerPoint Document
        Presentation ppt = new Presentation();
        ppt.loadFromFile("data/digitalSignature.pptx");

        //If the file contains the digital signature
        if (ppt.isDigitallySigned()) {
            System.out.println("This document is signed");
        } else {
            System.out.println("This document is not signed");
        }

    }
}
