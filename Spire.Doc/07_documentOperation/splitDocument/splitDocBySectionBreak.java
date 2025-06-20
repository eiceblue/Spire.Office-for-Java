import com.spire.doc.*;

public class splitDocBySectionBreak {
    public static void main(String[] args) throws Exception {
        //Create Word document.
        Document document = new Document();

        //Load the file from disk.
        document.loadFromFile("data/Template_Docx_4.docx");

        //Define another new word document object.
        Document newWord = new Document();

        //Split a Word document into multiple documents by section break.
        for (int i = 0; i < document.getSections().getCount(); i++){
            String result = "output/result-SplitWordFileBySectionBreak_"+i+".docx";
            newWord.getSections().add(document.getSections().get(i).deepClone());

            //Save to file.
            newWord.saveToFile(result);
        }

        //Dispose the document
        document.dispose();
        newWord.dispose();
    }
}
