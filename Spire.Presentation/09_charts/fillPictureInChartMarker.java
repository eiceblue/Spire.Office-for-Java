import com.spire.presentation.*;
import com.spire.presentation.charts.*;
import com.spire.presentation.charts.entity.ChartDataPoint;
import com.spire.presentation.drawing.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;

public class fillPictureInChartMarker {
    public static void main(String[] args) throws Exception {
        //Create PPT document and load file
        Presentation ppt = new Presentation();
        ppt.loadFromFile("data/ChartSample4.pptx");

        //Get chart on the first slide
        IChart chart = (IChart)ppt.getSlides().get(0).getShapes().get(0);

        File file = new File("data/Logo.png");
        //Load image file in ppt
        BufferedImage image = (BufferedImage)ImageIO.read(file);

        IImageData imageData = ppt.getImages().append(image);

        //Create a ChartDataPoint object and specify the index
        ChartDataPoint dataPoint = new ChartDataPoint(chart.getSeries().get(0));
        dataPoint.setIndex(0);

        //Fill picture in marker
        dataPoint.getMarkerFill().getFill().setFillType(FillFormatType.PICTURE);
        dataPoint.getMarkerFill().getFill().getPictureFill().getPicture().setEmbedImage(imageData);

        //Set marker size
        dataPoint.setMarkerSize(20);

        //Add the data point in series
        chart.getSeries().get(0).getDataPoints().add(dataPoint);

        String result = "output/fillPictureInChartMarker_result.pptx";
        //Save the document
        ppt.saveToFile(result, FileFormat.PPTX_2010);
    }
}
