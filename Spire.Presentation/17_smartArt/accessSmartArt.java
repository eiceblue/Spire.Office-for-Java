import com.spire.presentation.*;
import com.spire.presentation.diagrams.*;
import java.io.*;

public class accessSmartArt {
    public static void main(String[] args) throws Exception{
        //Create PPT document
        Presentation presentation = new Presentation();

        //Load the PPT
        presentation.loadFromFile("data/SmartArt.pptx");

        //Create a new TXT File
        String result = "output/accessSmartArt.txt";
        File file=new File(result);
        if(file.exists()){
            file.delete();
        }
        file.createNewFile();
        FileWriter fw=new FileWriter(file,true);
        BufferedWriter bw=new BufferedWriter(fw);

        bw.write("Access SmartArt nodes." + "\r\n");
        bw.write("Here is the SmartArt node parameters details:" + "\r\n");

        ISmartArtNode node;
        for (Object shapeObj : presentation.getSlides().get(0).getShapes())
        {
            IShape shape=(IShape)shapeObj;
            if (shape instanceof ISmartArt)
            {
                //Get the SmartArt
                ISmartArt sa = (ISmartArt)shape ;
                ISmartArtNodeCollection nodes = sa.getNodes();

                //Traverse through all nodes inside SmartArt
                for (int i = 0; i < nodes.getCount(); i++)
                {
                    //Access SmartArt node at index i
                    node = nodes.get(i);

                    //Save the SmartArt node parameters
                    bw.write("Node text =" + node.getTextFrame().getText() + "\r\n");
                    bw.write("Node level = " + node.getLevel() + "\r\n");
                    bw.write("Node Position = " + node.getPosition() + "\r\n");
                }
            }
        }

        bw.flush();
        bw.close();
        fw.close();
    }
}
