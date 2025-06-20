import com.spire.doc.*;

public class enableTrackChanges {
    public static void main(String[] args) throws Exception {
        //Create Word document.
        Document document = new Document();

        //Load the file from disk.
        document.loadFromFile("data/Template_Docx_1.docx");

        //Enable the track changes.
        document.setTrackChanges(true);

        String result = "output/result-enableTrackChanges.docx";

        //Save to file.
        document.saveToFile(result, FileFormat.Docx_2013);

        //Dispose the document
        document.dispose();
    }
}
