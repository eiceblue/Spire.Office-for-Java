import com.spire.presentation.*;
import com.spire.presentation.charts.ChartType;
import com.spire.presentation.diagrams.SmartArtLayoutType;

public class operatePlaceholders {
    public static void main(String[] args) throws Exception {
        String input="data/operatePlaceholders.pptx";
        String result="output/operatePlaceholders_result.pptx";

        //Create a PPT document
        Presentation presentation = new Presentation();

        //Load the document from disk
        presentation.loadFromFile(input);

        //Operate placeholders
        for (int j=0;j<presentation.getSlides().getCount();j++)
        {
            ISlide slide = presentation.getSlides().get(j);

            for (int i=0;i<slide.getShapes().getCount();i++)
            {
                Shape shape = (Shape)slide.getShapes().get(i);
                switch(shape.getPlaceholder().getType())
                {
                    case MEDIA:
                        shape.insertVideo("data/Video.mp4");
                        break;

                    case PICTURE:
                        shape.insertPicture("data/E-iceblueLogo.png");
                        break;

                    case CHART:
                        shape.insertChart(ChartType.COLUMN_CLUSTERED);
                        break;

                    case TABLE:
                        shape.insertTable(3,2);
                        break;

                    case DIAGRAM:
                        shape.insertSmartArt(SmartArtLayoutType.BASIC_BLOCK_LIST);
                        break;
                }
            }
        }

        //Save the document
        presentation.saveToFile(result, FileFormat.PPTX_2013);
        presentation.dispose();
    }
}
