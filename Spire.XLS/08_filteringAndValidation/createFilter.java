import com.spire.xls.*;

public class createFilter {
    public static void main(String[] args) {

        //Create a new workbook and load Excel data
        Workbook workbook = new Workbook();
        workbook.loadFromFile("data/CreateFilter.xlsx");
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Create filter
        sheet.getAutoFilters().setRange(sheet.getCellRange("A1:J1"));

        workbook.saveToFile("output/CreateFilter.xlsx", ExcelVersion.Version2010);
    }
}
