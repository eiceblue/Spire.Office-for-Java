import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import com.spire.pdf.utilities.*;

public class replaceImageByIndex {
    public static void main(String[] args)throws Exception {
		// Specify the input PDF file path
        String input = "data/DeleteImage.pdf";

		// Specify the input image file path
        String inputImg = "data/E-iceblueLogo.png";

        // Specify the output PDF file path for the modified document
        String output = "output/replaceImageByIndex.pdf";

        //Create a pdf document
        PdfDocument doc = new PdfDocument();

        //Load file from disk.
        doc.loadFromFile(input);

        //Get the first page.
        PdfPageBase page = doc.getPages().get(0);

        //Load a image
        PdfImage image = PdfImage.fromFile(inputImg);

        //Get the images info
        PdfImageHelper imageHelper = new PdfImageHelper();
        PdfImageInfo[] imageInfos = imageHelper.getImagesInfo(page);

        //Replace the first image on the page.
        imageHelper.replaceImage(imageInfos[0], image);

        //Save the document
        doc.saveToFile(output, FileFormat.PDF);

        // Close the PDF document
        doc.close();
    }
}
