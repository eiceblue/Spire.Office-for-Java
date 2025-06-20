import com.spire.doc.*;

public class preserveTheme {
    public static void main(String[] args) {

        String input = "data/Theme.docx";

        //Create a document
        Document doc = new Document();

        //Load from the disk
        doc.loadFromFile(input);

        //Create a new Word document
        Document newWord = new Document();

        //Clone default style, theme, compatibility from the source file to the destination document
        doc.cloneDefaultStyleTo(newWord);
        doc.cloneThemesTo(newWord);
        doc.cloneCompatibilityTo(newWord);

        //Add the cloned section to destination document
        newWord.getSections().add(doc.getSections().get(0).deepClone());

        //Save and launch document
        String output = "output/preserveTheme.docx";
        newWord.saveToFile(output, FileFormat.Docx_2013);

        //Dispose the documents
        doc.dispose();
        newWord.dispose();
    }
}
