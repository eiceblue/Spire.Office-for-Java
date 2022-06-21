import com.spire.xls.*;

public class changeDataRange {
    public static void main(String[] args) throws Exception {
        String input = "data/SampeB_4.xlsx";
        String output = "output/changeDataRange.xlsx";

        //create a workbook
        Workbook workbook = new Workbook();
        workbook.loadFromFile(input);

        //get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //get chart
        Chart chart = sheet.getCharts().get(0);

        //change data range
        chart.setDataRange(sheet.getCellRange("A1:C4"));

        //save and launch result file
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
