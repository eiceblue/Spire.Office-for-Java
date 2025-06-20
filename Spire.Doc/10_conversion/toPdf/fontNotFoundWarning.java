import com.spire.doc.Document;
import com.spire.doc.documents.converters.warning.*;
import java.util.Iterator;

public class fontNotFoundWarning {

    public static void main(String[] args) {
        // Load input file
        Document doc = new Document();
        doc.loadFromFile("Data/fontNotFoundWarning.docx");
        // Create HandleDocumentSubstitutionWarnings object to set warning callback function
        HandleDocumentSubstitutionWarnings substitutionWarningHandler = new HandleDocumentSubstitutionWarnings();
        doc.setWarningCallback(substitutionWarningHandler);
        //  Convert Word to Pdf.
        doc.saveToFile("fontNotFoundWarning_output.pdf", FileFormat.PDF);
        //  Get warning iterator
        Iterator iterator = substitutionWarningHandler.FontWarnings.iterator();
        //  Iterate the warnings and print it
        while(iterator.hasNext()){
            System.out.println(((WarningInfo)iterator.next()).getDescription());
        }
        // Get the first warning
        // String s = substitutionWarningHandler.FontWarnings.get(0).getDescription();
        // System.out.println(s);
        //  Clear the warnings
        WarningSource warningSource = substitutionWarningHandler.FontWarnings.get(0).getSource();
        substitutionWarningHandler.FontWarnings.clear();


    }

   //  Creat a HandleDocumentSubstitutionWarnings callback function
    static class HandleDocumentSubstitutionWarnings implements IWarningCallback
    {
        public void warning(WarningInfo info) {
            if(info.getWarningType() == WarningType.Font_Substitution)
                FontWarnings.warning(info);
        }
        public WarningInfoCollection FontWarnings = new WarningInfoCollection();
    }
}
