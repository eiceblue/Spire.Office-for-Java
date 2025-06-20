import com.spire.doc.*;

import java.util.*;

public class nestedMailMerge {

    public static void main(String[] args) throws Exception {
        // Set the input file path for the document to be processed
        String input = "data/nestedMailMerge.doc";

        // Set the data file path containing the merge fields and values
        String data = "data/orders.xml";

        // Set the output file path for the merged document
        String output = "output/nestedMailMerge.docx";

        // Create a new instance of the Document class
        Document document = new Document();

        // Load the document from the specified input file
        document.loadFromFile(input);

        // Create a list to store dictionary entries
        List list = new ArrayList();

        // Create a map entry for the "Customer" field
        Map<String, String> dictionaryEntry = new HashMap<>();
        dictionaryEntry.put("Customer", "");

        // Add the first dictionary entry to the list
        list.add(dictionaryEntry.entrySet().iterator().next());

        // Create another map entry for the "Order" field
        dictionaryEntry = new HashMap<>();
        dictionaryEntry.put("Order", "Customer_Id = %Customer.Customer_Id%");

        // Add the second dictionary entry to the list
        list.add(dictionaryEntry.entrySet().iterator().next());

        // Execute mail merge with nested regions using the specified data and list of dictionary entries
        document.getMailMerge().executeWidthNestedRegion(data, list);

        // Save the merged document to the specified output file in DOCX format
        document.saveToFile(output, FileFormat.Docx);

        // Dispose of the document object to release resources
        document.dispose();
    }
}
