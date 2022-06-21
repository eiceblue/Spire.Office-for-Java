import com.spire.xls.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class fillChartElementWithPicture {
    public static void main(String[] args) throws Exception {
        String input1 = "data/ChartSample1.xlsx";
        String input2 = "data/background.png";
        String output = "output/fillChartElementWithPicture.xlsx";

        //create a workbook
        Workbook workbook = new Workbook();

        //load the document from disk
        workbook.loadFromFile(input1);

        //get the first worksheet from workbook
        Worksheet ws = workbook.getWorksheets().get(0);

        //get the first chart
        Chart chart = ws.getCharts().get(0);

        // A. Fill chart area with image
        BufferedImage image = ImageIO.read(new File(input2));
        chart.getChartArea().getFill().customPicture(image,"None");
        chart.getPlotArea().getFill().setTransparency(0.9);

        // B.Fill plot area with image
        //chart.getPlotArea().getFill().customPicture(image,"None");

        //save the document
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
