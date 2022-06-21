import com.spire.xls.*;
import java.awt.*;

public class setMarkerColorForSparkline {
    public static void main(String[] args) {
        Workbook book = new Workbook();
        book.loadFromFile("data/SparkLine.xlsx");
        Worksheet worksheet = book.getWorksheets().get(0);
        SparklineGroupCollection sparklineGroup = worksheet.getSparklineGroups();
        sparklineGroup.get(1).setMarkersColor(Color.RED);
        book.saveToFile("output/setMarkerColorForSparkline.xlsx", FileFormat.Version2016);
    }
}
