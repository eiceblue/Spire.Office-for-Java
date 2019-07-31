import com.spire.presentation.*;

public class changeSlideLayout {
    public static void main(String[] args) throws Exception{
        String inputFile = "data/changeSlideLayout.pptx";
        String outputFile = "output/changeSlideLayout_result.pptx";
        Presentation ppt = new Presentation();
        ppt.loadFromFile(inputFile);
        //Change the layout of slide
        ppt.getSlides().get(1).setLayout(ppt.getMasters().get(0).getLayouts().get(4));
        ppt.saveToFile(outputFile, FileFormat.PPTX_2010);
        ppt.dispose();
    }
}
