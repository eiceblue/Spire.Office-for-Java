import java.io.*;

import com.spire.xls.*;

public class getPaperSize {
    public static void main(String[] args) throws IOException {
        Workbook workbook = new Workbook();

        //Load the document from disk
        workbook.loadFromFile("data/worksheetSample2.xlsx");

        StringBuilder sb = new StringBuilder();
        for (Object worksheet : workbook.getWorksheets()) {
            Worksheet sheet = (Worksheet) worksheet;
            double width = sheet.getPageSetup().getPageWidth();
            double height = sheet.getPageSetup().getPageHeight();
            sb.append(sheet.getName() + "\r\n");
            sb.append("Width: " + width + "\tHeight: " + height + "\r\n\r\n");
        }

        //Save to Text file
        String output = "output/getPaperSize_result.txt";
        FileWriter fw = new FileWriter(output, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.append(sb);
        bw.close();
        fw.close();
    }
}
