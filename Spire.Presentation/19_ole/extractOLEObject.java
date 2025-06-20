import com.spire.presentation.*;
import java.io.FileOutputStream;

public class extractOLEObject {
    public static void main(String[] args) throws Exception{
        //Create a PPT document
        Presentation presentation = new Presentation();

        //Load document from disk
        presentation.loadFromFile("data/ExtractOLEObject.pptx");

        //Loop through the slides and shapes
        for (Object slideObj : presentation.getSlides())
        {
            ISlide slide=(ISlide)slideObj;
            for (Object shapeObj : slide.getShapes())
            {
                IShape shape=(IShape)shapeObj;
                if (shape instanceof IOleObject)
                {
                    //Find OLE object
                    IOleObject oleObject = (IOleObject)shape;

                    //Get its data and write to file
                    byte[] bytes = oleObject.getData();
                    switch (oleObject.getProgId())
                    {
                        case "Excel.Sheet.8":
                            String result1 = "output/extractOLEObject.xls";
                            FileOutputStream output1=new FileOutputStream(result1);
                            output1.write(bytes);
                            output1.close();
                            break;
                        case "Excel.Sheet.12":
                            String result2 = "output/extractOLEObject.xlsx";
                            FileOutputStream output2=new FileOutputStream(result2);
                            output2.write(bytes);
                            output2.close();
                            break;
                        case "Word.Document.8":
                            String result3 = "output/extractOLEObject.doc";
                            FileOutputStream output3=new FileOutputStream(result3);
                            output3.write(bytes);
                            output3.close();
                            break;
                        case "Word.Document.12":
                            String result4 = "output/extractOLEObject.docx";
                            FileOutputStream output4=new FileOutputStream(result4);
                            output4.write(bytes);
                            output4.close();
                            break;
                        case "PowerPoint.Show.8":
                            String result5 = "output/extractOLEObject.ppt";
                            FileOutputStream output5=new FileOutputStream(result5);
                            output5.write(bytes);
                            output5.close();
                            break;
                        case "PowerPoint.Show.12":
                            String result6 = "output/extractOLEObject.pptx";
                            FileOutputStream output6=new FileOutputStream(result6);
                            output6.write(bytes);
                            output6.close();
                            break;
                    }
                }
            }
        };
    }
}
