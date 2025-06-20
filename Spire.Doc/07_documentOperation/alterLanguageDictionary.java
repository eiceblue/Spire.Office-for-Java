import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;

public class alterLanguageDictionary {
    public static void main(String[] args) {
        //Create a Word document.
        Document document = new Document();

        //Add new section
        Section sec = document.addSection();

        //Add a paragraph to the document.
        Paragraph para = sec.addParagraph();

        //Add a textRange for the paragraph and append some Peru Spanish words.
        TextRange txtRange = para.appendText("corrige según diccionario en inglés");
        short localeId=10250;
        txtRange.getCharacterFormat().setLocaleIdASCII(localeId);

        String result = "output/alterLanguageDictionary.docx";

        //Save to file.
        document.saveToFile(result, FileFormat.Docx_2013);

        //Dispose the document
        document.dispose();
    }
}
