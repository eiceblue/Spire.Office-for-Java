import com.spire.doc.*;

public class merge {
    public static void main(String[] args) {

        //Create a document
        Document document = new Document();

        //Load the file form disk
        document.loadFromFile("data/Summary_of_Science.doc", FileFormat.Doc);

        //Create a document
        Document documentMerge = new Document();

        //Load the file form disk
        documentMerge.loadFromFile("data/Bookmark.docx", FileFormat.Docx);

        //Loop all the sections of the documentMerge
        for (Object sectionObj : documentMerge.getSections()) {
            Section section=(Section)sectionObj;

            //Append the sections from documentMerge
            document.getSections().add(section.deepClone());
        }

        //Save as docx file.
        document.saveToFile("output/merge.docx", FileFormat.Docx_2013);

        //Dispose the documents
        document.dispose();
        documentMerge.dispose();
    }
}
