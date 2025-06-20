import com.spire.presentation.*;
import com.spire.presentation.charts.*;
import com.spire.presentation.charts.entity.*;

public class setRotationForDataLabel {
    public static void main(String[] args) throws Exception {
        //Create PPT document and load file
        Presentation ppt = new Presentation();
        ppt.loadFromFile("data/SetRotationForDataLabel.pptx");

        //Get chart on the first slide
        IChart Chart = (IChart) ppt.getSlides().get(0).getShapes().get(0);

        //Set the rotation angle for the data labels of first series
        for (int i = 0; i < Chart.getSeries().get(0).getValues().getCount(); i++) {
            ChartDataLabel label = Chart.getSeries().get(0).getDataLabels().add();
            label.setID(i);
            label.setRotationAngle(45);
        }

        String result = "output/setRotationForDataLabel_out.pptx";

        //Save the document
        ppt.saveToFile(result, FileFormat.PPTX_2013);
    }
}