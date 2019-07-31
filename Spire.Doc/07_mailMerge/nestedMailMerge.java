import com.spire.doc.*;
import java.util.*;

public class nestedMailMerge {
    public static void main(String[] args) throws Exception {
        String input = "data/nestedMailMerge.doc";
        String data = "data/orders.xml";
        String output = "output/nestedMailMerge.docx";

        //create word document
        Document document = new Document();
        document.loadFromFile(input);
        List list = new ArrayList();
        Map<String, String> dictionaryEntry = new HashMap<String, String>();

        dictionaryEntry.put("Customer", "");

        list.add(dictionaryEntry.entrySet().iterator().next());

        dictionaryEntry = new HashMap<String, String>();
        dictionaryEntry.put("Order", "Customer_Id = %Customer.Customer_Id%");
        list.add(dictionaryEntry.entrySet().iterator().next());

        document.getMailMerge().executeWidthNestedRegion(data, list);

        //save as docx file.
        document.saveToFile(output, FileFormat.Docx);
    }
}
