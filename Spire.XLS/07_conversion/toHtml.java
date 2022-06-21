import com.spire.xls.*;
import com.spire.xls.core.spreadsheet.HTMLOptions;

public class toHtml {
    public static void main(String[] args) {
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
        sheet.saveToHtml(outputFile,options);
    }
}
