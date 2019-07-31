import com.spire.doc.*;

public class autoFitToWindow {
    public static void main(String[] args) {

        String inputFile="data/tableSample.docx";
        String outputFile="output/autoFitToWindow.docx";

        //create a document
        Document document = new Document();
        //load file
        document.loadFromFile(inputFile);

        Section section = document.getSections().get(0);
        Table table = section.getTables().get(0);

        //automatically fit the table to the active window width
        table.autoFit(AutoFitBehaviorType.Auto_Fit_To_Window);

        //save to file
        document.saveToFile(outputFile,FileFormat.Docx);
    }
}
