import com.spire.ocr.*;
import java.io.FileWriter;
import java.io.IOException;

public class scanImageWithNewModel {
    public static void main(String[] args) throws Exception {
		
        // Create an instance of OcrScanner
        OcrScanner scanner = new OcrScanner();
		
        // Set up scanner configuration
        ConfigureOptions configureOptions = new ConfigureOptions();
		
        // Specify the language for text recognition, default is English (supported languages: English, Chinese, ChineseTraditional, French, German, Japanese, and Korean)
        configureOptions.setLanguage("English");
		
        //Please download the corresponding model dependencies based on your environment in the guide article(https://www.e-iceblue.com/Tutorials/Java/Spire.OCR-for-Java/Program-Guide/Extract-Text-from-Images-Using-the-New-Model-of-Spire.OCR-for-Java.html)
        // Specify the model path
        configureOptions.setModelPath("F:\\win-x64");
		
        // Apply the configuration to the scanner
        scanner.ConfigureDependencies(configureOptions);
		
        // Recognize text from the image
        scanner.scan("Sample.png");
		
        // Get the recognized text
        String scannedText = scanner.getText().toString();

        // Write the obtained text to a text file
        try (FileWriter writer = new FileWriter("extractedOut.txt")) {
            writer.write(scannedText);
            System.out.println("Done!");
        } catch (IOException e) {
            System.out.println("Error!");
            e.printStackTrace();
        }
    }
}
