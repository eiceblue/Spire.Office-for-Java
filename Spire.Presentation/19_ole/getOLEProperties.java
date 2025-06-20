import com.spire.presentation.*;
import com.spire.presentation.collections.OleObjectCollection;
import java.io.FileWriter;

public class getOLEProperties{

    public static void main(String[] args) {
        //create a PPT document
        Presentation ppt = new Presentation();

        //load ppt file
        ppt.loadFromFile("data/GetOLEPropertiesOutsideOfShape.pptx");

        //get the first slide
        OleObjectCollection oles = ppt.getSlides().get(0).getOleObjects();

        //get the first OLE
        OleObject oleO = oles.get(0);

        //create StringBuilder
        StringBuilder str = new StringBuilder();

        //get the information of OLE Object
        str.append("FrameHight=" +oleO.getFrame().getHeight()+"\n");
        str.append("FrameWidth=" +oleO.getFrame().getWidth()+"\n");
        str.append("FrameTop="+oleO.getFrame().getTop()+"\n");
        str.append("FrameLeft=" + oleO.getFrame().getLeft()+"\n");

        //save to text file
        String output = "out.txt";
        FileWriter writer = new FileWriter(output);
        writer.write(str.toString());
        writer.flush();
        writer.close();
        ppt.dispose();
    }
}

