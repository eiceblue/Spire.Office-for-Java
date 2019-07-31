import com.spire.barcode.BarCodeGenerator;
import com.spire.barcode.BarCodeType;
import com.spire.barcode.BarcodeSettings;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class UPCE {
    public static void main(String[] args) throws IOException {

        //Generate
        //Create the BarcodeSettings
        BarcodeSettings settings = new BarcodeSettings();
        //Set Data
        settings.setData("01234567890|991234-abcd");
        //Set the Symbology property
        settings.setType(BarCodeType.UPCE);
        //Set ShowText location on bottom
        settings.setShowTextOnBottom(true);
        //Set Border is visible
        settings.hasBorder(true);
        //Create the BarCodeGenerator
        BarCodeGenerator barCodeGenerator = new BarCodeGenerator(settings);
        //Get image from the BarCodeGenerator
        BufferedImage bufferedImage = barCodeGenerator.generateImage();
        //Save the image
        ImageIO.write(bufferedImage,"png",new File("UPCE.png"));

    }
}
