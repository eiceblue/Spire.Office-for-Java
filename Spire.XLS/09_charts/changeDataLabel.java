import com.spire.xls.*;

public class changeDataLabel {
    public static void main(String[] args) throws Exception {
        String input = "data/ChangeDataLabel.xlsx";
        String output = "output/changeDataLabel_output.xlsx";

        //create a workbook
        Workbook workbook = new Workbook();
        workbook.loadFromFile(input);

        //get the firstworksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //get the chart
        Chart chart = sheet.getCharts().get(0);

        //change data label of the frist datapoint of the first series
        chart.getSeries().get(0).getDataPoints().get(0).getDataLabels().setText("changed data label");

        //save and launch result file
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
