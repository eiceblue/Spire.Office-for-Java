import com.spire.barcode.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class addLogoImageToQRCode {
    public static void main(String[] args) throws IOException {

        // Create a BarcodeSettings object to set the parameters for the barcode
        BarcodeSettings settings = new BarcodeSettings();

        // Set the data content of the barcode to "ABC 123456789"
        settings.setData("ABC 123456789");

        // Set the type of the barcode to QR_Code (QR Code)
        settings.setType(BarCodeType.QR_Code);

        // Set whether the barcode should display text, here it is set to not display
        settings.setShowText(false);

        // Set whether the barcode should have a border, here it is set to have a border
        settings.hasBorder(true);

        // Read an image file named "E-iceblueLogo.png" and convert it to a BufferedImage object
        BufferedImage image = ImageIO.read(new File("data/E-iceblueLogo.png"));

        // Set the read image as the logo image for the QR code
        settings.setQRCodeLogoImage(image);

        // Create a BarCodeGenerator object for generating barcode images
        BarCodeGenerator barCodeGenerator = new BarCodeGenerator(settings);

        // Generate the barcode image using the generateImage() method and store the result in the bufferedImage variable
        BufferedImage bufferedImage = barCodeGenerator.generateImage();

        // Write the generated barcode image to a file named "QR_CODE_Logo_Image.png" in PNG format
        ImageIO.write(bufferedImage, "png", new File("QR_CODE_Logo_Image.png"));
    }
}
