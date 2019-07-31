import com.spire.doc.*;

public class autoFitToFixed {
    public static void main(String[] args) {

        String inputFile="data/tableSample.docx";
        String outputFile="output/autoFitToFixed.docx";

        //create a document
        Document document = new Document();
        //load file
        document.loadFromFile(inputFile);

        Section section = document.getSections().get(0);
        Table table = section.getTables().get(0);

        //the table is set to a fixed size
        table.autoFit(AutoFitBehaviorType.Fixed_Column_Widths);

        //save to file
        document.saveToFile(outputFile,FileFormat.Docx);
    }
}
