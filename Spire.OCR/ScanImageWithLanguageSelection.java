import com.spire.ocr.OcrScanner;
import java.io.*;

public class ScanImageWithLanguageSelection {
    public static void main(String[] args) throws Exception {
        // Set the path of the dependent file, please follow the instructions in readme.txt to obtain dependencies
        String dependencies = "dependencies/";
        // Define the path to the language file
        String languageFile = "data/japandata";
        // Define the path of the image file to scan
        String imageFile = "data/JapaneseSample.png";
        // Define the path to the output file
        String outputFile = "ScanImageWithLanguageSelection_out.txt";
        // Create an OcrScanner object
        OcrScanner scanner = new OcrScanner();
        // Set the dependent file path of the OcrScanner object
        scanner.setDependencies(dependencies);
        // Loads the specified language file
        scanner.loadLanguageFile(languageFile);
        // The OcrScanner object is used to scan the specified image file
        scanner.scan(imageFile);
        // Get the scanned text content
        String scannedText = scanner.getText().toString();

        // Create an output file object
        File output = new File(outputFile);
        // If the output file already exists, delete it
        if (output.exists()) {
            output.delete();
        }

        // Create a BufferedWriter object to write to the output file
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        // Write the scanned text contents to the output file
        writer.write(scannedText);
        // Close the BufferedWriter object to release resources
        writer.close();
    }
}
