import com.spire.xls.*;
import com.spire.xls.core.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.RenderedImage;
import java.io.File;

public class extractTextImageFromShape {
    public static void main(String[] args) throws Exception {
        String input = "data/Template_Xls_5.xlsx";
        String output = "output/result.png";

        //create a workbook.
        Workbook workbook = new Workbook();

        //load the file from disk.
        workbook.loadFromFile(input);

        //get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        //extract text from the first shape and save to a txt file.
        IPrstGeomShape shape1 = sheet.getPrstGeomShapes().get(2);
        String s = shape1.getText();
        StringBuilder sb = new StringBuilder();
        sb.append("The text in the third shape is: " + s);
        System.out.println(sb.toString());

        //extract image from the second shape and save to a local folder.
        IPrstGeomShape shape2 = sheet.getPrstGeomShapes().get(1);
        Image image = shape2.getFill().getPicture();
        ImageIO.write((RenderedImage) image, "png", new File(output));
    }
}
