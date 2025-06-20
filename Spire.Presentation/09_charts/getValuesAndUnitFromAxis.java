import com.spire.presentation.*;
import com.spire.presentation.charts.*;

public class getValuesAndUnitFromAxis {
    public static void main(String[] args) throws Exception {
        Presentation ppt = new Presentation();
        ppt.loadFromFile("data/ChartSample2.pptx");

        //Get chart on the first slide
        IChart chart = (IChart)ppt.getSlides().get(0).getShapes().get(0);

        //Get unit from primary category axis
        float MajorUnit = chart.getPrimaryCategoryAxis().getMajorUnit();
        ChartBaseUnitType type = chart.getPrimaryCategoryAxis().getMajorUnitScale();

        System.out.println(MajorUnit);
        System.out.println(type );

        //Get values from primary value axis
        float minValue = chart.getPrimaryValueAxis().getMinValue();
        float maxValue = chart.getPrimaryValueAxis().getMaxValue();

        System.out.println(minValue);
        System.out.println(maxValue);
    }
}
