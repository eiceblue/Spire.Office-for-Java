import com.spire.xls.*;

public class toODS {
    public static void main(String[] args) {
        String inputFile = "data/ToODS.xlsx";
        String outputFile = "output/ToODS_out.ods";

        //Create a workbook
        Workbook workbook = new Workbook();

        //Load an excel document
        workbook.loadFromFile(inputFile);

        //Convert to ODS file
        workbook.saveToFile(outputFile, FileFormat.ODS);
    }
}
