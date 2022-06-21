import com.spire.xls.*;

public class getWorksheetOfChart {
    public static void main(String[] args) throws Exception {
        String input = "data/ChartToImage.xlsx";

        //create a workbook
        Workbook workbook = new Workbook();

        //load the Excel document from disk
        workbook.loadFromFile(input);

        //access first worksheet of the workbook
        Worksheet worksheet = workbook.getWorksheets().get(0);

        //access the first chart inside this worksheet
        Chart chart = worksheet.getCharts().get(0);

        //get its worksheet
        Worksheet wSheet = (Worksheet)chart.getSheet();

        //create StringBuilder to save
        StringBuilder content = new StringBuilder();

        //set string format for displaying
        String result = String.format("Sheet Name: " + worksheet.getName() + "\r\nCharts' sheet Name: " + wSheet.getName());

        //add result string to StringBuilder
        content.append(result);

        //print out the result
        System.out.println(content.toString());
    }
}
