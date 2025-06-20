import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.Printing.*;

public class setMarginAndDuplex {
    public static void main(String[] args) {

        // Create
        Document doc = new Document();
        doc.loadFromFile("data/print.docx");

        //Get the PrintDocument object
        PrintDocument printDoc = doc.getPrintDocument();

        //Set graphics origin starts at the page margins
        printDoc.setOriginAtMargins(true);
        //Set the margin to 0
        printDoc.getDefaultPageSettings().setMargins(new Margins(0, 0, 0, 0));

        //Double-sided, vertical printing
        printDoc.getPrinterSettings().setDuplex(Duplex.Vertical);

        //Double-sided, horizontal printing
        //printDoc.getPrinterSettings().setDuplex(Duplex.Horizontal);

        //Print the Word document
        printDoc.print();

        // Dispose the document
        doc.dispose();
    }
}
