import com.spire.barcode.BarCodeGenerator;
import com.spire.barcode.BarCodeType;
import com.spire.barcode.BarcodeSettings;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AZTEC {
    public static void main(String[] args) throws IOException {

        //Generate
        //create the BarcodeSettings
        BarcodeSettings settings = new BarcodeSettings();
        //Set the code property
        settings.setData("ABC 123456789");
        //Set the Symbology property
        settings.setType(BarCodeType.Aztec);
        //Set ShowText location on bottom
        settings.setShowTextOnBottom(true);
        //Set Border is visible
        settings.hasBorder(true);
        //Set the  BarCodeGenerator
        BarCodeGenerator barCodeGenerator = new BarCodeGenerator(settings);
        //Get image from the BarCodeGenerator
        BufferedImage bufferedImage = barCodeGenerator.generateImage();
        //Save the image
        ImageIO.write(bufferedImage,"png",new File("AZTEC.png"));
    }
}
