import com.spire.barcode.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class CODABAR {
    public static void main(String[] args) throws Exception {

        //Generate
        //Create the BarcodeSettings
        BarcodeSettings settings = new BarcodeSettings();
        //Set Data
        settings.setData("2030405060");
        //Set the Symbology property
        settings.setType(BarCodeType.Codabar);
        //Set ShowText location on bottom
        settings.setShowTextOnBottom(true);
        //Set Border is visible
        settings.hasBorder(true);
        //Set the CodabarStartChar and CodabarStopChar
        settings.setCodabarStartChar(CodabarChar.B);
        settings.setCodabarStopChar(CodabarChar.D);
        //Create the BarCodeGenerator
        BarCodeGenerator barCodeGenerator = new BarCodeGenerator(settings);
        //Get image from the BarCodeGenerator
        BufferedImage bufferedImage = barCodeGenerator.generateImage();
        //Save the image
        ImageIO.write(bufferedImage,"png",new File("CODABAR.png"));
    }
}
