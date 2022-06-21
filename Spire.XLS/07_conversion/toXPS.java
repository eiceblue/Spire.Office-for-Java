import com.spire.xls.*;

public class toXPS {
    public static void main(String[] args) {
        String  inputFile = "data/CreateTable.xlsx";
        String  outputFile = "output/ToXPS.xps";
        //Open xls document
        Workbook workbook = new Workbook();
        workbook.loadFromFile(inputFile);
        //Convert to XPS
        workbook.saveToFile(outputFile, FileFormat.XPS);
    }
}
