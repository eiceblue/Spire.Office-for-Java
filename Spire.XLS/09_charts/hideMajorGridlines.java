import com.spire.xls.*;

public class hideMajorGridlines {
    public static void main(String[] args) throws Exception {
        String input = "data/SampeB_4.xlsx";
        String output = "output/hideMajorGridlines.xlsx";


        //create a workbook
        Workbook workbook = new Workbook();
        workbook.loadFromFile(input);

        //get the first sheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //get the chart
        Chart chart = sheet.getCharts().get(0);

        //hide major gridlines
        chart.getPrimaryValueAxis().hasMajorGridLines( false);

        //save and launch result file
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
