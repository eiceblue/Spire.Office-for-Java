import com.spire.presentation.*;
import com.spire.presentation.diagrams.*;
import java.io.*;

public class accessChildNodes {
    public static void main(String[] args) throws Exception{
        //Create PPT document
        Presentation presentation = new Presentation();

        //Load the PPT
        presentation.loadFromFile("data/SmartArt.pptx");

        //Create a new TXT File
        String result = "output/accessChildNodes.txt";
        File file=new File(result);
        if(file.exists()){
            file.delete();
        }
        file.createNewFile();
        FileWriter fw=new FileWriter(file,true);
        BufferedWriter bw=new BufferedWriter(fw);

        bw.write("Access SmartArt child nodes." + "\r\n");
        bw.write("Here is the SmartArt child node parameters details:" + "\r\n");

        for (Object shapeObj : presentation.getSlides().get(0).getShapes())
        {
            IShape shape=(IShape)shapeObj;
            if (shape instanceof ISmartArt)
            {
                //Get the SmartArt and collect nodes
                ISmartArt sa = (ISmartArt)shape;
                ISmartArtNodeCollection nodes = sa.getNodes();

                int position = 0;
                //Access the parent node at position 0
                ISmartArtNode node = nodes.get(position);
                ISmartArtNode childnode;

                //Traverse through all child nodes inside SmartArt
                for (int i = 0; i < node.getChildNodes().getCount(); i++)
                {
                    //Access SmartArt child node at index i
                    childnode = node.getChildNodes().get(i);

                    //Save the SmartArt child node parameters
                    bw.write("Node text =" + childnode.getTextFrame().getText() + "\r\n");
                    bw.write("Node level = " + childnode.getLevel() + "\r\n");
                    bw.write("Node Position = " + childnode.getPosition() + "\r\n");
                }
            }
        }

        bw.flush();
        bw.close();
        fw.close();
    }
}
