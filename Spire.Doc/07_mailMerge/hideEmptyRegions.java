import com.spire.doc.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class hideEmptyRegions {
    public static void main(String[] args) throws Exception {
        String input = "data/hideEmptyRegions.doc";
        String output = "output/hideEmptyRegions.docx";

        Document document = new Document();
        document.loadFromFile(input);

        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        String[] filedNames = new String[]{"Contact Name", "Fax", "Date"};
        String[] filedValues = new String[]{"John Smith", "+1 (69) 123456",dateString};

        //set the value to remove group which contain empty field.
        document.getMailMerge().setHideEmptyGroup(true);
        //set the value to remove paragraphs which contain empty field.
        document.getMailMerge().setHideEmptyParagraphs(true);
        document.getMailMerge().execute(filedNames, filedValues);

        //save doc file.
        document.saveToFile(output, FileFormat.Docx);
    }
}
