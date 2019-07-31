import com.spire.doc.*;

public class imageWaterMark {
    public static void main(String[] args) throws Exception {

        String inputFile="data/watermarkTemplate.doc";
        String imageFile="data/imageWatermark.png";
        String outputFile="output/imageWaterMark.docx";

        //open a Word document as template.
        Document document = new Document(inputFile);

        //insert the image watermark.
        insertImageWatermark(document,imageFile);

        //save to file.
        document.saveToFile(outputFile, FileFormat.Docx);
    }
    private static void insertImageWatermark(Document document, String imageFile) throws Exception{
        PictureWatermark picture = new PictureWatermark();
        picture.setPicture(imageFile);
        picture.setScaling(250);
        picture.isWashout(false);
        document.setWatermark(picture);
    }
}
