import com.spire.presentation.Presentation;

public class convertAllSlidesToSVG {
    public static void main(String[] args) throws Exception {
        //Load PPT document from disk
        Presentation ppt=new Presentation();
        ppt.loadFromFile("data/ConvertAllSlidesToSVG.pptx");
        //Save all slides to one svg
        byte[] bytes=ppt.saveToOneSVG();
        try(java.io.FileOutputStream stream = new java.io.FileOutputStream("output/AllSlidesToSVG.svg")){
            stream.write(bytes);
        }
    }
}
