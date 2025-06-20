import com.spire.pdf.*;
import com.spire.pdf.actions.*;
import com.spire.pdf.general.*;

public class embedSoundFile {
    public static void main(String[] args) {
        // Set the input paths for the PDF document and the sound file
        String input1 = "data/EmbedSoundFile.pdf";
        String input2 = "data/Music.wav";

        // Set the output file path for the modified PDF document
        String output = "output/embedSoundFile_output.pdf";

        // Create a new PdfDocument object and load the existing PDF document
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(input1);

        // Get the first page of the document
        PdfPageBase page = doc.getPages().get(0);

        // Create a new PdfSoundAction with the specified sound file
        PdfSoundAction soundAction = new PdfSoundAction(input2);

        // Set the properties of the sound, such as bits, channels, and encoding
        soundAction.getSound().setBits(16);
        soundAction.getSound().setChannels(PdfSoundChannels.Stereo);
        soundAction.getSound().setEncoding(PdfSoundEncoding.Signed);

        // Set the volume for the sound (0.0 - 1.0)
        soundAction.setVolume(0.8f);

        // Set the repeat flag to true, indicating that the sound should repeat when it finishes playing
        soundAction.setRepeat(true);

        // Set the sound action as the after open action for the document
        doc.setAfterOpenAction(soundAction);

        // Save the modified document to the specified output file path
        doc.saveToFile(output, FileFormat.PDF);

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }
}
