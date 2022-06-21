import com.spire.xls.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class addCommentWithPicture {
    public static void main(String[] args) throws IOException {
        //Open xls document
        Workbook workbook = new Workbook();

        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Specify the cell range for regular comment
        CellRange range = sheet.getCellRange("C6");
        range.setText("E-iceblue");

        ExcelComment comment = range.addComment();
        //Load the image file
        BufferedImage bufferedImage = ImageIO.read(new File("data/Logo.png"));
        //Fill the comment with a customized background picture
        comment.getFill().customPicture(bufferedImage, "logo.png");

        //Set the height and width of comment
        comment.setHeight(bufferedImage.getHeight());
        comment.setWidth(bufferedImage.getWidth());
        comment.setVisible(true);

        //Save to a file
        workbook.saveToFile("output/addCommentWithPicture.xlsx", ExcelVersion.Version2013);
    }
}
