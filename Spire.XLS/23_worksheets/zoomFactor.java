import com.spire.xls.*;

public class zoomFactor {
    public static void main(String[] args) {
        //Create a workbook and load a file
        Workbook workbook = new Workbook();
        workbook.loadFromFile("data/zoomFactor.xlsx");

        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Set the zoom factor of the sheet to 85
        sheet.setZoom(85);

        //Save the document and launch it
        String output = "output/zoomFactor_result.xlsx";
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
