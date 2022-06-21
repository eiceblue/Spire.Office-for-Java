import com.spire.xls.*;

public class autofilterBlank {
    public static void main(String[] args) {

        Workbook workbook = new Workbook();
        workbook.loadFromFile("data/AutofilterBlank.xlsx");
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Match the blank data
        sheet.getAutoFilters().matchBlanks(0);

        //Filter
        sheet.getAutoFilters().filter();

        workbook.saveToFile("output/autofilterBlank.xlsx", ExcelVersion.Version2010);
    }
}
