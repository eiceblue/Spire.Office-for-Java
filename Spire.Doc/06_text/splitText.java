import com.spire.doc.*;

public class splitText {
    public static void main(String[] args) {
        //Create a new document and load from file
        String input = "data/Sample.docx"; ;
        Document doc = new Document();
        doc.loadFromFile(input);

        //Add a column to the first section and set width and spacing
        doc.getSections().get(0).addColumn(100f, 20f);

        //Add a line between the two columns
        doc.getSections().get(0).getPageSetup().setColumnsLineBetween(true);

        //Save and launch the document
        String output = "output/splitText.docx";
        doc.saveToFile(output, FileFormat.Docx_2013);

        //Dispose the document
        doc.dispose();
    }
}
