import com.spire.xls.*;

public class toPDFSimply {
    public static void main(String[] args) {
        String inputFile = "data/ExcelSampleN.xlsx";
        String outputFile = "output/toPDFSimply.pdf";

        //Create a workbook
        Workbook workbook = new Workbook();

        //Load a file
        workbook.loadFromFile(inputFile);

        //Save to PDF file
        workbook.saveToFile(outputFile, FileFormat.PDF);

    }
}
