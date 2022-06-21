import com.spire.xls.*;

public class addPictureInChart {
    public static void main(String[] args) {
        //Load the document from disk
        Workbook workbook = new Workbook();
        workbook.loadFromFile("data/ChartToImage.xlsx");

        //Get the first sheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Get the chart
        Chart chart = sheet.getCharts().get(0);

        //Add the picture in chart
        chart.getShapes().addPicture("data/SpireXls.png");

        //Save and launch result file
        String result = "output/AddPictureInChart_out.xlsx";
        workbook.saveToFile(result, ExcelVersion.Version2010);
    }
}
