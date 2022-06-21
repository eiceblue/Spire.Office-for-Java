import com.spire.xls.*;

public class setViewMode {
    public static void main(String[] args) {
        //Create a workbook and load a file
        Workbook workbook = new Workbook();
        workbook.loadFromFile("data/setViewMode.xlsx");

        //Set the view mode 
        workbook.getWorksheets().get(0).setViewMode(ViewMode.Preview);

        //Save the document
        String output = "output/setViewMode_result.xlsx";
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
