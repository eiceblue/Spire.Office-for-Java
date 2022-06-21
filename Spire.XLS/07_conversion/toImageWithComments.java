import com.spire.xls.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class toImageWithComments {
    public static void main(String[] args) throws Exception {
        Workbook workbook =new Workbook();
        workbook.loadFromFile("data/ToImageWithComments.xlsx");
        Worksheet worksheet =workbook.getWorksheets().get(0);
        worksheet.getPageSetup().setPrintComments(PrintCommentType.InPlace);
        int firstRow =worksheet.getFirstRow();
        int firstColumn =worksheet.getFirstColumn();
        int lastRow =worksheet.getLastRow();
        int lastColumn =worksheet.getLastColumn();
        BufferedImage bufferedImage = worksheet.toImage(firstRow,firstColumn,lastRow,lastColumn);
        ImageIO.write(bufferedImage,"PNG",new File("output/ToImageWithComments.png"));
    }
}