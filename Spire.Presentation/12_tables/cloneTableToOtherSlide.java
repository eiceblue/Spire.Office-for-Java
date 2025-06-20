import com.spire.presentation.*;

public class cloneTableToOtherSlide {
    public static void main(String[] args) throws Exception {
        //Load the input ppt file
        Presentation ppt = new Presentation();
        ppt.loadFromFile("data/cloneTable.pptx");

        //Get the table
        ITable table = (ITable)ppt.getSlides().get(0).getShapes().get(0);

        //Create a new ppt file
        Presentation ppt2 = new Presentation();
        ISlide slide = ppt2.getSlides().get(0);

        //Clone the table of the first ppt to the second ppt
        slide.getShapes().appendTable(60,60,table);

        //Save the second ppt file
        String outputFile = "output/result_cloneTableToOtherSlide.pptx";
        ppt2.saveToFile(outputFile, FileFormat.PPTX_2013);
    }
}
