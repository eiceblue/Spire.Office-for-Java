import com.spire.presentation.Presentation;

import java.util.ArrayList;

public class getSlideText{
    public static void main(String[] args) throws Exception {
        //Load PPT from disk
        Presentation ppt = new Presentation();
        ppt.loadFromFile("data/GetSlideText.pptx");
        //Loop through all slides
        for(int i=0;i<ppt.getSlides().getCount();i++){
            //Get text from slide
            ArrayList arrayList=ppt.getSlides().get(i).getAllTextFrame();
            for(int j=0;j<arrayList.size();j++){
                System.out.println(arrayList.get(j));
            }
        }
    }
}
