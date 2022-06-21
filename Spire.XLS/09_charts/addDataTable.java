import com.spire.xls.*;

public class addDataTable {
    public static void main(String[] args)throws Exception {
        String input = "data/AddDataTable.xlsx";
        String output = "output/addDataTable_output.xlsx";

        //create a Workbook
        Workbook workbook = new Workbook();
        workbook.loadFromFile(input);

        //get the first sheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //get the first chart
        Chart chart = sheet.getCharts().get(0);

        //add data table
        chart.hasDataTable(true);

        //save the result file
        workbook.saveToFile(output, FileFormat.Version2013);
    }
}
