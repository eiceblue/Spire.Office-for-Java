import com.spire.doc.*;

public class autoFitToContents {
    public static void main(String[] args) {

        String inputFile="data/tableSample.docx";
        String outputFile="output/autoFitToContents.docx";

        //create a document
        Document document = new Document();
        //load file
        document.loadFromFile(inputFile);

        Section section = document.getSections().get(0);
        Table table = section.getTables().get(0);

        //automatically fit the table to the cell content
        table.autoFit(AutoFitBehaviorType.Auto_Fit_To_Contents);

        //save to file
        document.saveToFile(outputFile,FileFormat.Docx);
    }
}
