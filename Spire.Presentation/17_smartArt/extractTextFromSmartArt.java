import com.spire.presentation.Presentation;
import com.spire.presentation.diagrams.ISmartArt;
import java.io.*;

public class extractTextFromSmartArt {
    public static void main(String[] args) throws Exception{
        //Create a PowerPoint document.
        Presentation presentation = new Presentation();

        //Load the file from disk.
        presentation.loadFromFile("data/ExtractTextFromSmartArt.pptx");

        //Create a new TXT File
        String result = "output/extractTextFromSmartArt.txt";
        File file=new File(result);
        if(file.exists()){
            file.delete();
        }
        file.createNewFile();
        FileWriter fw=new FileWriter(file,true);
        BufferedWriter bw=new BufferedWriter(fw);

        bw.write("Below is extracted text from SmartArt:" + "\r\n");

        //Traverse through all the slides of the PPT file and find the SmartArt shapes.
        for (int i = 0; i < presentation.getSlides().getCount(); i++)
        {
            for (int j = 0; j < presentation.getSlides().get(i).getShapes().getCount(); j++)
            {
                if (presentation.getSlides().get(i).getShapes().get(j) instanceof ISmartArt)
                {
                    ISmartArt smartArt = (ISmartArt)presentation.getSlides().get(i).getShapes().get(j);

                    //Extract text from SmartArt and append to the StringBuilder object.
                    for (int k = 0; k < smartArt.getNodes().getCount(); k++)
                    {
                        bw.write(smartArt.getNodes().get(k).getTextFrame().getText() + "\r\n");
                    }
                }
            }
        }
        bw.flush();
        bw.close();
        fw.close();
    }
}
