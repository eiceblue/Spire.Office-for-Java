import com.spire.xls.*;
import com.spire.xls.core.spreadsheet.HTMLOptions;

import java.io.*;

public class toHtmlStream {
    public static void main(String[] args) throws IOException {
        String inputFile = "data/ToHtml.xlsx";
        String outputFile = "output/ToHtml_out.html";

        //Create a workbook
        Workbook workbook = new Workbook();

        //Load an excel document
        workbook.loadFromFile(inputFile);

        //Get the first sheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Set embedded image
        HTMLOptions options = new HTMLOptions();
        options.setImageEmbedded(true);

        //Save to HTML file
        FileOutputStream stream = new FileOutputStream(outputFile);
        sheet.saveToHtml(stream, options);
        stream.flush();
        stream.close();
    }
}
