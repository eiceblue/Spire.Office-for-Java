import com.spire.doc.*;

public class addSectionFromOtherDoc {
    public static void main(String[] args) {
        //Open a Word document as target document
        Document TarDoc = new Document("data/SampleB_1.docx");

        //Open a Word document as source document
        Document SouDoc = new Document( "data/Sample_two sections.docx");

        //Get the second section from source document
        Section Ssection = SouDoc.getSections().get(1);

        //Add the section in target document
        TarDoc.getSections().add(Ssection.deepClone());

        String result = "output/addSectionFromOtherDoc.docx";

        //Save to file
        TarDoc.saveToFile(result, FileFormat.Docx_2013);

        //Dispose the document
        TarDoc.dispose();
        SouDoc.dispose();
    }
}
