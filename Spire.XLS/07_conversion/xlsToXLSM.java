import com.spire.xls.ExcelVersion;
import com.spire.xls.Workbook;

public class xlsToXLSM {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the document from disk
        workbook.loadFromFile("data/MacroSample.xls",ExcelVersion.Version97to2003);

        //Save the workbook as a new XLSM file
        String output = "output/XLSToXLSM.xlsm";
        workbook.saveToFile(output);
    }
}
