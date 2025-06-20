import java.io.*;
import java.util.*;
import com.spire.xls.*;

public class getPageCount {
    public static void main(String[] args) throws IOException {
        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load the Excel file from the specified path
        workbook.loadFromFile("data/worksheetSample2.xlsx");

        // Get the page information for each worksheet and store it in a list of maps
        List<Map<Integer, PageColRow>> pageInfoList = workbook.getSplitPageInfo();

        // Create a StringBuilder to store the result
        StringBuilder stringBuilder = new StringBuilder();

        // Iterate through each worksheet
        for (int i = 0; i < workbook.getWorksheets().getCount(); i++) {
            // Get the name of the current worksheet
            String sheetname = workbook.getWorksheets().get(i).getName();

            // Get the page count for the current worksheet
            int pagecount = pageInfoList.get(i).size();

            // Append the sheet name and its page count to the StringBuilder
            stringBuilder.append(sheetname + "'s page count is: " + pagecount + "\r\n");
        }

        // Specify the output file path
        String output = "output/getPageCount_result.txt";

        // Create a FileWriter object to write to the output file (append mode)
        FileWriter fw = new FileWriter(output, true);

        // Create a BufferedWriter object to improve writing performance
        BufferedWriter bw = new BufferedWriter(fw);

        // Append the content to the output file
        bw.append(stringBuilder);

        // Close the BufferedWriter and FileWriter objects
        bw.close();
        fw.close();

        // Dispose the workbook to release resources
        workbook.dispose();
    }
}
