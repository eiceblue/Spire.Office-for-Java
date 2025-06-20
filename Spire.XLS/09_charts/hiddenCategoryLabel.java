import com.spire.xls.*;

public class hiddenCategoryLabel {
    public static void main(String[] args) {

        String input = "data/ChartSample1.xlsx";
        String output = "output/hiddenCategoryLabel.xlsx";

        //Create a new instance of Workbook
        Workbook workbook = new Workbook();

        //Load the workbook from the specified file path
        workbook.loadFromFile(input);

        //Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Get the first chart
        Chart chart = sheet.getCharts().get(0);

        //Get all category labels
        String[] labels = chart.getCategoryLabels();

        //Hide the first category label
        chart.hideCategoryLabels(new String[]{labels[0]});

        //Save the workbook to the specified output file path in Excel 2010 format
        workbook.saveToFile(output, ExcelVersion.Version2010);

        //Release the resources used by the workbook
        workbook.dispose();
    }
}
