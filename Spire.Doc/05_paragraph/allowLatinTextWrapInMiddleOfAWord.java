import com.spire.doc.*;
import com.spire.doc.documents.*;

public class allowLatinTextWrapInMiddleOfAWord {
    public static void main(String[] args){
        //Create Word document.
        Document document = new Document();

        //Load the file from disk.
        document.loadFromFile("data/AllowLatinTextWrapInMiddleOfAWord.docx");

        Paragraph para = document.getSections().get(0).getParagraphs().get(0);

        //Allow Latin text to wrap in the middle of a word
        para.getFormat().setWordWrap(false);

        String result = "output/AllowLatinTextWrapInMiddleOfAWord-Result.docx";

        //Save to file.
        document.saveToFile(result, FileFormat.Docx_2013);

        //Dispose the document
        document.dispose();
    }
}
