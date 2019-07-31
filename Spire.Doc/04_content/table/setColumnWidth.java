import com.spire.doc.*;

public class setColumnWidth {
    public static void main(String[] args) {

        String inputFile="data/tableSample.docx";
        String outputFile="output/setColumnWidth.docx";

        //create a document and load file
        Document document = new Document();
        document.loadFromFile(inputFile);

        Section section = document.getSections().get(0);
        Table table = section.getTables().get(0);

        //traverse the first column
        for (int i = 0; i < table.getRows().getCount(); i++) {
            //set the cell width type
            table.getRows().get(i).getCells().get(0).setCellWidthType(CellWidthType.Point);
            //set the value
            table.getRows().get(i).getCells().get(0).setWidth(200);
        }

        //save to file
        document.saveToFile(outputFile, FileFormat.Docx);
    }
}
