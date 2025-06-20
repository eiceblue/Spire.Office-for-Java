import com.spire.xls.*;

public class setCategoryTextDirection {
    public static void main(String[] args) {
        String input = "data/CategoryText.xlsx";
        String output = "output/setCategoryTextDirection_output.xlsx";

        //create a Workbook
        Workbook workbook = new Workbook();

        //load an Excel document
        workbook.loadFromFile(input);

        //get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //get the first chart
        Chart chart = sheet.getCharts().get(0);

        //set Category text direction
        chart.getPrimaryCategoryAxis().setTextDirection(TextVerticalValue.Vertical);

        //save to file
        workbook.saveToFile(output);
    }
}
