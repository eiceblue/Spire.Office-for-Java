import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.Printing.*;

public class customPaperSize {
    public static void main(String[] args) {
        //Create a document
        Document doc = new Document();

        //Load a document
        doc.loadFromFile("data/print.docx");

        //Get the PrintDocument object
        PrintDocument printDoc = doc.getPrintDocument();

        //Custom the paper size
        PaperSize size = new PaperSize();
        size.setWidth(900);
        size.setHeight(800);

        //Apply the page size
        printDoc.getDefaultPageSettings().setPaperSize(size);

        //Print the document
        printDoc.print();

        //Dispose the document
        doc.dispose();
    }
}
