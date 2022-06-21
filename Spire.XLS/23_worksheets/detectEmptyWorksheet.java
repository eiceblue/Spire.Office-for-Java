import java.io.*;

import com.spire.xls.*;

public class detectEmptyWorksheet {
    public static void main(String[] args) throws IOException {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the Excel document from disk
        workbook.loadFromFile("data/readImages.xlsx");

        //Get the first worksheet
        Worksheet worksheet1 = workbook.getWorksheets().get(0);

        //Detect the first worksheet is empty or not
        boolean detect1 = worksheet1.isEmpty();

        //Get the second worksheet
        Worksheet worksheet2 = workbook.getWorksheets().get(1);

        //Detect the second worksheet is empty or not
        boolean detect2 = worksheet2.isEmpty();

        //Create StringBuilder to save 
        StringBuilder content = new StringBuilder();

        //Set string format for displaying
        String result = String.format("The first worksheet is empty or not: " + detect1 + "\r\nThe second worksheet is empty or not: " + detect2);

        //Add result string to StringBuilder
        content.append(result + "\r\n");

        //Save to file
        String output = "output/detectEmptyWorksheet_result.txt";
        FileWriter fw = new FileWriter(output, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.append(content);
        bw.close();
        fw.close();
    }
}
