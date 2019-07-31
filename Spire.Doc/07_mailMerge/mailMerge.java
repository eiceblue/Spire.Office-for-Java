import com.spire.doc.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class mailMerge {
    public static void main(String[] args) throws Exception {
        String input = "data/mailMerge.doc";
        String output = "output/mailMerge.doc";

        Document document = new Document();
        document.loadFromFile(input);

        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        String[] filedNames = new String[]{"Contact Name", "Fax", "Date"};
        String[] filedValues = new String[]{"John Smith", "+1 (69) 123456", dateString};

        document.getMailMerge().execute(filedNames, filedValues);

        //save doc file.
        document.saveToFile(output, FileFormat.Doc);
    }
}
