import com.spire.xls.*;

public class helloWorld {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();
        //Get the first sheet
        Worksheet sheet = workbook.getWorksheets().get(0);
        sheet.get("A1").setText("Hello World");

        sheet.get("A1").autoFitColumns();

        String result = "output/helloWorld.xlsx";

        //Save to file
        workbook.saveToFile(result, ExcelVersion.Version2010);
    }
}
