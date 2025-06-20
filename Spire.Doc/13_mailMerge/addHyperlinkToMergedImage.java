import com.spire.doc.*;
import com.spire.doc.reporting.*;

public class addHyperlinkToMergedImage {
    public static void main(String[] args) throws Exception {
        // Path to the input Word document
        String input = "data/mailMergeImage.docx";
        // Path to the output Word document
        String output = "output/mailMergeImage.docx";
        // Path to the input image file
        String inputImg = "data/mailMergedImage.png";

        // Create a new Document object
        Document spireDoc = new Document();

        // Load the input Word document
        spireDoc.loadFromFile(input);

        // Define field names and values for mail merge
        String[] fieldNames = new String[]{"ImageFile"};
        String[] fieldValues = new String[]{inputImg};

        // Set up the MergeImageField event handler for custom processing
        spireDoc.getMailMerge().MergeImageField = new MergeImageFieldEventHandler() {
            @Override
            public void invoke(Object sender, MergeImageFieldEventArgs args) {
                mailMerge_MergeImageField(sender, args);
            }
        };

        // Execute the mail merge with the specified field names and values
        spireDoc.getMailMerge().execute(fieldNames, fieldValues);

        // Save the resulting document to the output path
        spireDoc.saveToFile(output, FileFormat.Docx);

        // Dispose of the document
        spireDoc.dispose();
    }

    // Custom mail merge event handler for image fields
    private static void mailMerge_MergeImageField(Object sender, MergeImageFieldEventArgs field) {
        // Get the file path of the image
        String filePath = field.getImageFileName();

        // Check if the file path is not null and not empty
        if (filePath != null && !"".equals(filePath)) {
            try {
                // Set the image using the file path
                field.setImage(filePath);
                // Adding hyperlink for image
                field.setImageLink("https://www.baidu.com/");
            } catch (Exception e) {
                // Handle any exceptions that occur during image merging
                e.printStackTrace();
            }
        }
    }
}
