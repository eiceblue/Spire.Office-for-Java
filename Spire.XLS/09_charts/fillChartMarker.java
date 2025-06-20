import com.spire.xls.*;
import com.spire.xls.core.IShapeFill;

import java.awt.*;

public class fillChartMarker {
    public static void main(String[] args) {
        String inputFile = "data/FillChartMarker.xlsx";
        String imageFile = "data/E-iceblueLogo.png";
        String outputFile = "output/FillChartMarker_out.xlsx";

        //Load the excel file
        Workbook workbook = new Workbook();
        workbook.loadFromFile(inputFile);

        //Get the first chart object
        Worksheet worksheet = workbook.getWorksheets().get(0);
        Chart chart =worksheet.getCharts().get(0);

        //Fill chart marker with custom picture
        chart.getSeries().get(0).getFormat().getLineProperties().setColor(Color.yellow);
        chart.getSeries().get(0).getFormat().setMarkerStyle(ChartMarkerType.Picture);
        IShapeFill markerFill = chart.getSeries().get(0).getDataFormat().getMarkerFill();
        markerFill.customPicture(imageFile);

        //Fill chart marker with texture
        IShapeFill markerFill2 = chart.getSeries().get(1).getDataFormat().getMarkerFill();
        chart.getSeries().get(1).getFormat().getLineProperties().setColor(Color.red);
        markerFill2.setTexture(GradientTextureType.Granite);

        //Fill chart marker with pattern
        chart.getSeries().get(2).getFormat().getLineProperties().setColor(Color.BLUE); //系列的线条颜色
        IShapeFill markerFill3 = chart.getSeries().get(2).getDataFormat().getMarkerFill();
        markerFill3.setPattern(GradientPatternType.Pat10Percent);
        markerFill3.setForeColor(Color.lightGray);
        markerFill3.setBackColor(Color.ORANGE);

        //Save the result file
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);
    }
}
