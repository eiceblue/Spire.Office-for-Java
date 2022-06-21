import java.io.*;

import com.spire.xls.*;

public class getWorksheetNames {
    public static void main(String[] args) throws IOException {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the document from disk
        workbook.loadFromFile("data/worksheetSample3.xlsx");

        //Get the names of all worksheets
        StringBuilder sb = new StringBuilder();
        for (Object worksheet : workbook.getWorksheets()) {
            Worksheet sheet = (Worksheet) worksheet;
            sb.append(sheet.getName() + "\r\n");
        }

        //Save to the Text file
        String output = "output/getWorksheetNames_result.txt";
        FileWriter fw = new FileWriter(output, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.append(sb);
        bw.close();
        fw.close();
    }
}
