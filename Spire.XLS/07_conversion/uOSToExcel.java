import com.spire.xls.*;

public class uOSToExcel {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook=new Workbook();
        //Load the UOS from disk
        workbook.loadFromFile("data/input.uos",ExcelVersion.UOS);
        //Convert to Excel
        workbook.saveToFile("output/output.xlsx",ExcelVersion.Version2013);
    }
}
