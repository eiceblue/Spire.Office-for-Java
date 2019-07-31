import com.spire.doc.*;
import com.spire.doc.reporting.*;

public class mailMergeImage {
    public static void main(String[] args) throws Exception {
        String input = "data/mailMergeImage.docx";
        String output = "output/mailMergeImage.docx";
        String inputImg = "data/mailMergedImage.png";

        Document spireDoc = new Document();
        spireDoc.loadFromFile(input);
        String[] fieldNames = new String[]{"ImageFile"};
        String[] fieldValues = new String[]{inputImg};
        spireDoc.getMailMerge().MergeImageField = new MergeImageFieldEventHandler() {
            @Override
            public void invoke(Object sender, MergeImageFieldEventArgs args) {
                mailMerge_MergeImageField(sender, args);
            }
        };
        spireDoc.getMailMerge().execute(fieldNames, fieldValues);
        spireDoc.saveToFile(output, FileFormat.Docx);
    }

    private static void mailMerge_MergeImageField(Object sender, MergeImageFieldEventArgs field) {
        String filePath = field.getImageFileName();
        if (filePath != null && !"".equals(filePath)) {
            try {
                field.setImage(filePath);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
