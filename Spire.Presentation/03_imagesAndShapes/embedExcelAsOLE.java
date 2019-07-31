import com.spire.presentation.*;
import com.spire.presentation.drawing.IImageData;
import javax.imageio.ImageIO;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.*;

public class embedExcelAsOLE {
    public static void main(String[] args) throws Exception {
        String excelFile = "data/embedExcelAsOLE.xlsx";
        String outputFile = "output/embedExcelAsOLE_result.pptx";
        String imageFile = "data/embedExcelAsOLE.png";

        //Create a Presentation document
        Presentation ppt = new Presentation();

        //Load a image file
        BufferedImage image = ImageIO.read(new File(imageFile));
        IImageData oleImage = ppt.getImages().append(image);
        Rectangle2D.Double rec = new Rectangle2D.Double(80, 60, image.getWidth(), image.getHeight());

        FileInputStream fileStream=new FileInputStream(excelFile);
        byte[] buffer=new byte[fileStream.available()];
        fileStream.read(buffer);

        //Insert an OLE object to presentation based on the Excel data
        IOleObject  oleObject =ppt.getSlides().get(0).getShapes().appendOleObject("excel", buffer, rec);
        oleObject.getSubstituteImagePictureFillFormat().getPicture().setEmbedImage(oleImage);
        oleObject.setProgId("Excel.Sheet.12");

        //Save the document
        ppt.saveToFile(outputFile, FileFormat.PPTX_2010);
    }
}
