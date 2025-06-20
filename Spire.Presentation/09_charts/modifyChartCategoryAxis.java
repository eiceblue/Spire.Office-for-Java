import com.spire.presentation.*;
import com.spire.presentation.charts.*;

public class modifyChartCategoryAxis {
    public static void main(String[] args) throws Exception {
        //Create PPT document and load file
        Presentation ppt = new Presentation();
        ppt.loadFromFile("data/ChartSample2.pptx");

        //Get chart on the first slide
        IChart chart = (IChart)ppt.getSlides().get(0).getShapes().get(0);

        //Modify the major unit
        chart.getPrimaryCategoryAxis().isAutoMajor(false);
        chart.getPrimaryCategoryAxis().setMajorUnit(1);
        chart.getPrimaryCategoryAxis().setMajorUnitScale(ChartBaseUnitType.MONTHS);

        String result = "output/modifyChartCategoryAxis_result.pptx";
        //Save the document
        ppt.saveToFile(result, FileFormat.PPTX_2010);
    }
}
