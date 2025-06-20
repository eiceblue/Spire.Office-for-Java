import com.spire.xls.*;

import java.io.File;
import java.io.FileWriter;

public class findTextByRegex {
    public static void main(String[] args) throws Exception{
        // Load an existing workbook from a file
        Workbook workbook = new Workbook();
        workbook.loadFromFile("data/FindTextByRegex.xlsx");

        // Get the first sheet
        Worksheet worksheet = workbook.getWorksheets().get(0);

        // Find cell ranges by Regex
        CellRange[] ranges = worksheet.findAllString(".*North.", false, false, true);
        String information = "";

        // Get the information of every cell range
        for (int i = 0; i < ranges.length; i++) {
            information += "RangeAddressLocal:" + ranges[i].getRangeAddressLocal() + "\r\n";
            information += "Text:" + ranges[i].getText() + "\r\n";
        }

        // Specify the output file name for the result
        String result = "output/FindTextByRegex_result.txt";
        FileWriter writer = new FileWriter(result);
        writer.write(information);
        writer.flush();
        writer.close();
    }
}
