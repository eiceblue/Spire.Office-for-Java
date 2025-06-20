import com.spire.presentation.*;
import com.spire.presentation.diagrams.ISmartArt;
import java.io.*;

public class accessSmartArtLayout {
    public static void main(String[] args) throws Exception{
        //Create PPT document
        Presentation presentation = new Presentation();

        //Load the PPT
        presentation.loadFromFile("data/SmartArt.pptx");

        //Create a new TXT File
        String result = "output/accessSmartArtLayout.txt";
        File file=new File(result);
        if(file.exists()){
            file.delete();
        }
        file.createNewFile();
        FileWriter fw=new FileWriter(file,true);
        BufferedWriter bw=new BufferedWriter(fw);

        for (Object shapeObj : presentation.getSlides().get(0).getShapes())
        {
            IShape shape=(IShape)shapeObj;
            if (shape instanceof ISmartArt)
            {
                //Get the SmartArt and collect nodes
                ISmartArt sa = (ISmartArt)shape;

                //Check SmartArt Layout
                String layout = sa.getLayoutType().toString();
                bw.write("SmartArt layout type is "+layout);
            }
        }

        bw.flush();
        bw.close();
        fw.close();
    }
}
