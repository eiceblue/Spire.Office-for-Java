import com.spire.doc.*;
import com.spire.doc.documents.*;
import java.awt.*;

public class setGradientBackground {
    public static void main(String[] args) {
        // Create a new Document object
        Document document = new Document();

        // Load an existing document from the specified file path
        document.loadFromFile("data/Template_Docx_2.docx");

        // Set the background type to "Gradient"
        document.getBackground().setType(BackgroundType.Gradient);

        // Get the gradient background object
        BackgroundGradient background = document.getBackground().getGradient();

        // Set the first color of the gradient background to white
        background.setColor1(Color.white);

        // Set the second color of the gradient background to light gray
        background.setColor2(Color.lightGray);

        // Set the shading variant to "Shading_Down"
        background.setShadingVariant(GradientShadingVariant.Shading_Down);

        // Set the shading style to "Horizontal"
        background.setShadingStyle(GradientShadingStyle.Horizontal);

        // Specify the output file path
        String result = "output/result-SetGradientBackground.docx";

        // Save the modified document to the output file path in Docx format (compatible with Word 2013)
        document.saveToFile(result, FileFormat.Docx_2013);

        // Dispose the document object to release resources
        document.dispose();
    }
}
