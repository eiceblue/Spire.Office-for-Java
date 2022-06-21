import java.io.*;
import java.util.*;

import com.spire.xls.*;

public class getPageCount {
    public static void main(String[] args) throws IOException {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the document from disk
        workbook.loadFromFile("data/worksheetSample2.xlsx");

        List<Map<Integer, PageColRow>> pageInfoList = workbook.getSplitPageInfo();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < workbook.getWorksheets().getCount(); i++) {
            String sheetname = workbook.getWorksheets().get(i).getName();
            int pagecount = pageInfoList.get(i).size();
            sb.append(sheetname + "'s page count is: " + pagecount + "\r\n");
        }

        //Save the document
        String output = "output/getPageCount_result.txt";
        FileWriter fw = new FileWriter(output, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.append(sb);
        bw.close();
        fw.close();
    }
}
