import com.spire.presentation.*;

public class removeTextBox {
    public static void main(String[] args) throws Exception {
        //Create an instance of presentation document
        Presentation ppt = new Presentation();
        //Load file
        ppt.loadFromFile("data/textBoxTemplate.pptx");

        //Get the first slide
        ISlide slide = ppt.getSlides().get(0);
        //Traverse all the shapes in slide
        for (int i = 0; i < slide.getShapes().getCount(); i++) {
            if(slide.getShapes().get(i).getName().Contains("TextBox")){
                	slide.getShapes().removeAt(i);
                	i--;
                }
        }

        //Save the document
        String result = "output/removeTextBox.pptx";
        ppt.saveToFile(result, FileFormat.PPTX_2013);
    }
}
