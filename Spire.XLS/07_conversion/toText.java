import com.spire.xls.*;

import java.nio.charset.Charset;

public class toText {
    public static void main(String[] args) {
        String  inputFile = "data/CreateTable.xlsx";
        String  outputFile = "output/toText.txt";
        //Open xls document
        Workbook workbook = new Workbook();
        workbook.loadFromFile(inputFile);

        Worksheet worksheet = workbook.getWorksheets().get(0);
        //Convert to text
        Charset charset = Charset.forName("utf8");
        worksheet.saveToFile(outputFile, " ", charset);

    }
}
