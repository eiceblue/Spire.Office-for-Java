import com.spire.presentation.*;
import com.spire.presentation.charts.*;

public class setRotationForValueAxisText {
    public static void main(String[] args) throws Exception{
       //Create PPT document and load file
        Presentation ppt = new Presentation();
        ppt.loadFromFile("data/ChartSample2.pptx");
        //Get chart on the first slide
        IChart chart = (IChart)ppt.getSlides().get(0).getShapes().get(0);

        //Set the rotation angle for the text on the value axis
        chart.getPrimaryValueAxis().setTextRotationAngle(45);

        String result = "output/setRotationForValueAxisText_result.pptx";
        //Save the document
        ppt.saveToFile(result, FileFormat.PPTX_2010);
    }
}
