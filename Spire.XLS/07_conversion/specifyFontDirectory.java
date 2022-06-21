import com.spire.xls.*;

import java.util.Hashtable;

public class specifyFontDirectory {
    public static void main(String[] args) {
        String inputFile = "data/ToPDF.xlsx";
        String outputFile = "output/result.pdf";
        //Create a workbook
        Workbook workbook = new Workbook();
        //Load a file
        workbook.loadFromFile(inputFile);
        //Specifies the font file directory
        workbook.setCustomFontFileDirectory(new String[]{"./data/Font"});
        //Get custom font analysis results
        Hashtable hashtable = workbook.getCustomFontParsedResult();
        //Save to PDF file
        workbook.saveToFile(outputFile, FileFormat.PDF);
        workbook.dispose();
    }
}
