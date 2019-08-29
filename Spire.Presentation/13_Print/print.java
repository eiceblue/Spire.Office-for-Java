import com.spire.presentation.Presentation;
import com.spire.presentation.PresentationPrintDocument;

public class print {
    public static void main(String[] args) throws Exception{
		
        String inputFile ="data/print.pptx";
        Presentation ppt = new Presentation();
        ppt.loadFromFile(inputFile);
        PresentationPrintDocument document = new PresentationPrintDocument(ppt);
        document.print();
        ppt.dispose();
    }
}

