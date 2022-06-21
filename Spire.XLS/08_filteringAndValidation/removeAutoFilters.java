import com.spire.xls.*;

public class removeAutoFilters {
    public static void main(String[] args) {

        Workbook workbook = new Workbook();
        workbook.loadFromFile("data/RemoveAutoFilters.xlsx");
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Remove the auto filters
        sheet.getAutoFilters().clear();

        //Save the document
        String output = "output/removeAutoFilters.xlsx";
        workbook.saveToFile(output, ExcelVersion.Version2013);

    }
}
