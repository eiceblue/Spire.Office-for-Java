import com.spire.xls.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class chartToImage {
    public static void main(String[] args) throws Exception {
        String input = "data/ChartToImage.xlsx";
        String output = "output/chartToImage.png";

        //Load file from disk
        Workbook workbook = new Workbook();
        workbook.loadFromFile(input);

        //save chart as image
        BufferedImage image= workbook.saveChartAsImage(workbook.getWorksheets().get(0), 0);
        ImageIO.write(image,"png",new File(output));
    }
}
