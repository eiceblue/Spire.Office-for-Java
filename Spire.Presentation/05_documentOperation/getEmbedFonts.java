import com.spire.presentation.*;
import java.util.ArrayList;

public class getEmbedFonts{
    public static void main(String[] args) throws Exception {

        String inputFile = "data/EmbedFonts.pptx";

        // Load a PowerPoint presentation from the specified file
        Presentation ppt = new Presentation();
        ppt.loadFromFile(inputFile);

		// Create an ArrayList to hold the embedded fonts from the PPT
        ArrayList<String> embedFonts = ppt.getEmbedFonts();

		// Loop through each font in the ArrayList
        for(int i=0; i<embedFonts.size();i++)
        {
			 // Print the current font to the console
            System.out.println("-------"+embedFonts.get(i));
        }

        // Dispose of the Presentation object
        ppt.dispose();
    }


}
