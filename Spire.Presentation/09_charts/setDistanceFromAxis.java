import com.spire.presentation.*;
import com.spire.presentation.charts.*;
import com.spire.presentation.charts.entity.IChartAxis;
import java.awt.geom.Rectangle2D;

public class setDistanceFromAxis {
    public static void main(String[] args) throws Exception {
        //create a powerpoint file
        Presentation ppt = new Presentation();

        //get the first slide
        ISlide slide = ppt.getSlides().get(0);

        //Append a chart in slide
        Rectangle2D rect = new Rectangle2D.Double(50, 50, 400, 400);
        IChart chart = slide.getShapes().appendChart(ChartType.COLUMN_CLUSTERED, rect);

        //get the PrimaryCategory axis
        IChartAxis chartAxis = chart.getPrimaryCategoryAxis();

        //set "Distance from axis"
        chartAxis.setLabelsDistance(200);

        //Save to file
        ppt.saveToFile("setDistanceFromAxis.pptx", FileFormat.PPTX_2013);
    }
}
