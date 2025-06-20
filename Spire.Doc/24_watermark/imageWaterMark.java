import com.spire.doc.*;

public class imageWaterMark {
    public static void main(String[] args) {
        // Create a new instance of the Document class with the input file name
        Document document = new Document("data/sampleB_2.docx");

        // Insert the image watermark into the document
        insertImageWatermark(document);

        // Save the modified document as a docx file
        String output = "output/imageWaterMark.docx";
        document.saveToFile(output, FileFormat.Docx);

        // Dispose the document
        document.dispose();
    }

    public static void insertImageWatermark(Document document) {
        // Create a new instance of the PictureWatermark class with the input image file name
        PictureWatermark picture = new PictureWatermark();
        picture.setPicture("data/imageWatermark.png");

        // Set the scaling factor for the watermark image
        picture.setScaling(250);

        // Set whether the watermark should be washed out or not
        picture.isWashout(false);

        // Set the watermark to be applied to the document
        document.setWatermark(picture);
    }
}
