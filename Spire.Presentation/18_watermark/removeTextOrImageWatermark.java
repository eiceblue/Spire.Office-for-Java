import com.spire.presentation.*;
import com.spire.presentation.drawing.FillFormatType;

public class removeTextOrImageWatermark {
    public static void main(String[] args) throws Exception{
        //Create a PowerPoint document.
        Presentation presentation = new Presentation();

        //Load the file from disk.
        presentation.loadFromFile("data/RemoveTextAndImageWatermarks.pptx");

        //Remove text watermark by removing the shape which contains the text string "E-iceblue".
        for (int i = 0; i < presentation.getSlides().getCount(); i++)
        {
            for (int j = 0; j < presentation.getSlides().get(i).getShapes().getCount(); j++)
            {
                if (presentation.getSlides().get(i).getShapes().get(j) instanceof IAutoShape)
                {
                    IAutoShape shape = (IAutoShape)presentation.getSlides().get(i).getShapes().get(j);
                    if (shape.getTextFrame().getText().contains("E-iceblue"))
                    {
                        presentation.getSlides().get(i).getShapes().remove(shape);
                    }
                }
            }
        }

        //Remove image watermark.
        for (int i = 0; i < presentation.getSlides().getCount(); i++)
        {
            presentation.getSlides().get(i).getSlideBackground().getFill().setFillType(FillFormatType.NONE);
        }

        String result = "output/removeTextOrImageWatermark.pptx";

        //Save to file.
        presentation.saveToFile(result, FileFormat.PPTX_2013);
    }
}
