import com.spire.barcode.BarCodeGenerator;
import com.spire.barcode.BarCodeType;
import com.spire.barcode.BarcodeSettings;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class EAN_128 {
    public static void main(String[] args) throws IOException {

        //Generate
        //Create the BarcodeSettings
        BarcodeSettings settings = new BarcodeSettings();
        //Set Data
        settings.setData("800500036510123456");
        //Set the Symbology property
        settings.setType(BarCodeType.EAN_128);
        //Set ShowText location on bottom
        settings.setShowTextOnBottom(true);
        //Set Border is visible
        settings.hasBorder(true);
        //Create the BarCodeGenerator
        BarCodeGenerator barCodeGenerator = new BarCodeGenerator(settings);
        //Get image from the BarCodeGenerator
        BufferedImage bufferedImage = barCodeGenerator.generateImage();
        //Save the image
        ImageIO.write(bufferedImage,"png",new File("EAN_128.png"));

    }
}
