import com.spire.xls.*;

import java.io.*;

public class chartSheetToSVG {

    public static void main(String[] args) throws Exception {

        Workbook workbook = new Workbook();
        //Load file from disk
        workbook.loadFromFile("data/ChartSheet.xlsx");

        //Get the second chartsheet by name
        ChartSheet sheet = workbook.getChartSheetByName("Chart1");
        FileOutputStream stream = new FileOutputStream("output/chartSheetToSVG.svg");

        sheet.toSVGStream(stream);
        stream.flush();
        stream.close();
    }
}
