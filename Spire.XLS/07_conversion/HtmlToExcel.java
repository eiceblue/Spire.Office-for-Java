import com.spire.xls.ExcelVersion;
import com.spire.xls.Workbook;

public class HtmlToExcel {

    public static void main(String[] args) {
        //Input and output file path
        String inputFile = "data/HtmlToExcel.html";
        String outputFile="output/HtmlToExcel_output.xlsx";
        //Create a workbook
        Workbook workbook = new Workbook();
        //Load HTML file from disk
        workbook.loadFromHtml(inputFile);

        //Save workbook to .xlsx file
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);
        //Dispose
        workbook.dispose();
    }
}
