import com.spire.doc.*;
import com.spire.doc.documents.*;

public class managePagination {
    public static void main(String[] args) {
        //Create Word document.
        Document document = new Document();

        //Load the file from disk.
        document.loadFromFile("data/Template_Docx_1.docx");

        //Get the first section
        Section sec = document.getSections().get(0);

        //Get the fifth paragraph.
        Paragraph para = sec.getParagraphs().get(4);

        //Set the pagination format as Format.PageBreakBefore for the checked paragraph.
        para.getFormat().setPageBreakBefore(true);

        String result = "output/managePagination.docx";

        //Save the file.
        document.saveToFile(result, FileFormat.Docx_2013);

        //Dispose the document
        document.dispose();
    }
}
