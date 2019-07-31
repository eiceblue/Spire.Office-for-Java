import com.spire.pdf.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class extraction{
    public static void main(String[] args) throws Exception {
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile("data/extraction.pdf");

        StringBuilder buffer = new StringBuilder();
        ArrayList<BufferedImage> images = new ArrayList<BufferedImage>();
        for (PdfPageBase page : (Iterable<PdfPageBase>) doc.getPages()) {
            buffer.append(page.extractText());
            for (BufferedImage image : page.extractImages()) {
                images.add(image);
            }
        }
        //save text
        String fileName = "output/text.txt";
        FileWriter writer = new FileWriter(fileName);
        writer.write(buffer.toString());
        writer.flush();
        writer.close();

        int index = 0;
        for (BufferedImage image : images) {
            File output = new File("output/images/" + String.format("Image_%d.png", index++));
            ImageIO.write(image, "PNG", output);
        }
    }
}
