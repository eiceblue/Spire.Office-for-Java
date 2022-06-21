import com.spire.xls.*;

public class saveFiles {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the document from disk
        workbook.loadFromFile("data/excelSample_N1.xlsx");

        // Save in Excel 97-2003 format
        workbook.saveToFile("output/result.xls", ExcelVersion.Version97to2003);

        // Save in Excel2010 xlsx format
        workbook.saveToFile("output/result.xlsx", ExcelVersion.Version2010);

        // Save in XLSB format
        workbook.saveToFile("output/result.xlsb", ExcelVersion.Xlsb2010);

        // Save in ODS format
        workbook.saveToFile("output/result.ods", ExcelVersion.ODS);

        // Save in PDF format
        workbook.saveToFile("output/result.pdf", FileFormat.PDF);

        // Save in XML format
        workbook.saveToFile("output/result.xml", FileFormat.XML);

        // Save in XPS format
        workbook.saveToFile("output/result.xps", FileFormat.XPS);
    }
}
