import com.spire.xls.*;
import com.spire.xls.core.IGroupBoxes;

public class getGroupBoxes {
    public static void main(String[] args) {
        String inputFile = "data/groupBox.xlsx";
        // Create a workbook
        Workbook workbook = new Workbook();
        //Load the document from disk
        workbook.loadFromFile(inputFile);
        //Get the first worksheet
        Worksheet worksheet = workbook.getWorksheets().get(0);
        //Get the group box collection
        IGroupBoxes groupBoxs = worksheet.getGroupBoxes();
        for (int i = 0; i < groupBoxs.getCount(); i++) {
            String name = groupBoxs.get(i).getName();
        }
    }
}
