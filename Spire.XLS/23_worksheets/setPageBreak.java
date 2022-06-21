import com.spire.xls.*;

public class setPageBreak {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the document from disk
        workbook.loadFromFile("data/worksheetSample1.xlsx");

        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Set Excel Page Break Horizontally
        sheet.getHPageBreaks().add(sheet.getRange().get("A8"));
        sheet.getHPageBreaks().add(sheet.getRange().get("A14"));

        //Set Excel Page Break Vertically
        //sheet.getVPageBreaks().add(sheet.getRange().get("B1"));
        //sheet.getVPageBreaks().add(sheet.getRange().get("C1"));

        //Set view mode to Preview mode
        workbook.getWorksheets().get(0).setViewMode(ViewMode.Preview);

        //Save the document
        String output = "output/setPageBreak_result.xlsx";
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
