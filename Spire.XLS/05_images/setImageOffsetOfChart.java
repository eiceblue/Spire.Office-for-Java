import com.spire.xls.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class setImageOffsetOfChart {
    public static void main(String[] args) throws Exception {
        //Create a workbook.
        Workbook workbook = new Workbook();

        //Load the file from disk.
        workbook.loadFromFile( "data/Template_Xls_1.xlsx");

        //Get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        Worksheet sheet1 = workbook.getWorksheets().add("Contrast");

        //Add chart1 and background image to sheet1 as comparision.
        Chart chart1 = sheet1.getCharts().add(ExcelChartType.ColumnClustered);
        chart1.setDataRange(sheet.getCellRange("D1:E8"));
        chart1.setSeriesDataFromRange(false);

        //Chart Position.
        chart1.setLeftColumn(1);
        chart1.setTopRow(11);
        chart1.setRightColumn(8);
        chart1.setBottomRow(33);

        BufferedImage bufferedImage = ImageIO.read(new File("data/Background.png"));
        //Add picture as background.
        chart1.getChartArea().getFill().customPicture(bufferedImage,"None");


        //Set the image offset.
        chart1.getChartArea().getFill().getPicStretch().setLeft(20);
        chart1.getChartArea().getFill().getPicStretch().setTop(20);
        chart1.getChartArea().getFill().getPicStretch().setRight(5);
        chart1.getChartArea().getFill().getPicStretch().setBottom(5);

        String result = "output/Result-SetImageOffsetOfChart.xlsx";

        //Save to file.
        workbook.saveToFile(result, ExcelVersion.Version2013);
    }
}
