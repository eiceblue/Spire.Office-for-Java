import com.spire.xls.*;
import com.spire.xls.core.IShape;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashMap;

public class getShapesAndSaveToImage {
    public static void main(String[] args) throws IOException {
        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load the workbook from the specified file ("data/Shape.xlsx")
        workbook.loadFromFile("data/Shape.xlsx");

        // Get the first worksheet in the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Convert shapes to images
        SaveShapeTypeOption shapelist = new SaveShapeTypeOption();

        // Save all shapes in the worksheet to images
        shapelist.setSaveAll(true);

        // Save the shapes in the worksheet to images and get a HashMap of shapes and their corresponding images
        HashMap<IShape, BufferedImage> images = sheet.saveAndGetShapesToImage(shapelist);

        // Iterate through each shape in the HashMap
        for (IShape shape : images.keySet()) {
            // Get the image corresponding to the current shape
            BufferedImage image = images.get(shape);

            // Generate a filename based on the shape's properties
            String fileName = shape.getName() + "_" + shape.getHeight() + "_" + shape.getWidth() + "_" + shape.getShapeType() + ".png";

            // Save the image to a file in the "testImage" directory with the generated filename
            ImageIO.write(image, "PNG", new File("testImage/" + fileName));
        }

        // Dispose the workbook
        workbook.dispose();

    }
}
