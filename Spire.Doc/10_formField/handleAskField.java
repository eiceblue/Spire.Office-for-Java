import com.spire.doc.*;
import com.spire.doc.fields.*;
import java.io.InputStream;

public class handleAskField {
    public static void main(String[] args) {
        String input="data/handleAskField.docx";
        String output="output/handleAskField.docx";
        //create and load Word document.
        Document doc = new Document();
        doc.loadFromFile(input);

        //call UpdateFieldsHandler event to handle the ASK field.
        doc.UpdateFields = new HandleAskFieldex();
        //update the fields in the document.
        doc.isUpdateFields(true);
        //save the document.
        doc.saveToFile(output, FileFormat.Docx);
    }

    static class HandleAskFieldex extends UpdateFieldsHandler {
        public void invoke(Object sender, IFieldsEventArgs args) {
            if (args instanceof AskFieldEventArgs) {
                AskFieldEventArgs askArgs = (AskFieldEventArgs) args;

                if (askArgs.getBookmarkName().equals("1")) {
                    askArgs.setResponseText("Thank you. This is my first time to come to a Chinese restaurant. Could you " +
                            "tell me the different features of Chinese food?");
                }

                if (askArgs.getBookmarkName().equals("2")) {
                    askArgs.setResponseText("No more, thank you. I'm quite full.");
                }
            }
        }
    }
}
