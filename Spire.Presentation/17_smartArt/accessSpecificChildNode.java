import com.spire.presentation.*;
import com.spire.presentation.diagrams.*;
import java.io.*;

public class accessSpecificChildNode {
    public static void main(String[] args) throws Exception{
        //Create PPT document
        Presentation presentation = new Presentation();

        //Load the PPT
        presentation.loadFromFile("data/SmartArt.pptx");

        //Create a new TXT File
        String result = "output/accessSpecificChildNode.txt";
        File file=new File(result);
        if(file.exists()){
            file.delete();
        }
        file.createNewFile();
        FileWriter fw=new FileWriter(file,true);
        BufferedWriter bw=new BufferedWriter(fw);

        bw.write("Access SmartArt child node at specific position." + "\r\n");
        bw.write("Here is the SmartArt child node parameters details:" + "\r\n");

        for (Object shapeObj : presentation.getSlides().get(0).getShapes())
        {
            IShape shape=(IShape)shapeObj;
            if (shape instanceof ISmartArt)
            {
                //Get the SmartArt
                ISmartArt sa = (ISmartArt)shape;

                //Get SmartArt node collection
                ISmartArtNodeCollection nodes = sa.getNodes();

                //Access SmartArt node at index 0
                ISmartArtNode node = nodes.get(0);

                //Access SmartArt child node at index 1
                ISmartArtNode childNode = node.getChildNodes().get(1);

                //Print the SmartArt child node parameters
                bw.write("Node text =" + childNode.getTextFrame().getText() + "\r\n");
                bw.write("Node level = " + childNode.getLevel() + "\r\n");
                bw.write("Node Position = " + childNode.getPosition() + "\r\n");
            }
        }

        bw.flush();
        bw.close();
        fw.close();
    }
}
