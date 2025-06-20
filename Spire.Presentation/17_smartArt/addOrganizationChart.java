import com.spire.presentation.*;
import com.spire.presentation.diagrams.SmartArtLayoutType;

public class addOrganizationChart {
    public static void main(String[] args) throws Exception {
        //Create a PPT document
        Presentation presentation = new Presentation();

        //Get the first slide and insert Picture Organization Chart
        ISlide slide0 =  presentation.getSlides().get(0);
        slide0.getShapes().appendSmartArt(50, 50, 250, 250, SmartArtLayoutType.PICTURE_ORGANIZATION_CHART);

        //Append a new slide and insert Name and Title Organization Chart
        ISlide newSlide = presentation.getSlides().append();
        newSlide.getShapes().appendSmartArt(50, 50, 250, 250, SmartArtLayoutType.NAME_AND_TITLE_ORGANIZATION_CHART);

        //Save the result file
        presentation.saveToFile("output/addOrganizationChart_result.pptx", FileFormat.PPTX_2013);
    }
}
