import com.spire.presentation.*;
import com.spire.presentation.charts.IChart;
import com.spire.presentation.drawing.FillFormatType;

public class setChartBorderCorners {
    public static void main(String[] args) throws Exception {
        //Input file path
        String input = "data/ChartSample2.pptx";

        //Output file path
        String output ="output/setChartBorderCorners_output.pptx";

        //Create PPT document and load file
        Presentation ppt = new Presentation();
        ppt.loadFromFile(input);

        //Get chart on the first slide
        ISlide slide = ppt.getSlides().get(0);
        IChart chart = (IChart)slide.getShapes().get(0);

        //Set border as solid
        chart.getLine().setFillType(FillFormatType.SOLID);

        //Set border to right angle, "false" for right angles, "true" for rounded corners
        chart.setBorderRoundedCorners(false);

        //Save to file
        ppt.saveToFile(output, FileFormat.PPTX_2013);
    }
}
