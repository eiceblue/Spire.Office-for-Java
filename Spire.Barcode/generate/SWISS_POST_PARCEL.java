import com.spire.barcode.BarCodeGenerator;
import com.spire.barcode.BarCodeType;
import com.spire.barcode.BarcodeSettings;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SWISS_POST_PARCEL {
    public static void main(String[] args) throws IOException {

        //Generate
        //Create the BarcodeSettings
        BarcodeSettings settings = new BarcodeSettings();
        //Set Data
        settings.setData("993413796700168509");
        //Set the Symbology property
        settings.setType(BarCodeType.Swiss_Post_Parcel);
        //Set ShowText location on bottom
        settings.setShowTextOnBottom(true);
        //Set Border is visible
        settings.hasBorder(true);
        //Create the BarCodeGenerator
        BarCodeGenerator barCodeGenerator = new BarCodeGenerator(settings);
        //Get image from the BarCodeGenerator
        BufferedImage bufferedImage = barCodeGenerator.generateImage();
        //Save the image
        ImageIO.write(bufferedImage,"png",new File("SWISS_POST_PARCEL.png"));

    }
}
