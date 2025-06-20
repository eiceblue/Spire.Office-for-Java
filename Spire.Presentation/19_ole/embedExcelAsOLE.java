import com.spire.presentation.*;
import com.spire.presentation.drawing.IImageData;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class embedExcelAsOLE {
    public static void main(String[] args) throws Exception{
        //Create a Presentaion document
        Presentation ppt = new Presentation();

        //Load the image file
        File file =new File("data/EmbedExcelAsOLE.png");
        BufferedImage image = ImageIO.read(file);
        IImageData oleImage = ppt.getImages().append(image);
        Rectangle rec = new Rectangle(80, 60, image.getWidth(), image.getHeight());

        String input = "data/EmbedExcelAsOLE.xlsx";
        File oldFile=new File(input);
        FileInputStream inputStream = new FileInputStream(oldFile);
        byte[] data = new byte[(int)oldFile.length()];
        inputStream.read(data,0,data.length);

        //Insert an OLE object to presentation based on the Excel data
        com.spire.presentation.IOleObject oleObject=ppt.getSlides().get(0).getShapes().appendOleObject("excel", data, rec);
        oleObject.getSubstituteImagePictureFillFormat().getPicture().setEmbedImage(oleImage);
        oleObject.setProgId("Excel.Sheet.12");

        //Save the document
        ppt.saveToFile("output/embedExcelAsOLE.pptx", FileFormat.PPTX_2013);

        inputStream.close();
    }
}
