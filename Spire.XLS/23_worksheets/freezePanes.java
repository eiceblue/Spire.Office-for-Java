import com.spire.xls.*;

public class freezePanes {
    public static void main(String[] args) {
        //Load a Workbook from disk
        Workbook workbook = new Workbook();
        workbook.loadFromFile("data/freezePanes.xlsx");

        //Get the first sheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Freeze Top Row
        sheet.freezePanes(2, 1);

        //Save and Launch
        String output = "output/freezePanes_result.xlsx";
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
