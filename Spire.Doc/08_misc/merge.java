import com.spire.doc.*;

public class merge {
    public static void main(String[] args) {
        String input1 = "data/merge1.doc";
        String input2 = "data/merge2.docx";
        String output = "output/merge.docx";
        //create word document
        Document document = new Document();
        document.loadFromFile(input1, FileFormat.Doc);

        Document documentMerge = new Document();
        documentMerge.loadFromFile(input2, FileFormat.Docx);

        for (Section sec : (Iterable<Section>) documentMerge.getSections()) {
            document.getSections().add(sec.deepClone());
        }

        //save as docx file.
        document.saveToFile(output, FileFormat.Docx);
    }
}
