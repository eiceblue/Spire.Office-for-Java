import com.spire.doc.*;

public class mergeAndSplitTableCell {
    public static void main(String[] args) {

        String inputFile="data/tableSample.docx";
        String outputFile="output/mergeAndSplitTableCell.docx";

        //create a document and load file from disk
        Document document = new Document();
        document.loadFromFile(inputFile);

        Section section = document.getSections().get(0);
        Table table = section.getTables().get(0);

        //the method shows how to merge cell horizontally
        table.applyHorizontalMerge(6, 2, 3);

        //the method shows how to merge cell vertically
        table.applyVerticalMerge(2, 4, 5);

        //the method shows how to split the cell
        table.getRows().get(8).getCells().get(3).splitCell(2, 2);

        //save to file and launch it
        document.saveToFile(outputFile, FileFormat.Docx);
    }
}
