import com.spire.presentation.*;

public class print {
    public static void main(String[] args) throws Exception{
        String inputFile ="data/print.pptx";
        Presentation ppt = new Presentation();

        //Load the file
        ppt.loadFromFile(inputFile);
        PresentationPrintDocument document = new PresentationPrintDocument(ppt);

        //Print the file
        document.print();
        ppt.dispose();
    }
}
