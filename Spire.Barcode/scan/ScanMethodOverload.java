import com.spire.barcode.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;

public class ScanMethodOverload {
    public static void main(String[] args) throws Exception {
        String imagePath = "Data/barcode.png";
        // Scan through image path
        String[] s1 = BarcodeScanner.scan(imagePath, BarCodeType.EAN_13,true);
        System.out.println(s1[0]);
        // Scan the image and specify the location
        BufferedImage bufferedImage = ImageIO.read(new File(imagePath));
        Rectangle rectangle = new Rectangle(0, 0, 300, 300);
        String[] s2 = BarcodeScanner.scan(bufferedImage, rectangle,BarCodeType.EAN_13,false);
        System.out.println(s2[0]);
        // Save the result as a string through image path
        String s3 = BarcodeScanner.scanOne(imagePath, BarCodeType.EAN_13, true);
        System.out.println(s3);
        // Save the result as a string through the input stream
        String s4 = BarcodeScanner.scanOne(Files.newInputStream(new File(imagePath).toPath()), BarCodeType.EAN_13, true);
        System.out.println(s4);

    }
}
