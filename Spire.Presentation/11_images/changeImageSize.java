
import com.spire.presentation.*;

public class changeImageSize {
    public static void main(String[] args) throws Exception {
        String inputFile ="data/extractImage.pptx";
        String outputFile="output/changeImageSize.pptx";

        Presentation ppt = new Presentation();
        ppt.loadFromFile(inputFile);

        float scale=0.5f;

        for (int i = 0; i < ppt.getSlides().getCount(); i++) {

            ISlide slide = ppt.getSlides().get(i);
            for(int j = 0; j < slide.getShapes().getCount(); j ++)
            {
                IShape shape = slide.getShapes().get(j);
                if (shape instanceof IEmbedImage)
                {

                    IEmbedImage image = (IEmbedImage)shape;
                    image.setWidth(image.getWidth() * scale);
                    image.setHeight(image.getHeight()* scale);
                }
            }
        }

        ppt.saveToFile(outputFile, FileFormat.PPTX_2013);
    }
}
