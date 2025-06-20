import com.spire.doc.*;
import com.spire.doc.documents.*;

public class acceptOrRejectTrackedChange {
    public static void main(String[] args) {
       //Create Word document.
        Document document = new Document();

        //Load the file from disk.
        document.loadFromFile("data/acceptOrRejectTrackedChanges.docx");

        //Get the first section and the paragraph we want to accept/reject the changes.
        Section sec = document.getSections().get(0);
        Paragraph para = sec.getParagraphs().get(0);

        //Accept the changes or reject the changes.
        para.getDocument().acceptChanges();
        //para.getDocument().rejectChanges();

        String result = "output/result-acceptOrRejectTrackedChanges.docx";

        //Save to file.
        document.saveToFile(result, FileFormat.Docx_2013);

        //Dispose the document
        document.dispose();
    }
}
