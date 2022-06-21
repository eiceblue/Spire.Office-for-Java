import com.spire.xls.*;

public class chartAxisTitle {
    public static void main(String[] args) throws Exception {
        String input = "data/SampeB_5.xlsx";
        String output = "output/chartAxisTitle.xlsx";

        //create a workbook
        Workbook workbook = new Workbook();
        workbook.loadFromFile(input);

        //get the first sheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //get the chart
        Chart chart = sheet.getCharts().get(0);

        //set axis title
        chart.getPrimaryCategoryAxis().setTitle("Category Axis");
        chart.getPrimaryValueAxis().setTitle( "Value axis");

        //set font size
        chart.getPrimaryCategoryAxis().getFont().setSize(12);
        chart.getPrimaryValueAxis().getFont().setSize(12);

        //save the result file
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
